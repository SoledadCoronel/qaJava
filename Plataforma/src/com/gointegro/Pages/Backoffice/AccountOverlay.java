package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AccountOverlay extends PageBase{
	
	@FindBy (id = "filters_name")
	private WebElement filters;
	
	@FindBy (id = "btn-add")
	private WebElement btnAdd;

	public AccountOverlay(WebDriver driver) {
		super(driver);
	}

}
