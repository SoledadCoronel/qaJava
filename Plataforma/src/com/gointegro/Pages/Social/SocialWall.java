package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Constructor para el social Wall. El manejo de feeds y postform queda en otras clases respectivas
 * 
 * @author gustavomoreira
 *
 */

public class SocialWall extends PageBase{
	
	/** Constructor */
	public SocialWall(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/social/wall";
	}
	
	
}
