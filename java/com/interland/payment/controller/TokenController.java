package com.interland.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interland.payment.service.TokenService;


@Controller
@RequestMapping("/tokenController")
public class TokenController {
	
	private static final Logger logger = Logger
			.getLogger(TokenController.class.getName());
	
//	@Autowired
//	TokenService tokenService;

	
	@RequestMapping(value = "/getAllTokens", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody String getAllList(HttpServletRequest request) {

		int idisplaylength = Integer.parseInt(request
				.getParameter("iDisplayLength"));
		int displaystart = Integer.parseInt(request
				.getParameter("iDisplayStart"));
		String sSearch = request.getParameter("sSearch");
		String searchParam = request.getParameter("searchData");
		
		String tokenList = "";
		try {
			HttpSession session = request.getSession();
			String Id = (String) session.getAttribute("userId");
//			tokenList = tokenService.getAllTokens(searchParam, sSearch,displaystart, idisplaylength, Id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return tokenList;

	}
	
}
