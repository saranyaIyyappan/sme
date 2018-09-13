package com.interland.payment.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pay_mer_ser")	
public class MerchantService implements Serializable {   

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SERVICE_ID")
	private String serviceId;
    
	@Id
	@Column(name = "MERCHANT_ID")
	private String merchantId;

	@Column(name = "SERVICE_TYPE")
	private int serviceType;
	
	@Column(name = "DATE_FRM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFrm;
	
	@Column(name = "DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTo;
	
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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public Date getDateFrm() {
		return dateFrm;
	}

	public void setDateFrm(Date dateFrm) {
		this.dateFrm = dateFrm;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
