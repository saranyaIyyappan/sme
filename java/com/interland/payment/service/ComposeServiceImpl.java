package com.interland.payment.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.interland.payment.dao.ComposeDao;
import com.interland.payment.dao.MailBoxDao;
import com.interland.payment.dto.ComposeDto;
import com.interland.payment.dto.MailDto;
import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;
import com.interland.payment.exception.DataAccessException;
import com.interland.payment.util.SendEmail;

@Service("composeService")
@Transactional

public class ComposeServiceImpl implements ComposeService {
	Logger logger = Logger.getLogger(ComposeServiceImpl.class.getName());
	@Autowired
	ComposeDao composeDao;
	@Autowired
	MailBoxDao mailBoxDao;
	
	
	/************composemail***********************************rafi***************************/
	@Override
	public String composemail(ComposeDto composeDto, MailDto mailConfigDto,
			String mailContent,String userid,List<CommonsMultipartFile> fileList, String attachments, String fileName,String fileDelete,String fileUpload) {
		JSONObject jsonobjStatus = new JSONObject();
		Date date=new Date();
		try {
			System.out.println(">>>>>seqid"+composeDto.getSeqid());
			System.out.println(composeDto.getStatus()+">>>>>>>>>>new");
			//if((!StringUtils.isEmpty(composeDto.getStatus()==""))||(!StringUtils.isEmpty(composeDto.getStatus().equals(null)))){
			
			{
				Emails cmpse = new Emails();
				System.out.println("COMPOSE>>>>servicesave"+composeDto.getStatus()+composeDto.getMsgid());
				if (!StringUtils.isEmpty(cmpse)) {
					cmpse.setSubject(composeDto.getSubject());
					cmpse.setBody(composeDto.getBody());
					cmpse.setToid(composeDto.getToid());
					cmpse.setCreatedby(userid);
					cmpse.setStatus("UNREAD");
					cmpse.setSenttime(date);
					  long timeMilli = date.getTime();
					  BigInteger sequenceNumbr=   new BigInteger(String.valueOf(timeMilli));
					  System.out.println("::::::::::::::::::::::::::"+sequenceNumbr);
					  cmpse.setSeqid(sequenceNumbr);					 
					//cmpse.setSeqid(composeDto.getMsgid());
					System.out.println("aaaaaaaaaa"+composeDto.getSubject());
					
					boolean returnStatus = composeDao.saveComposeMail(cmpse);
					System.out.println(fileName+"meeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+fileDelete);
					if(fileName!=null&&fileName!="null"&&fileName!=""){
						if(!fileName.equalsIgnoreCase(fileDelete)){					
						List<String> fileid = Arrays.asList(attachments.split(","));	
							for(String fileId:fileid){							
							List<String> fileDel = Arrays.asList(fileDelete.split(","));		
							System.out.println(fileDel.size()+"11111111111111111");
								for(String filedel:fileDel){
								if(!fileId.equalsIgnoreCase(filedel)){	
							EmailAttachment emailObj=new EmailAttachment();
						EmailAttachment emails=composeDao.getAttachmentFile(fileId);
						emailObj.setAttachMentFile(emails.getAttachMentFile());
						emailObj.seteMail(cmpse);
						emailObj.setFileName(emails.getFileName());
						emailObj.setSeqid(sequenceNumbr.toString());
						
						boolean status=composeDao.saveAttachments(emailObj);
						}
					   }
						}
					}
					}
					
				 	for (CommonsMultipartFile commonsMultipartFile : fileList) {
						List<String> fileupload = Arrays.asList(fileUpload.split(","));	
						for(String files:fileupload){
							if(!commonsMultipartFile.getOriginalFilename().equals(files)){
				 		EmailAttachment attachment = new EmailAttachment();
					 	attachment.seteMail(cmpse);
					 	attachment.setSeqid(sequenceNumbr.toString());
						attachment.setFileName(commonsMultipartFile.getOriginalFilename());						
					 	attachment.setAttachMentFile(new sun.misc.BASE64Encoder().encode(commonsMultipartFile.getBytes()));
					 	
						returnStatus = composeDao.saveAttachments(attachment);
						}
						}
					}
					jsonobjStatus.put("status", "Success");
					jsonobjStatus.put("message", "Mail send successfully");
				}else {
					jsonobjStatus.put("status", "Failed");
					jsonobjStatus.put("message", "Mail send Failed");

				}
				
			}	
			//}
			 
		} catch (DataAccessException e) {
			logger.info(e.getMessage(), e);
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return jsonobjStatus.toString();

		
		}
	/*************************************************************************************/
	
	
	/*********getinbox****************************************rafi****************/

	@Override
	public String getinbox(String userid,String userIdSearch) {
	    JSONArray arrAlluserId = new JSONArray();
		 String sendMailTime="";
		 DateFormat dateFormat=null;
	      try {
	    	  dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	     List<Emails> getinboxdetails = composeDao.getmsgid(userid,userIdSearch);
	     for (Emails cmpse : getinboxdetails) {
	    	 long diff = new Date().getTime()-cmpse.getSenttime().getTime();
	         long diffHours = diff / (60 * 60 * 1000);
	         long justnow= diff/ (60 * 1000) % 60;
	         if(diffHours<24){
	        	 sendMailTime =diffHours+" Hours Ago" ;
	        	 long diffSeconds = diff / 1000 % 60;
		        
	        	 if(diffHours<1){
	        		 long diffMinutes = diff / (60 * 1000) % 60;
	        		 sendMailTime=diffMinutes+" Minutes ago" ;
	        		 if(diffMinutes<1){
	        			 sendMailTime=diffSeconds+" Seconds ago" ;
	        		 }
	        	 
	        	 }
	        	 
	         }else{
	        	 sendMailTime =dateFormat.format(cmpse.getSenttime()) ; 
	         } 
	         logger.info(sendMailTime);
	         int count = 0;
	         List<Emails> getcount = mailBoxDao.getcountmsg(userid);
	         for (Emails cmpse1 : getcount) {
		    	++count;
	      
	         }
	         System.out.println(count);
	      JSONObject jsonObjAllCodes = new JSONObject();
	      jsonObjAllCodes.put("messageId", cmpse.getMsgid());
	      jsonObjAllCodes.put("toid", cmpse.getToid());
	      jsonObjAllCodes.put("subject", cmpse.getSubject());
	      jsonObjAllCodes.put("body", cmpse.getBody());
	      jsonObjAllCodes.put("sendTime", sendMailTime);
	      jsonObjAllCodes.put("count", count);
	      
	      arrAlluserId.add(jsonObjAllCodes);
	     
	     }
	    
	    } catch (Exception e) {
	     logger.info(e.getMessage(),e);
	    }
	  
	    return arrAlluserId.toString();
	 }
	/*************************************************************************************/
	@Override
	public String getReadMail(String userid) {
	    JSONArray arrAlluserId = new JSONArray();
	    
	    try {
	     List<Emails> getinboxdetails = composeDao.getreadmaildetails(userid);
	     for (Emails cmpse : getinboxdetails) {
	      JSONObject jsonObjAllCodes = new JSONObject();
	      jsonObjAllCodes.put("toid", cmpse.getToid());
	      jsonObjAllCodes.put("subject", cmpse.getSubject());
	      jsonObjAllCodes.put("body", cmpse.getBody());
	      jsonObjAllCodes.put("senttime", cmpse.getSenttime().toString());
	      jsonObjAllCodes.put("createdby", cmpse.getCreatedby());
	      
	      arrAlluserId.add(jsonObjAllCodes);
	     }
	    } catch (Exception e) {
	     logger.info(e.getMessage(),e);
	    }
	  
	    return arrAlluserId.toString();
	 }


/*	@Override
	public String replysentmail(ComposeDto composeDto, MailDto mailConfigDto,
			String mailContent, String userid,
			List<CommonsMultipartFile> fileList) {
		JSONObject jsonobjStatus = new JSONObject();
		Date date=new Date();
		try {
			System.out.println(composeDto.getToid());
			System.out.println(composeDto.getStatus()+">>>>>>>>>>new");
			//if((!StringUtils.isEmpty(composeDto.getStatus()==""))||(!StringUtils.isEmpty(composeDto.getStatus().equals(null)))){
			if(composeDto.getStatus().equals("REPLY")){
				
				System.out.println("REPLY>>>>serviceupdate"+composeDto.getStatus()+composeDto.getMsgid());
				Emails emails = composeDao.updategetMailid(composeDto.getMsgid());
				if(!StringUtils.isEmpty(emails)){
				System.out.println(">>>rafi>"+composeDto.getToid());
				emails.setBody(composeDto.getBody());
				System.out.println(">>>>>>sree>>>"+composeDto.getToid());
				BigInteger sequenceId=new BigInteger(composeDto.getSeqid());
				emails.setSeqid(sequenceId);
				//emails.setCreatedby(userid);
				emails.setStatus("UNREAD");
				emails.setSenttime(date);
				
				
				
				boolean updatestatus = composeDao.updateComposeMail(emails);
			 	for (CommonsMultipartFile commonsMultipartFile : fileList) {
			 		EmailAttachment attachment = new EmailAttachment();
				 	attachment.seteMail(emails);
					attachment.setFileName(commonsMultipartFile.getOriginalFilename());						
				 	attachment.setAttachMentFile(new sun.misc.BASE64Encoder().encode(commonsMultipartFile.getBytes()));
					//returnStatus = composeDao.updateComposeMail(composeDto.getMsgid());
					//updatestatus= composeDao.updateAttachments(attachment);
				}
				jsonobjStatus.put("status", "Success");
				jsonobjStatus.put("message", "Mail send successfully");
			
			}
			}
		} catch (DataAccessException e) {
			logger.info(e.getMessage(), e);
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return jsonobjStatus.toString();

		
		}*/
	@Override
	public String replysentmail(ComposeDto composeDto, MailDto mailConfigDto,
			String mailContent,String userid,List<CommonsMultipartFile> fileList,String fileUpload) {
		JSONObject jsonobjStatus = new JSONObject();
		Date date=new Date();
		try {
			System.out.println(">>>>>seqid"+composeDto.getSeqid());
			System.out.println(composeDto.getStatus()+">>>>>>>>>>new");
			//if((!StringUtils.isEmpty(composeDto.getStatus()==""))||(!StringUtils.isEmpty(composeDto.getStatus().equals(null)))){
			
			{
				Emails cmpse = new Emails();
				System.out.println("COMPOSE>>>>servicesave"+composeDto.getStatus()+composeDto.getMsgid());
				if (!StringUtils.isEmpty(cmpse)) {
					cmpse.setSubject(composeDto.getSubject());
					cmpse.setBody(composeDto.getBody());
					cmpse.setToid(composeDto.getToid());
					cmpse.setCreatedby(userid);
					cmpse.setStatus("UNREAD");
					cmpse.setSenttime(date);
					System.out.println(">>>>>>sree>>>"+composeDto.getToid());
					BigInteger sequenceId=new BigInteger(composeDto.getSeqid());
					cmpse.setSeqid(sequenceId);
					//emails.setCreatedby(userid);
					
					//cmpse.setSeqid(composeDto.getMsgid());
					System.out.println("aaaaaaaaaa"+composeDto.getSubject());
					
					boolean returnStatus = composeDao.saveComposeMail(cmpse);
					
					
				 	for (CommonsMultipartFile commonsMultipartFile : fileList) {
				 		List<String> fileupload = Arrays.asList(fileUpload.split(","));	
						for(String files:fileupload){
							if(!commonsMultipartFile.getOriginalFilename().equals(files)){
				 		EmailAttachment attachment = new EmailAttachment();
					 	attachment.seteMail(cmpse);
						attachment.setFileName(commonsMultipartFile.getOriginalFilename());						
					 	attachment.setAttachMentFile(new sun.misc.BASE64Encoder().encode(commonsMultipartFile.getBytes()));
					 	attachment.setSeqid(sequenceId.toString());
						returnStatus = composeDao.saveAttachments(attachment);
					}
						}
				 	}
					jsonobjStatus.put("status", "Success");
					jsonobjStatus.put("message", "Mail send successfully");
				}else {
					jsonobjStatus.put("status", "Failed");
					jsonobjStatus.put("message", "Mail send Failed");

				}
				
			}	
			//}
			 
		} catch (DataAccessException e) {
			logger.info(e.getMessage(), e);
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return jsonobjStatus.toString();

		
		}


	@Override
	public String getListOfMessage(String sequenceId,String userid) {
		JSONArray arrAlluserId = new JSONArray();	  
		 JSONObject res = new JSONObject();
	    try {
	     List<Emails> getinboxdetails = composeDao.getListOfMessage(sequenceId,userid);
	 	JSONArray newArrGetAllList=new JSONArray();
	     for (Emails cmpse : getinboxdetails) {
	      JSONObject jsonObjAllCodes = new JSONObject();
	      jsonObjAllCodes.put("toid", cmpse.getToid());
	      jsonObjAllCodes.put("subject", cmpse.getSubject());
	      jsonObjAllCodes.put("body", cmpse.getBody());
	      jsonObjAllCodes.put("senttime", cmpse.getSenttime().toString());
	      jsonObjAllCodes.put("createdby", cmpse.getCreatedby());
	      jsonObjAllCodes.put("messageId",cmpse.getMsgid());
	      if(cmpse.getEmailAttachments().isEmpty()){
	    	  jsonObjAllCodes.put("filename","null");
	    	  jsonObjAllCodes.put("fileID","null");
	      }else{
	    	  List<EmailAttachment> test= (List<EmailAttachment>) cmpse.getEmailAttachments();
				
				for(EmailAttachment emailatt :test){
					
					JSONObject newObjList=new JSONObject();
					System.out.println(""+emailatt.getFileName());
					newObjList.put("filename",emailatt.getFileName());
					newObjList.put("fileID", emailatt.getAttachmentSeq());
					newObjList.put("msgId",cmpse.getMsgid());
					newArrGetAllList.add(newObjList);
				}
	      }
	      arrAlluserId.add(jsonObjAllCodes);
	    res.put("aData", newArrGetAllList);
	     }
	     res.put("aaData", arrAlluserId);
	     
	    } catch (Exception e) {
	     logger.info(e.getMessage(),e);
	    }
	  
	    return res.toString();
	 }

	
}
