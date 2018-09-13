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
@Table(name = "pay_trn_ins")	
public class TransactionInstalment {

	@Id
	@Column(name = "INSTALLMENT_ID")
	private String installmentId;
    
	@Column(name = "TRANCTION_ID")
	private String tranctionId;

	@Column(name = "AUTHERIZATION_CODE")
	private String autherizationCode;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
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

	public String getInstallmentId() {
		return installmentId;
	}

	public void setInstallmentId(String installmentId) {
		this.installmentId = installmentId;
	}

	public String getTranctionId() {
		return tranctionId;
	}

	public void setTranctionId(String tranctionId) {
		this.tranctionId = tranctionId;
	}

	public String getAutherizationCode() {
		return autherizationCode;
	}

	public void setAutherizationCode(String autherizationCode) {
		this.autherizationCode = autherizationCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
