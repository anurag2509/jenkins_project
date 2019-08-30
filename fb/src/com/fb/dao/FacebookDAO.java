package com.fb.dao;

import com.fb.entity.FacebookEmployee;

public class FacebookDAO implements FacebookDAOInterface{
	
	private FacebookDAO(){}

	public static FacebookDAOInterface createDAOObject() {
		// TODO Auto-generated method stub
		return new FacebookDAO();
	}

	@Override
	public int loginprofile(FacebookEmployee fe) {
		// TODO Auto-generated method stub
		return 1;
	}

}
