package com.gointegro.Pages.Registration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Platform.Login;

public class SignUp extends PageBase{
	
	@FindBy (id = "name")
	private WebElement name;
	
	@FindBy (id = "surname")
	private WebElement surname;
	
	@FindBy (id = "email")
	private WebElement email;
	
	@FindBy (id = "document")
	private WebElement document;
	
	@FindBy (id = "usernameId")
	private WebElement usernameId;
	
	@FindBy (id = "password")
	private WebElement password;
	
	@FindBy (id = "repeatPassword")
	private WebElement repeatPassword;
	
	@FindBy (id = "birthdate")
	private WebElement birthdate;
	
	@FindBy (id = "gender-0")
	private WebElement gender0;
	
	@FindBy (id = "termsAndConditions")
	private WebElement termsAndConditions;
	
	@FindBy (id = "submitRegistration")
	private WebElement submitRegistration;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SignUp(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar el nombre
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isNamePresent() {
		return name.isDisplayed();
	}
	
	/**
	 * Completar el surname
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname.clear();
		this.surname.sendKeys(surname);
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isSurnamePresent() {
		return surname.isDisplayed();
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
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isEmailPresent() {
		return email.isDisplayed();
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
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isDocumentPresent() {
		return document.isDisplayed();
	}
	
	/**
	 * Completar el usernameid
	 * 
	 * @param usernameid
	 */
	public void setUsernameId(String usernameid) {
		this.usernameId.clear();
		this.usernameId.sendKeys(usernameid);
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isUsernameIdPresent() {
		return usernameId.isDisplayed();
	}
	
	/**
	 * Completar pwd y repeatpwd
	 * 
	 * @param pwd
	 */
	public void setPassword(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
		this.repeatPassword.clear();
		this.repeatPassword.sendKeys(pwd);
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isPasswordPresent() {
		return password.isDisplayed();
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isRepeatPasswordPresent() {
		return repeatPassword.isDisplayed();
	}
	
	/**
	 * Completar fecha nacimiento
	 * 
	 * @param date
	 */
	public void setBirthdate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('birthdate').value='"+date+"'");
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isBirthdatePresent() {
		return birthdate.isDisplayed();
	}
	
	/**
	 * Completar el genero, por default M
	 */
	public void setGender() {
		gender0.click();
	}
	
	/**
	 * Verificar que el campo se muestre
	 * 
	 * @return boolean
	 */
	public boolean isGenderPresent() {
		return gender0.isDisplayed();
	}
	
	/**
	 * Aceptar tyc
	 */
	public void setTyC() {
		termsAndConditions.click();
	}
	
	/**
	 * Obtener el nombre
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getAttribute("value");
	}
	
	/**
	 * Obtener el apellido
	 * 
	 * @return String
	 */
	public String getSurname() {
		return surname.getAttribute("value");
	}
	
	/**
	 * Obtener el email
	 * 
	 * @return String
	 */
	public String getEmail() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.getElementById('email').disable=false");
		
		return email.getAttribute("value");
	}
	
	/**
	 * Obtener el documento
	 * 
	 * @return String
	 */
	public String getDocument() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.getElementById('document').disable=false");
		
		return document.getAttribute("value");
	}
	
	/**
	 * Obtener el usernameId
	 * 
	 * @return String
	 */
	public String getUsernameId() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.getElementById('usernameId').disable=false");
		
		return usernameId.getAttribute("value");
	}
	
	/**
	 * Obtener la fecha de nacimiento
	 * 
	 * @return String
	 */
	public String getBirthdate() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.getElementById('birthdate').disable=false");
		
		return birthdate.getAttribute("value");
	}
	
	/**
	 * Seleccionar Registrarme
	 * 
	 * @return {@link Login}
	 */
	public Login selectRegister() {
		submitRegistration.click();
		
		return PageFactory.initElements(driver, Login.class);
	}

}
