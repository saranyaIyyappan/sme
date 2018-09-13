package com.interland.payment.entity;

import java.io.Serializable;
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
@Table(name = "PAY_TRN_MST")
public class TransactionMaster  implements Serializable{

 
	@Id
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	@Id
	@Column(name = "MERCHANT_ID")
	private String merchantId;
	@Column(name = "TOKEN_ID")
	private String tokenID;
	@Column(name = "ACCESS_CODE")
	private String accessCode;
	@Column(name = "MRCHNT_REF")
	private String merchantReference;
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	@Column(name = "CARD_NUMBER")
	private String cardNumber;
	@Column(name = "CARD_TYPE")
	private String cardType;
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;
	@Column(name = "EXP_DATE")
	@Temporal(TemporalType.DATE)
	private Date expDate;
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	@Column(name = "CUSTMR_EMAIL")
	private String customerEmail;
	@Column(name = "CUSTMR_NAME")
	private BigDecimal customerName;
	@Column(name = "CUSTMR_IP")
	private String customerIp;
	@Column(name = "GEO_IP")
	private String geoIp;
	@Column(name = "COMMAND")
	private String command;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "DESCRIPTION")
	@Temporal(TemporalType.DATE)
	private Date description;
	@Column(name = "LANGUAGE")
	private String language;
	@Column(name = "RETURN_URL")
	private String returnUrl;
	@Column(name = "CHANNEL")
	private String channel;
	@Column(name = "OLP_ALIAS")
	private String olpAlias;
	@Column(name = "ECI")
	private String eci;
	@Column(name = "INSTALLMENT")
	private String installment;
	@Column(name = "FRAUD")
	private String fraud;
	@Column(name = "THREED_SECURE")
	private String secure3d;
	@Column(name = "INVOICE_NUMBER")
	private String invoiceNumbe;
	@Column(name = "INSTLMT_INTRST")
	private BigDecimal installmentInterest;
	@Column(name = "NO_OF_INSTLMT")
	private long noOfInstallment;
	@Column(name = "ENTERDBY")
	private long enterdby;

	@Column(name = "DATE_CRE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCre;

	@Column(name = "UPDATEDBY")
	private BigInteger updatedby;

	@Column(name = "DATE_UPD")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpd;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public String getTokenID() {
		return tokenID;
	}

	public void setTokenID(String tokenID) {
		this.tokenID = tokenID;
	}


	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getMerchantReference() {
		return merchantReference;
	}

	public void setMerchantReference(String merchantReference) {
		this.merchantReference = merchantReference;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public BigDecimal getCustomerName() {
		return customerName;
	}

	public void setCustomerName(BigDecimal customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}

	public String getGeoIp() {
		return geoIp;
	}

	public void setGeoIp(String geoIp) {
		this.geoIp = geoIp;
	}

	/*public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDescription() {
		return description;
	}

	public void setDescription(Date description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOlpAlias() {
		return olpAlias;
	}

	public void setOlpAlias(String olpAlias) {
		this.olpAlias = olpAlias;
	}

	public String getEci() {
		return eci;
	}

	public void setEci(String eci) {
		this.eci = eci;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public String getFraud() {
		return fraud;
	}

	public void setFraud(String fraud) {
		this.fraud = fraud;
	}

	public String getSecure3d() {
		return secure3d;
	}

	public void setSecure3d(String secure3d) {
		this.secure3d = secure3d;
	}

	public String getInvoiceNumbe() {
		return invoiceNumbe;
	}

	public void setInvoiceNumbe(String invoiceNumbe) {
		this.invoiceNumbe = invoiceNumbe;
	}

	public BigDecimal getInstallmentInterest() {
		return installmentInterest;
	}

	public void setInstallmentInterest(BigDecimal installmentInterest) {
		this.installmentInterest = installmentInterest;
	}

	public long getNoOfInstallment() {
		return noOfInstallment;
	}

	public void setNoOfInstallment(long noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
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
