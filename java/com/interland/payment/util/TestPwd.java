package com.interland.payment.util;

public class TestPwd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		//	logger.info(EncryptionUtil.encryptPassword("admin"));
			System.out.println(EncryptionUtil.encryptPassword("root"));
			System.out.println(EncryptionUtil.decryptPassword("UAj/YRzeKpV63JSEqQ1uog=="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
