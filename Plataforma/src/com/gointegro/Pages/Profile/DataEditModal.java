package com.gointegro.Pages.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DataEditModal extends PageBase{
	
	@FindBy (id = "name")
	private WebElement name;
	
	@FindBy (id = "surname")
	private WebElement surname;
	
	@FindBy (id = "email")
	private WebElement email;
	
	@FindBy (id = "document")
	private WebElement document;
	
	@FindBy (id = "birthdate")
	private WebElement birthdate;
	
	@FindBy (id = "language")
	private WebElement language;
	
	@FindBy (id = "timezone")
	private WebElement timezone;
	
	@FindBy (id = "saveProfileData")
	private WebElement saveProfileData;
	
	@FindBy (id = "cancelProfileData")
	private WebElement cancelProfileData;

	public DataEditModal(WebDriver driver) {
		super(driver);
	}
	

}
