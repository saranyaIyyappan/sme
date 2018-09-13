package com.interland.payment.dao;

import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;


@Repository("composeDao")

public class ComposeDaoImpl implements ComposeDao{

	Logger logger = Logger.getLogger(ComposeDaoImpl.class.getName());
	@Autowired
	SessionFactory sessionFactory;
	Session session;
    Transaction transaction;
    
    
	@Override
	public boolean saveComposeMail(Emails cmpse) {
		 boolean blStatus=false;
			try {
				 session = sessionFactory.getCurrentSession();
				 session.save(cmpse);
				 blStatus=true;
			} catch (Exception e) {
				logger.error("Exception in saveComposeMail(compose cmpse)"+e.getMessage(),e);
			}
			return blStatus;
	}


	@Override
	public List<Emails> getmsgid(String userid,String userIdSearch) {
		   List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		    if (!StringUtils.isEmpty(userIdSearch)) {
				criteria.add(Restrictions.ilike("toid",userIdSearch+"%"));
			}
		    criteria.add(Restrictions.eq("createdby",(userid)));
		    criteria.add(Restrictions.not(Restrictions.in("status",new String[]{"Mail Deleted"})));
		    criteria.addOrder(Order.desc("senttime"));
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }


	@Override
	public List<Emails> getreadmaildetails(String userid) {
		   List <Emails>getreadmaildetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		    criteria.add(Restrictions.eq("createdby",(userid)));
		    getreadmaildetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getreadmaildetails;
		 }


	@Override
	public boolean saveAttachments(EmailAttachment attachment) {
		 boolean blStatus=false;
			try {
				 session = sessionFactory.getCurrentSession();
				 session.save(attachment);
				 blStatus=true;
			} catch (Exception e) {
				logger.error("Exception in saveAttachments(EmailAttachment attachment)"+e.getMessage(),e);
			}
			return blStatus;
	}


	@Override
	public List<Emails> getcountmsg(String userid) {
		   List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		   criteria.add(Restrictions.eq("status","UNREAD"));
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }


	@Override
	public Emails updategetMailid(String msgid) {
		Emails objStatusDetails = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid", Integer.parseInt(msgid)));
			System.out.println(msgid+"msgid>>>>>>>>>>");
			objStatusDetails = (Emails) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return objStatusDetails;
	}


		@Override
	public boolean updateComposeMail(Emails emails) {
		 boolean blStatus=false;
			try {
				 session = sessionFactory.getCurrentSession();
				 session.save(emails);
				 blStatus=true;
			} catch (Exception e) {
				logger.error("Exception in updateComposeMail(Emails cmpse)"+e.getMessage(),e);
			}
			return blStatus;
	}


		@Override
		public List<Emails> getListOfMessage(String sequenceId,String userid) {	
				   List <Emails>getdetails=null;  
				   try { 
				    session = sessionFactory.getCurrentSession();  
				    Criteria criteria = session.createCriteria(Emails.class); 
				    BigInteger seqId=new BigInteger(sequenceId);
				   criteria.add(Restrictions.eq("seqid",seqId));
				   criteria.add(Restrictions.eq("toid",userid));
				    getdetails=(List<Emails>)criteria.list(); 
				    } catch (Exception e) {  
				     logger.info("Exception in inboxdetails() method :"+ e); 
				     } 
				   
				   return getdetails;
				 }


		@Override
		public List<EmailAttachment> getAttachments(Integer msgId) {
			List<Emails> email = null;
			List<EmailAttachment> emailAttachments=null;
			try {
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(Emails.class);
				criteria.add(Restrictions.eq("msgid",msgId));
				email=(List <Emails>)criteria.list();	
				if(email.size()>0){				
					for(int x=0;x<email.size();x++)	{
						if(email.get(x).getEmailAttachments().size()>0){
		emailAttachments=(List<EmailAttachment>)(email.get(x).getEmailAttachments());
						}
						}
				}else{
					System.out.println("assdsadsa"+email.size());
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				email=null;
			}
			
			return emailAttachments;
		}


		@Override
		public EmailAttachment getAttachmentFile(String attachments) {
			EmailAttachment objStatusDetails = null;
			try {
				// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(EmailAttachment.class);
				criteria.add(Restrictions.eq("attachmentSeq",Long.parseLong(attachments)));
				objStatusDetails = (EmailAttachment) criteria.uniqueResult();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			System.out.println(objStatusDetails+"@@@@@@@@@@@@@@@@@sree@@@@@@@@@@@@@@");
			return objStatusDetails;
		}

		
		/*
	@Override
	public boolean updateAttachments(EmailAttachment attachment) {
		 boolean blStatus=false;
			try {
				 session = sessionFactory.getCurrentSession();
				 session.update(attachment);
				 blStatus=true;
			} catch (Exception e) {
				logger.error("Exception in saveAttachments(EmailAttachment attachment)"+e.getMessage(),e);
			}
			return blStatus;
	}
*/


    
}
