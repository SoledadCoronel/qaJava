package com.gointegro.Helpers;

public class ConfigElementsBO {
	
	private static String user = "admin";
	
	private static String passw = "m4rt3ll";
	
	private static String urlBackoffice = ConfigElements.getURL()+"/backoffice";
	
	private static String accountId = "213";
	
	private static String platformId = "";
	
	private static String hostname = ".p2-stage.gointegro.com";
	
	private static String accountPlatformTestName = "Fresenius Medical Care";
	
	private static String accountRegionalId = "215";

	private static String accountRegionalName = "Automation Test Platform Regional Hija";
	
	private static String webSiteAccount = "http://automationtestplatformregional.p2-stage.gointegro.com";
	
	private static String accountRegionalFather = "Automation Test Platform Regional";
	
	private static String accountRegionalFather2 = "Automation Test Platform 2 Regional";

	public static String getAccountRegionalFather2() {
		return accountRegionalFather2;
	}

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
	
	public static String getAccountRegionalId() {
		return accountRegionalId;
	}

	public static String getAccountRegionalName() {
		return accountRegionalName;
	}
	
	public static String getWebSiteAccount() {
		return webSiteAccount;
	}
	
	public static String getAccountRegionalFather() {
		return accountRegionalFather;
	}

}
