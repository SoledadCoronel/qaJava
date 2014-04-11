package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * AppSocial. This class contains only the constructor appsocial.
 */

public class AppSocial extends PageBase{

	
	/** Constructor */
	public AppSocial(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/social/app/"+ConfigElements.getIdAppSocial();
	}
	
	

}
