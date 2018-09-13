package com.interland.payment.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.log4j.Logger;

import com.interland.payment.dto.MailDto;

public class SendEmail {
	
	private static final Logger logger = Logger.getLogger(SendEmail.class
			.getName());

public boolean sendMailtest(MailDto mailConfigDto) {
	logger.info("Sending Mail To::::"+mailConfigDto.getToMail());
	boolean status=false;
	try{
		String mailContent=mailConfigDto.getMailContent();
		logger.info("mailContent:::"+mailContent);
	    Properties props = new Properties();
	    props.put("mail.smtp.host", mailConfigDto.getSmtpAdress());
	    props.put("mail.smtp.port", mailConfigDto.getSmtpPort());
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage mail = new MimeMessage(session);
	    mail.setFrom(new InternetAddress(mailConfigDto.getFromMail()));
	    mail.setRecipient(RecipientType.TO, new InternetAddress(mailConfigDto.getToMail()));
	    mail.setSubject(mailConfigDto.getMesageSub());
	    mail.setContent(mailContent,"text/html;charset=UTF-8;");  
	    mail.setSentDate(new Date());
	    Transport.send(mail);
	 
		status=true;
   }  catch (NoSuchProviderException e) {
	   status=false;
	   logger.error("Error() in sendMail() "+e.getMessage(),e);
   } catch (MessagingException e) {
	   status=false;
	   logger.error("Error() in sendMail() "+e.getMessage(),e);
   } catch(Exception e){
	   status=false;
		logger.error("Error() in sendMail() "+e.getMessage(),e);
	}
	logger.info("Mail Send Status:::::::"+status);
	return status;
}



public  boolean sendMail(MailDto mailConfigDto){
	boolean status=false;
	logger.info("Sending Mail To::::"+mailConfigDto.getToMail());
	try {
		SendEmail sendEmail=new SendEmail();
		Session session =sendEmail.getSession(mailConfigDto);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailConfigDto.getFromMail()));
		message.setRecipient(RecipientType.TO, new InternetAddress(mailConfigDto.getToMail()));
		message.setSubject(mailConfigDto.getMesageSub());
		message.setContent(mailConfigDto.getMailContent(),"text/html;charset=UTF-8;");  
		message.setSentDate(new Date());
		Transport transport = session.getTransport("smtp");
		transport.send(message);
		status=true;
		} catch (NoSuchProviderException e) {
			status=false;
		   logger.error("Error() in sendMail() "+e.getMessage(),e);
	   } catch (MessagingException e) {
		   status=false;
		   logger.error("Error() in sendMail() "+e.getMessage(),e);
	   } catch(Exception e){
		   status=false;
			logger.error("Error() in sendMail() "+e.getMessage(),e);
		
		}
	return status;
}
private Session getSession(MailDto mailConfigDto) {
	Authenticator authenticator = new Authenticator(mailConfigDto);
	Properties properties = new Properties();
	properties.setProperty("mail.smtp.starttls.enable", "false");
	properties.setProperty("mail.smtp.submitter",authenticator.getPasswordAuthentication().getUserName());
	properties.setProperty("mail.smtp.auth", "false");
	properties.setProperty("mail.smtp.host", mailConfigDto.getSmtpAdress());
	properties.setProperty("mail.smtp.port", mailConfigDto.getSmtpPort());
	properties.setProperty("mail.smtp.ssl.enable", "false");
	
	return Session.getInstance(properties, authenticator);
}
private class Authenticator extends javax.mail.Authenticator {
	private PasswordAuthentication authentication;


	public Authenticator(MailDto mailConfigDto) {
		String username = mailConfigDto.getFromMail();
		String password = "ctab@123";   //Production
		//String password = "Sipu@1234";	  //Local
		authentication = new PasswordAuthentication(username, password);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}

}
