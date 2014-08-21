package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBOBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailSpecial;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewSpecial;
import com.gointegro.Pages.Backoffice_Benefits.SpecialList;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditSpecial extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_edit_special_disabled() {
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_edit_special_portuguese() {
		String name = DataGenerator.nombreFile();
		
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completePortuguese(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getNamePT());
	}
	
	
	@Test
	public void test_edit_special_spanish() {
		String name = DataGenerator.nombreFile();
		
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getNameES());
	}
	
	
	@Test
	public void test_edit_special_english() {
		String name = DataGenerator.nombreFile();
		
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeEnglish(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(name, detail.getNameEN());
	}
	
	
	@Test
	public void test_edit_special_valid_until() {
		String date = "15/12/2020";
		
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(date, detail.getValidUntil());
	}
	
	
	@Test
	public void test_edit_special_remove_benefit() {
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.removefirstBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El especial debe tener al menos un beneficio relacionado", newSpecial.getBenefitsError());
	}
	
	
	@Test
	public void test_edit_special_save_and_new() {
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().contains("/collection/create"));
		assertTrue(newSpecial.getSpanish().isEmpty());
	}
	
	
	@Test
	public void test_edit_special_cancel() {
		String name = DataGenerator.nombreFile();
		
		DetailSpecial detail = createSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(name, detail.getNameES());
	}
	
	private DetailSpecial createSpecial() {
		String spanish = DataGenerator.nombreFile();
		String portuguese = DataGenerator.nombreFile();
		String english = DataGenerator.nombreFile();
		String date = DataGenerator.fechamanana();
		String image = ConfigElements.getFileImagen();
		String benefit = ConfigElementsBOBenefits.getCompanyName();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSearchCompany(benefit);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectFirstBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.addBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return newSpecial.selectSave();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
