/*
 * Licensed Materials - Property of Alfaris Info Com
 *
 * Copyright 2016 Alfaris Info Com.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alfaris Info Com ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with
 * Alfaris Info Com
 */

package com.interland.payment.controller;

/**
 *
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Authentication filter javadoc goes here.
 *
 */
public class AuthenticationFilter implements Filter {

	private static final Logger logger = Logger
			.getLogger(AuthenticationFilter.class.getName());
	private ServletContext context;

	public void init(final FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		logger.info("AuthenticationFilter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (request.isSecure())
			res.setHeader("Strict-Transport-Security","max-age=31622400; includeSubDomains");
			res.setHeader("X-Frame-Options", "SAMEORIGIN");
			res.setHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		logger.info("URI : " + uri);
		if (uri.indexOf("/user/login") >= 0 || uri.indexOf("/user/loginPage") >= 0
			||uri.indexOf("/user/index") >= 0||uri.indexOf("/user/activateAccount") >= 0
			||uri.indexOf("/user/loginPage") >= 0||uri.indexOf("/currency/getexchangeDetails") >= 0
			||(session != null && session.getAttribute("userId") != null)||uri.indexOf("/user/saveNewUser") >= 0
			||uri.indexOf("/user/subscribeWithUs") >= 0|| uri.contains("resource")
			||uri.contains("/user/confirmMail")|| uri.contains("/user/aboutUs")
			|| uri.contains("/user/changePassword")
			||uri.contains("/user/howToTrade") || uri.contains("/user/forgotPassWordMail")
		    ||uri.contains("/user/forgotPasswordScr")|| uri.contains("/token/getPagetoken")){
				chain.doFilter(request, response);
		} else {
			logger.info("Unauthorized access request");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			 
		}
	}

	@Override
	public void destroy() {
		// close any resources here
	}
}
