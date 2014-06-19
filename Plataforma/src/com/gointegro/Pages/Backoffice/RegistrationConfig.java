package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class RegistrationConfig extends PageBase{
	
	@FindBy (name = "requireRegistration")
	private WebElement requireRegistration;
	
	@FindBy (name = "usesCard")
	private WebElement usesCard;
	
	@FindBy (name = "usesBirthDate")
	private WebElement usesBirthDate;
	
	@FindBy (name = "usesGender")
	private WebElement usesGender;
	
	@FindBy (name = "requireVerification")
	private WebElement requireVerification;
	
	@FindBy (name = "verificationField1")
	private WebElement verificationField1;
	
	@FindBy (name = "verificationField2")
	private WebElement verificationField2;
	
	@FindBy (name = "identityField")
	private WebElement identityField;
	
	@FindBy (name = "hasPassword")
	private WebElement hasPassword;
	
	@FindBy (name = "recoverPassword")
	private WebElement recoverPassword;

	public RegistrationConfig(WebDriver driver) {
		super(driver);
	}

}
