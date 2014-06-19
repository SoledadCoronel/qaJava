package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class CreateAccountHome extends PageBase{
	
	@FindBy (xpath = "//div[@id='content']/div/div/button")
	private WebElement createRegional;
	
	@FindBy (xpath = "//div[@id='content']/div/div/button[2]")
	private WebElement createStandard;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateAccountHome(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/create";
	}
	
	/**
	 * Seleccionar Cuenta Regional
	 * 
	 * @return {@link CreateAccountRegional}
	 */
	public CreateAccountRegional selectRegional() {
		createRegional.click();
		
		return PageFactory.initElements(driver, CreateAccountRegional.class);
	}
	
	/**
	 * Seleccionar Cuenta Estandar
	 * 
	 * @return {@link CreateAccountStandard}
	 */
	public CreateAccountStandard selectStandard() {
		createStandard.click();
		
		return PageFactory.initElements(driver, CreateAccountStandard.class);
	}

}
