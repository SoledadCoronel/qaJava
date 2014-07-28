package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice_Benefits.DetailBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.NewBenefits;
import com.gointegro.Pages.Backoffice_Benefits.SelectStoreOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewBenefit extends TestBase {
	
	String owner = DataGenerator.nombreFile();
	String name = DataGenerator.nombreFile();
	String targetUser = "Clientes";
	String discount = "2x1";
	String validFrom = DataGenerator.fechaactual();
	String validUntil = DataGenerator.fechamanana();
	String fileupload = ConfigElements.getFileImagen();
	String benefitCode = "54aAsd4542";
	String title = DataGenerator.nombreFile();
	String desc = DataGenerator.nombreFile();
	
	private WebDriver driver;
		
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test  
	public void test_new_benefit() {
		String category = "Autos"; 
		String redeeming = "Mobile";
		String validDays = "Martes";
		String paymentMethod = "Tarjeta de débito";
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectRedeeming(redeeming);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectValidDays(validDays);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectPaymentMethods(paymentMethod);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectCategory(category);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
		assertEquals(owner, detail.getOwner());
		assertEquals(name, detail.getName());
		assertEquals(targetUser, detail.getTargetUser());
		assertEquals(discount, detail.getDiscount());
		assertTrue(detail.isCategoryPresent(category));
		assertTrue(detail.isRedeemingPresent(redeeming));
		assertTrue(detail.isValidDaysPresent(validDays));
		assertTrue(detail.isPaymentMethodPresent(paymentMethod));
		assertEquals(validFrom, detail.getValidFrom());
		assertEquals("", detail.getValidUntil());
		assertEquals("No", detail.getExpires());
		assertTrue(detail.getImage().endsWith(".jpg"));
		assertEquals("Si", detail.getHighlight());
		assertEquals(benefitCode, detail.getBenefitCode());
		assertEquals(title, detail.getTitle());
		assertEquals(desc, detail.getDescription());
	}
	
	
	@Test
	public void test_new_benefit_save_and_new() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().endsWith("/benefit/create"));
	}
	
	
	@Test
	public void test_new_benefit_owner_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit("", name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getOwnerErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_owner_max_char() {
		owner = StringUtils.getTextoLargo();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El responsable no puede superar los 80 caracteres", newBenefit.getOwnerErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_name_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, "", targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getNameErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_name_max_char() {
		name = StringUtils.getTextoLargo();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre no puede superar los 80 caracteres", newBenefit.getNameErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_no_discount() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, "", validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getDiscountErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_discount_promo() {
		discount = "PROMO";
		String value = "17";
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createValue(value);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(value, detail.getDiscount());
	}
	
	
	@Test
	public void test_new_benefit_validfrom_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, "", "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getValidFromErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_validfrom_invalid() {
		validFrom = DataGenerator.fechamanana();
		validUntil = DataGenerator.fechaactual();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, validUntil, fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El valor de creacion no puede ser mayor al valor de renovación", newBenefit.getValidFromErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_validuntil_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectExpires();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getValidUntilErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_no_image() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", "", true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe seleccionar una imagen", newBenefit.getImageErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_description_image_small() {
		fileupload = ConfigElements.getFileImageSmall();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.uploadSmallImg(fileupload);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El tamaño de la imagen debe ser mayor a 600x306", newBenefit.getImageErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_tags() {
		String tag = DataGenerator.nombreFile();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createTags(tag);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagPresent(tag));
	}
	
	
	@Test
	public void test_new_benefit_title_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, "", desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_title_max_char() {
		title = StringUtils.getTextoLargo();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El titulo no puede superar los 80 caracteres", newBenefit.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_description_empty() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo no puede estar vacío", newBenefit.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_description_max_char() {
		desc = StringUtils.getTextoLargo();
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La descripción no puede superar los 500 caracteres", newBenefit.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_associate_store() {
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SelectStoreOverlay selectStore = detail.selectRelateStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String storeName = selectStore.selectFirstStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		selectStore.selectClose();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isStoreInList(storeName));
	}
	
	@Test
	public void test_new_benefit_restricted() {
		String parts[] = ConfigElementsBO.getAccountPlatformTestName().split(" ");
		String platform = parts[1] + " " + parts[2];
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.searchRestrictedPlataform(platform);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.addRestricted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isRestrictedPlatformInList(platform));
	}
	
	
	@Test
	public void test_new_benefit_exclusive() {
		String parts[] = ConfigElementsBO.getAccountPlatformTestName().split(" ");
		String platform = parts[1] + " " + parts[2];
		
		NewBenefits newBenefit = goToCompany();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectExclusive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.searchExclusivePlataform(platform);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.addExclusive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isExclusivePlatformInList(platform));
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
	
	private NewBenefits goToCompany() {
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return detail.selectNewBenefit();
	}
}
