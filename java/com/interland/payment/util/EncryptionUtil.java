package com.interland.payment.util;

public final class EncryptionUtil {
  public static String encryptPassword(String password) throws Exception {
    Encryption encryption = new EncryptionConfiguration();
    char[] tmp = (password == null) ? new char[0] : password.toCharArray();

    return encryption.encrypt(tmp);
  }
  public static String decryptPassword(String encryptedPsw) throws Exception {
    Encryption encryption = new EncryptionConfiguration();
    return encryption.decrypt(encryptedPsw);
  }

  public static String decryptSupersededPassword(String encryptedPsw) throws Exception {
    Encryption encryption = new EncryptionConfiguration(6);

    return encryption.decrypt(encryptedPsw);
  }
  
  public static void main(String args[]) throws Exception {
	  System.out.println(EncryptionUtil.decryptPassword(("2tz8DvmCDRh22ttJtCMHxQ==")));
	  System.out.println(EncryptionUtil.encryptPassword(("123")));
	  String name="hellooo";
	  String invoice="21212";
	  String result=invoice.concat(name);
	  System.out.println("afere"+result);
	  
	  
  }
  
}

