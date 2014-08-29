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
	
	@FindBy (id = "save")
	protected WebElement save;
	
	@FindBy (id = "cancel")
	protected WebElement cancel;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateUser(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/platforms/"+ConfigElementsBO.getPlatformId()+"/user/create";
	}
	
	/**
	 * Seleccionar enabled
	 */
	protected void selectEnabled(boolean status) {
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
	protected void setName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	/**
	 * Completar el surname del usuario
	 * 
	 * @param surname
	 */
	protected void setSurname(String surname) {
		this.surname.clear();
		this.surname.sendKeys(surname);
	}
	
	/**
	 * Completar el email
	 * 
	 * @param email
	 */
	protected void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	/**
	 * Completar la fecha de ingreso
	 * 
	 * @param admissiondate
	 */
	protected void setAdmission(String admissiondate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('admission').value='"+admissiondate+"'");
	}
	
	/**
	 * Completar el documento
	 * 
	 * @param document
	 */
	protected void setDocument(String document) {
		this.document.clear();
		this.document.sendKeys(document);
	}
	
	/**
	 * Completar la fecha de nacimiento
	 * 
	 * @param birthdate
	 */
	protected void setBirthDate(String birthdate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('birthdate').value='"+birthdate+"'");
	}
	
	/**
	 * Completar el genero
	 * 
	 * @param gender
	 */
	protected void setGender(String gender) {
		Select select = new Select(this.gender);
		select.selectByVisibleText(gender);
	}
	
	/**
	 * Completar el telefono
	 * 
	 * @param phone
	 */
	protected void setPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	/**
	 * Completar el celular
	 * 
	 * @param cellphone
	 */
	protected void setCellphone(String cellphone) {
		this.cellphone.clear();
		this.cellphone.sendKeys(cellphone);
	}
	
	/**
	 * Completar el nombre de usuario
	 * 
	 * @param usernameid
	 */
	protected void setUsernameId(String usernameid) {
		this.usernameId.clear();
		this.usernameId.sendKeys(usernameid);
	}
	
	/**
	 * Seleccionar Registrado
	 * 
	 * @param regstatus
	 */
	protected void setRegistered(boolean regstatus) {
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
	protected void setRegistedDate(String regdate) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('registeredDate').value='"+regdate+"'");
	}
	
	/**
	 * Completar el integrationId
	 * 
	 * @param integrationid
	 */
	protected void setintegrationId(String integrationid) {
		this.integrationId.clear();
		this.integrationId.sendKeys(integrationid);
	}
	
	/**
	 * Seleccionar role
	 * 
	 * @param role
	 */
	protected void selectRole(String role) {
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
		setGender(gender);
		setPhone(phone);
		setCellphone(cellphone);
		setUsernameId(usernameid);
		setRegistered(regstatus);
		setRegistedDate(regdate);
		setintegrationId(integrationid);
		selectRole(role);
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

}
