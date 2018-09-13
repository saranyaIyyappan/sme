package com.interland.payment.dto;

import java.util.Date;

public class ComposeDto {
	
	
	private String msgid;
    private String subject;
    private String body;
    private String toid;
    private String status;
    private String createdby;
    private Date date;
    private String replymsg;
    private String seqid;
    
	public String getReplymsg() {
		return replymsg;
	}
	public void setReplymsg(String replymsg) {
		this.replymsg = replymsg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
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
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	
    
    
    
    
}
