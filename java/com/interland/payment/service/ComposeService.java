package com.interland.payment.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.interland.payment.dto.ComposeDto;
import com.interland.payment.dto.MailDto;

public interface ComposeService {

	String composemail(ComposeDto composeDto, MailDto mailConfigDto, String mailContent, String userid, List<CommonsMultipartFile> fileList, String attachment, String fileName, String fileDelete, String fileUpload);

	String getinbox(String userid, String userIdSearch);

	String getReadMail(String userid);

	String replysentmail(ComposeDto composeDto, MailDto mailConfigDto,
			String mailContent, String userid,
			List<CommonsMultipartFile> fileList, String fileUpload);

	String getListOfMessage(String sequenceId, String userid);


}
