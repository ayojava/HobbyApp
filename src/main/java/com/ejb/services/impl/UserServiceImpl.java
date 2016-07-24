package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.UserService;
import com.jpa.entities.User;
import javax.persistence.Query;

@Stateless
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = "HobbyApp")
    private EntityManager em;

    @Override
    public User getUserDetails(String username) {
        Query qryObj = em.createQuery("Select u from User u where u.username=:username");
        qryObj.setParameter("username", username);
        return (User) qryObj.getSingleResult();
    }

}
