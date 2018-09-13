package com.interland.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interland.payment.service.TransactionService;


@Controller
@RequestMapping("/transaction")
public class TransactionController {

	private static final Logger logger = Logger
			.getLogger(TransactionController.class.getName());
	@Autowired
	TransactionService transactionService;

	
	@RequestMapping(value = "/getTransactionPage",method = RequestMethod.GET) 
	public String getHomepage() {  
		
		return "transaction";    
		}
	
	
	
	@RequestMapping(value = "/getAllTranactions", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody String getAllList(HttpServletRequest request,@RequestParam(value = "nextCount") int nextCount
   			,@RequestParam(value = "startCount") int startCount) {

		logger.info("Inside getAllTranactions");
//		String sSearch = request.getParameter("sSearch");
//		String searchParam = request.getParameter("searchData");
		String listResult = "";
		try {
			HttpSession session = request.getSession();
			String loggedUser = (String) session.getAttribute("userId");
			
			listResult = transactionService.getAllTransactionList(loggedUser,nextCount,startCount);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return listResult;

	}
	
	@RequestMapping(value = "/getOperationforTransaction", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody String getOperationforTransaction(HttpServletRequest request,@RequestParam(value = "transactionId") String transactionId) {

		logger.info("Inside getOperationforTransaction in TransactionController");

		String listResult = "";
		try {
			HttpSession session = request.getSession();
			String loggedUser = (String) session.getAttribute("userId");
			listResult = transactionService.getOperationforTransaction(transactionId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return listResult;

	}
	
}
