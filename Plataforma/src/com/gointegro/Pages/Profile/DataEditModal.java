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

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DataEditModal(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener la fecha de nacimiento
	 * 
	 * @return String
	 */
	public String getBirthdate() {
		return birthdate.getAttribute("value");
	}
	
	/**
	 * Obtener el nombre de la persona
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getAttribute("value");
	}
	
	/**
	 * Obtener el apellido de la persona
	 * 
	 * @return String
	 */
	public String getSurname() {
		return surname.getAttribute("value");
	}
	
	/**
	 * Obtener el email de la persona
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email.getAttribute("value");
	}
	
	/**
	 * Obtener el documento de la persona
	 * 
	 * @return String
	 */
	public String getDocument() {
		return document.getAttribute("value");
	}
	
	/**
	 * Seleccionar Cancelar
	 */
	public void selectCancel() {
		cancelProfileData.click();
	}
	
	/**
	 * Seleccionar Guardar
	 */
	public void selectSave() {
		saveProfileData.click();
	}

}
