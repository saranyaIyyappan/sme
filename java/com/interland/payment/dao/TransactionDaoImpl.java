package com.interland.payment.dao;

import java.util.List;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interland.payment.entity.TransactionMaster;
import com.interland.payment.entity.TransactionOperation;




@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao {

	Logger logger = Logger.getLogger(TransactionDaoImpl.class.getName());
	@Autowired
	SessionFactory sessionFactory;
	Session session;
    Transaction transaction;
	@Override
	public List<TransactionMaster> getAllList(String loggedUserId,int nextCount,int startCount) {
	List<TransactionMaster> listTransactions= null;
		JSONParser parser = new JSONParser();
		logger.info("Inside getAllTransactionList in TransactionDaoImpl");
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(TransactionMaster.class);
			
		//	String department=null;
		//	String priority=null;
			String stat=null;
//				if (!StringUtils.isEmpty(searchParam)) {
//				JSONObject searchObject = (JSONObject) parser
//						.parse(searchParam);
		/*		department = (String) searchObject.get("department");
				priority = (String) searchObject.get("priority");
				stat = (String) searchObject.get("stat");
			   }
				if (!StringUtils.isEmpty(department)) {
					criteria.add(Restrictions.eq("department",(department)));
				}
				if (!StringUtils.isEmpty(priority)) {
					criteria.add(Restrictions.eq("priority",priority));
				}
				if (!StringUtils.isEmpty(stat)) {
					criteria.add(Restrictions.eq("status",(stat)));
				}else {
			 //   criteria.add(Restrictions.eq("status","processing"));
				}*/
		//	criteria.add(Restrictions.eq("merchantId",loggedUserId));
				  
			//criteria.add(Restrictions.eq("status",stat));
					
			criteria.setMaxResults(nextCount);
			criteria.setFirstResult(startCount);
			// criteria.addOrder(Order.desc("dateCre"));
		listTransactions = (List<TransactionMaster>) criteria.list();
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return listTransactions;
		
	}

	@Override
	public Long getRecordCountForListTheme(String loggedUserId,int nextCount,int startCount) {
		Long count = (long) 0;
		JSONParser parser = new JSONParser();
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(TransactionMaster.class);
//			String department=null;
//			String priority=null;
			String stat=null;
//				JSONObject searchObject = (JSONObject) parser
//						.parse(searchParam);
				
			/*	department = (String) searchObject.get("department");
				priority = (String) searchObject.get("priority");
				stat = (String) searchObject.get("stat");
				if (!StringUtils.isEmpty(department)) {
					criteria.add(Restrictions.eq("department",(department)));
				}
				if (!StringUtils.isEmpty(priority)) {
					criteria.add(Restrictions.eq("priority",priority));
				};
				if (!StringUtils.isEmpty(stat)) {
					criteria.add(Restrictions.eq("status",stat));
				}else {
			//	criteria.add(Restrictions.eq("status","processing"));
				}*/
			criteria.add(Restrictions.eq("merchantId",loggedUserId));		
			criteria.setMaxResults(nextCount);
			criteria.setFirstResult(startCount);
			criteria.addOrder(Order.desc("dateCre"));
			count = (Long) criteria.setProjection(Projections.rowCount())
							.uniqueResult();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return count;
	}

	@Override
	public List<TransactionOperation> getAlloperations(String transactionId) {
	
		logger.info("Inside getAlloperations in TransactionDaoImpl");
		List<TransactionOperation> getAllOperations=null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(TransactionOperation.class);
			
			criteria.add(Restrictions.eq("transactionId",transactionId));
			getAllOperations = (List<TransactionOperation>) criteria.list();
		} catch (Exception e) {
			logger.error("Exception in TransactionDaoImpl  getAlloperations() method :"
					+e.getMessage(),e);
		}
		return getAllOperations;
		
	}	
}
