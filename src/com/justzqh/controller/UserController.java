package com.justzqh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;
import com.justzqh.service.imp.UserService;


/**
 * 
* @Title: UserController.java
* @author: zqh
* @date 2016-4-17 涓嬪崍06:28:50
* @Description:鐢ㄦ埛鐩稿叧鎺у埗鍣紝鐧婚檰锛屾敞鍐岋紝鏇存柊鎿嶄綔澶勭悊鍣�
 */
@Controller
@RequestMapping("/users")
public class UserController {
	
	//娉ㄥ叆鐢ㄦ埛service鎺ュ彛
	@Autowired
	private UserService userService;
	
	
	/**
	 * 
	* @Title: Index
	* @author: zqh
	* @date 2016-4-22 涓婂崍11:43:36
	* @Description:home椤甸潰璺宠浆锛岀敤浜庝紶閫掔敤鎴风櫥闄嗕俊鎭紝鏍囪宸茬櫥闄嗙姸鎬�
	* @param model
	* @param userTCustom
	* @return
	*
	 */
	@RequestMapping("/index")
	public String Index(Model model, UserTCustom userTCustom) {

		model.addAttribute("userTCustom", userTCustom);
		return "/index";
	}
	
	
	/**
	 * 
	* @Title: loginUserSubmit
	* @author: zqh
	* @date 2016-4-17 涓嬪崍06:39:04
	* @Description:鐢ㄦ埛鐧婚檰澶勭悊 
	* @param userTCustom
	* @return
	* @throws Exception
	*
	 */
	@RequestMapping("/login")
	public String loginUserSubmit(HttpSession session, Model model,@Validated UserTCustom userTCustom , BindingResult bindingResult)throws Exception{
		
		if(bindingResult.hasErrors()){
			
			String emailError = null;
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error:allErrors){
				
				String errorType = error.getCodes()[1];
				System.out.println(errorType);
				
				if(errorType.equals("Size.email")){
					
					emailError = "Email should not empty,and have limited size!";
				}
			}			
			model.addAttribute("emailError", emailError);
			
			return "/template/login";//璺宠浆鍒版敞鍐岄〉闈�
			
			
		}
		else {
			
			UserTQauryVo userTQauryVo = new UserTQauryVo();
			userTQauryVo.setUserTCustom(userTCustom);
			
			UserTCustom userT = userService.findUserByEmail(userTQauryVo); 
			if(userT != null){
				
				//鏈夋鐢ㄦ埛
				boolean isSuitable = userT.getPassword().equals(userTCustom.getPassword());
				if(isSuitable){
					
					//鎴愬姛鐧婚檰
					model.addAttribute("userTCustom", userT);
					
					//跟踪用户登陆session
					String username = userT.getName();
					session.setAttribute("username", username);
					session.setAttribute("userid", userT.getId());
					
					//跳转到home处理器，forward可传递参数
					return "forward:/.action";
					//return "/index";
				}
				else{
					
					//杩斿洖瀵嗙爜閿欒
					String passwdError = "Email or password input error!";
					model.addAttribute("passwdError", passwdError);
					return "/template/login";
				}
			}
			else {
				
				//鏃犳鐢ㄦ埛锛岃繑鍥炴棤姝ょ敤鎴�
				String emialError = "This emial has not existed!";
				model.addAttribute("emailError", emialError);
				return "/template/login";
				
			}
			
			
		}	
		
	}
	
	
	/**
	 * 
	* @Title: LoginOut
	* @author: zqh
	* @date 2016-4-22 涓婂崍11:24:33
	* @Description:鐢ㄦ埛閫�嚭鐧诲綍锛屾竻闄ょ敤鎴蜂俊鎭紝杩斿洖鍒癶ome椤甸潰 
	* @param model
	* @param userTCustom
	* @return
	*
	 */
	@RequestMapping("/loginout")
	public String LoginOut(HttpSession session , Model model , UserTCustom userTCustom) {
		
		userTCustom = null;
		model.addAttribute("userTCustom", userTCustom);
		session.removeAttribute("username");
		session.removeAttribute("userid");
		//跳转到home处理器，forward可传递参数
		return "forward:/.action";		
	}
	
	
	/**
	 * 
	* @Title: registerUserSubmit
	* @author: zqh
	* @date 2016-4-17 涓嬪崍06:41:01
	* @Description:鐢ㄦ埛娉ㄥ唽澶勭悊 
	* @param userTCustom
	* @return
	* @throws Exception
	*
	 */
	//閫氳繃鏍￠獙鍣ㄥuserCustom杩涜鏍￠獙
	@RequestMapping("/register")
	public String registerUserSubmit(HttpSession session , Model model,
			@Validated UserTCustom userTCustom ,BindingResult bindingResult) throws Exception{
			
		if(bindingResult.hasErrors()){
			
			String nameError = null;
			String namePatternError = null;
			String emailError = null;
			String emailPattenError = null;
			String passWordError = null;
			
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError error:allErrors){
				
				String errorType = error.getCodes()[1];
				System.out.println(errorType);
				
				if(errorType.equals("Size.name")){
					
					nameError = "Name size should be in 1-20!";
				}
				else if (errorType.equals("Pattern.name")) {
					
					namePatternError = "Username must be begin with char or _ !";
					model.addAttribute("namePatternError", namePatternError);
					
				}
				else if(errorType.equals("Size.email")){
					
					emailError = "Email should not empty,and have limited size!";
				}
				else if (errorType.equals("Email.email")) {
					
					emailPattenError = "This email is not a correct email!";
				}
				else if (errorType.equals("Size.password")) {
					
					passWordError = "Password should not empty,and have limited size!";	
				}
				
			}
			
			model.addAttribute("nameError", nameError);
			model.addAttribute("emailError", emailError);
			model.addAttribute("passwdError", passWordError);
			model.addAttribute("emailPattenError", emailPattenError);
			
			
			//model.addAttribute("allErrors", userInfoErrorVo);//鍒╃敤springmvc榛樿鐨刴odel鍙傛暟鍚慾sp椤甸潰浼犻�鍙傛暟
			
			return "/template/register";//璺宠浆鍒版敞鍐岄〉闈�
			
			
		}
		else if (userTCustom.getPassword().equals(userTCustom.getPasswdConfirm()) == false){
			
			//涓ゆ杈撳叆鐨勫瘑鐮佷笉涓�嚧
			String passwdConfirmError = "The passwords you entered must be the same!";
			
			model.addAttribute("passwdConfirmError", passwdConfirmError);
			return "/template/register";//璺宠浆鍒版敞鍐岄〉闈�
		}
		else {
			
			String sameEmail = null;
			String sameName = null;
			
			//鏌ヨ涓婂惁淇℃伅閲嶅鏉′欢绫�
			UserTQauryVo userTQauryVo = new UserTQauryVo();
			userTQauryVo.setUserTCustom(userTCustom);
			
			
			if (userService.findUserByName(userTQauryVo) != null) {
				//鐢ㄦ埛鍚嶉噸澶�
				//鍥炴樉閿欒淇℃伅鍒版敞鍐岄〉闈�
				sameName = "This name has been used, please chose another!";
				model.addAttribute("sameName", sameName);
				return "/template/register";//璺宠浆鍒版敞鍐岄〉闈�
				
				
			}
			else if(userService.findUserByEmail(userTQauryVo) != null){
				//閭閲嶅娉ㄥ唽
				//鍥炴樉閿欒淇℃伅鍒版敞鍐岄〉闈�
				sameEmail = "This email has been used, please chose another!";
				model.addAttribute("sameEmail", sameEmail);
				return "/template/register";//璺宠浆鍒版敞鍐岄〉闈�
			}
			
			//婊¤冻鎻掑叆鏉′欢锛宨d鑷锛岀洿鎺ユ彃鍏ュ嵆鍙�
			userService.insertUserInfo(userTCustom);
			//閲嶅畾鍚戝埌涓婚〉鎴栨垚鍔熼〉闈�
			session.setAttribute("username", userTCustom.getName());
			
			//跳转到home处理器，forward可传递参数
			return "forward:/.action";
		}
		
		
	}
	

}
