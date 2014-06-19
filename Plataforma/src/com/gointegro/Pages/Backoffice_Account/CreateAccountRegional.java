package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Base.PageBase;

public class CreateAccountRegional extends PageBase{
	
	@FindBy (name = "name")
	private WebElement name;
	
	@FindBy (name = "webSite")
	private WebElement website;
	
	@FindBy (xpath = "//div[@class='selection-list-container']/button")
	private WebElement searchAccount;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button[2]")
	private WebElement cancelBtn;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateAccountRegional(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Select search account
	 * 
	 * @return {@link AccountOverlay}
	 */
	public AccountOverlay selectDependentAccounts() {
		searchAccount.click();
		
		return PageFactory.initElements(driver, AccountOverlay.class);
	}

}
