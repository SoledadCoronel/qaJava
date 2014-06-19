package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class PlatformDetail extends PageBase{

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlatformDetail(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/"+ConfigElementsBO.getPlatformId()
				+"/view";
	}

}
