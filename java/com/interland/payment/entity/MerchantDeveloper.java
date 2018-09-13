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
	@Table(name = "pay_mer_dev")	
public class MerchantDeveloper {

		@Id
		@Column(name = "DEVELOPER_ID")
		private String developerId;
	    
	
		@Column(name = "MERCHANT_ID")
		private String merchantId;

		@Column(name = "NAME")
		private String name;
		
		@Column(name = "EMAIL")
		private String email;
		
		@Column(name = "MOBILE")
		private String mobile;
		
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

		public String getDeveloperId() {
			return developerId;
		}

		public void setDeveloperId(String developerId) {
			this.developerId = developerId;
		}

		public String getMerchantId() {
			return merchantId;
		}

		public void setMerchantId(String merchantId) {
			this.merchantId = merchantId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
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
