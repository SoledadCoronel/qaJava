package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailContactOverlay;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCompany;
import com.gointegro.Pages.Backoffice_Benefits.NewContactOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewContact extends AllTestsBackOfficeBenefits {
	
	String contactName = DataGenerator.nombreFile();
	String surname = DataGenerator.nombreFile();
	String document = "484545646";
	String phone = "11458788";
	String area = "Comercial";
	String cellphone = "94838933";
	String position = DataGenerator.nombreFile();
	String email = "test@email.com";
	String observation = DataGenerator.nombreFile();
	
	private WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void test_new_contact() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailCompany detail = newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(contactName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(contactName + " " + surname, detail.getContactName(contactElement));
		assertEquals(area, detail.getContactArea(contactElement));
		assertEquals(position, detail.getContactPosition(contactElement));
		assertTrue(detail.isContactEnabled(contactElement));
	}
	
	@Test
	public void test_new_contact_check_detail() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailCompany detail = newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(contactName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailContactOverlay detailContact = detail.selectContact(contactElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Si", detailContact.getActive());
		assertEquals(contactName + " " + surname, detailContact.getName());
		assertEquals(area, detailContact.getArea());
		assertEquals(position, detailContact.getPosition());
		assertEquals(document, detailContact.getDocument());
		assertEquals(phone, detailContact.getPhone());
		assertEquals(email, detailContact.getEmail());
		assertEquals(observation, detailContact.getObservation());
		assertEquals(cellphone, detailContact.getCellphone());
		
	}
	
	@Test
	public void test_new_contact_name_empty() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact("", surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newContact.getFirstnameErrorMsg());
	}
	
	@Test
	public void test_new_contact_name_special_char() {
		contactName = StringUtils.getCaracteresEspeciales();
		
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailCompany detail = newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(contactName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(contactName + " " + surname, detail.getContactName(contactElement));	
	}
	
	@Test
	public void test_new_contact_name_max_char() {
		String contactName = StringUtils.getTextoLargo();
		
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre del contacto no puede superar los 80 caracteres", newContact.getFirstnameErrorMsg());
	}
	
	@Test
	public void test_new_contact_surname_empty() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, "", document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newContact.getSurnameErrorMsg());
	}
	
	@Test
	public void test_new_contact_surname_max_char() {
		String surname = StringUtils.getTextoLargo();
		
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El apellido del contacto no puede superar los 80 caracteres", newContact.getSurnameErrorMsg());
	}
	
	@Test
	public void test_new_contact_email_invalid() {
		email = DataGenerator.nombreFile();
		
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese un mail válido", newContact.getEmailErrorMsg());
	}
	
	@Test
	public void test_new_contact_observation_max_char() {
		observation = StringUtils.getTextoLargo();
		
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo observaciones no puede superar los 500 caracteres", newContact.getObservationsErrorMsg());
	}
	
	@Test
	public void test_new_contact_save_and_new() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(newContact.isNameInputEmpty());
	}
	
	@Test
	public void test_new_contact_cancel() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailCompany detail = newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isContactInList(contactName));
	}
	
	@Test
	public void test_new_contact_disabled() {
		NewContactOverlay newContact = createCompany();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailCompany detail = newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(contactName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(detail.isContactEnabled(contactElement));
	}
	
	private NewContactOverlay createCompany() {
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String fax = "01 468455666";
		String siteLink = ConfigElements.getUrlTest();
		String description = DataGenerator.nombreFile();
		String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
		String zipCode = "1222";

		String fileupload = ConfigElements.getFileImagen();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCompany detail = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return detail.selectNewContact();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
