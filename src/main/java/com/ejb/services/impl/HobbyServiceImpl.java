package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.interceptors.AuditInterceptor;
import com.ejb.services.HobbyService;
import com.jpa.entities.UserHobby;

@Stateless
public class HobbyServiceImpl implements HobbyService {

	@PersistenceContext(name = "HobbyApp")
	private EntityManager em;
	
	@Interceptors(AuditInterceptor.class)
	@Override
	public void saveHobby(UserHobby h) {
		em.persist(h);	
	}

}
