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
import com.gointegro.Util.WaitTool;

public class testEditContact extends AllTestsBackOfficeBenefits {
	
	String contactName = DataGenerator.nombreFile();
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_edit_contact_first_name() {
		String newName = DataGenerator.nombreFile();
		
		DetailCompany detail = createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewContactOverlay newContact = detail.selectEditContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.createFirstName(newName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.getContactName(contactElement).contains(newName));
	}
	
	
	@Test
	public void test_edit_contact_surname() {
		String newName = DataGenerator.nombreFile();
		
		DetailCompany detail = createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewContactOverlay newContact = detail.selectEditContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.createSurname(newName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.getContactName(contactElement).contains(newName));
	}
	
	
	@Test
	public void test_edit_contact_disabled() {
		DetailCompany detail = createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewContactOverlay newContact = detail.selectEditContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement contactElement = detail.getContactElement(contactName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(detail.isContactEnabled(contactElement));
	}
	
	
	@Test
	public void test_edit_contact() {
		String contactName = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String document = "8972154";
		String area = "Publicidad";
		String phone = "2349084";
		String cellphone = "9823154";
		String position = DataGenerator.nombreFile();
		String email = "nuevotest@gmail.com";
		String observation = DataGenerator.nombreFile();
		
		DetailCompany detail = createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewContactOverlay newContact = detail.selectEditContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
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
	
	private DetailCompany createContact() {
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String fax = "01 468455666";
		String siteLink = ConfigElements.getUrlTest();
		String description = DataGenerator.nombreFile();
		String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
		String zipCode = "1222";

		
		String surname = DataGenerator.nombreFile();
		String document = "484545646";
		String area = "Comercial";
		String cellphone = "94838933";
		String position = DataGenerator.nombreFile();
		String email = "test@email.com";
		String observation = DataGenerator.nombreFile();
		
		String fileupload = ConfigElements.getFileImagen();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCompany detail = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewContactOverlay newContact = detail.selectNewContact();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newContact.createContact(contactName, surname, document, phone, area, cellphone, position, email, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newContact.selectSave();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
