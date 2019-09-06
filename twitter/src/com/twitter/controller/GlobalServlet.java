package com.twitter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twitter.entity.Entity;
import com.twitter.services.TwitterService;
import com.twitter.services.TwitterServiceInterface;

public class GlobalServlet extends HttpServlet {
	   
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter io=response.getWriter();
		io.println("<html><body>");
		
		String option=request.getParameter("ac");
		
		if (option.equals("register")) {
			String fname=request.getParameter("First name");
			String lname=request.getParameter("Last name");
			String gender=request.getParameter("gender");
			String dob=request.getParameter("bday");
			String cnumber=request.getParameter("Contact Number");
			String username=request.getParameter("Username");
			String pass=request.getParameter("Password");
			String cpass=request.getParameter("Confirm Password");
			String country=request.getParameter("Country");
			String state=request.getParameter("State");
			String city=request.getParameter("City");
			String pin=request.getParameter("Pin");
			
			Entity e=new Entity();
			e.setFname(fname);
			e.setLname(lname);
			e.setGender(gender);
			e.setDob(dob);
			e.setCnumber(cnumber);
			e.setUsername(username);
			e.setPass(pass);
			e.setPass(cpass);
			e.setCountry(country);
			e.setState(state);
			e.setCity(city);
			e.setPin(pin);
			
			TwitterServiceInterface tsi= TwitterService.createServiceObject();
           int i=tsi.createProfile(e);	
           if(i>0)
        	   io.println("profile created");
           else
        	   io.println("profile not created");
		}
		io.println("</body></html>");
	}

}
