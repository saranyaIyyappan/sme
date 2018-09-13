package com.interland.payment.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;




@Entity
@Table(name = "SME_EMAIL_ATTACH")


public class EmailAttachment implements Serializable

{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ATTACH_SEQ")
	@GeneratedValue(generator ="ATTACH_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="ATTACH_SEQ",sequenceName="FILE_SEQ",allocationSize=1)
	Long attachmentSeq;
	
	
	@Column(name = "FILE_NAME")
	String fileName;
	
	@Column(name = "ATTACH_FILE")
	String attachMentFile;
	
	@Column(name = "SEQ_ID")
	String seqid;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "UPLOAD_TIME")
	Date uploadTime;

	@JoinColumn(name = "MSG_ID", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	//@LazyToOne(LazyToOneOption.PROXY)
	Emails eMail;

	public Long getAttachmentSeq() {
		return attachmentSeq;
	}

	public void setAttachmentSeq(Long attachmentSeq) {
		this.attachmentSeq = attachmentSeq;
	}

	public Emails geteMail() {
		return eMail;
	}

	public void seteMail(Emails eMail) {		
		this.eMail = eMail;
		//this.msgid = eMail.getMsgid();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAttachMentFile() {
		return attachMentFile;
	}

	public void setAttachMentFile(String attachMentFile) {
		this.attachMentFile = attachMentFile;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

	
	
	
	
}
