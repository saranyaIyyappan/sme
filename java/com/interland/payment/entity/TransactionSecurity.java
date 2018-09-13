package com.interland.payment.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pay_trn_sec")
public class TransactionSecurity {

	@Id
	@Column(name = "TRE_SEC_ID")
	private String securityId;
	@Column(name = "TRANCTION_ID")
	private String transactionId;
	@Column(name = "CARD_ENRLD")
	private String cardEnrolled;
	@Column(name = "ECI")
	private String eci;
	@Column(name = "VER_TKN")
	private String verToken;
	@Column(name = "VER_TYPE")
	private String verType;
	@Column(name = "XID")
	private String xid;
	@Column(name = "REQUEST_NAME")
	private String requestName;
	@Column(name = "VER_STATUS")
	private String verStatus;
	@Column(name = "enterdby")
	private long enterdby;
	
	@Column(name = "date_cre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCre;
	
	@Column(name = "updatedby")
	private BigInteger updatedby;
	
	@Column(name = "date_upd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpd;

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCardEnrolled() {
		return cardEnrolled;
	}

	public void setCardEnrolled(String cardEnrolled) {
		this.cardEnrolled = cardEnrolled;
	}

	public String getEci() {
		return eci;
	}

	public void setEci(String eci) {
		this.eci = eci;
	}

	public String getVerToken() {
		return verToken;
	}

	public void setVerToken(String verToken) {
		this.verToken = verToken;
	}

	public String getVerType() {
		return verType;
	}

	public void setVerType(String verType) {
		this.verType = verType;
	}

	public String getXid() {
		return xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}

	public String getVerStatus() {
		return verStatus;
	}

	public void setVerStatus(String verStatus) {
		this.verStatus = verStatus;
	}

	public long getEnterdby() {
		return enterdby;
	}

	public void setEnterdby(long enterdby) {
		this.enterdby = enterdby;
	}

	public Date getDateCre() {
		return dateCre;
	}

	public void setDateCre(Date dateCre) {
		this.dateCre = dateCre;
	}

	public BigInteger getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(BigInteger updatedby) {
		this.updatedby = updatedby;
	}

	public Date getDateUpd() {
		return dateUpd;
	}

	public void setDateUpd(Date dateUpd) {
		this.dateUpd = dateUpd;
	}

}
