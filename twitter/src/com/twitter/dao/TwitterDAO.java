package com.twitter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.twitter.entity.Entity;

public class TwitterDAO implements TwitterDAOInterface{

	private TwitterDAO(){}
	public static TwitterDAOInterface createDAOObject() {
		return new TwitterDAO();
	}
	@Override
	public int createDAOProfile(Entity e) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getDob());
			ps.setString(5, e.getCnumber());
			ps.setString(6, e.getUsername());
			ps.setString(7, e.getPass());
			ps.setString(8, e.getCpass());
			ps.setString(9, e.getCountry());
			ps.setString(10, e.getState());
			ps.setString(11, e.getCity());
			ps.setString(12, e.getPin());
			i=ps.executeUpdate();
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return i;
	}

}
