package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElementsBO;

public class CreatePlatformRegional extends CreatePlatform{
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreatePlatformRegional(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountRegionalId()+"/platform/create";
	}

}
