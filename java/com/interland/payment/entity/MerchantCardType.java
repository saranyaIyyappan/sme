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
@Table(name = "mer_crd_typ")
public class MerchantCardType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CARD_TYPE")
	private String cardType;

	@Id
	@Column(name = "MERCHANT_ID")
	@Temporal(TemporalType.TIMESTAMP)
	private Date merchantId;

	@Column(name = "CREDIT_CARD")
	private int creditCard;

	@Column(name = "SADAD_ACC")
	private int sadadAcc;

	@Column(name = "MADA_SABB")
	private int madaSabb;

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

	public String getCard_type() {
		return cardType;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Date merchantId) {
		this.merchantId = merchantId;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public int getSadadAcc() {
		return sadadAcc;
	}

	public void setSadadAcc(int sadadAcc) {
		this.sadadAcc = sadadAcc;
	}

	public int getMadaSabb() {
		return madaSabb;
	}

	public void setMadaSabb(int madaSabb) {
		this.madaSabb = madaSabb;
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
