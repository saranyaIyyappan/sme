package com.interland.payment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interland.payment.dto.ComposeDto;
import com.interland.payment.service.MailBoxService;

@Controller
@RequestMapping("/mailBox")
public class MailBoxController {
	private static final Logger logger = Logger.getLogger(MailBoxController.class.getName());
	@Autowired
	MailBoxService mailBoxService;
	/*****************getTrashMessages*******************************rafi***********************/
	 @RequestMapping(value = "/deletemailinbox", method ={RequestMethod.GET,RequestMethod.POST})
	 	public @ResponseBody String deletemailinbox(HttpServletRequest request,ComposeDto composeDto,int []  msgIdList) {
		// HttpSession session=request.getSession();
	  	String returnStatus="";
	      try {
	    	 // System.out.println("inside controller:::::"+msgIdList);
	    	  returnStatus=mailBoxService.deletemailinbox(msgIdList,composeDto);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	     	return returnStatus;
	     }
	 
	 /*******************************************************************************************/
	 
	 /*****************getTrashMessages*******************************rafi***********************/
		@RequestMapping(value = "/getTrashMessages" , method = RequestMethod.POST)  
	    public @ResponseBody String getinbox(HttpServletRequest request,ComposeDto composeDto){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {     
	    	 returnStatus=mailBoxService.getTrashMessages(userid);
	      } catch (Exception e) {
	       logger.error("Exception in DashboardController getTrashMessages() method :"     + e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/
		
		
		 /*****************getTrashMessages*******************************rafi***********************/
		@RequestMapping(value = "/getInboxMessages" , method = RequestMethod.POST)  
	    public @ResponseBody String getInboxMessages(HttpServletRequest request,ComposeDto composeDto,String userIdSearch){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {   
		      String searchParam = request.getParameter("searchData");
	    	 returnStatus=mailBoxService.getInboxMessages(userid,userIdSearch);
	      } catch (Exception e) {
	       logger.error("Exception in getInboxMessages() method :"     + e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/
	
		 /*****************getTrashMessages*******************************saranya***********************/
		@RequestMapping(value = "/deletetrash" , method = RequestMethod.POST)  
	    public @ResponseBody String getTrashMessages(HttpServletRequest request,ComposeDto composeDto,int []  msgIdList){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {     
	    	 returnStatus=mailBoxService.deletetrash(userid,msgIdList);
	      } catch (Exception e) {
	       logger.error("Exception in deletetrash() method :"     + e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/


		 /*****************getTrashMessages*******************************rafi***********************/
		@RequestMapping(value = "/notification" , method = RequestMethod.POST)  
	    public @ResponseBody String notification(HttpServletRequest request,ComposeDto composeDto,String messageid,int []  msgIdList){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {     
	    	 System.out.println("controller"+messageid);
	    	 returnStatus=mailBoxService.notification(userid,messageid,msgIdList);
	      } catch (Exception e) {
	       logger.error("Exception in notification() method :"     + e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/


}



