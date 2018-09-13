package com.interland.payment.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pay_trn_opr")
public class TransactionOperation {

	@Id
	@Column(name = "OPERATION_ID")
	private String oerationId;
	@Column(name = "TRANCTION_ID")
	private String transactionId;
	@Column(name = "AUTHERIZATION_CODE")
	private String authenticationCode;
	@Column(name = "OPERATION_TYPE")
	private String operationType;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	@Column(name = "OPERATION_DATE")
	private Date operationDate;
	@Column(name = "MESSAGE_CODE")
	private String msgCode;
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
	
	public String getOerationId() {
		return oerationId;
	}
	public void setOerationId(String oerationId) {
		this.oerationId = oerationId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAuthenticationCode() {
		return authenticationCode;
	}
	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
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
