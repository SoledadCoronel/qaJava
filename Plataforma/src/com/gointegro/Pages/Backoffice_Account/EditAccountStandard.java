package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountStandard extends CreateAccountStandard{
	
	@FindBy(name = "webSite")
	private WebElement webSite;
	
	@FindBy(xpath = "//ul[@id='c1_parent']/li/a")
	private WebElement principalaccount;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EditAccountStandard(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el nombre de la cuenta
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getAttribute("value");
	}
	
	/**
	 * Obtener el nombre de salesforce id
	 * 
	 * @return String
	 */
	public String getSalesforceId() {
		return salesforceId.getAttribute("value");
	}
	
	/**
	 * Obtener la cuenta principal
	 * 
	 * @return String
	 */
	public String getPrincipalAccount() {
		return principalaccount.getText();
	}

}
