package com.interland.payment.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.interland.payment.dao.ComposeDao;
import com.interland.payment.dao.MailBoxDao;
import com.interland.payment.dao.ReadmailDao;
import com.interland.payment.dto.ComposeDto;
import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;
import com.interland.payment.entity.Users;
import com.interland.payment.exception.DataAccessException;
import com.interland.payment.exception.ProcessingException;

@Service("readmailService")
@Transactional
public class ReadmailServiceImpl implements ReadmailService {
	Logger logger = Logger.getLogger(ReadmailServiceImpl.class.getName());
	@Autowired
	ReadmailDao readmailDao;
	@Autowired
	MailBoxDao mailBoxDao;
	@Autowired
	ComposeDao composeDao;

	@Override
	public String getreadmail(String msgid, String userId, ComposeDto composeDto) {
		JSONArray arrGetAllList=new JSONArray();
		JSONObject res = new JSONObject();
		
		 String sendMailTime="";
		 DateFormat dateFormat=null;
		try {
			 dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			//Emails getdetails=readmailDao.getreadmail(composeDto.getMsgid());
			List <Emails> getdetails=readmailDao.getreadmail(composeDto.getMsgid());
			for (Emails emails : getdetails) {
				List <Emails> getMails=readmailDao.getMails(emails.getSeqid(),userId);
				JSONArray newArrGetAllList=new JSONArray();
				for(Emails mails : getMails){
				 long diff = new Date().getTime()-mails.getSenttime().getTime();
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
		        	 sendMailTime =dateFormat.format(mails.getSenttime()) ; 
		         } 
		         logger.info(sendMailTime);
		         int count = 0;
		         List<Emails> getcount = mailBoxDao.getcountmsg(userId);
		         for (Emails cmpse1 : getcount) {
			    	++count;
		         }
		         System.out.println(count);
		         
				JSONObject objList=new JSONObject();
				objList.put("Createdby",mails.getCreatedby());	
				objList.put("Toid",mails.getToid());
				objList.put("Body",mails.getBody());
				objList.put("Subject",mails.getSubject());
				objList.put("Senttime",sendMailTime);
				objList.put("msgid",mails.getMsgid());
				objList.put("count",count);
				objList.put("Status",mails.getStatus());
				objList.put("seqid", mails.getSeqid());
				//System.out.println(mails.getEmailAttachments()+"sreeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				if(mails.getEmailAttachments().isEmpty()){
					objList.put("filename","null");
					objList.put("fileID","null");
				}else{
									
					System.out.println( mails.getEmailAttachments());	
					List<EmailAttachment> test= (List<EmailAttachment>) mails.getEmailAttachments();
				
					for(EmailAttachment emailatt :test){
						
						JSONObject newObjList=new JSONObject();
						System.out.println(""+emailatt.getFileName());
						newObjList.put("filename",emailatt.getFileName());
						newObjList.put("fileID", emailatt.getAttachmentSeq());
						newObjList.put("msgId",mails.getMsgid());
						newArrGetAllList.add(newObjList);
					}
				
					
					
			}
				arrGetAllList.add(objList);
			}
				res.put("aData", newArrGetAllList);
			}
			res.put("aaData", arrGetAllList);
		
			
			
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			throw e;
		}
		
		return res.toString();
		
	}

	/*@Override
	public String getFileContentById(String messageId, ComposeDto composeDto) {
		JSONArray arrGetAllList=new JSONArray();
		JSONObject res = new JSONObject();
		EmailAttachment emailAttachment = null;
		try {
			List <EmailAttachment> getattachmentsdetails=readmailDao.getattachments(messageId);
			for (EmailAttachment eMail : getattachmentsdetails) {
		         
				JSONObject objList=new JSONObject();
				objList.put("attachments",eMail.getFileName());
				objList.put("filename", eMail.geteMail());
				objList.put("msgid", eMail.geteMail().getMsgid());
				 System.out.println(">>>>>service>>>>"+eMail.geteMail());
				arrGetAllList.add(objList);
			}
			res.put("aaData", arrGetAllList);
			
			
		} catch (Exception e) {
			logger.info(">>>>>service>>>>>"+arrGetAllList);
			logger.error(e.getMessage(), e);
			throw e;
		}
		return arrGetAllList.toString();
		
	}*/

	@Override
	public String getFileAttachment(String fileId) {
		String attachment = readmailDao.getAttachment(fileId);
		logger.info(attachment+"getFileAttachment(String fileId)");
      return attachment;
	}
	

	


	@Override
	public String getFileContentById(String messageId, ComposeDto composeDto,String sequenceId) {
		JSONArray arrGetAllList=new JSONArray();
		JSONObject res = new JSONObject();
		try {
			List<EmailAttachment> emailAttachments=new ArrayList<EmailAttachment>();
			List<EmailAttachment> getattachmentsdetails=readmailDao.getattachments(messageId,sequenceId);
				 if (!StringUtils.isEmpty(getattachmentsdetails)){
				 for (EmailAttachment eMail : getattachmentsdetails) {
					
						JSONObject objList=new JSONObject();
						objList.put("filename",eMail.getFileName());
						objList.put("fileID",eMail.getAttachmentSeq());
						//objList.put("FileCheck",eMail.getAttachMentFile());						
						arrGetAllList.add(objList);
					
				 }
			 }
				  
			
			res.put("aaData", arrGetAllList);
			
			
		} catch (Exception e) {
			logger.info(">>>>>service>>>>>"+arrGetAllList);
			logger.error(e.getMessage(), e);
			throw e;
		}
		return arrGetAllList.toString();
		
	}

	@Override
	public String getreply(String hidden_msgid, String userId,ComposeDto composeDto) {
		JSONObject jsonobjStatus = new JSONObject();
		Date date=new Date();
		try {
			Emails cmpse = new Emails();
			
			if (!StringUtils.isEmpty(cmpse)) {
				List<Emails> getreply=readmailDao.getreply(hidden_msgid);
				System.out.println(hidden_msgid+"abcde");
				boolean returnStatus = composeDao.saveComposeMail(cmpse);
			} else {
				jsonobjStatus.put("status", "Failed");
				jsonobjStatus.put("message", "Mail send Failed");

			}
		} catch (DataAccessException e) {
			logger.info(e.getMessage(), e);
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		return jsonobjStatus.toString();
	}


	
	
}
