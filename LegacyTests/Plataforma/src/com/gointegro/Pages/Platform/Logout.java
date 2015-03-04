package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Logout
 * 
 * @author gustavomoreira
 *
 */

public class Logout extends PageBase{

	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Logout(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/auth/signout";
	}
	
	

}
