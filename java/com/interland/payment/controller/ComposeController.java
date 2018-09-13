package com.interland.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.interland.payment.dto.ComposeDto;
import com.interland.payment.dto.MailDto;
import com.interland.payment.exception.ProcessingException;
import com.interland.payment.service.ComposeService;




@Controller
@RequestMapping("/compose")
public class ComposeController {
	private static final Logger logger = Logger.getLogger(ComposeController.class.getName());
	@Autowired
	ComposeService composeService;
	 @Value("${VERIFY_FROM_ADDRS}")
	 private String fromAddress;
	 @Value("${EMAIL_VER_CONTENT}")
	 private String mailContent;
	 @Value("${SMTPHOST}")
	 private String smtpHost;
	 @Value("${SMTPPORT}")
	 private String smtpPort;
	 private String sendTo;
	 @Value("${FORWARD_CONTENT}")
	 private String fwdContent;
	 
	 

	 /*******composemail***************************************rafi***********************/
		@RequestMapping(value = "/composemail")
		public @ResponseBody String composeMail(Model model,MultipartHttpServletRequest mulrequest,ComposeDto composeDto)
		{
			  HttpSession session = mulrequest.getSession();
			 String returnStatus="";  
			 List<CommonsMultipartFile> fileList=null;
			try {
				 String userid = (String) session.getAttribute("userId");
				 fileList=new ArrayList<CommonsMultipartFile>();
				 int fileCount=Integer.parseInt(mulrequest.getParameter("fileCount"));							 
				 String attachment=mulrequest.getParameter("attachment");				
				 String fileName=mulrequest.getParameter("fileName");				
				 String fileDelete=mulrequest.getParameter("fileDelete");				
				 String fileUpload=mulrequest.getParameter("fileUpload");
				 
				 if(fileCount>0){
					 for (int i = 0; i <fileCount; i++) {
							logger.info("No Of File::::::"+fileCount);	
							fileList.add((CommonsMultipartFile)mulrequest.getFile("docFile"+i));							
							}
				 }
				 
				 composeDto.setStatus("compose");	
				
			 	 MailDto mailConfigDto=new MailDto();
				 mailConfigDto.setFromMail(userid);
				 mailConfigDto.setSmtpAdress(smtpHost);
				 mailConfigDto.setSmtpPort(smtpPort);
				    returnStatus=composeService.composemail(composeDto,mailConfigDto,mailContent,userid,fileList,attachment,fileName,fileDelete,fileUpload);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			return returnStatus;
		}
	 
		/*************************************************************************************/
		
		
		/*****************getinbox*******************************rafi***********************/
		@RequestMapping(value = "/getinbox" , method = RequestMethod.POST)  
	    public @ResponseBody String getinbox(HttpServletRequest request,ComposeDto composeDto,String userIdSearch){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {     
	    	 returnStatus=composeService.getinbox(userid,userIdSearch);
	      } catch (Exception e) {
	       logger.error(e.getMessage(),e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/
		
		

		/*****************getReadMail*******************************rafi***********************/
		@RequestMapping(value = "/getReadMail" , method = RequestMethod.POST)  
	    public @ResponseBody String getReadMail(HttpServletRequest request,ComposeDto composeDto){  
	   HttpSession session = request.getSession();
	     String returnStatus="";  
	     String userid = (String) session.getAttribute("userId");
	     try {     
	    	 returnStatus=composeService.getReadMail(userid);
	      } catch (Exception e) {
	       logger.error("Exception in DashboardController getAllClosedTicketCount() method :"     + e); 
	       }     
	     return returnStatus; 
	     }
		/*************************************************************************************/
		
		/*************************************************************************************/
		

		/*@RequestMapping(value = "/replysentmail")
		public @ResponseBody String replysentmail(Model model,MultipartHttpServletRequest mulrequest,ComposeDto composeDto)
		{
			  HttpSession session = mulrequest.getSession();
			 String returnStatus="";  
			 List<CommonsMultipartFile> fileList=null;
			 
			try {
				System.out.println("hsaiiiiii");
				 String userid = (String) session.getAttribute("userId");
				 fileList=new ArrayList<CommonsMultipartFile>();
				 int fileCount=Integer.parseInt(mulrequest.getParameter("fileCount"));
				 
				 if(fileCount>0){
					 for (int i = 0; i <fileCount; i++) {
							logger.info("No Of File::::::"+fileCount);
							fileList.add((CommonsMultipartFile)mulrequest.getFile("docFile"+i));
							}
				 }
			
				 composeDto.setStatus(mulrequest.getParameter("REPLY"));
				 composeDto.setSeqid(mulrequest.getParameter("seqid"));
				 System.out.println(":::::::::::::::::"+composeDto.getSeqid());
				 composeDto.setMsgid(mulrequest.getParameter("msgid"));
				 System.out.println("controller"+mulrequest.getParameter("msgid"));
			 	 MailDto mailConfigDto=new MailDto();
				 mailConfigDto.setFromMail(userid);
				 mailConfigDto.setSmtpAdress(smtpHost);
				 mailConfigDto.setSmtpPort(smtpPort);
				    returnStatus=composeService.replysentmail(composeDto,mailConfigDto,mailContent,userid,fileList);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			return returnStatus;
		}
*/@RequestMapping(value = "/replysentmail")
public @ResponseBody String replysentmail(Model model,MultipartHttpServletRequest mulrequest,ComposeDto composeDto)
{
	  HttpSession session = mulrequest.getSession();
	 String returnStatus="";  
	 List<CommonsMultipartFile> fileList=null;
	try {
		 String userid = (String) session.getAttribute("userId");
		 fileList=new ArrayList<CommonsMultipartFile>();
		 int fileCount=Integer.parseInt(mulrequest.getParameter("fileCount"));
		 String fileUpload=mulrequest.getParameter("fileUpload");
		 composeDto.setStatus(mulrequest.getParameter("REPLY"));
		 composeDto.setSeqid(mulrequest.getParameter("seqid"));
		 System.out.println(":::::::::::::::::"+composeDto.getSeqid());
		 composeDto.setMsgid(mulrequest.getParameter("msgid"));
		 System.out.println("controller"+mulrequest.getParameter("msgid"));
		 if(fileCount>0){
			 for (int i = 0; i <fileCount; i++) {
					logger.info("No Of File::::::"+fileCount);
					fileList.add((CommonsMultipartFile)mulrequest.getFile("docFile"+i));
					}
		 }
		 
		
		
		
	 	 MailDto mailConfigDto=new MailDto();
		 mailConfigDto.setFromMail(userid);
		 mailConfigDto.setSmtpAdress(smtpHost);
		 mailConfigDto.setSmtpPort(smtpPort);
		    returnStatus=composeService.replysentmail(composeDto,mailConfigDto,mailContent,userid,fileList,fileUpload);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
	}
	return returnStatus;
}
/*****************Sreejith*****************************************************/
@RequestMapping(value = "/getListOfMessage" , method = RequestMethod.POST)  
public @ResponseBody String getListOfMessage(HttpServletRequest request,@RequestParam("sequenceId") String sequenceId)throws ProcessingException{  
HttpSession session = request.getSession();
String userid = (String) session.getAttribute("userId");
 String returnStatus="";  
 try {     
	 returnStatus=composeService.getListOfMessage(sequenceId,userid);
  } catch (Exception e) {
   logger.error("Exception in DashboardController getAllClosedTicketCount() method :"     + e); 
   }     
 return returnStatus; 
 }
/**********************************************************************/
}
