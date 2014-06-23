package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class AccountList extends PageBase{
	
	@FindBy (name = "filters[name]")
	private WebElement filter;
	
	@FindBy (id = "name-filter-btn-close")
	private WebElement cancelfilter;
	
	@FindBy (id = "name-filter-btn-submit")
	private WebElement submitfilter;
	
	@FindBy (id = "basic-grid")
	private WebElement grid;

	public AccountList(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/list";
	}

}
