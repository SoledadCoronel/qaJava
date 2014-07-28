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
import com.gointegro.Util.WaitTool;

public class testEditBenefit extends TestBase {
	
	String parts[] = ConfigElementsBO.getAccountPlatformTestName().split(" ");
	String platform = parts[1] + " " + parts[2];
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_edit_benefit_disabled() {
		DetailBenefits detail = createBenefit(true, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_edit_benefit_enabled_without_store() {
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe tener sucursales adheridas para activar el beneficio", newBenefit.getSaveErrorMsg());
	}
	
	
	@Test
	public void test_edit_benefit_owner() {
		String name = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createOwner(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getOwner());
	}
	
	
	@Test
	public void test_edit_benefit_name() {
		String name = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createName(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getName());
	}
	
	
	@Test
	public void test_edit_benefit_target_user() {
		String target = "Empleados";
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectTargetUserType(target);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(target, detail.getTargetUser());
	}
	
	
	@Test
	public void test_edit_benefit_discount() {
		String discount = "85%";
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectDiscount(discount);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(discount, detail.getDiscount());
	}
	
	
	@Test
	public void test_edit_benefit_highlighted() {
		DetailBenefits detail = createBenefit(false, true, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectHighlight();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getHighlight());
	}
	
	
	@Test
	public void test_edit_benefit_validFrom() {
		String date = "12/12/2020";
				
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectValidFrom(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(date, detail.getValidFrom());
	}
	
	
	@Test
	public void test_edit_benefit_add_expire() {
		String date = "12/12/2020";
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectExpires();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectValidUntil(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getExpires());
		assertEquals(date, detail.getValidUntil());
	}
	
	
	@Test
	public void test_edit_benefit_remove_expire() {
		String date = DataGenerator.fechamanana();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, date);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectExpires();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectValidUntil(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getExpires());
		assertTrue(detail.getValidUntil().isEmpty());
	}
	
	
	@Test
	public void test_edit_benefit_benefitCode() {
		String code = "23d23d333x";
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefitCode(code);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(code, detail.getBenefitCode());
	}
	
	
	@Test
	public void test_edit_benefit_remove_access_info() {
		DetailBenefits detail = createBenefit(false, false, true, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.removeRedeeming();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.removePaymentMethods();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.removeValidDays();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isRedeemingListEmpty());
		assertTrue(detail.isValidDaysListEmpty());
		assertTrue(detail.isPaymentMethodListEmpty());
	}
	
	
	@Test
	public void test_edit_benefit_title() {
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(title, detail.getTitle());
	}
	
	
	@Test
	public void test_edit_benefit_description() {
		String description = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(description, detail.getDescription());
	}
	
	
	@Test
	public void test_edit_benefit_tags_empty() {
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.removeTags(1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagListEmpty());
	}
	
	
	@Test
	public void test_edit_benefit_category_empty() {
		DetailBenefits detail = createBenefit(false, false, false, true, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.removeTags(1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isCategoryListEmpty());
	}
	
	
	@Test
	public void test_edit_benefit_save_and_new() {
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().endsWith("/benefit/create"));
	}
	
	
	@Test
	public void test_edit_benefit_cancel() {
		String name = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createName(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCompany detailCompany = PageFactory.initElements(driver, DetailCompany.class);
		
		assertEquals(detailCompany.getURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_edit_benefit_remove_exclusive() {
		DetailBenefits detail = createBenefit(false, false, false, false, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectExclusive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.removeExclusive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isExclusivePlatformInList(platform));
	}
	
	
	@Test
	public void test_edit_benefit_remove_restricted() {
		DetailBenefits detail = createBenefit(false, false, false, false, false, true, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.removeRestricted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isRestrictedPlatformInList(platform));
	}
	
	@Test
	public void test_edit_benefit_remove_store() {
		DetailBenefits detail = createBenefit(false, false, false, false, false, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SelectStoreOverlay selectStore = detail.selectRelateStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String storeName = selectStore.selectFirstStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		selectStore.selectClose();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isStoreInList(storeName));
		
		detail.selectRelateStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		selectStore.selectFirstStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		selectStore.selectClose();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isStoreInList(storeName));
	}
	
	
	private DetailBenefits createBenefit(boolean isActive, boolean isHighlighted, boolean hasAccessInfo, boolean hasCategory, boolean isExclusive, boolean isRestricted, String validUntil) {
		String owner = DataGenerator.nombreFile();
		String name = DataGenerator.nombreFile();
		String targetUser = "Clientes";
		String discount = "2x1";
		String validFrom = DataGenerator.fechaactual();
		String fileupload = ConfigElements.getFileImagen();
		String benefitCode = "54aAsd4542";
		String title = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String category = "Autos"; 
		String redeeming = "Mobile";
		String validDays = "Martes";
		String paymentMethod = "Tarjeta de débito";

		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewBenefits newBenefit = detail.selectNewBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, validUntil, fileupload, isHighlighted, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createTags(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		if(isActive) {
			newBenefit.selectActive();
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		
		if(hasAccessInfo) {
			newBenefit.selectRedeeming(redeeming);
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			newBenefit.selectValidDays(validDays);
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			newBenefit.selectPaymentMethods(paymentMethod);
			WaitTool.waitForJQueryProcessing(driver, 10);
		}
		
		if(hasCategory) {
			newBenefit.selectCategory(category);
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		
		if(isExclusive) {
			newBenefit.selectExclusive();
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			newBenefit.searchExclusivePlataform(platform);
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			newBenefit.addExclusive();
			WaitTool.waitForJQueryProcessing(driver, 10);
		}
		
		if(isRestricted) {
			newBenefit.searchRestrictedPlataform(platform);
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			newBenefit.addRestricted();
			WaitTool.waitForJQueryProcessing(driver, 10);
		}
		
		return newBenefit.selectSave();
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
