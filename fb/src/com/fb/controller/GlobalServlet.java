package com.fb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fb.entity.FacebookEmployee;
import com.fb.service.FacebookService;
import com.fb.service.FacebookServiceInterface;

public class GlobalServlet extends HttpServlet {
	
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String option=request.getParameter("ac");
		
		if (option.equals("login")) {
			
			String username=request.getParameter("username");
			String pass=request.getParameter("pass");
			
			
			FacebookEmployee fe=new FacebookEmployee();
			fe.setUsername(username);
			fe.setPass(pass);
			
			FacebookServiceInterface fs=FacebookService.createServiceObject();
			
			int i=fs.logInProfile(fe);
			
			if (i>0) {
				out.println("login successfully");
			} 
			else {
				out.println("could not login");
			}
		}
		out.println("</body></html>");
	}

}
