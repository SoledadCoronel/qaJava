package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.NewStore;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewStore extends TestBase {
	
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
		
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	@Ignore
	@Test
	public void test_new_store() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		System.out.println("22: " + driver.findElement(By.xpath("//form[@class='form-horizontal']")).isDisplayed());
		System.out.println("pri: " + driver.findElement(By.xpath("//form[@class='form-horizontal']")).isEnabled());
		
		newStore.createFloor(floor);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.createApartment(apartment);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//String contact = newStore.selectContact();
		newStore.createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		System.out.println("text: " + driver.findElement(By.xpath("//body")).isDisplayed());
		System.out.println("text22: " + driver.findElement(By.xpath("//body")).isEnabled());
		
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(type, detail.getType());
		assertEquals(name, detail.getName());
		//assertEquals(contact, detail.getContact());
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
	
	@Ignore
	@Test  //FALTA ASSERT
	public void test_new_store_type_online() {
		type = "Online";
		address = "Buenos Aires, Argentina";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//newStore.createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(type, detail.getType());
		assertEquals(name, detail.getName());
		
	}
	
	@Ignore
	@Test   //FALTA ASSERT
	public void test_new_store_type_phone() {
		type = "Telefónica";
		address = "Buenos Aires, Argentina";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//newStore.createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(type, detail.getType());
		assertEquals(name, detail.getName());
		
	}

	
	@Test
	public void test_new_store_name_empty() {
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, "", phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getNameError());
		
	}

	
	@Test
	public void test_new_store_name_max_char() {
		name = StringUtils.getTextoLargo();
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
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
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newStore.getCompanyNameError());
	}

	
	@Test
	public void test_new_store_company_name_max_char() {
		companyName = StringUtils.getTextoLargo();
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
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
		
		newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El código postal no puede estar vacío", newStore.getAddressError());
	}

	@Ignore
	@Test  //FALTA ASSERT
	public void test_new_store_add_new_area() {
		type = "Online";
		address = "Buenos Aires, Argentina";
		
		NewStore newStore = selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, "", "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//newStore.createContact();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.selectAddNewArea();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.selectCollapseArea1();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createAddressArea(address);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.selectCollapseArea2();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createAddressArea2(address);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(type, detail.getType());
		assertEquals(name, detail.getName());
	}
	
	private NewStore selectNewStore() {
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return detail.selectNewStore();
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
