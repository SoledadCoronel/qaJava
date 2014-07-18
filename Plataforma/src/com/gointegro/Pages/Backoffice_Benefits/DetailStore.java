package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailStore extends DetailCompany {
	
	@FindBy(id = "storeType")
	WebElement type;
	
	@FindBy(id = "contact")
	WebElement contact;
	
	@FindBy(id = "email")
	WebElement email;
	
	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public DetailStore(WebDriver driver) {
		super(driver);
	}

	/**
	 * Devuelve Tipo de sucursal
	 */
	public String getType() {
		return type.getText();
	}
	
	/**
	 * Devuelve Contacto
	 */
	public String getContact() {
		return contact.getText();
	}
	
	/**
	 * Devuelve Email
	 */
	public String getEmail() {
		return email.getText();
	}
	
}
