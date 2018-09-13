package com.interland.payment.dto;

public class MailDto {
	
	String mailContent;
	String serverAdress;
	String smtpAdress;
	String smtpPort;
	String fromMail;
	String mesageSub;
	String toMail;
	
	
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public String getServerAdress() {
		return serverAdress;
	}
	public void setServerAdress(String serverAdress) {
		this.serverAdress = serverAdress;
	}
	public String getSmtpAdress() {
		return smtpAdress;
	}
	public void setSmtpAdress(String smtpAdress) {
		this.smtpAdress = smtpAdress;
	}
	public String getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}
	public String getFromMail() {
		return fromMail;
	}
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	public String getMesageSub() {
		return mesageSub;
	}
	public void setMesageSub(String mesageSub) {
		this.mesageSub = mesageSub;
	}
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	
	

}
