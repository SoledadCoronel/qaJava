package com.gointegro.Pages.Backoffice_User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class UserDetail extends PageBase{

	@FindBy (id = "enabled")
	WebElement enabled;
	
	@FindBy (id = "name")
	WebElement name;
	
	@FindBy (id = "surname")
	WebElement surname;
	
	@FindBy (id = "email")
	WebElement email;
	
	@FindBy (id = "admission")
	WebElement admission;
	
	@FindBy (id = "document")
	WebElement document;
	
	@FindBy (id = "birthdate")
	WebElement birthdate;
	
	@FindBy (id = "gender")
	WebElement gender;
	
	@FindBy (id = "phone")
	WebElement phone;
	
	@FindBy (id = "cellphone")
	WebElement cellphone;
	
	@FindBy (id = "role")
	WebElement role;
	
	@FindBy (id = "usernameId")
	WebElement usernameId;
	
	@FindBy (id = "registered")
	WebElement registered;
	
	@FindBy (id = "registeredDate")
	WebElement registeredDate;
	
	@FindBy (id = "integrationId")
	WebElement integrationId;
	
	@FindBy (xpath = "//button[contains(@class, 'edit-link')]")
	WebElement edit;
	
	public UserDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obteber Activo
	 * @return String
	 */
	public boolean isActive() {
		return enabled.getText().contains("Si");
	}
	
	/**
	 * Obteber Nombre
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Obteber Apellido
	 * @return String
	 */
	public String getSurname() {
		return surname.getText();
	}
	
	/**
	 * Obteber Email
	 * @return String
	 */
	public String getEmail() {
		return email.getText();
	}
	
	/**
	 * Obteber Fecha de ingreso
	 * @return String
	 */
	public String getAdmission() {
		return admission.getText();
	}
	
	/**
	 * Obteber Fecha de nacimiento
	 * @return String
	 */
	public String getBirthdate() {
		return birthdate.getText();
	}
	
	/**
	 * Obteber Documento
	 * @return String
	 */
	public String getDocument() {
		return document.getText();
	}
	
	/**
	 * Obteber Sexo
	 * @return String
	 */
	public String getGender() {
		return gender.getText();
	}
	
	/**
	 * Obteber Telefono
	 * @return String
	 */
	public String getPhone() {
		return phone.getText();
	}
	
	/**
	 * Obteber Celular
	 * @return String
	 */
	public String getCellphone() {
		return cellphone.getText();
	}
	
	/**
	 * Obteber Perfil
	 * @return String
	 */
	public String getRole() {
		return role.getText();
	}
	
	/**
	 * Obteber Nombre de usuario (id)
	 * @return String
	 */
	public String getUsernameId() {
		return usernameId.getText();
	}
	
	/**
	 * Obteber Registrado
	 * @return String
	 */
	public boolean isRegistered() {
		return registered.getText().contains("Si");
	}
	
	/**
	 * Obteber Fecha de registro
	 * @return String
	 */
	public String getRegisteredDate() {
		return registeredDate.getText();
	}

	/**
	 * Obteber Ususario de joomla
	 * @return String
	 */
	public String getIntegrationId() {
		return integrationId.getText();
	}
	
	/**
	 * Seleccionar editar
	 */
	public CreateUser selectEdit() {
		edit.click();
		return PageFactory.initElements(driver, CreateUser.class);
	}
}
