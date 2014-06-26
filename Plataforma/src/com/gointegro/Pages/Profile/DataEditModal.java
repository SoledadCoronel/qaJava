package com.gointegro.Pages.Profile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;

public class DataEditModal extends PageBase{
	
	@FindBy (xpath = "//input[@id='name']")
	private WebElement name;
	
	@FindBy (xpath = "//input[@id='surname']")
	private WebElement surname;
	
	@FindBy (xpath = "//input[@id='email']")
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
	 * Obtener la Zona horaria
	 * 
	 * @return String
	 */
	public String getTimeZone() {
		Select timeZoneOption = new Select(timezone);
		WebElement option = timeZoneOption.getFirstSelectedOption();
		return option.getText();
	}
	
	/**
	 * Obtener el Idioma
	 * 
	 * @return String
	 */
	public String getLanguage() {
		Select languageOption = new Select(language);
		WebElement option = languageOption.getFirstSelectedOption();
		return option.getText();
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
	
	/**
	 * Completar Fecha de nacimiento
	 * 
	 * @param date
	 */
	public void completeBirthdate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('birthdate').removeAttribute('readonly');document.getElementById('birthdate').value='"+date+"'");
	}
	
	/**
	 * Completar el campo Documento
	 * 
	 * @param id
	 */
	public void completeDocumentId(String id) {
		document.clear();
		document.sendKeys(id);
	}
	
	/**
	 * Seleccionar el idioma
	 * 
	 * @param lang
	 */
	public void selectLanguage(String lang) {
		Select langOpiton = new Select(language);
		langOpiton.selectByVisibleText(lang);
	}
	
	/**
	 * Seleccionar Zona horaria
	 * 
	 * @param zone
	 */
	public void selectTimeZone(String zone) {
		Select timeZoneOption = new Select(timezone);
		timeZoneOption.selectByValue(zone);
	}

}
