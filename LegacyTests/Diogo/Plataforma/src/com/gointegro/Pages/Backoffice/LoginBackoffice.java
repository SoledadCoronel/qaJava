package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class LoginBackoffice extends PageBase{
	
	@FindBy (name = "_username")
	private WebElement username;
	
	@FindBy (name = "_password")
	private WebElement pwd;
	
	@FindBy (name = "_submit")
	private WebElement submit;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public LoginBackoffice(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice();
	}
	
	/**
	 * Completar username
	 * 
	 * @param user
	 */
	private void completeUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}
	
	/**
	 * Completar pass
	 * 
	 * @param pass
	 */
	private void completePwd(String pass) {
		pwd.clear();
		pwd.sendKeys(pass);
	}
	
	/**
	 * Seleccionar Sign in
	 */
	private void selectSubmit() {
		submit.click();
	}
	
	/**
	 * Loguear
	 * 
	 * @param user
	 * @param pass
	 * @return {@link HomeBackoffice}
	 */
	public HomeBackoffice loginBackoffice(String user, String pass) {
		completeUsername(user);
		completePwd(pass);
		selectSubmit();
		
		return PageFactory.initElements(driver, HomeBackoffice.class);
	}

}
