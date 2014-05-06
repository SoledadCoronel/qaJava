package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsFollowers;
import com.gointegro.Pages.Base.PageBase;

public class OtherProfileFollow extends PageBase{

	public OtherProfileFollow(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElementsFollowers.getFollower2profile();
	}

}
