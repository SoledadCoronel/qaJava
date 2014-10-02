package com.gointegro.Tests.Backoffice.Platform;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Backoffice_User.CreateUser;
import com.gointegro.Pages.Backoffice_User.UserDetail;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewUser extends AllTestsBackofficePlatform {

	private WebDriver driver;
	String name = DataGenerator.nombreFile();
	String surname = DataGenerator.nombreFile();
	String email = DataGenerator.nombreFile() + "@mail.com";
	String adminissionDate = "09/10/2010";
	String birthdate = "04/11/1990";
	String gender = "Masculino";
	String phone = "20349829";
	String cellphone = "00293483";
	String usernameId = DataGenerator.nombreFile();
	boolean regStatus = true;
	String integrationId = DataGenerator.nombreFile();
	String regDate = DataGenerator.fechaactual();
	String role = "ROLE_BASIC";
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void test_new_user() {
		String document = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, adminissionDate, document, birthdate, gender, phone, cellphone, usernameId, true, regDate, integrationId, role);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isActive());
		assertEquals(name, detail.getName());
		assertEquals(surname, detail.getSurname());
		assertEquals(document, detail.getDocument());
		assertEquals(email, detail.getEmail());
		assertEquals(adminissionDate, detail.getAdmission());
		assertEquals(birthdate, detail.getBirthdate());
		assertEquals(gender, detail.getGender());
		assertEquals(phone, detail.getPhone());
		assertEquals(cellphone, detail.getCellphone());
		assertEquals(usernameId, detail.getUsernameId());
		assertTrue(detail.isRegistered());
		assertEquals(regDate, detail.getRegisteredDate());
		assertEquals(role, detail.getRole());
		assertEquals(integrationId, detail.getIntegrationId());
	}
	
	@Test
	public void test_new_user_without_name() {
		String document = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, "", surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newUser.getNameError());
	}
	
	@Test
	public void test_new_user_name_invalid() {
		String document = DataGenerator.nombreFile();
		
		String localname = "399";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, localname, surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un nombre válido", newUser.getNameError());
		
	}
	
	@Test
	public void test_new_user_name_max_char() {
		String document = DataGenerator.nombreFile();
		
		String localname = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, localname, surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede superar los 80 caracteres", newUser.getNameError());
	}
	
	@Test
	public void test_new_user_name_min_char() {
		String document = DataGenerator.nombreFile();
		String localname = "a";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, localname, surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un nombre válido", newUser.getNameError());
	}
	
	@Test
	public void test_new_user_without_surname() {
		String document = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, "", "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newUser.getSurnameError());
	}
	
	@Test
	public void test_new_user_surname_invalid() {
		String document = DataGenerator.nombreFile();
		String localSurname = "smi234rew3";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, localSurname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un apellido válido", newUser.getSurnameError());
	}
	
	@Test
	public void test_new_user_surname_max_char() {
		String document = DataGenerator.nombreFile();
		String localSurname = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, localSurname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede superar los 80 caracteres", newUser.getSurnameError());
	}
	
	@Test
	public void test_new_user_surname_min_char() {
		String document = DataGenerator.nombreFile();
		String localSurname = "a";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, localSurname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un apellido válido", newUser.getSurnameError());
	}
	
	@Test
	public void test_new_user_without_document() {
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", "", "", "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El documento no puede ser vacío porque es el campo único de la plataforma", newUser.getAlertError());
	}
	
	@Test
	public void test_new_user_document_invalid() {
		String localDoc = "zasdx<<";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", localDoc, "", "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar sólo números y/o letras. Máximo 20 caracteres", newUser.getDocumentError());
	}
	
	@Test
	public void test_new_user_document_max_char() {
		String localDoc = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", localDoc, "", "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar sólo números y/o letras. Máximo 20 caracteres", newUser.getDocumentError());
	}
	
	@Test
	public void test_new_user_document_min_char() {
		String localDoc = "a";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", localDoc, "", "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar sólo números y/o letras. Máximo 20 caracteres", newUser.getDocumentError());
	}
	
	@Test
	public void test_new_user_email_invalid() {
		String document = DataGenerator.nombreFile();
		String localEmail = "asdlk@lll.asldkj@asld";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, localEmail, "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un mail válido", newUser.getEmailError());
	}
	
	@Test
	public void test_new_user_birthdate_invalid() {
		String document = DataGenerator.nombreFile();
		String localDate = "01/01/2099";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, localDate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha de nacimiento ingresada es inválida", newUser.getBirthdateError());
	}
	
	@Test
	public void test_new_user_phone_invalid() {
		String document = DataGenerator.nombreFile();
		String number = "09asd8s99";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", number, "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	
		assertEquals("Ingresar sólo números y como máximo 15 caracteres", newUser.getPhoneError());
	}
	
	@Test
	public void test_new_user_phone_max_chars() {
		String document = DataGenerator.nombreFile();
		String number = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", number, "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	
		assertEquals("Ingresar sólo números y como máximo 15 caracteres", newUser.getPhoneError());
	}
	
	@Test
	public void test_new_user_cellphone_invalid() {
		String document = DataGenerator.nombreFile();
		String number = "987sd888";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", number, "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar sólo números y como máximo 15 caracteres", newUser.getCellphoneError());
	}
	
	@Test
	public void test_new_user_cellphone_max_chars() {
		String document = DataGenerator.nombreFile();
		String number = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", number, "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar sólo números y como máximo 15 caracteres", newUser.getCellphoneError());
	}
	
	@Test
	public void test_new_user_userId_invalid() {
		String document = DataGenerator.nombreFile();
		String userId = "a<>234";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", "", userId, false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar números y/o letras, sin espacios y como máximo 80 caracteres", newUser.getUsernameIdError());
	}
	
	@Test
	public void test_new_user_userId_max_chars() {
		String document = DataGenerator.nombreFile();
		String userId = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", "", userId, false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingresar números y/o letras, sin espacios y como máximo 80 caracteres", newUser.getUsernameIdError());
	}
	
	@Test
	public void test_new_user_registeredDate_invalid() {
		String document = DataGenerator.nombreFile();
		String localDate = "05/05/2099";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", "", "", false, localDate, "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha ingresada no puede ser mayor a la fecha actual", newUser.getRegisteredDateError());
	}
	
	@Test
	public void test_new_user_cancel() {
		String document = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(newUser.getURL(), driver.getCurrentUrl());
	}
	
	@Test
	public void test_new_user_save_and_new() {
		String document = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, "", "", document, birthdate, "", "", "", "", false, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("", newUser.getName());
	}

	@Test
	public void test_new_user_existent_name() {
		String name = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		String surname = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, "", document, birthdate, "", "", "", "", true, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, "", document, birthdate, "", "", "", "", true, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El usuario ya existe", newUser.getAlertError());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}
