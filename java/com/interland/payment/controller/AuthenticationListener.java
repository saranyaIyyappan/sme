package com.interland.payment.controller;

import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class AuthenticationListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		//session.getAttribute("userId");
		session.removeAttribute("UserContext");
	}

}
