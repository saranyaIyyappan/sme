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
@Table(name = "pay_mer_sec")
public class MerchantSecurity {    

	@Id
	@Column(name = "SECURITY_ID")
	private String securityId;
    

	@Column(name = "MERCHANT_ID")
	private String merchantId;

	@Column(name = "MRCHNT_REF")
	private String mrchntRef;
	
	@Column(name = "ACCESS_CODE")
	private String accessCode;
	
	@Column(name = "SHA_TYPE")
	private String shaType;
	
	@Column(name = "SHA_RQST_PHRASE")
	private String shaRqstPhrase;
	
	@Column(name = "SHA_RES_PHRASE")
	private String shaResPhrase;
	
	@Column(name = "ORGIN_IP")
	private String orginIp;
	
	@Column(name = "ORGIN_URL")
	private BigDecimal orginUrl;
	
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

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMrchntRef() {
		return mrchntRef;
	}

	public void setMrchntRef(String mrchntRef) {
		this.mrchntRef = mrchntRef;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getShaType() {
		return shaType;
	}

	public void setShaType(String shaType) {
		this.shaType = shaType;
	}

	public String getShaRqstPhrase() {
		return shaRqstPhrase;
	}

	public void setShaRqstPhrase(String shaRqstPhrase) {
		this.shaRqstPhrase = shaRqstPhrase;
	}

	public String getShaResPhrase() {
		return shaResPhrase;
	}

	public void setShaResPhrase(String shaResPhrase) {
		this.shaResPhrase = shaResPhrase;
	}

	public String getOrginIp() {
		return orginIp;
	}

	public void setOrginIp(String orginIp) {
		this.orginIp = orginIp;
	}

	public BigDecimal getOrginUrl() {
		return orginUrl;
	}

	public void setOrginUrl(BigDecimal orginUrl) {
		this.orginUrl = orginUrl;
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
