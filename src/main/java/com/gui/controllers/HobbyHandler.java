/**
 *
 */
package com.gui.controllers;

import com.ejb.services.HobbyService;
import com.ejb.services.UserService;
import com.jpa.entities.User;

import com.jpa.entities.UserHobby;
import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * @author Administrator
 *
 */
@ManagedBean(name = "hobbyHandler")
@RequestScoped
public class HobbyHandler {

    private UserHobby userHobby;

    @EJB
    private UserService userService;
    
    @EJB
    private HobbyService hobbyService;

    @ManagedProperty(value = "#{userLogin}")
    private UserLogin userLogin;

    @PostConstruct
    public void init() {
        System.out.println(":::: Init HobbyHandler :::: ");
        userHobby = new UserHobby();
        if(userLogin.isCheckUserDetails()){
            populateUserDetails();
        }
        
    }

    public void saveHobby() {
        hobbyService.saveHobby(userHobby);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Hobby Saved Successfully" ));
    }

    private void populateUserDetails() {
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if (principal != null) {
            String principalName = principal.getName();
            if (principalName != null) {
                User userObj = userService.getUserDetails(principalName);
                if (userObj != null) {
                    userLogin.setCheckUserDetails(false);
                    userLogin.setUserObj(userObj);
                } else {
                    System.out.println(":::: User Object is null :::: ");
                }
            }
        } else {
            System.out.println(" ::::  Principal is null");
        }
    }

    @PreDestroy
    public void clear() {
        userHobby = null;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

//    @EJB
//    HobbyService hobbyService;
//
//    UserHobby userHobby = new UserHobby();
//
//    public void addHobby() {
//        String userName = (String) getSessionMap("userName");
//        userHobby.setName(userName);
//        userHobby.setCreatedBy(userName);
//        userHobby.setCreatedOnDateTime(new Date());
//        hobbyService.saveHobby(userHobby);
//    }
//
//    public FacesContext getFacesContext() {
//        return FacesContext.getCurrentInstance();
//    }
//
//    public Object getSessionMap(String mapKey) {
//        return getFacesContext().getExternalContext().getSessionMap().get(mapKey);
//    }
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public UserHobby getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(UserHobby userHobby) {
        this.userHobby = userHobby;
    }
}
