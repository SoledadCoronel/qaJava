package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
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
	String street = "Avenida Alvarez Thomas";
	String streetNumber = "198";
	String floor = "7";
	String apartment = "5A";
	String district = "Chacarita";
	String city = "Ciudad Autónoma de Buenos Aires";
	String province = "Buenos Aires";
	String country = "Argentina";
	String fileupload = ConfigElements.getFileImagen();
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_create_company() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createFloor(floor);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createApartment(apartment);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCompany detail = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Si", detail.getActive());
		assertEquals(name, detail.getName());
		assertEquals(companyName, detail.getCompanyName());
		assertEquals(taxId, detail.getTaxId());
		assertEquals(phone, detail.getPhone());
		assertEquals(fax, detail.getFax());
		assertFalse(detail.getLogo().isEmpty());
		assertTrue(detail.getWebSite().contains(siteLink));
		assertEquals(description, detail.getDescription());
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
	public void test_create_company_check_home() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.searchBenefit(name);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WebElement benefit = home.getBenefitElement(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(name, home.getName(benefit));
		assertEquals(country, home.getCountry(benefit));
		assertTrue(home.isEnabled(benefit));
	}


	
	@Test
	public void test_create_company_title_max_chars() {
		String name = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del comercio no puede superar los 80 caracteres", newCompany.getNameError());
	}
	
	
	@Test
	public void test_create_company_name_max_chars() {
		String companyName = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("La razón social del comercio no puede superar los 80 caracteres", newCompany.getCompanyNameError());
	}
	
	
	@Test
	public void test_create_company_description_max_chars() {
		String description = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
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
		
		newCompany.createNewCompany("", companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Este campo no puede estar vacío", newCompany.getNameError());
	}

	
	@Test
	public void test_create_company_empty_company_name() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, "", taxId, phone, fax, fileupload, siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getCompanyNameError());
	}
	
	
	@Test
	public void test_create_company_empty_taxId() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, "", phone, fax, fileupload, siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getTaxIdError());
	}
	
	
	@Test
	public void test_create_company_empty_phone() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, "", fax, fileupload, siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getPhoneError());
	}
	
	
	@Test
	public void test_create_company_empty_logo() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, "", siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getLogoError());
	}
	
	
	@Test
	public void test_create_company_empty_description() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, "", address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);

		assertEquals("Este campo no puede estar vacío", newCompany.getDescriptionError());
	}
	
	
	@Test
	public void test_create_company_disabled() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCompany detail = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("No", detail.getActive());
	}

	
	@Test
	public void test_create_company_small_logo() {
		fileupload = ConfigElements.getFileImageSmall();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.logoUploadSmallImg(fileupload);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, "", siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El tamaño de la imagen debe ser mayor a 188x95", newCompany.getLogoError());
	}

	
	@Test
	public void test_create_company_invalid_url() {
		String siteLink = "www.google.com/id=1?'";
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Ingrese una URL válida", newCompany.getWebSiteError());
	}
	
	
	@Test
	public void test_create_company_without_address() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, "", zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createZipCode(zipCode);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Por favor, complete con una ubicación", newCompany.getAddressError());
	}

	
	@Test
	public void test_create_company_no_zipcode() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, "", false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createAddress(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El código postal no puede estar vacío", newCompany.getAddressError());
	}
	
	
	@Test
	public void test_create_company_images_small() {
		String smallImg = ConfigElements.getFileImageSmall();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.image1Upload(smallImg);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.image2Upload(smallImg);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.image3Upload(smallImg);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El tamaño de la imagen debe ser mayor a 600x306", newCompany.getImage1Error());
		assertEquals("El tamaño de la imagen debe ser mayor a 600x306", newCompany.getImage2Error());
		assertEquals("El tamaño de la imagen debe ser mayor a 600x306", newCompany.getImage3Error());
	}
	
	
	@Test
	public void test_create_company_with_tag() {
		String tag1 = DataGenerator.nombreFile();
		String tag2 = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createTag(tag1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createTag(tag2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCompany detail = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.isTagPresent(tag1));
		assertTrue(detail.isTagPresent(tag2));
	}
	
	
	@Test
	public void test_create_company_with_category() {
		String nameCat = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(nameCat, nameCat, nameCat);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectCategory(nameCat);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCompany detailCompany = newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detailCompany.isCategoryPresent(nameCat));
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
