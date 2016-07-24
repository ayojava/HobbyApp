package com.ejb.services;

import javax.ejb.Local;

import com.jpa.entities.User;

@Local
public interface UserService {

	public User getUserDetails(String username);
}
