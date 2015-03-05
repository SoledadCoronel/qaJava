package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Page de una App Social privada
 * 
 * @author gustavomoreira
 *
 */

public class AppPrivateSocial extends PageBase{
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */

	public AppPrivateSocial(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/social/app/"+ConfigElements.getIdAppEspacioPrivado();
	}

}
