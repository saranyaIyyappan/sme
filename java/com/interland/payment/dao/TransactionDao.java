package com.interland.payment.dao;

import java.util.List;

import com.interland.payment.entity.TransactionMaster;
import com.interland.payment.entity.TransactionOperation;

public interface TransactionDao {

	public List<TransactionMaster> getAllList(String loggedUserId,int nextCount,int startCount) ;

	public Long getRecordCountForListTheme(String loggedUserId,int nextCount,int startCount);

	public List<TransactionOperation> getAlloperations(String transactionId);

}
