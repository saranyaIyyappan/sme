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
@Table(name = "pay_trn_inv")	
public class TransactionInvoice { 

	@Id
	@Column(name = "INVOICE_NUMBER")
	private String invoiceNumber;
    
	@Column(name = "PYMNT_OPTN")
	private String pymntOptn;

	@Column(name = "MRCHNT_REF")
	private String mrchntRef;
	
	@Column(name = "ORDR_DESC")
	private String ordrDesc;
	
	@Column(name = "CUSTMR_EMAIL")
	private String custmrEmail;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "CURRENCY")
	private String currency;
	
	@Column(name = "NOTIFICN_TYPE")
	private String notificnType;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EXP_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;

	@Column(name = "LANGUAGE")
	private String language;
	
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

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPymntOptn() {
		return pymntOptn;
	}

	public void setPymntOptn(String pymntOptn) {
		this.pymntOptn = pymntOptn;
	}

	public String getMrchntRef() {
		return mrchntRef;
	}

	public void setMrchntRef(String mrchntRef) {
		this.mrchntRef = mrchntRef;
	}

	public String getOrdrDesc() {
		return ordrDesc;
	}

	public void setOrdrDesc(String ordrDesc) {
		this.ordrDesc = ordrDesc;
	}

	public String getCustmrEmail() {
		return custmrEmail;
	}

	public void setCustmrEmail(String custmrEmail) {
		this.custmrEmail = custmrEmail;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNotificnType() {
		return notificnType;
	}

	public void setNotificnType(String notificnType) {
		this.notificnType = notificnType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
