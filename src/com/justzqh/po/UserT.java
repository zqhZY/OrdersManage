package com.justzqh.po;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class UserT {
	
	
    private Integer id;

    @Size(min=1, max=20, message="user.name.length.error")
    @Pattern(regexp="^[a-zA-Z_]\\w{0,20}$" , message="user.name.pattern.error")
    private String name;

    @Size(min=1, max = 50,message="user.email.notnull")
    @Email(message="user.email.pattern.error")
    private String email;

    @Size(min=1, max=19 , message="user.passwd.notnunll")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}