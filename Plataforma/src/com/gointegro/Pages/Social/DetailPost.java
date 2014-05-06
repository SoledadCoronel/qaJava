package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailPost extends PageBase{
	
	@FindBy (className = "app-title")
	private WebElement title;
	

	public DetailPost(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle() {
		return title.getText();
	}

}
