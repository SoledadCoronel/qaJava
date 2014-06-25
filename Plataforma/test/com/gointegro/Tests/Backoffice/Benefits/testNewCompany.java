package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCompany;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCompany extends TestBase {
	
	private WebDriver driver;

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
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	@Ignore  //FALTA ASSERT
	@Test
	public void test_create_company() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		
		
		
	}

	@Ignore
	@Test
	public void test_create_company_title_max_chars() {
		String name = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del comercio no puede superar los 80 caracteres", newCompany.getNameError());
	}
	
	@Ignore
	@Test
	public void test_create_company_name_max_chars() {
		String companyName = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("La razón social del comercio no puede superar los 80 caracteres", newCompany.getCompanyNameError());
	}
	
	@Ignore
	@Test
	public void test_create_company_description_max_chars() {
		String description = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("La descripción del comercio no puede superar los 500 caracteres", newCompany.getDescriptionError());
	}

	
	@Test
	public void test_create_company_empty_name() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany("", companyName, taxId, phone, fax, fileupload, siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Este campo no puede estar vacío", newCompany.getNameError());
	}

	@Ignore
	@Test
	public void test_create_company_empty_company_name() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, "", taxId, phone, fax, fileupload, siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getCompanyNameError());
	}
	
	@Ignore
	@Test
	public void test_create_company_empty_taxId() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, "", phone, fax, fileupload, siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getTaxIdError());
	}
	
	@Ignore
	@Test
	public void test_create_company_empty_phone() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, "", fax, fileupload, siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getPhoneError());
	}
	
	@Ignore
	@Test
	public void test_create_company_empty_logo() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, "", siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getLogoError());
	}
	
	@Ignore
	@Test
	public void test_create_company_empty_description() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, "", true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getDescriptionError());
	}
	
	@Ignore  //FALTA ASSERT
	@Test
	public void test_create_company_disabled() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}

	@Ignore
	@Test
	public void test_create_company_small_image() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El tamaño de la imagen debe ser mayor a 188x95", newCompany.getLogoError());
	}

	@Ignore
	@Test
	public void test_create_company_invalid_url() {
		String siteLink = "www.google.com";
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Ingrese una URL válida", newCompany.getWebSiteError());
	}
	
	@Ignore  //FALTA ASSERT
	@Test
	public void test_create_company_with_address() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createAddress(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createZipCode(zipCode);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		
	}

	@Ignore
	@Test
	public void test_create_company_no_zipcode() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createAddress(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El código postal no puede estar vacío", newCompany.getZipCodeError());
	}


	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
