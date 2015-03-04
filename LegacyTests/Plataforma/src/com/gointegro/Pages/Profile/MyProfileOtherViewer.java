package com.gointegro.Pages.Profile;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Mi perfil visto por otra persona
 * 
 * @author gustavomoreira
 *
 */
public class MyProfileOtherViewer extends PageBase{

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public MyProfileOtherViewer(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElements.getSlugMiPerfil();
	}
	
	

}
