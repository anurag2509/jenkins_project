package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.handlers.message_rfc822;
import com.sun.mail.iap.Response;

public class Servlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try{
			response.setContentType("text/html");
			PrintWriter io=response.getWriter();
			out.println("<html><body>");
			out.println("message "+message.getText()+" sent successfully");
			String ss=request.getParameter("m");
			Context inictx=new InitialContext();
			Queue que=(Queue)inictx.lookup("java:/zensar_queue");
			Destination dest=(Destination) que;
			
			QueueConnectionFactory qcf=(QueueConnectionFactory)inictx.lookup("java:/ConnectionFactory");//step 1
			Connection connection = qcf.createConnection();//step 2
			Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE);//step 3
			MessageProducer producer=session.createProducer(dest);//step 4
			
			TextMessage message=session.createTextMessage(ss);//step 5
			System.out.println("Sending message "+message.getText());
			producer.send(message);//step 6
			
			out.println("to recieve message please <a href=RecieveServlet>Click Here..</a>");
		}
		catch (Exception e) {
			System.err.println("Exception occurred:  "+e.toString());
		}
	}

}
