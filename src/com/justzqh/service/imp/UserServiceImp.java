package com.justzqh.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.justzqh.mapper.UserTMapper;
import com.justzqh.mapper.UserTMapperCustom;
import com.justzqh.po.UserT;
import com.justzqh.po.UserTCustom;
import com.justzqh.po.UserTQauryVo;

/**
 * 
* @Title: UserServiceImp.java
* @author: zqh
* @date 2016-4-17 涓嬪崍04:37:59
* @Description:userService瀹炵幇绫�
 */
public class UserServiceImp implements UserService{

	//鑷畾涔塽ser鐨刴apper鎺ュ彛
	@Autowired
	private UserTMapperCustom userTMapperCustom;
	
	//鐢ㄦ埛mapper鎺ュ彛娉ㄥ叆
	@Autowired
	private UserTMapper userTMapper;

	
	public UserTCustom findUserByEmail(UserTQauryVo userTQauryVo) throws Exception {
		// TODO Auto-generated method stub
		UserTCustom userTCustom = userTMapperCustom.findUserByEmail(userTQauryVo);
		return userTCustom;
	}

	public UserTCustom findUserByName(UserTQauryVo userTQauryVo) throws Exception {
		// TODO Auto-generated method stub 
		UserTCustom userTCustom = userTMapperCustom.findUserByName(userTQauryVo);
		return userTCustom;
	}

	public void insertUserInfo(UserTCustom userTCustom) throws Exception {
		// TODO Auto-generated method stub
		UserT userT = new UserT();
		BeanUtils.copyProperties(userTCustom, userT);		
		userTMapper.insert(userT);
			
	}

}
