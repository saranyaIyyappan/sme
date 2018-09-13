package com.interland.payment.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.interland.payment.dto.ComposeDto;
import com.interland.payment.exception.ProcessingException;
import com.interland.payment.service.ReadmailService;
import com.interland.payment.service.UserService;


@Controller
@RequestMapping("/readMail")
public class readMailController {
	private static final Logger logger = Logger.getLogger(MailBoxController.class.getName());
	@Autowired
	ReadmailService readmailService;
	@Autowired 
	UserService userService;
	
	/**************getreadmail****************************************rafi**********************/
	 @RequestMapping(value = "/getreadmail", method ={RequestMethod.POST})
     public @ResponseBody String getreadmail(ComposeDto composeDto,HttpServletRequest request, String msgid) {
	  HttpSession session=request.getSession();
	  String userId = (String) session.getAttribute("userId");
      String returnStatus="";
         try {
          returnStatus=readmailService.getreadmail(msgid,userId,composeDto);
   } catch (Exception e) {
    logger.error(e.getMessage(), e);
   }
         return returnStatus;
        }
	/**********************************************************************************************/
	 
	 
	 /**************getreadmail****************************************rafi**********************/
		@RequestMapping(value = "/fileId", method = RequestMethod.POST)
	  	public @ResponseBody String fileId(ComposeDto composeDto,HttpServletRequest request,@RequestParam(value="messageId") String messageId,@RequestParam(value="sequenceId") String sequenceId) {
	  		HttpSession session = request.getSession(); 
	  		String fileContent="";
	  		
	  try{
		  System.out.println(messageId+"messageId");
	  		 fileContent=readmailService.getFileContentById(messageId,composeDto,sequenceId);
	  	      logger.info(messageId+":::::::controller:::::::::::::::::::::::::::::::FIlessss"+fileContent.toString());
	  } catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	  	      return fileContent.toString();
	  	}
	/**********************************************************************************************/
	  	 @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
	     public void downloadFile(HttpServletResponse response,HttpServletRequest request) throws IOException {
	  		 
	         try{
	        	 logger.info("Inside Controller downloadFile()");
	        	 String fileId=request.getParameter("fileId");
	        	String fileName=request.getParameter("fileName");
	        	 //logger.info("Byte Array::::"+fileName); 
	        	
	        	String fileContent=readmailService.getFileAttachment(fileId);
	        	 byte[] decodedBytes = new sun.misc.BASE64Decoder().decodeBuffer(fileContent);	
	        	 response.setContentType("application/octet-stream");
	        	 response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+ "\"");
	         /* System.out.println(fileContent);
	          byte[] decodedBytes = new sun.misc.BASE64Decoder().decodeBuffer(fileContent);	   */       
	            //logger.info("Byte Array::::"+fileContent);   
	      
	          //response.setHeader("Content-Disposition", "attachment; filename=\""+file.getName()+ "\"");
	         	           
	          OutputStream out = response.getOutputStream();
	          InputStream is = new ByteArrayInputStream(decodedBytes);
	          int len;
	          while ((len = is.read(decodedBytes)) != -1) {
	        	  out.write(decodedBytes, 0, len);
	           }
	       out.flush();
	       out.close();
	       is.close();    
	          
	           
	         }catch (Exception e) {
	          logger.error(e.getMessage(),e); 
	          throw e;
	   }
	        
	     }
	  	
	  	@RequestMapping("/gettoid")
		public String mailbox(Model model,ComposeDto composeDto, HttpServletRequest request,
				@RequestParam("hidden_toid") String hidden_toid,
				@RequestParam("hidden_fromid") String hidden_fromid,
				@RequestParam("hidden_subject") String hidden_subject,
				@RequestParam("hidden_msgid") String hidden_msgid,
				@RequestParam("hidden_body") String hidden_body,
				@RequestParam("hidden_senttime") String hidden_senttime,
				@RequestParam("hidden_reply") String hidden_reply,
				@RequestParam("hidden_seqId") String hidden_seqId)
				throws ProcessingException {
	  		
	  		HttpSession session = request.getSession(); 
	  		String userId = (String) session.getAttribute("userId");
	  		System.out.println("::::::::::::::::::::::::::::sqnce ID"+hidden_seqId);
	  		 try {
	  		model.addAttribute("hidden_msgid",hidden_msgid);
	  		model.addAttribute("STATUS","REPLY");
	  		hidden_subject=hidden_subject.replaceAll(",","");
	  		model.addAttribute("hidden_subject",hidden_subject);
	  		hidden_body=hidden_body.replaceAll(",","");
	  		//model.addAttribute("hidden_body",hidden_body);
	  		model.addAttribute("hidden_senttime",hidden_senttime);
	  		model.addAttribute("hidden_seqId",hidden_seqId);
	  		//model.addAttribute("hidden_fromid",hidden_fromid);
	  		//String returnStatus="";
	  		//composeDto.setStatus("REPLY");
	  	
	  		System.out.println(hidden_toid+"<<<<hidden_toid>>>>>");
	  		System.out.println(hidden_fromid+"<<<<hidden_fromid>>>>>");
	  	if((userId.equals(hidden_toid)||(userId==hidden_toid))){
	  			model.addAttribute("hidden_toid",hidden_fromid);
	  			System.out.println(userId+"yaaaadu");
	  		}
	  		else{
	  			model.addAttribute("hidden_toid",hidden_toid);
	  			System.out.println(hidden_fromid+"suabsh");
	  		}
	  	   } catch (Exception e) {
	  	    logger.error(e.getMessage(), e);
	  	   }
			return "compose";
		}
	  	@RequestMapping("/forwardMessage")
			public String forwardMessage(Model model, HttpServletRequest request,@RequestParam("hidden_seqId") String sequenceId)throws ProcessingException {
	  		 try {
	  		System.out.println(sequenceId+"function forward");
	  		model.addAttribute("hidden_seqId",sequenceId);
	  		model.addAttribute("STATUS","FORWARD");
	  		 } catch (Exception e) {
	 	  	    logger.error(e.getMessage(), e);}
	  		 
	  		return "compose";	
	  	}
	  	

}
