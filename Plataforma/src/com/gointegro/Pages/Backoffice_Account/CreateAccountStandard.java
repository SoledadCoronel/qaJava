package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Base.PageBase;

public class CreateAccountStandard extends PageBase{
	
	@FindBy (name = "name")
	private WebElement name;
	
	@FindBy (name = "salesforceId")
	private WebElement salesforceId;
	
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
	public CreateAccountStandard(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar cuenta principal overlay
	 * 
	 * @return
	 */
	public AccountOverlay selectDependentAccounts() {
		searchAccount.click();
		
		return PageFactory.initElements(driver, AccountOverlay.class);
	}

}
