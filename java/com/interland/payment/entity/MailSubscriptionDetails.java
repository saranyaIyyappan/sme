package com.interland.payment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "usr_mil_sub")
public class MailSubscriptionDetails {

	@Id
	@Column(name = "MAIL_ID")
	private String mailId;

	@Column(name = "DATE_SUB")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date subscriptionDate;

	@Column(name = "STATUS")
	private String status;

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	
	
	
}
