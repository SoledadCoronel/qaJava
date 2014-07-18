package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;

public class NewContactOverlay extends PageBase {
	
	@FindBy(xpath = "//input[contains(@class, 'field-active')]")
	WebElement active;
	
	@FindBy(xpath = "//input[contains(@class, 'field-name')]")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement surname;
	
	@FindBy(id = "document")
	WebElement document;
	
	@FindBy(xpath = "//input[contains(@class, 'field-phone')]")
	WebElement phone;
	
	@FindBy(id = "cellPhone")
	WebElement cellphone;
	
	@FindBy(id = "position")
	WebElement position;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "area")
	WebElement area;
	
	@FindBy(id = "observations")
	WebElement observations;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[contains(@class, 'form-name')]/div/div/div")
	WebElement firstnameErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'form-surname')]/div/div/div")
	WebElement surnameErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'form-email')]/div/div/div")
	WebElement emailErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'form-observations')]/div/div/div")
	WebElement observationsErrorMsg;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewContactOverlay(WebDriver driver) {
		super(driver);
	}

	/**
	 * Seleccionar Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Crear Nombre
	 * @param name
	 */
	public void createFirstName(String name) {
		firstname.clear();
		firstname.sendKeys(name);
	}
	
	/**
	 * Crear Apellido
	 * 
	 * @param name
	 */
	public void createSurname(String name) {
		surname.clear();
		surname.sendKeys(name);
	}
	
	/**
	 * Crear Documento
	 * 
	 * @param number
	 */
	public void createDocument(String number) {
		document.clear();
		document.sendKeys(number);
	}
	
	/**
	 * Crear Teléfono
	 * 
	 * @param number
	 */
	public void createPhone(String number) {
		phone.clear();
		phone.sendKeys(number);
	}
	
	/**
	 * Crear Celular
	 * 
	 * @param number
	 */
	public void createCellPhone(String number) {
		cellphone.clear();
		cellphone.sendKeys(number);
	}
	
	/**
	 * Seleccionar area
	 * 
	 * @param name
	 */
	public void selectArea(String name) {
		Select select = new Select(area);
		select.selectByVisibleText(name);;
	}
	
	/**
	 * Crear Puesto
	 * 
	 * @param name
	 */
	public void createPosition(String name) {
		position.clear();
		position.sendKeys(name);
	}
	
	/**
	 * Crear Email
	 * 
	 * @param name
	 */
	public void createEmail(String name) {
		email.clear();
		email.sendKeys(name);
	}
	
	/**
	 * Crear Observaciones
	 * 
	 * @param obs
	 */
	public void createObservation(String obs) {
		observations.clear();
		observations.sendKeys(obs);
	}
	
	/**
	 * Crear Contacto
	 * 
	 * @param name
	 * @param surname
	 * @param document
	 * @param phone
	 * @param area
	 * @param cellphone
	 * @param position
	 * @param email
	 * @param observation
	 * @param isEnabled
	 * @return DetailCompany
	 */
	public DetailCompany createContact(String name, String surname, String document, String phone, String area, String cellphone, String position, String email, String observation, boolean isDisabled) {
		createFirstName(name);
		createSurname(surname);
		createDocument(document);
		createPhone(phone);
		selectArea(area);
		createCellPhone(cellphone);
		createPosition(position);
		createEmail(email);
		createObservation(observation);
		
		if(isDisabled) {
			selectActive();
		}
		
		return PageFactory.initElements(driver, DetailCompany.class);
	}
	
	/**
	 * Seleccionar Guardar
	 */
	public void selectSave() {
		save.click();
	}
	
	/**
	 * Seleccionar Guardar y Nuevo
	 */
	public void selectSaveAndNew() {
		saveAndNew.click();
	}
	
	/**
	 * Seleccionar Cancelar
	 */
	public void selectCancel() {
		cancel.click();
	}
	
	/**
	 * Devuelve el mensaje de error del Nombre
	 * 
	 * @return String
	 */
	public String getFirstnameErrorMsg() {
		return firstnameErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del Apellido
	 * 
	 * @return String
	 */
	public String getSurnameErrorMsg() {
		return surnameErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del Email
	 * 
	 * @return String
	 */
	public String getEmailErrorMsg() {
		return emailErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Observaciones
	 * 
	 * @return String
	 */
	public String getObservationsErrorMsg() {
		return observationsErrorMsg.getText();
	}
	
	/**
	 * Devuelve si el imput Nombre esta vacio. Se usa para saber si se cargo un nuevo formulario
	 * al presionar Guardar y nuevo
	 * 
	 * @return boolean
	 */
	public boolean isNameInputEmpty() {
		return firstname.getText().isEmpty();
	}
	
}
