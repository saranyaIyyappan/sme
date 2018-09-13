package com.interland.payment.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;





@Entity
@Table(name = "SME_EML_SRV")
@XmlRootElement(name="SME_EML_SRV")


public class Emails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator ="MSG_ID",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="MSG_ID",sequenceName="MSG_ID",allocationSize=1)
	@Column(name = "MSG_ID")
	private Integer msgid;
	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "BODY")
	private String body;
	@Column(name = "TO_ID")
	private String toid;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CREATED_BY")
	private String createdby;
	@Column(name = "SENT_TIME")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date senttime;
	@Column(name = "GRD_ID")
	private String grpid;
	@Column(name = "SEQ_ID")
	private BigInteger seqid;
	

	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "eMail",fetch = FetchType.LAZY)
	    private Collection<EmailAttachment> emailAttachments;
	
	  
	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getSenttime() {
		return senttime;
	}
	public void setSenttime(Date senttime) {
		this.senttime = senttime;
	}
	public String getGrpid() {
		return grpid;
	}
	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}
	public Collection<EmailAttachment> getEmailAttachments() {
		return emailAttachments;
	}
	public void setEmailAttachments(Collection<EmailAttachment> emailAttachments) {
		this.emailAttachments = emailAttachments;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigInteger getSeqid() {
		return seqid;
	}
	public void setSeqid(BigInteger seqid) {
		this.seqid = seqid;
	}
	
	
	
}
