package com.twitter.services;

import com.twitter.dao.TwitterDAO;
import com.twitter.dao.TwitterDAOInterface;
import com.twitter.entity.Entity;

public class TwitterService implements TwitterServiceInterface {
	
	private TwitterService(){}

	public static TwitterServiceInterface createServiceObject() {
		
		return new TwitterService();
	}

	@Override
	public int createProfile(Entity e) {
		TwitterDAOInterface tdi=TwitterDAO.createDAOObject();
		
		return tdi.createDAOProfile(e);
	}

}
