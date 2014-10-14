package com.gointegro.Pages.Backoffice_User;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class CreateUser extends PageBase{
	
	@FindBy (id = "enabled")
	protected WebElement enabled;
	
	@FindBy (id = "name")
	protected WebElement name;
	
	@FindBy (id = "surname")
	protected WebElement surname;
	
	@FindBy (id = "email")
	protected WebElement email;
	
	@FindBy (id = "admission")
	protected WebElement admission;
	
	@FindBy (id = "document")
	protected WebElement document;
	
	@FindBy (id = "birthdate")
	protected WebElement birthdate;
	
	@FindBy (id = "gender")
	protected WebElement gender;
	
	@FindBy (id = "phone")
	protected WebElement phone;
	
	@FindBy (id = "cellphone")
	protected WebElement cellphone;
	
	@FindBy (id = "usernameId")
	protected WebElement usernameId;
	
	@FindBy (id = "registered")
	protected WebElement registered;
	
	@FindBy (id = "registeredDate")
	protected WebElement registeredDate;
	
	@FindBy (id = "integrationId")
	protected WebElement integrationId;
	
	@FindBy (id = "role")
	protected WebElement role;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	protected WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	protected WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	protected WebElement cancel;
	
	//ERRORS
	@FindBy(xpath = "//div[contains(@class, 'form-name')]/div/div/div")
	WebElement nameError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-surname')]/div/div/div")
	WebElement surnameError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-document')]/div/div/div")
	WebElement documentError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-email')]/div/div/div")
	WebElement emailError;
	
	@FindBy(xpath = "//div[contains(@class,'form-birthdate')]/div/div/div")
	WebElement birthdateError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-phone')]/div/div/div")
	WebElement phoneError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-cellphone')]/div/div/div")
	WebElement cellphoneError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-usernameId')]/div/div/div")
	WebElement usernameIdError;
	
	@FindBy(xpath = "//div[contains(@class, 'form-registeredDate')]/div/div/div")
	WebElement registeredDateError;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-error')]")
	WebElement alertError;
	
	String createURL = ConfigElementsBO.getUrlBackoffice()+"/platform/"+ConfigElementsBO.getPlatformId()+"/user/create"; 

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateUser(WebDriver driver) {
		super(driver);
		URL = createURL;
		System.out.println("text: " + URL);
	}
	
	/**
	 * Obtener la URL de crear usuario
	 */
	public String getURL() {
		return createURL;
	}
	
	/**
	 * Seleccionar enabled
	 */
	public void selectEnabled(boolean status) {
		if (status && enabled.getAttribute("checked") == null)
			enabled.click();
		else if (!status && enabled.getAttribute("checked") != null)
			enabled.click();
		else {}
	}
	
	/**
	 * Completar el nombre del usuario
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	/**
	 * Obtener el nombre
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Completar el surname del usuario
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname.clear();
		this.surname.sendKeys(surname);
	}
	
	/**
	 * Completar el email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	/**
	 * Completar la fecha de ingreso
	 * 
	 * @param admissiondate
	 */
	public void setAdmission(String admissiondate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('admission')[1].value='"+admissiondate+"'");
	}
	
	/**
	 * Completar el documento
	 * 
	 * @param document
	 */
	public void setDocument(String document) {
		this.document.clear();
		this.document.sendKeys(document);
	}
	
	/**
	 * Completar la fecha de nacimiento
	 * 
	 * @param birthdate
	 */
	public void setBirthDate(String birthdate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('birthdate')[1].value='"+birthdate+"'");
	}
	
	/**
	 * Completar el genero
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		Select select = new Select(this.gender);
		select.selectByVisibleText(gender);
	}
	
	/**
	 * Completar el telefono
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	/**
	 * Completar el celular
	 * 
	 * @param cellphone
	 */
	public void setCellphone(String cellphone) {
		this.cellphone.clear();
		this.cellphone.sendKeys(cellphone);
	}
	
	/**
	 * Completar el nombre de usuario
	 * 
	 * @param usernameid
	 */
	public void setUsernameId(String usernameid) {
		this.usernameId.clear();
		this.usernameId.sendKeys(usernameid);
	}
	
	/**
	 * Seleccionar Registrado
	 * 
	 * @param regstatus
	 */
	public void setRegistered(boolean regstatus) {
		if (regstatus && registered.getAttribute("checked") == null)
			registered.click();
		else if (!regstatus && registered.getAttribute("checked") != null)
			registered.click();
		else {}
	}
	
	/**
	 * Completar la fecha de registro
	 * 
	 * @param regdate
	 */
	public void setRegistedDate(String regdate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('registeredDate')[1].value='"+regdate+"'");
	}
	
	/**
	 * Completar el integrationId
	 * 
	 * @param integrationid
	 */
	public void setintegrationId(String integrationid) {
		this.integrationId.clear();
		this.integrationId.sendKeys(integrationid);
	}
	
	/**
	 * Seleccionar role
	 * 
	 * @param role
	 */
	public void selectRole(String role) {
		Select select = new Select(this.role);
		select.selectByVisibleText(role);
	}
	
	/**
	 * Completar las campos
	 * 
	 * @param status
	 * @param name
	 * @param surname
	 * @param email
	 * @param admissiondate
	 * @param document
	 * @param birthdate
	 * @param gender
	 * @param phone
	 * @param cellphone
	 * @param usernameid
	 * @param regstatus
	 * @param regdate
	 * @param integrationid
	 * @param role
	 */
	public void completeInformation(boolean status, String name, String surname, String email, String admissiondate,
			String document, String birthdate, String gender, String phone, String cellphone, String usernameid,
			boolean regstatus, String regdate, String integrationid, String role) {
		selectEnabled(status);
		setName(name);
		setSurname(surname);
		setEmail(email);
		setAdmission(admissiondate);
		setDocument(document);
		setBirthDate(birthdate);
		if(!gender.isEmpty()) {
			setGender(gender);
		}
		setPhone(phone);
		setCellphone(cellphone);
		setUsernameId(usernameid);
		setRegistered(regstatus);
		setRegistedDate(regdate);
		setintegrationId(integrationid);
		if(!role.isEmpty()) {
			selectRole(role);
		}
	}
	
	/**
	 * Guardar
	 * 
	 * @return {@link UserDetail}
	 */
	public UserDetail selectSave() {
		save.click();
		
		return PageFactory.initElements(driver, UserDetail.class);
	}
	
	/**
	 * Cancelar
	 * 
	 * @return {@link UserList}
	 */
	public UserList selectCancel() {
		cancel.click();
		
		return PageFactory.initElements(driver, UserList.class);
	}
	

	/**
	 * Guardar y nuevo
	 * 
	 * @return {@link CreateUser}
	 */
	public CreateUser selectSaveAndNew() {
		saveAndNew.click();
		
		return PageFactory.initElements(driver, CreateUser.class);
	}

	/**
	 * Obtener el mensaje de error del apellido
	 * @return String
	 */
	public String getNameError() {
		return nameError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del apellido
	 * @return String
	 */
	public String getSurnameError() {
		return surnameError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del documento
	 * @return String
	 */
	public String getDocumentError() {
		return documentError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del email
	 * @return String
	 */
	public String getEmailError() {
		return emailError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Fecha de nacimiento
	 * @return String
	 */
	public String getBirthdateError() {
		return birthdateError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del telefono
	 * @return String
	 */
	public String getPhoneError() {
		return phoneError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del celular
	 * @return String
	 */
	public String getCellphoneError() {
		return cellphoneError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Id de usuario
	 * @return
	 */
	public String getUsernameIdError() {
		return usernameIdError.getText();
	}
	
	/**
	 * Obtener el mensaje de error de fecha de registro
	 * @return
	 */
	public String getRegisteredDateError() {
		return registeredDateError.getText();
	}
	
	/**
	 * Obtner el alerta de error
	 * @return
	 */
	public String getAlertError() {
		return alertError.getText();
	}
}
