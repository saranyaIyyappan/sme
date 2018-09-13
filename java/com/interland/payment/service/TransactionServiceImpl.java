package com.interland.payment.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.interland.payment.dao.TransactionDao;
import com.interland.payment.entity.TransactionMaster;
import com.interland.payment.entity.TransactionOperation;


@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	Logger logger = Logger.getLogger(TransactionServiceImpl.class.getName());
	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public String getAllTransactionList(String loggedUserId,int nextCount,int startCount) {
		JSONArray arrGetAllList=new JSONArray();
		JSONObject res = new JSONObject();
		try {
			logger.info("Inside getAllTransactionList in TransactionServiceImpl");
			List<TransactionMaster> transactionsList = transactionDao.getAllList(loggedUserId,nextCount,startCount);
			Long rowCount = transactionDao.getRecordCountForListTheme(loggedUserId,nextCount,startCount);
			
			if(!StringUtils.isEmpty(transactionsList)){
			
			for (TransactionMaster transactionMaster : transactionsList) {
				JSONObject objList = new JSONObject();		
				objList.put("transactionId",transactionMaster.getTransactionId() );
				objList.put("merchantId",transactionMaster.getMerchantId() );
				objList.put("tokenId",transactionMaster.getTokenID() );
				objList.put("accessCode",transactionMaster.getAccessCode());	
				objList.put("merchantReference",transactionMaster.getMerchantReference());
				objList.put("amount",transactionMaster.getAmount());
				objList.put("currencyCode",transactionMaster.getCurrencyCode());
				objList.put("cardNumber",transactionMaster.getCardNumber());
				objList.put("status",transactionMaster.getStatus());				
				objList.put("cardType",transactionMaster.getCardType());
				objList.put("paymentMethod",transactionMaster.getPaymentMethod());
//				objList.put("expirydate",transactionMaster.getExpDate().toString());
				objList.put("cardHolderName",transactionMaster.getCardHolderName());
				objList.put("customerEmail",transactionMaster.getCustomerEmail());
				objList.put("customerName",transactionMaster.getCustomerName());
				objList.put("customerIp",transactionMaster.getCustomerIp());
				objList.put("geoIp",transactionMaster.getGeoIp());
				//objList.put("command",transactionMaster.getCommand());
				objList.put("description",transactionMaster.getDescription());
				objList.put("language",transactionMaster.getLanguage());
				objList.put("returnUrl",transactionMaster.getReturnUrl());
				objList.put("channel",transactionMaster.getChannel());
				objList.put("olpAlias",transactionMaster.getOlpAlias());
				objList.put("eci",transactionMaster.getEci());
				objList.put("installment",transactionMaster.getInstallment());	
				objList.put("fraud",transactionMaster.getFraud());
				objList.put("3dSecure",transactionMaster.getSecure3d());
				objList.put("invoiceNumber",transactionMaster.getInvoiceNumbe());
				objList.put("installmentIntrest",transactionMaster.getInstallmentInterest());
				objList.put("numbrOfInstallment",transactionMaster.getNoOfInstallment());
				objList.put("enteredBy",transactionMaster.getEnterdby());
				objList.put("dateCre",transactionMaster.getDateCre().toString());
				objList.put("updatedBy",transactionMaster.getUpdatedby());
				objList.put("dateupd",transactionMaster.getDateUpd());				
		
				arrGetAllList.add(objList);
			}
			}
			res.put("Data", arrGetAllList);
			res.put("iTotalDisplayRecords", rowCount);
			res.put("iTotalRecords", rowCount);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return res.toString();
		
	}

	@Override
	public String getOperationforTransaction(String transactionId) {
		JSONArray arrGetAllList=new JSONArray();
		JSONObject res = new JSONObject();
//		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		logger.info("Inside getOperationforTransaction in TransactionServiceImpl");
		try {	
		List<TransactionOperation> operationList=transactionDao.getAlloperations(transactionId);
		
		for (TransactionOperation transactionOperation : operationList) {
			JSONObject operationJson = new JSONObject();	
			
			operationJson.put("transactionId",transactionOperation.getTransactionId());
			operationJson.put("authorizationCode",transactionOperation.getAuthenticationCode());
			operationJson.put("status",transactionOperation.getStatus());
			operationJson.put("operation",transactionOperation.getOperationType());
			operationJson.put("amount",transactionOperation.getAmount());
			operationJson.put("currencyCode",transactionOperation.getCurrencyCode());
			operationJson.put("dateCreated",transactionOperation.getDateCre().toString());
			arrGetAllList.add(operationJson);
			}
			res.put("Data", arrGetAllList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
		return res.toString();
	}
}
