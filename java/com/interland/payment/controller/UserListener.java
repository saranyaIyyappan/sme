package com.interland.payment.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserListener implements HttpSessionBindingListener{
	private static Set<String> logins = new HashSet<String>();
	private String accountId;
    private boolean alreadyLoggedIn;
    private String userId;

    public UserListener(String userId) {
      this.userId = userId;
    }
	public void valueBound(HttpSessionBindingEvent event) {
	    if (logins.contains(userId)) {
	    	//logins.remove(userId);	
	    	alreadyLoggedIn = true;
	    } else {
	      logins.add(userId);
	    }
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logins.remove(userId);		
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public boolean isAlreadyLoggedIn() {
		return alreadyLoggedIn;
	}
	public void setAlreadyLoggedIn(boolean alreadyLoggedIn) {
		this.alreadyLoggedIn = alreadyLoggedIn;
	}
}
