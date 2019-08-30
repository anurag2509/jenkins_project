package com.fb.service;

import com.fb.dao.FacebookDAO;
import com.fb.dao.FacebookDAOInterface;
import com.fb.entity.FacebookEmployee;

public class FacebookService implements FacebookServiceInterface{
	private FacebookService(){}
	public static FacebookServiceInterface createServiceObject() {
		
		
		
		return new FacebookService() ;
	}


	@Override
	public int logInProfile(FacebookEmployee fe) {
		FacebookDAOInterface fd=FacebookDAO.createDAOObject();
		return fd.loginprofile(fe);
	}

}
