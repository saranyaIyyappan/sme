package com.interland.payment.service;

import java.util.List;
import java.util.Map;

import com.interland.payment.dto.ScreenBean;
import com.interland.payment.dto.UserDetailsDto;
import com.interland.payment.exception.ProcessingException;

public interface UserService {

	UserDetailsDto loggedUserDetails(String userId);
	boolean authenticateUser(String userId, String password)throws Exception ;
	public Map<String, List<ScreenBean>> getScreensforUser(String userId,String menu) throws ProcessingException; 
//	public String getHomeScreen(String userId);
//	public void saveUserLoginAttempt(String userId, String logStatus,String ipAddress, String reason);
	String getScreensforUser(String userId);
}
