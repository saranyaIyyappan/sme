package com.interland.payment.dao;

import java.util.List;

import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;

public interface ComposeDao {

	boolean saveComposeMail(Emails cmpse);

	List<Emails> getmsgid(String userid, String userIdSearch);

	List<Emails> getreadmaildetails(String userid);

	boolean saveAttachments(EmailAttachment attachment);

	List<Emails> getcountmsg(String userid);

	Emails updategetMailid(String msgid);

	boolean updateComposeMail(Emails cmpse);

	List<Emails> getListOfMessage(String sequenceId, String userid);

	List<EmailAttachment> getAttachments(Integer msgId);

	EmailAttachment getAttachmentFile(String attachments);

	/*
	  boolean updateAttachments(EmailAttachment attachment);
*/


}
