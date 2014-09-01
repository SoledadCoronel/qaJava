package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.NewStore;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewStore extends AllTestsBackOfficeBenefits {
	
	String type = "Local";
	String name = DataGenerator.nombreFile();
	String companyName = DataGenerator.nombreFile();
	String taxId = "654855551";
	String phone = "15 84546655";
	String email = "test@mail.com";
	String siteLink = ConfigElements.getUrlTest();
	String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
	String zipCode = "1222";
	String street = "Avenida Alvarez Thomas";
	String streetNumber = "198";
	String floor = "7";
	String apartment = "5A";
	String district = "Chacarita";
	String city = "Ciudad Autónoma de Buenos Aires";
	String province = "Buenos Aires";
	String country = "Argentina";
	
	private WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_new_store() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String contact = newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createFloor(floor);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createApartment(apartment);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(type, detail.getType());
		assertEquals(name, detail.getName());
		assertEquals(contact, detail.getContact());
		assertEquals(phone, detail.getPhone());
		assertEquals(companyName, detail.getCompanyName());
		assertEquals(taxId, detail.getTaxId());
		assertEquals(email, detail.getEmail());
		assertEquals(siteLink, detail.getWebSite());
		assertEquals(street, detail.getStreet());
		assertEquals(streetNumber, detail.getStreetNumber());
		assertEquals(floor, detail.getFloor());
		assertEquals(apartment, detail.getApartment());
		assertEquals(district, detail.getDistrict());
		assertEquals(city, detail.getCity());
		assertEquals(province, detail.getProvince());
		assertEquals(country, detail.getCountry());
	}
	
	
	@Test  
	public void test_new_store_type_online() {
		String onlinetype = "Online";
		String address1 = "Ciudad Autónoma de Buenos Aires, Buenos Aires";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(onlinetype, name, phone, companyName, taxId, email, siteLink, address1, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(onlinetype, detail.getType());
		assertTrue(detail.isAreaTitlePresent(address1));
	}
	
	
	@Test   
	public void test_new_store_type_phone() {
		String teletype = "Telefónica";
		String address1 = "Ciudad Autónoma de Buenos Aires, Buenos Aires";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(teletype, name, phone, companyName, taxId, email, siteLink, address1, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(teletype, detail.getType());
		assertTrue(detail.isAreaTitlePresent(address1));
	}

	
	@Test
	public void test_new_store_name_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, "", phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getNameError());	
	}

	
	@Test
	public void test_new_store_name_max_char() {
		String localname = StringUtils.getTextoLargo();
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, localname, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre de la sucursal no puede superar los 80 caracteres", newStore.getNameError());
	}

	
	@Test
	public void test_new_store_contact_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getContactError());
	}

	
	@Test
	public void test_new_store_company_name_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, "", taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getCompanyNameError());
	}

	
	@Test
	public void test_new_store_company_name_max_char() {
		String localcompanyName = StringUtils.getTextoLargo();
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, localcompanyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La razón social de la sucursal no puede superar los 80 caracteres", newStore.getCompanyNameError());
	}

	
	@Test
	public void test_new_store_taxid_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, "", email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getTaxIdError());
	}

	
	@Test
	public void test_new_store_address_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, "", zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor, complete con una ubicación", newStore.getAddressError());
	}

	
	@Test
	public void test_new_store_zipcode_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El código postal no puede estar vacío", newStore.getAddressError());
	}

	
	@Test
	public void test_new_store_add_new_area() {
		String onlinetype = "Online";
		String address1 = "Ciudad Autónoma de Buenos Aires, Buenos Aires";
		String address2 = "Córdoba, Argentina";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(onlinetype, name, phone, companyName, taxId, email, siteLink, "", "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createAddressArea(address1);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.selectAddNewArea();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createAddressArea2(address2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(onlinetype, detail.getType());
		assertTrue(detail.isAreaTitlePresent(address1));
		assertTrue(detail.isAreaTitlePresent(address2));
	}
	
	private NewStore selectNewStore() {
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return detail.selectNewStore();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
