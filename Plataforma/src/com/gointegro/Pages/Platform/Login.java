package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Login
 * 
 * @author gustavomoreira
 *
 */

public class Login extends PageBase{
	
	@FindBy(name = "_username")
    private WebElement usernamelogin;
	
	@FindBy(name = "_password")
	private WebElement passwordlogin;
	
	@FindBy(name = "_submit")
	private WebElement submit;
	
	@FindBy(id = "signupButton")
	private WebElement signup;
	
	@FindBy(id = "forgotPasswordButton")
	private WebElement forgotPasswordButton;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Login (WebDriver driver){
		super(driver);
		URL = ConfigElements.getURL();
	}
	
	
	/**
	 * Complete username
	 * 
	 * @param username
	 */
	private void completeUsername (String username) {
		usernamelogin.sendKeys(username);
	}
	
	/**
	 * Complete Password
	 * 
	 * @param password
	 */
	/*private void completePassword (String password) {
		passwordlogin.sendKeys(password);
	}*/
	
	/**
	 * Submit login
	 */
	private void submitform () {
		submit.click();
	}
	
	/**
	 * Complete Login
	 * 
	 * @param username
	 * @param password
	 * @return Home
	 */
	public Home LoginPlatformNoReg(String username, String password) {
		completeUsername(username);
		//completePassword(password);
		submitform();
		
		return PageFactory.initElements(driver, Home.class);
	}
	
	/**
	 * Verificar campo esta presente
	 * 
	 * @return boolean
	 */
	public boolean isPasswordPresent() {
		boolean status = false;
		if (passwordlogin.isDisplayed())
			status = true;
		return status;
	}
	
}
