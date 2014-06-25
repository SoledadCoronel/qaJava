package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCategory extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}

	@Ignore  //FALTA ASSERT
	@Test
	public void test_new_category() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		
		
		
		
	}
	
	@Ignore
	@Test
	public void test_new_category_save_and_new() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newCategory.getNewCategoryURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_new_category_press_cancel() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(category.getURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_new_category_empty_spanish() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español es obligatorio", newCategory.getSpanishError());		
	}
	
	
	@Test
	public void test_new_category_empty_portuguese() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Portugués es obligatorio", newCategory.getPortugueseError());	
	}
	
	
	@Test
	public void test_new_category_empty_english() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Inglés es obligatorio", newCategory.getEnglishError());		
	}
	
	
	@Test
	public void test_new_category_spanish_max_char() {
		String name = DataGenerator.nombreFile();
		String nameLarge = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(nameLarge);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español no puede superar los 80 caracteres", newCategory.getSpanishError());
	}
	
	
	@Test
	public void test_new_category_portugues_max_char() {
		String name = DataGenerator.nombreFile();
		String nameLarge = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(nameLarge);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Portugués no puede superar los 80 caracteres", newCategory.getPortugueseError());
	}
	
	
	@Test
	public void test_new_category_english_max_char() {
		String name = DataGenerator.nombreFile();
		String nameLarge = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeSpanish(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completePortuguese(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.completeEnglish(nameLarge);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Inglés no puede superar los 80 caracteres", newCategory.getEnglishError());
	}
	
	@Ignore //FALTA ASSERT
	@Test
	public void test_new_category_disabled() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
