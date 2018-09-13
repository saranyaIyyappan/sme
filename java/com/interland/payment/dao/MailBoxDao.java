package com.interland.payment.dao;

import java.math.BigInteger;
import java.util.List;

import com.interland.payment.entity.Emails;

public interface MailBoxDao {

	boolean deleteDepartment(Emails cmpose);


	List<Emails> getmsgid(Integer strArrValues);


	boolean deleteMultipleMails(int[] msgIdList);


	List<Emails> getTrashMessages(String userid);


	List<BigInteger> getInboxMessages(String userid, String searchParam);


	Emails getprojectDetail(int i);


	boolean deletetrash(int[] msgIdList);


	List<Emails> getnotification(String userid, String messageid);


	List<Emails> getcountmsg(String userid);


	Emails getmsgid(String msgid);


	List<Emails> getAllListAppend(BigInteger seqid);


	List<Emails> getMesgId(Integer msgid);


	List<Emails> getMessage(BigInteger sequence);



}
