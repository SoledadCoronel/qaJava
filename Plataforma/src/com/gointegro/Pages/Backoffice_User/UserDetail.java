package com.gointegro.Pages.Backoffice_User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class UserDetail extends PageBase{

	@FindBy (xpath = "//div[@id='enabled-info']/span")
	WebElement enabled;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[1]/div[4]/span")
	WebElement name;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[1]/div[6]/span")
	WebElement surname;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[1]/div[8]/span")
	WebElement email;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[1]/div[10]/span")
	WebElement admission;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[2]/div[2]/span")
	WebElement document;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[1]/div[12]/span")
	WebElement birthdate;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[2]/div[4]/span")
	WebElement gender;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[2]/div[6]/span")
	WebElement phone;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[2]/div[8]/span")
	WebElement cellphone;
	
	@FindBy (xpath = "//div[@id='content']/div[5]/div/span[2]/div[10]/span")
	WebElement role;
	
	@FindBy (xpath = "//div[@id='content']/div[7]/div/div[2]/span")
	WebElement usernameId;
	
	@FindBy (xpath = "//div[@id='content']/div[7]/div[2]/div[2]/span")
	WebElement registered;
	
	@FindBy (xpath = "//div[@id='content']/div[7]/div[3]/div[2]/span")
	WebElement registeredDate;
	
	@FindBy (xpath = "//div[@id='content']/div[7]/div[4]/div[2]/span")
	WebElement integrationId;
	
	@FindBy (xpath = "//div[@class='btn-group']/a[1]")
	WebElement edit;
	
	@FindBy (xpath = "//div[@class='btn-group']/a[2]")
	WebElement delete;
	
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
	
	/**
	 * Seleccionar Eliminar
	 * @return CreateUser
	 */
	public CreateUser selectDelete() {
		delete.click();
		return PageFactory.initElements(driver, CreateUser.class);
	}
}
