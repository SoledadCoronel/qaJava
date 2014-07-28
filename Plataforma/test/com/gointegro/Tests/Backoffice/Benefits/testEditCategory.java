package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.DetailCategory;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditCategory extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_edit_category_disabled() {
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_edit_category_enabled() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
	}
	
	
	@Test
	public void test_edit_category_portuguese() {
		String newName = DataGenerator.nombreFile();
		
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newName, detail.getCatPT());
	}
	
	
	@Test
	public void test_edit_category_spanish() {
		String newName = DataGenerator.nombreFile();
		
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newName, detail.getCatES());		
	}
	
	
	@Test
	public void test_edit_category_english() {
		String newName = DataGenerator.nombreFile();
		
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newName, detail.getCatEN());
	}
	
	
	@Test
	public void test_edit_category_add_tags() {
		String tag = DataGenerator.nombreFile();
		
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeTags(tag);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagPresent(tag));
	}
	
	
	@Test
	public void test_edit_category_tags_empty() {
		String name = DataGenerator.nombreFile();
		String tag = DataGenerator.nombreFile();
		String tag2 = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeTags(tag);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.completeTags(tag2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.removeTags(2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagPresent(tag));
		assertTrue(detail.isTagPresent(tag2));
	}
	
	
	@Test
	public void test_edit_category_save_and_new() {
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newCategory.getNewCategoryURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_edit_category_cancel() {
		String newName = DataGenerator.nombreFile();
		
		DetailCategory detail = createCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(newName, newName, newName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(newName, detail.getCatEN());
	}

	private DetailCategory createCategory() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newCategory.selectSave();
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
