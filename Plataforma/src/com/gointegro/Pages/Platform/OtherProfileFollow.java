package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsFollowers;
import com.gointegro.Pages.Base.PageBase;

public class OtherProfileFollow extends PageBase{
	
	@FindBy(id = "unfollow-button")
	private WebElement unfollowbutton;

	public OtherProfileFollow(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElementsFollowers.getFollower2profile();
	}
	
	public boolean isPresentUnfollowBtn() {
		return unfollowbutton.isEnabled();
	}

}
