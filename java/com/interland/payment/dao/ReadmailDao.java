package com.interland.payment.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.validator.constraints.Email;

import com.interland.payment.entity.EmailAttachment;
import com.interland.payment.entity.Emails;
import com.interland.payment.entity.Users;

public interface ReadmailDao {





	List<Emails> getreadmail(String msgid);

	List<EmailAttachment> getattachments(String messageId, String sequenceId);

	String getAttachment(String fileName);

	boolean saveComposereplyMail(Emails cmpse);

	List<Emails> getreply(String hidden_msgid);

	List<Emails> getMails(BigInteger seqid, String userId);


	//Emails getSequenceId(String hidden_msgid);


}
