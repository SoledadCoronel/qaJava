package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class AppPrivateSocial extends PageBase{

	public AppPrivateSocial(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/social/app/"+ConfigElements.getIdAppEspacioPrivado();
	}

}
