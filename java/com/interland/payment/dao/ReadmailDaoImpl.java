package com.interland.payment.dao;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;
import com.interland.payment.entity.Users;


@Repository("readmailDao")
public class ReadmailDaoImpl implements ReadmailDao {
	Logger logger = Logger.getLogger(ReadmailDaoImpl.class.getName());
	@Autowired
	SessionFactory sessionFactory;
	Session session;
    Transaction transaction;


	@Override
	public List<Emails> getreadmail(String msgid) {
		List<Emails> objToMail = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid", Integer.parseInt(msgid)));
			objToMail=(List <Emails>)criteria.list();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("::::::::::::::::::::::::"+objToMail);
		return objToMail;
	}
	@Override
	public List<Emails> getMails(BigInteger seqid,String userId) {
		List<Emails> objToMail = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("seqid",seqid));
			criteria.add(Restrictions.eq("toid", userId));
			objToMail=(List <Emails>)criteria.list();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("::::::::::::::::::::::::"+objToMail);
		return objToMail;
	}


	@Override
	public List<EmailAttachment> getattachments(String messageId,String sequenceId) {
		List<Emails> email = null;
		List<EmailAttachment> emailAttachments=null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid",Integer.parseInt(messageId)));			
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
	public String getAttachment(String fileId) {
		EmailAttachment attachment = null;
		String returnValue=null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(EmailAttachment.class);
			 long file=Long.parseLong(fileId);
			criteria.add(Restrictions.eq("attachmentSeq", file));
			attachment = (EmailAttachment) criteria.uniqueResult();
			returnValue=attachment.getAttachMentFile();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return returnValue;
	}


	@Override
	public boolean saveComposereplyMail(Emails cmpse) {
		 boolean blStatus=false;
			try {
				 session = sessionFactory.getCurrentSession();
				 session.saveOrUpdate(cmpse);
				 blStatus=true;
			} catch (Exception e) {
				logger.error("Exception in saveComposereplyMail(Emails cmpse)"+e.getMessage(),e);
			}
			return blStatus;
	}


	@Override
	public List<Emails> getreply(String hidden_msgid) {
		List<Emails> objToMail = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid", Integer.parseInt(hidden_msgid)));
			objToMail=(List <Emails>)criteria.list();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("::::::::::::::::::::::::"+objToMail);
		return objToMail;
	}



	
}
