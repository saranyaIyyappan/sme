package com.interland.payment.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.interland.payment.entity.GroupScreen;
import com.interland.payment.entity.LogDetails;
import com.interland.payment.entity.Screen;
import com.interland.payment.entity.Users;
import com.interland.payment.exception.DataAccessException;


@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class.getName());
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
	@Override
	public Users authenticateUser(String userId, String encryptPassword) {
		
    	Users user = null;
    	
        try {
        	
        	logger.info("Inside authenticateUser() in UserDaoImpl");
            session = sessionFactory.getCurrentSession();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userId", userId));
            cr.add(Restrictions.eq("password", encryptPassword));
            cr.add(Restrictions.eq("accountStatus", "1"));
            user = (Users) cr.uniqueResult();
            
         } catch (Exception e) {
        	 
        	 logger.error("Exception authenticateUser() in UserDaoImpl "+e.getMessage(),e); 
        	 throw e;
        	 
        }
        return user;
	}

	@Override
	public Users loggedUserDetails(String userId) {

		Users user=null;
		try {
			logger.info("Inside login() of CommonDaoImpl");
            session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("userId",userId));
            user = (Users) criteria.uniqueResult(); 
         
        } catch (Exception e) {
        	logger.error("Exception loggedUserDetails() in UserDaoImpl "+e.getMessage(),e);
        	throw e;
        }
		return user;
	
	}
	@Override
	public Users getUserDetails(String userId) {
		Users user = null;
        try {
            session = sessionFactory.getCurrentSession();
            Criteria cr = session.createCriteria(Users.class);
            cr.add(Restrictions.eq("userId", userId));
            user = (Users) cr.uniqueResult();
        } catch (Exception e) {
        	logger.error("Exception getUserDetails() in UserDaoImpl "+e.getMessage(),e);
            throw e;      
        }
        return user;
	}
	
	  @Override
	    public List<Screen> getAllScreens(List<String> screenIds){
	        List<Screen> screenList = null;
	        try {
	            session = sessionFactory.getCurrentSession();
	            Criteria cr = session.createCriteria(Screen.class);
	            cr.add(Restrictions.in("screenId", screenIds));
	            cr.addOrder(Order.asc("screenNo"));
	            screenList = cr.list();
	            if (StringUtils.isEmpty(screenList)) {
	                screenList = new ArrayList<Screen>();
	            }
	        } catch (Exception e) {
	           	logger.error("Exception getAllScrrens() in UserDaoImpl "+e.getMessage(),e);
	                }
	        return screenList;
	    }

//		@Override
//		public boolean addLogDetails(LogDetails details) {
//			boolean status = false;
//			try {
//				session = sessionFactory.getCurrentSession();
//				session.save(details);
//				status = true;
//			} catch (Exception e) {
//				logger.error(e.getMessage(), e);
//				throw new DataAccessException();
//			}
//			return status;
//		}
	    @Override
	    public List<String> getAllScrrenForGroup(String groupId)  {
	        List<String> screenArr = null;
	        try {
	            session = sessionFactory.getCurrentSession();
	            Criteria cr = session.createCriteria(GroupScreen.class);
	            cr.add(Restrictions.eq("groupId", groupId));
	            cr.add(Restrictions.eq("dspFlag", "Y"));
	            cr.setProjection(Projections.property("screenId"));
	            screenArr = cr.list();
	            if (StringUtils.isEmpty(screenArr)) {
	                screenArr = new ArrayList<String>();
	            }
	        } catch (Exception e) {
	          	logger.error("Exception getAllScrrenForGroup() in UserDaoImpl "+e.getMessage(),e);}
	        return screenArr;
	    }
		   @Override
		    public List<Screen> getAllScrrens(List<String> screenIds){
		        List<Screen> screenList = null;
		        try {
		            session = sessionFactory.getCurrentSession();
		            Criteria cr = session.createCriteria(Screen.class);
		            cr.add(Restrictions.in("screenId", screenIds));
		            cr.addOrder(Order.asc("screenNo"));
		            screenList = cr.list();
		            if (StringUtils.isEmpty(screenList)) {
		                screenList = new ArrayList<Screen>();
		            }
		        } catch (Exception e) {
		           	logger.error("Exception getAllScrrens() in UserDaoImpl "+e.getMessage(),e);
		                }
		        return screenList;
		    }

	
}
