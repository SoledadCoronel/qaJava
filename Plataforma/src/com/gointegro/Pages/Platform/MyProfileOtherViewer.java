package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class MyProfileOtherViewer extends PageBase{

	/** Constructor */
	public MyProfileOtherViewer(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElements.getSlugMiPerfil();
	}
	
	

}
