package com.interland.payment.service;

public interface TransactionService {

	String getAllTransactionList(String loggedUserId,int nextCount,int startCount);

	String getOperationforTransaction(String transactionId);

}
