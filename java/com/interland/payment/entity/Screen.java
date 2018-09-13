/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.interland.payment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author priya
 */
@Entity
@Table(name = "EFTSCREEN")
public class Screen implements Serializable {

	@Column(name = "screen_no")
	private String screenNo;
	@Id
	@Column(name = "screen_id")
	private String screenId;
	@Column(name = "screen_name")
	private String screenName;
	@Column(name = "screen_name_arabic")
	private String screenNameArabic;
	@Column(name = "link_scr")
	private String linkScr;
	@Column(name = "pro_id")
	private String proID;
	@Column(name = "ver_id")
	private String verID;
	@Column(name = "status")
	private String status;
	@Column(name = "date_cre")
	private String dateCre;
	@Column(name = "link_scr_ar")
	private String linkScrAr;

	public String getLinkScrAr() {
		return linkScrAr;
	}

	public void setLinkScrAr(String linkScrAr) {
		this.linkScrAr = linkScrAr;
	}


	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getScreenNameArabic() {
		return screenNameArabic;
	}

	public void setScreenNameArabic(String screenNameArabic) {
		this.screenNameArabic = screenNameArabic;
	}

	public String getLinkScr() {
		return linkScr;
	}

	public void setLinkScr(String linkScr) {
		this.linkScr = linkScr;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getVerID() {
		return verID;
	}

	public void setVerID(String verID) {
		this.verID = verID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateCre() {
		return dateCre;
	}

	public void setDateCre(String dateCre) {
		this.dateCre = dateCre;
	}

}
