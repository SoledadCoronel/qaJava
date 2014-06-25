package com.gointegro.Helpers;

public class ConfigElementsBO {
	
	private static String user = "admin";
	
	private static String passw = "m4rt3ll";
	
	private static String urlBackoffice = ConfigElements.getURL()+"/backoffice";
	
	private static String accountId = "213";
	
	private static String platformId = "";
	
	private static String hostname = ".p2-stage.gointegro.com";
	
	private static String accountPlatformTestName = "Automation Test Platform";

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
	
	public static String getHostName() {
		return hostname;
	}

	public static String getAccountPlatformTestName() {
		return accountPlatformTestName;
	}

}
