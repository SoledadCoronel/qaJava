package com.gointegro.Helpers;

public class ConfigElementsBO {
	
	private static String user = "admin";
	
	private static String passw = "m4rt3ll";
	
	private static String urlBackoffice = ConfigElements.getURL()+"/backoffice";
	
	private static String accountId = "";
	
	private static String platformId = "";

	public static String getUser() {
		return user;
	}

	public static String getPassw() {
		return passw;
	}
	
	public static String getUrlBackoffice() {
		return urlBackoffice;
	}

	public static String getAccountId() {
		return accountId;
	}
	
	public static String getPlatformId() {
		return platformId;
	}

}
