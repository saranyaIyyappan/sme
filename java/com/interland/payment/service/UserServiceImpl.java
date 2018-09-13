package com.interland.payment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.interland.payment.dao.UserDao;
import com.interland.payment.dto.ScreenBean;
import com.interland.payment.dto.UserDetailsDto;
import com.interland.payment.entity.LogDetails;
import com.interland.payment.entity.Screen;
import com.interland.payment.entity.Users;
import com.interland.payment.exception.DataAccessException;
import com.interland.payment.exception.ProcessingException;
import com.interland.payment.util.EncryptionUtil;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired UserDao userDao;
	
	@Override
	public boolean authenticateUser(String userId, String password) throws Exception {
		boolean status = false;
		try {
			logger.info("Inside authenticateUser() in UserServiceImpl");
			Users user = userDao.authenticateUser(userId,EncryptionUtil.encryptPassword(password));
			
			if(StringUtils.isEmpty(user)){
				status = false;
			}else{
				status = true;
			}
			
			
//			if(!user.getGroupId().equals("5")){ 				
//				boolean isActiveUser=userDao.isUserActive(user.getUserId());
//				if(isActiveUser){
//					if (!StringUtils.isEmpty(user)) {
//						logger.info("user is non empty in authenticateUser() of UserServiceImpl");
//						status = true;
//					}else{
//						logger.info("authenticateUser() from UserDaoImpl returning value is empty");
//						status = false;
//					}
//				}
//			}else{
//				logger.info(">>>>>>>>>>>>>>>>>>ADMIN");
//				if (!StringUtils.isEmpty(user)) {
//					logger.info("user is non empty in authenticateUser() of UserServiceImpl");
//					status = true;
//				}else{
//					logger.info("authenticateUser() from UserDaoImpl returning value is empty");
//					status = false;
//				}
//			}
			
			
		}  catch (Exception e) {
			logger.error("Exception authenticateUser() in UserServiceImpl "+ e.getMessage(),e);
			throw e;
				}		
		return status;
	}
		
	@Override
	public UserDetailsDto loggedUserDetails(String userId) {
		UserDetailsDto userDetailsDto=null;
		try {
			logger.info("Inside login() in UserServiceImpl");
			Users userObject = userDao.loggedUserDetails(userId);
			if (userObject != null) {
				logger.info("userObject inside login() in UserServiceImpl is not null");
				userDetailsDto=new UserDetailsDto();
				userDetailsDto.setUserId(userObject.getUserId());
				userDetailsDto.setUserName(userObject.getUserName());
				userDetailsDto.setGroupId(userObject.getGroupId());
				userDetailsDto.setProfilePicture(userObject.getProfilePicture());
			}
		} catch (Exception e) {
			logger.error("Exception loggedUserDetails() in UserServiceImpl "+ e.getMessage(),e);
			throw e;
		}
		return userDetailsDto;
	}
	
	@Override
	public Map<String, List<ScreenBean>> getScreensforUser(String userId,String menu) throws ProcessingException {
		String[] menuItems = menu.split(";");
		Map<String, String> propMenuMap = new HashMap<String, String>();
		Map<String, List<ScreenBean>> menuMap = new HashMap<String, List<ScreenBean>>();
		for (int i = 0; i < menuItems.length; i++) {
			String[] propMenuItems = menuItems[i].split("->");
			propMenuMap.put(propMenuItems[0], propMenuItems[1]);
		}
		List<ScreenBean> resArray = new ArrayList<ScreenBean>();
		try {
			Users user = userDao.getUserDetails(userId);
			if (!StringUtils.isEmpty(user)) {
				String groupId = user.getGroupId();
				List<String> screenIdArr = userDao.getAllScrrenForGroup(groupId);
				if (screenIdArr.size() > 0) {
					List<Screen> screenArr = userDao.getAllScrrens(screenIdArr);
					for (Screen screen : screenArr) {
						String scrId = screen.getScreenId();
						ScreenBean screenDto = new ScreenBean();
						screenDto.setScreenId(scrId);
						screenDto.setScreenName(screen.getScreenName());
					//	screenDto.setLogo(screen.getLinkTYpe());
						screenDto.setUrl(screen.getLinkScr());
						screenDto.setCls(screen.getLinkScrAr());
						String propMenuKey = "";
						String propMenuValue = "";
						 
						if (menu.indexOf(scrId) != -1) {
							Iterator propMenuItr = propMenuMap.entrySet()
									.iterator();
							while (propMenuItr.hasNext()) {
								Map.Entry propMenuEntry = (Map.Entry) propMenuItr
										.next();
								propMenuKey = propMenuEntry.getKey().toString();
								propMenuValue = propMenuEntry.getValue()
										.toString();
								if (propMenuValue.indexOf(scrId) != -1) {
									if (menuMap.containsKey(propMenuKey)) {
										resArray = menuMap.get(propMenuKey);
									}
									resArray.add(screenDto);
									break;
								}
							}
						} else {
							propMenuKey = "NoSubMenu";
							if (menuMap.containsKey(propMenuKey)) {
								resArray = menuMap.get(propMenuKey);
							}
							resArray.add(screenDto);
						}
						menuMap.put(propMenuKey, resArray);
						resArray = new ArrayList<ScreenBean>();
					}
				}
			}
		} catch (Exception e) {
			logger.error("Exception getScreensforUser() in UserServiceImpl "+ e.getMessage(),e);
					throw new ProcessingException();
		}
		return menuMap;
	}

	@Override
	public String getScreensforUser(String userId) {
		JSONObject returnstatus=new JSONObject();
		try {
			Users user = userDao.getUserDetails(userId);
			
		} catch (Exception e) {
			logger.error("Exception getScreensforUser() in UserServiceImpl "+ e.getMessage(),e);
					throw new ProcessingException();
		}
		return returnstatus.toString();
	}

//	@Override
//	public void saveUserLoginAttempt(String userId, String logStatus,
//			String ipAddress, String reason) {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh.mm.ss.SS a");
//        Calendar cal = Calendar.getInstance();
//        String formattedDate = sdf.format(cal.getTime());    
//    	boolean flag = false;
//        try {
//        	LogDetails details = new LogDetails();
//            details.setUserId(userId);
//            details.setLogStatus(logStatus);
//            details.setIpAddress(ipAddress);
//            details.setReason(reason);
//            details.setSysDate(new Date());
//        	details.setLogTime(sdf.parse(formattedDate)); 
//        	flag=userDao.addLogDetails(details);
//       } catch (DataAccessException | ParseException e) {
//			logger.error(e.getMessage(),e);
//			throw new ProcessingException();
//		}
//       
//	}
	
}
