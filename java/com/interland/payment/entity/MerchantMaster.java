package com.interland.payment.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pay_mer_mst")	
public class MerchantMaster {   

	@Id
	@Column(name = "MERCHANT_ID")
	private String merchantId;
    

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "COMPANY_ADDRESS")
	private String cmpanyAddress;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "STREET_NAME")
	private String streetName;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@Column(name = "ACC_NUMBER")
	private String accNumber;
	
	@Column(name = "IBAN_NUMBER")
	private String ibanNumber;
	
	@Column(name = "PRJCT_CHANNL")
	private String prjctChannl;
	
	@Column(name = "PRJCT_DOMAIN")
	private String prjctDomain;
	
	@Column(name = "PLATFORM")
	private String platform;
	
	@Column(name = "B2B")
	private int b2b;
	
	@Column(name = "B2C")
	private int b2c;
	
	@Column(name = "YEAR_INCOME")
	private BigDecimal yearIncome;
	
	@Column(name = "AMNT_FRM_TRN")
	private BigDecimal amntFrmTrn;
	
	@Column(name = "PER_MNTH_TRN")
	private BigDecimal perMnthTrn;
	
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

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmpanyAddress() {
		return cmpanyAddress;
	}

	public void setCmpanyAddress(String cmpanyAddress) {
		this.cmpanyAddress = cmpanyAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getIbanNumber() {
		return ibanNumber;
	}

	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}

	public String getPrjctChannl() {
		return prjctChannl;
	}

	public void setPrjctChannl(String prjctChannl) {
		this.prjctChannl = prjctChannl;
	}

	public String getPrjctDomain() {
		return prjctDomain;
	}

	public void setPrjctDomain(String prjctDomain) {
		this.prjctDomain = prjctDomain;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getB2b() {
		return b2b;
	}

	public void setB2b(int b2b) {
		this.b2b = b2b;
	}

	public int getB2c() {
		return b2c;
	}

	public void setB2c(int b2c) {
		this.b2c = b2c;
	}

	public BigDecimal getYearIncome() {
		return yearIncome;
	}

	public void setYearIncome(BigDecimal yearIncome) {
		this.yearIncome = yearIncome;
	}

	public BigDecimal getAmntFrmTrn() {
		return amntFrmTrn;
	}

	public void setAmntFrmTrn(BigDecimal amntFrmTrn) {
		this.amntFrmTrn = amntFrmTrn;
	}

	public BigDecimal getPerMnthTrn() {
		return perMnthTrn;
	}

	public void setPerMnthTrn(BigDecimal perMnthTrn) {
		this.perMnthTrn = perMnthTrn;
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
