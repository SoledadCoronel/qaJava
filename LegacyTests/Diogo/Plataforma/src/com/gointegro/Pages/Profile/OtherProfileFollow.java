package com.gointegro.Pages.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsFollowers;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Muestra el profile de otra persona que sigo
 * 
 * @author gustavomoreira
 *
 */
public class OtherProfileFollow extends PageBase{
	
	@FindBy(id = "unfollow-button")
	private WebElement unfollowbutton;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public OtherProfileFollow(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElementsFollowers.getFollower2profile();
	}
	
	/**
	 * Verificar el estado del btn Unfollow
	 * 
	 * @return boolean
	 */
	public boolean isPresentUnfollowBtn() {
		return unfollowbutton.isEnabled();
	}

}
