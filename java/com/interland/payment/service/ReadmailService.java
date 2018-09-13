package com.interland.payment.service;

import java.math.BigInteger;

import com.interland.payment.dto.ComposeDto;

public interface ReadmailService {




	String getreadmail(String msgid, String userId, ComposeDto composeDto);


	String getFileContentById(String messageId, ComposeDto composeDto, String sequenceId);
	
	String getFileAttachment(String fileName);


	String getreply(String hidden_msgid, String userId, ComposeDto composeDto);


//	String getSequenceId(String hidden_msgid);



}
