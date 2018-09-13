package com.interland.payment.dto;
public class UserDetailsDto {
	private String userId;
	private String userName;
	private String password;
	private String confirmPassword;
	private String emaild;
	private String cellNo;
	private String userType;
	private String orgId;
	private String groupId;
	private String orgDept;
	private Integer  userCat;
	private byte[] profilePicture;
	private String clinicId;
	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getOrgDept() {
		return orgDept;
	}

	public void setOrgDept(String orgDept) {
		this.orgDept = orgDept;
	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmaild() {
		return emaild;
	}

	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getUserCat() {
		return userCat;
	}

	public void setUserCat(Integer userCat) {
		this.userCat = userCat;
	}

	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	
}
