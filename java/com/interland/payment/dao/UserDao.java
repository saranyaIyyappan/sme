package com.interland.payment.dao;

import java.util.List;

import com.interland.payment.entity.LogDetails;
import com.interland.payment.entity.Screen;
import com.interland.payment.entity.Users;


public interface UserDao {
	
	Users authenticateUser(String userId, String encryptPassword);
	Users loggedUserDetails(String userId);
	public Users getUserDetails(String userId);
	public List<Screen> getAllScreens(List<String> screenIds);
//	public boolean addLogDetails(LogDetails details);
	 public List<String> getAllScrrenForGroup(String groupId);
	 public List<Screen> getAllScrrens(List<String> screenIds);
}
