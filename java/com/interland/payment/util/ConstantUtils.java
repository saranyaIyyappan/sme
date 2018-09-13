package com.interland.payment.util;
public class ConstantUtils {
	public static String getMode(Integer code) {
		if(code == null){
			return "";
		}
		switch (code) {
		case 1:
			return "Recurring Payment";
		case 3:
			return "One time";
		default:
			return "Other";
		}
		
	}

	public static String getCollectionType(Integer code) {
		if(code == null){
			return "";
		}
		switch (code) {
		case 11:
			return "Pre-Prepared";
		case 12:
			return "Incoming";
		case 16:
			return "One time";
		}
		return null;
	}

	public static String getFrequency(String code) {
		if(code == null){
			return "";
		}
		switch (code) {
		case "D":
			return "Daily";
		case "W":
			return "Weekly";
		case "M":
			return "Monthly";
		case "Q":
			return "Quarterly";
		case "S":
			return "Six Month";
		case "Y":
			return "Yearly";
		case "O":
			return "One time";
		}
		return null;
	}
}
