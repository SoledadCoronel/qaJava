package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.NewStore;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditStore extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_edit_store_type() {
		String type = "Online";
		String area = "Córdoba, Argentina";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectType(type);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createAddress(area);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(type, detail.getType());
	}

	
	@Test
	public void test_edit_store_disabled() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}

	
	@Test
	public void test_edit_store_name() {
		String name = DataGenerator.nombreFile();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createName(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getName());
	}

	
	@Test
	public void test_edit_store_contact() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.removeContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createContact(name, surname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name + " " + surname, detail.getContact());
	}

	
	@Test
	public void test_edit_store_phone() {
		String phone = DataGenerator.nombreFile();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createPhone(phone);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(phone, detail.getPhone());
	}

	
	@Test
	public void test_edit_store_company_name() {
		String companyName = DataGenerator.nombreFile();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createCompanyName(companyName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(companyName, detail.getCompanyName());
	}

	
	@Test
	public void test_edit_store_taxId() {
		String taxId = "20-198154562-5";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createTaxId(taxId);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(taxId, detail.getTaxId());
	}

	
	@Test
	public void test_edit_store_email() {
		String email = "untest@gmail.com";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createEmail(email);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(email, detail.getEmail());
	}

	
	@Test
	public void test_edit_store_web_site() {
		String email = "untest@gmail.com";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createEmail(email);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(email, detail.getEmail());
	}

	
	@Test
	public void test_edit_store_address() {
		String address = "Avenida Córdoba 5500, Buenos Aires, Argentina";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createAddress(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(address.contains(detail.getStreet()));
	}

	
	@Test
	public void test_edit_store_zip_code() {
		String zipcode = "1358";
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createZipCode(zipcode);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(zipcode, detail.getZipCode());
	}

	
	@Test
	public void test_edit_store_area() {
		String type = "Online";
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String email = "test@mail.com";
		String siteLink = ConfigElements.getUrlTest();
		String address = "Ciudad Autónoma de Buenos Aires, Buenos Aires";
		String address2 = "Córdoba, Argentina";
		
		
		loginBackoffice(driver);
		
		DetailCompany detailCompany = PageFactory.initElements(driver, DetailCompany.class);
		detailCompany.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore1 = detailCompany.selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore1.createNewStore(type, name, phone, companyName, taxId, email, siteLink, "", "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore1.createAddressArea(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore1.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailStore detail = newStore1.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createAddressArea(address2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isAreaTitlePresent(address2));
	}

	
	@Test
	public void test_edit_store_save_and_new() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(newStore.getName().isEmpty());
	}

	
	@Test
	public void test_edit_store_cancel() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCompany company = PageFactory.initElements(driver, DetailCompany.class);
		
		assertEquals(company.getURL(), driver.getCurrentUrl());
	}
	
	private DetailStore createStore() {
		String type = "Local";
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String email = "test@mail.com";
		String siteLink = ConfigElements.getUrlTest();
		String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
		String zipCode = "1222";
		
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return newStore.selectSave();
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
