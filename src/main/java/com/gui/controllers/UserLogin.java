package com.gui.controllers;

import com.jpa.entities.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userLogin")
@SessionScoped
public class UserLogin implements Serializable {

    private User userObj;
    
    private boolean checkUserDetails;
    
    @PostConstruct
    public void init() {
        checkUserDetails = true;
    }

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }
    
    

//    @EJB
//    UserService userService;
//
//    private String message = "Enter username and password.";
//    private String username;
//    private String password;
//
//    @PostConstruct
//    public void init() {
//        username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//        System.out.println(">>>>>>>>>>> In USer bean <<<<<<<<<<<<" + username);
//    }
//
//    public String login() {
//        userService.getUserDetails(username);
//        return "hobbyForm";
//
//        /*
//    	 * System.out.println("In USer bean"+username+password);
//    	if("concretepage".equalsIgnoreCase(username) && "concretepage".equalsIgnoreCase(password)) {
//    		message ="Successfully logged-in.";
//    		//return "success";
//    	} else {
//    		message ="Wrong credentials.";
//    		//return "login";
//    	}
//         */
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public boolean isCheckUserDetails() {
        return checkUserDetails;
    }

    public void setCheckUserDetails(boolean checkUserDetails) {
        this.checkUserDetails = checkUserDetails;
    }

}
