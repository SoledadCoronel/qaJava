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
import com.gointegro.Util.WaitTool;

public class testEditUser extends AllTestsBackofficePlatform {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void test_edit_user_name() {
		String newName = DataGenerator.nombreFile();
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setName(newName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newName, detail.getName());
	}
	
	@Test
	public void test_edit_name_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setName("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Campo obligatorio.", edit.getNameError());
	}
	
	@Test
	public void test_edit_surname() {
		String newSurname = DataGenerator.nombreFile();
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setSurname(newSurname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newSurname, detail.getSurname());
	}
	
	@Test
	public void test_edit_surname_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setSurname("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Campo obligatorio.", edit.getSurnameError());
	}
	
	@Test
	public void test_edit_email() {
		String newEmail = DataGenerator.nombreFile() + "@mail.com";
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setEmail(newEmail);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newEmail, detail.getEmail());		
	}
	
	@Test
	public void test_edit_email_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setEmail("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setRegistered(false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No posee", detail.getEmail());
	}
	
	@Test
	public void test_edit_email_empty_registered() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setEmail("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Un usuario registrado no puede tener el email vacío.", edit.getEmailError());
	}
	
	@Test
	public void test_edit_document() {
		String newDocument = DataGenerator.nombreFile();
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setDocument(newDocument);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newDocument, detail.getDocument());
	}
	
	@Test
	public void test_edit_document_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setDocument("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El documento no puede estar vacío", edit.getAlertError());
	}
	
	@Test
	public void test_edit_inactive() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectEnabled(false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isActive());
	}
	
	@Test
	public void test_edit_admission() {
		String newDate = "01/01/2055";
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setAdmission(newDate);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newDate, detail.getAdmission());
	}
	
	@Test
	public void test_edit_birithdate() {
		String newDate = "01/01/1055";
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setBirthDate(newDate);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newDate, detail.getBirthdate());
	}
	
	@Test
	public void test_edit_phone() {
		String newnumber = "01195468755";
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setPhone(newnumber);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newnumber, detail.getPhone());
	}
	
	@Test
	public void test_edit_phone_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setPhone("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No posee", detail.getPhone());
	}
	
	@Test
	public void test_edit_cellphone() {
		String newnumber = "01195468755";
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setCellphone(newnumber);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newnumber, detail.getCellphone());
	}
	
	@Test
	public void test_edit_cellphone_empty() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setCellphone("");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No posee", detail.getCellphone());
	}
	
	@Test
	public void test_edit_gender() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setGender("Femenino");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("F", detail.getGender());
	}
	
	@Test
	public void test_edit_role() {
		String role = "ROLE_ADMIN";
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.selectRole(role);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(role, detail.getRole());
	}
	
	@Test
	public void test_edit_unregister() {
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setRegistered(false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isRegistered());
	}
	
	@Test
	public void test_edit_registeredDate() {
		String newdate = "06/12/1910";
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setRegistedDate(newdate);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newdate, detail.getRegisteredDate());
	}
	
	@Test
	public void test_edit_integrationId() {
		String integrationID = DataGenerator.nombreFile();
		
		CreateUser edit = createUser();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.setintegrationId(integrationID);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(integrationID, detail.getIntegrationId());
	}
	
	private CreateUser createUser() {
		String name = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		String usernameId = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String adminissionDate = "09/10/2010";
		String birthdate = "04/11/1990";
		String gender = "Masculino";
		String phone = "20349829";
		String cellphone = "00293483";
		boolean regStatus = true;
		String integrationId = DataGenerator.nombreFile();
		String regDate = DataGenerator.fechaactual();
		String role = "ROLE_BASIC";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, adminissionDate, document, birthdate, gender, phone, cellphone, usernameId, regStatus, regDate, integrationId, role);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail.selectEdit();
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}
