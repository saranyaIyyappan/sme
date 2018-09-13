package com.interland.payment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author priya
 */
@Entity
@Table(name = "EFTSECGSC")
public class GroupScreen implements Serializable {

	@Id
	@Column(name = "group_id")
	private String groupId;
	@Id
	@Column(name = "screen_id")
	private String screenId;
	@Column(name = "add_fl")
	private String addFlag;
	@Column(name = "del_fl")
	private String delFlag;
	@Column(name = "upd_fl")
	private String updFlag;
	@Column(name = "dsp_fl")
	private String dspFlag;
	@Column(name = "ver_fl")
	private String verFlag;
	@Column(name = "sys_date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date sysDate;
	@Column(name = "pro_id")
	private String proId;
	@Column(name = "ver_id")
	private String verId;
	@Column(name = "pro_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date proTime;
	@Column(name = "ver_time")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date verTime;

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public String getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getUpdFlag() {
		return updFlag;
	}
	public void setUpdFlag(String updFlag) {
		this.updFlag = updFlag;
	}
	public String getDspFlag() {
		return dspFlag;
	}
	public void setDspFlag(String dspFlag) {
		this.dspFlag = dspFlag;
	}
	public String getVerFlag() {
		return verFlag;
	}
	public void setVerFlag(String verFlag) {
		this.verFlag = verFlag;
	}
	public Date getSysDate() {
		return sysDate;
	}
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getVerId() {
		return verId;
	}
	public void setVerId(String verId) {
		this.verId = verId;
	}
	public Date getProTime() {
		return proTime;
	}
	public void setProTime(Date proTime) {
		this.proTime = proTime;
	}
	public Date getVerTime() {
		return verTime;
	}
	public void setVerTime(Date verTime) {
		this.verTime = verTime;
	}

	

}