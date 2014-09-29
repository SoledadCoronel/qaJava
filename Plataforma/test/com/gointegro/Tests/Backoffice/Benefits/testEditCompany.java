package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.DetailCategory;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.ImageCropOverlay;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
import com.gointegro.Pages.Backoffice_Benefits.NewCompany;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditCompany extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_company_disabled() {
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_edit_company_name() {
		String name = DataGenerator.nombreFile();
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createName(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getName());
	}
	
	
	@Test
	public void test_edit_company_company_name() {
		String companyName = DataGenerator.nombreFile();
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createCompanyName(companyName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(companyName, detail.getCompanyName());
	}
	
	
	@Test
	public void test_edit_company_taxId() {
		String taxId = "56987522";
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createTaxId(taxId);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(taxId, detail.getTaxId());
	}
	
	
	@Test
	public void test_edit_company_phone() {
		String phone = "46851235";
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createPhone(phone);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(phone, detail.getPhone());
	}
	
	
	@Test
	public void test_edit_company_fax() {
		String fax = "01 514512321";
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createFax(fax);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(fax, detail.getFax());	
	}
	
	
	@Test
	public void test_edit_company_images() {
		String images = ConfigElements.getFileImagen();
		
		DetailCompany detail = createCompany(true, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String image1 = detail.getImage1();
		String image2 = detail.getImage2();
		String image3 = detail.getImage3();
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		ImageCropOverlay imageCrop = newCompany.image1Upload(images);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		imageCrop.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.image2Upload(images);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		imageCrop.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.image3Upload(images);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		imageCrop.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(image1, detail.getImage1());
		assertNotEquals(image2, detail.getImage2());
		assertNotEquals(image3, detail.getImage3());
	}
	
	
	@Test
	public void test_edit_company_logo() {
		String image = ConfigElements.getFileImagen();
		
		DetailCompany detail = createCompany(true, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String logo = detail.getLogo();
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		ImageCropOverlay imageCrop = newCompany.logoUpload(image);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		imageCrop.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(logo, detail.getLogo());
	}
	
	
	@Test
	public void test_edit_company_website() {
		String website = "http://www.algo.com";
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createWebSite(website);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(website, detail.getWebSite());	
	}
	
	
	@Test
	public void test_edit_company_description() {
		String description = DataGenerator.nombreFile();
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(description, detail.getDescription());
	}
	
	
	@Test
	public void test_edit_company_address() {
		String address = "Avenida Córdoba 5500, Buenos Aires, Argentina";
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createAddress(address);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(address.contains(detail.getStreet()));
	}
	
	
	@Test
	public void test_edit_company_tags_empty() {
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.removeTags(2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagListEmpty());
	}
	
	
	@Test
	public void test_edit_company_tags() {
		String tags = DataGenerator.nombreFile();
		String tags2 = DataGenerator.nombreFile();
		
		DetailCompany detail = createCompany(false, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createTag(tags);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createTag(tags2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagPresent(tags));
		assertTrue(detail.isTagPresent(tags2));
	}
	
	
	@Test
	public void test_edit_company_category_empty() {
		DetailCompany detail = createCompany(false, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.removeCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isCategoryListEmpty());
	}
	
	
	@Test
	public void test_edit_company_category() {
		String nameCat2 = DataGenerator.nombreFile();
		
		DetailCompany detail = createCompany(false, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String url = driver.getCurrentUrl();
		
		createCategory(nameCat2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(url);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCompany newCompany = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectCategory(nameCat2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isCategoryPresent(nameCat2));
	}
	
	private DetailCompany createCompany(boolean withImages, boolean withCategory) {
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String fax = "01 468455666";
		String siteLink = ConfigElements.getUrlTest();
		String description = DataGenerator.nombreFile();
		String tag1 = DataGenerator.nombreFile();
		String tag2 = DataGenerator.nombreFile();
		String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
		String zipCode = "1222";
		String floor = "7";
		String apartment = "5A";
		String fileupload = ConfigElements.getFileImagen();
		String nameCat = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		if(withCategory) {
			createCategory(nameCat);
		}
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		NewCompany newCompany = home.selectNewCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCompany.createNewCompany(name, companyName, taxId, phone, fax, fileupload, siteLink, description, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		if(withImages) {
			ImageCropOverlay imageCrop = newCompany.image1Upload(fileupload);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			newCompany.image2Upload(fileupload);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			newCompany.image3Upload(fileupload);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		
		newCompany.createTag(tag1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createTag(tag2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.selectCategory(nameCat);
		
		newCompany.createFloor(floor);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCompany.createApartment(apartment);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return newCompany.selectSave();
	}
	
	private void createCategory(String name) {
		String subcat = DataGenerator.nombreFile();
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectNewSubCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(subcat, subcat, subcat);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
