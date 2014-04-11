package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class ExcessLikers extends PageBase{
	
	@FindBy (xpath = "//table[@class='show-colabs']/tbody")
	private WebElement colabstable;
	

	public ExcessLikers(WebDriver driver) {
		super(driver);
	}
	
	public String getColabLikeList() {
		return colabstable.getText();
	}
	
	

}
