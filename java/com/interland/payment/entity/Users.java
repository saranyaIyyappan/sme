/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interland.payment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
*
* @author Interland
*/
@Entity
@Table(name = "EFTSECUSR")
public class Users implements Serializable{

@Id
@Column(name = "USER_ID")
private String  userId;
@Column(name = "USER_NAME")
private String  userName;
@Column(name = "GROUP_ID")
private String  groupId;
@Column(name = "PASSWORD")
private String  password;
@Column(name = "EMAIL_ID")
private String  emaild;
@Column(name = "CELL_NO")
private String  cellNo;
@Column(name = "SYS_DATE")
@Temporal(javax.persistence.TemporalType.DATE)
private Date  syaDate;
@Column(name = "TIME_CRE")
@Temporal(javax.persistence.TemporalType.DATE)
private Date  createdTime;
@Column(name = "TIME_VER")
@Temporal(javax.persistence.TemporalType.DATE)
private Date  verTime;
@Column(name = "LOG_TIME")
@Temporal(javax.persistence.TemporalType.DATE)
private Date  logTime;
@Column(name = "NUM_ATEPT")
private int  numAttempt;
@Column(name = "ACC_STS")
private String  accountStatus;
@Column(name = "RNV_PWSD")
private Integer  renewPassword;
@Column(name = "PWD_DATE")
@Temporal(javax.persistence.TemporalType.DATE)
private Date  passwordDate;
@Column(name = "PRO_ID")
private String  productionId;
@Column(name = "VER_ID")
private String  VerId;
@Column(name = "STATUS")
private String  status;
@Column(name = "LST_PWD1")
private String  lostPassword1;
@Column(name = "LST_PWD2")
private String  lostPassword2;
@Column(name = "LST_PWD3")
private String  lostPassword3;
@Column(name = "LST_PWD4")
private String  lostPassword4;
@Column(name = "LST_PWD5")
private String  lostPassword5;
@Column(name = "PHY_IMG")
private String  phyImage;
@Column(name = "FGET_PWD_Q1")
private String  forgetPasswordQuestion1;
@Column(name = "FGET_PWD_A1")
private String  forgetPasswordAnswer1;
@Column(name = "FGET_PWD_Q2")
private String  forgetPasswordQuestion2;
@Column(name = "FGET_PWD_A2")
private String  forgetPasswordAnswer2;
@Column(name = "LOGINSTATUS")
private Integer  loginStatus;
@Column(name = "PROFILE_PICTURE")
private byte[] profilePicture;

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmaild() {
        return emaild;
    }

    public void setEmaild(String emaild) {
        this.emaild = emaild;
    }

    public String getGroupId() {
    	return groupId;
    }

    public void setGroupId(String groupId) {
    	this.groupId = groupId;
    }

    public void setRenewPassword(Integer renewPassword) {
    	this.renewPassword = renewPassword;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public Date getSyaDate() {
        return syaDate;
    }

    public void setSyaDate(Date syaDate) {
        this.syaDate = syaDate;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getVerTime() {
        return verTime;
    }

    public void setVerTime(Date verTime) {
        this.verTime = verTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public int getNumAttempt() {
        return numAttempt;
    }

    public void setNumAttempt(int numAttempt) {
        this.numAttempt = numAttempt;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getRenewPassword() {
        return renewPassword;
    }

    public void setRenewPassword(int renewPassword) {
        this.renewPassword = renewPassword;
    }

    public Date getPasswordDate() {
        return passwordDate;
    }

    public void setPasswordDate(Date passwordDate) {
        this.passwordDate = passwordDate;
    }

    

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getVerId() {
        return VerId;
    }

    public void setVerId(String VerId) {
        this.VerId = VerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLostPassword1() {
        return lostPassword1;
    }

    public void setLostPassword1(String lostPassword1) {
        this.lostPassword1 = lostPassword1;
    }

    public String getLostPassword2() {
        return lostPassword2;
    }

    public void setLostPassword2(String lostPassword2) {
        this.lostPassword2 = lostPassword2;
    }

    public String getLostPassword3() {
        return lostPassword3;
    }

    public void setLostPassword3(String lostPassword3) {
        this.lostPassword3 = lostPassword3;
    }

    public String getLostPassword4() {
        return lostPassword4;
    }

    public void setLostPassword4(String lostPassword4) {
        this.lostPassword4 = lostPassword4;
    }

    public String getLostPassword5() {
        return lostPassword5;
    }

    public void setLostPassword5(String lostPassword5) {
        this.lostPassword5 = lostPassword5;
    }

   

    public String getPhyImage() {
        return phyImage;
    }

    public void setPhyImage(String phyImage) {
        this.phyImage = phyImage;
    }

    public String getForgetPasswordQuestion1() {
        return forgetPasswordQuestion1;
    }

    public void setForgetPasswordQuestion1(String forgetPasswordQuestion1) {
        this.forgetPasswordQuestion1 = forgetPasswordQuestion1;
    }

    public String getForgetPasswordAnswer1() {
        return forgetPasswordAnswer1;
    }

    public void setForgetPasswordAnswer1(String forgetPasswordAnswer1) {
        this.forgetPasswordAnswer1 = forgetPasswordAnswer1;
    }

    public String getForgetPasswordQuestion2() {
        return forgetPasswordQuestion2;
    }

    public void setForgetPasswordQuestion2(String forgetPasswordQuestion2) {
        this.forgetPasswordQuestion2 = forgetPasswordQuestion2;
    }

    public String getForgetPasswordAnswer2() {
        return forgetPasswordAnswer2;
    }

    public void setForgetPasswordAnswer2(String forgetPasswordAnswer2) {
        this.forgetPasswordAnswer2 = forgetPasswordAnswer2;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    
	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	
}
