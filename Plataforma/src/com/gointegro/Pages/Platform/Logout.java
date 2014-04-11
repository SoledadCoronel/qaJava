package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Clase que solo desloguea. No mucho mas.
 * 
 * @author gustavomoreira
 *
 */

public class Logout extends PageBase{

	
	/** Constructor */
	public Logout(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/auth/signout";
	}
	
	

}
