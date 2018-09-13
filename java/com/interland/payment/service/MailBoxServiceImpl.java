package com.interland.payment.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interland.payment.dao.MailBoxDao;
import com.interland.payment.dto.ComposeDto;
import com.interland.payment.entity.Emails;
import com.interland.payment.exception.DataAccessException;

@Service("mailBoxService")
@Transactional
public class MailBoxServiceImpl implements MailBoxService{
	Logger logger = Logger.getLogger(MailBoxServiceImpl.class.getName());
	@Autowired
	MailBoxDao mailBoxDao;
	
	
	@Override
	public String deletemailinbox(int [] msgIdList,ComposeDto composeDto) {
		JSONObject deleteDepartmentObject=new JSONObject();
	 	boolean deleteStatus=false;
		try {
			Emails cmpse=new Emails();
			List<Integer> list = new ArrayList<>(msgIdList.length);

			for (int i : msgIdList) {
				 cmpse = mailBoxDao.getprojectDetail(i);
				 cmpse.setStatus("Mail Deleted");
				
			}

			
			deleteStatus=mailBoxDao.deleteMultipleMails(msgIdList);
			if(deleteStatus){
				deleteDepartmentObject.put("status", "Success");
				deleteDepartmentObject.put("message", "deleted successfully");
			}else{
				deleteDepartmentObject.put("status", "Failed");
				deleteDepartmentObject.put("message", "deletion Failed");
			}
			
		}catch (DataAccessException e) {
			 logger.error(e.getMessage(), e);
			 throw new  DataAccessException();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			 
		}
		return deleteDepartmentObject.toString();
	}


	
	/*********getTrashMessages****************************************saranya****************/

	@Override
	public String getTrashMessages(String userid) {
	    JSONArray arrAlluserId = new JSONArray();
	    String sendMailTime="";
		 DateFormat dateFormat=null;
	    try {
	    	 dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	     List<Emails> getinboxdetails = mailBoxDao.getTrashMessages(userid);
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
	      jsonObjAllCodes.put("senttime",sendMailTime);
	      jsonObjAllCodes.put("count", count);
	      arrAlluserId.add(jsonObjAllCodes);
	     }
	    } catch (Exception e) {
	     logger.info("Exception in userdept getAllCodeFromsupportdepartment() method :"
	       + e);
	    }
	  
	    return arrAlluserId.toString();
	 }
	/*************************************************************************************/

	/*********getTrashMessages****************************************saranya****************/

	@Override
	public String getInboxMessages(String userid,String userIdSearch) {
	    JSONArray arrAlluserId = new JSONArray();
	    String sendMailTime="";
		 DateFormat dateFormat=null;
		 BigInteger messageId=null;
	    try {
	    	  dateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	     List<BigInteger> getinboxdetail = mailBoxDao.getInboxMessages(userid,userIdSearch);	
	    for(BigInteger seqId :getinboxdetail){
	    List<Emails> getinboxdetails= mailBoxDao.getMessage(seqId);
	     for (Emails cmpse : getinboxdetails) {
	    	
	    	 long diff = new Date().getTime()-cmpse.getSenttime().getTime();
	         long diffHours = diff / (60 * 60 * 1000);
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
	         int count = 0;
	         List<Emails> getcount = mailBoxDao.getcountmsg(userid);
	         
	         for (Emails cmpse1 : getcount) {
		    	++count;
	      
	         } 
	       
	         List<Emails> getListForAppend=mailBoxDao.getAllListAppend(cmpse.getSeqid());
	         
	        for(Emails emails:getListForAppend){
	        	
	      
	      System.out.println( emails.getSeqid());	
	      JSONObject jsonObjAllCodes = new JSONObject();
	      jsonObjAllCodes.put("messageId", emails.getMsgid());
	      jsonObjAllCodes.put("toid", emails.getCreatedby());
	      jsonObjAllCodes.put("subject", emails.getSubject());
	      jsonObjAllCodes.put("body", emails.getBody());
	      jsonObjAllCodes.put("Status", emails.getStatus());
	      jsonObjAllCodes.put("senttime", sendMailTime);
	      jsonObjAllCodes.put("count", count);
	      jsonObjAllCodes.put("seqId", emails.getSeqid());
	
	      arrAlluserId.add(jsonObjAllCodes);
	     }
	     }
	     }
	    } catch (Exception e) {
	     logger.info("Exception in userdept getAllCodeFromsupportdepartment() method :"
	       + e);
	    }
	  
	    return arrAlluserId.toString();
	 }
	/*************************************************************************************/



	@Override
	public String deletetrash(String userid,int[] msgIdList) {
		JSONObject deleteDepartmentObject=new JSONObject();
	 	boolean deleteStatus=false;
		try {
			Emails cmpse=new Emails();
			List<Integer> list = new ArrayList<>(msgIdList.length);

		/*	for (int i : msgIdList) {
				 cmpse = mailBoxDao.getprojectDetail(i);
				 cmpse.setStatus("Mail Deleted");
				
			}
*/
			
			deleteStatus=mailBoxDao.deletetrash(msgIdList);
			if(deleteStatus){
				deleteDepartmentObject.put("status", "Success");
				deleteDepartmentObject.put("message", "deleted successfully");
			}else{
				deleteDepartmentObject.put("status", "Failed");
				deleteDepartmentObject.put("message", "deletion Failed");
			}
			
		}catch (DataAccessException e) {
			 logger.error(e.getMessage(), e);
			 throw new  DataAccessException();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			 
		}
		return deleteDepartmentObject.toString();
	}



	@Override
	public String notification(String userid,String messageid,int[] msgIdList) {
		System.out.println("aa");
	    JSONArray arrAlluserId = new JSONArray();
	    try {
	     List<Emails> getinboxdetails = mailBoxDao.getnotification(userid,messageid);
	 	boolean blStatus=false;
	     for (Emails cmpse : getinboxdetails) {
	    	 System.out.println("ser"+messageid);
	         if(cmpse.getStatus().equals("UNREAD")){
	        	 cmpse.setStatus("readed");
        		 blStatus=mailBoxDao.deleteMultipleMails(msgIdList);
	         }
	   
	     }
	    } catch (Exception e) {
	     logger.info("Exception in userdept messageId() method :"
	       + e);
	    }
	  
	    return arrAlluserId.toString();
	 }






	
}
