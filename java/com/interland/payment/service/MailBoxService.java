package com.interland.payment.service;

import com.interland.payment.dto.ComposeDto;


public interface MailBoxService {

	String deletemailinbox(int [] msgIdList, ComposeDto composeDto);

	String getTrashMessages(String userid);

	String getInboxMessages(String userid, String sSearch);

	String deletetrash(String userid, int[] msgIdList);

	String notification(String userid,String messageid, int[] msgIdList);

}
