package com.interland.payment.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.interland.payment.entity.Emails;
import com.interland.payment.exception.DataAccessException;

@Repository("mailBoxDao")
public class MailBoxDaoImpl implements MailBoxDao {
	Logger logger = Logger.getLogger(MailBoxDaoImpl.class.getName());
	@Autowired
	SessionFactory sessionFactory;
	Session session;
    Transaction transaction;
    
    
	@Override
	public List<Emails> getmsgid(Integer strArrValues) {
		List <Emails>myLst=null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid", strArrValues));
			myLst=(List <Emails>)criteria.list();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return myLst;
	}
	
	@Override
	public boolean deleteDepartment(Emails cmpose) {
		boolean result = false;
		try {
			session = sessionFactory.getCurrentSession();
			session.delete(cmpose);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		return result;
		}

	@Override
	public boolean deleteMultipleMails(int[] msgIdList) {
		boolean result = false;
		try {
			session = sessionFactory.getCurrentSession();
			for(int i=0;i<msgIdList.length;i++)
		    {
		        if(i%20==0) {
		            session.flush();
		            session.clear();
		        }
		        Emails mails=(Emails)session.get(Emails.class,msgIdList[i]);
		        session.update(mails);
		    }
	 	    result = true;
		}catch (DataAccessException e) {
			logger.error(e.getMessage(), e);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
 	
		return result;
	}

	@Override
	public List<Emails> getTrashMessages(String userid) {
		   List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		   criteria.add(Restrictions.eq("status","Mail Deleted"));
		   criteria.addOrder(Order.desc("senttime"));
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }

	@Override
	public List<BigInteger> getInboxMessages(String userid,String userIdSearch) {
		   List <BigInteger>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class);
		  criteria.add(Restrictions.eq("toid",(userid)));
		   criteria.add(Restrictions.not(Restrictions.in("status",new String[]{"Mail Deleted"})));
		  if (!StringUtils.isEmpty(userIdSearch)) {
	    	//System.out.println(">>>>>>>>"+userIdSearch);
			criteria.add(Restrictions.ilike("createdby",userIdSearch+"%"));				
		}
		   
		//  criteria.addOrder(Order.desc("senttime"));
		   criteria.setProjection( Projections.projectionList()
			        .add( Projections.distinct(Projections.property("seqid")) )
				    );
		    getdetails=(List<BigInteger>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }

	@Override
	public Emails getprojectDetail(int msgIdList) {
		
		
		Emails getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		    criteria.add(Restrictions.eq("msgid", msgIdList));
		    getdetails = (Emails) criteria.uniqueResult();
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
	}

	@Override
	public boolean deletetrash(int[] msgIdList) {
		boolean result = false;
		try {
			session = sessionFactory.getCurrentSession();
			for(int i=0;i<msgIdList.length;i++)
		    {
		        if(i%20==0) {
		            session.flush();
		            session.clear();
		        }
		        Emails mails=(Emails)session.get(Emails.class,msgIdList[i]);
		        session.delete(mails);
		    }
	 	    result = true;
		}catch (DataAccessException e) {
			logger.error(e.getMessage(), e);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
 	
		return result;
	}

	@Override
	public List<Emails> getnotification(String userid, String messageid) {
		   List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		   criteria.add(Restrictions.eq("msgid",Integer.parseInt(messageid)));
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }

	@Override
	public List<Emails> getcountmsg(String userid) {
		   List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class); 
		   criteria.add(Restrictions.eq("toid",userid));
		   criteria.add(Restrictions.eq("status","UNREAD"));
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   
		   return getdetails;
		 }

	@Override
	public Emails getmsgid(String msgid) {
		Emails objStatusDetails = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			Integer messageid=new Integer(msgid);
			criteria.add(Restrictions.eq("msgid", messageid));
			objStatusDetails = (Emails) criteria.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return objStatusDetails;
	}

	@Override
	public List<Emails> getAllListAppend(BigInteger seqid) {
		 List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class);
		   criteria.add(Restrictions.eq("seqid",(seqid)));		   
		   criteria.addOrder(Order.desc("msgid"));
		   criteria.setMaxResults(1);
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   System.out.println(getdetails+":::::::::::::::::::::::::");
		   return getdetails;
	}

	@Override
	public List<Emails> getMesgId(Integer msgid) {
		List<Emails> objStatusDetails = null;
		try {
			// logger.info("inside method  getSaveStatusDetailsByPk() in StatusDaoImpl");
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Emails.class);
			criteria.add(Restrictions.eq("msgid", msgid));
			 criteria.setMaxResults(1);
			objStatusDetails = (List<Emails>)criteria.list(); 
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return objStatusDetails;
	
	}

	@Override
	public List<Emails> getMessage(BigInteger seqId) {
		List <Emails>getdetails=null;  
		   try { 
		    session = sessionFactory.getCurrentSession();  
		    Criteria criteria = session.createCriteria(Emails.class);
		   criteria.add(Restrictions.eq("seqid",(seqId)));
		   criteria.addOrder(Order.desc("senttime"));
		   criteria.setMaxResults(1);
		    getdetails=(List<Emails>)criteria.list(); 
		    } catch (Exception e) {  
		     logger.info("Exception in inboxdetails() method :"+ e); 
		     } 
		   System.out.println(getdetails+":::::::::::::::::::::::::");
		   return getdetails;
	}


	



}
