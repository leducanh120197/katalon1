package com.opcbiz.fxprimus.utils;

public class EmailUtils {
	public static String get(String email) {
		String[] emailsplit = email.split("@");
		
		return emailsplit[0] + (System.currentTimeMillis()) +"@" +emailsplit[1];
	}
}
