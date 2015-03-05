package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.DetailCategory;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCategory extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	
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
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getActive());
		assertEquals(name, detail.getCatES());
		assertEquals(name, detail.getCatPT());
		assertEquals(name, detail.getCatEN());
	}
	
	
	@Test
	public void test_new_category_check_home() {
		String nameES = DataGenerator.nombreFile();
		String namePT = DataGenerator.nombreFile();
		String nameEN = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(nameES, namePT, nameEN);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		category.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		category.searchCategory(nameES);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement categoryElement = category.getCategoryElement(nameES);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(category.isNamePresent(categoryElement, nameES));
		assertTrue(category.isNamePresent(categoryElement, namePT));
		assertTrue(category.isNamePresent(categoryElement, nameEN));
		assertTrue(category.isActive(categoryElement));
	}
	
	
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
		
		newCategory.createCategory(name, name, name);
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
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(category.getURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_new_category_spanish_empty() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory("", name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español es obligatorio", newCategory.getSpanishError());		
	}
	
	
	@Test
	public void test_new_category_portuguese_empty() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, "", name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Portugués es obligatorio", newCategory.getPortugueseError());	
	}
	
	
	@Test
	public void test_new_category_english_empty() {
		String name = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, "");
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
		
		newCategory.createCategory(nameLarge, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español no puede superar los 80 caracteres", newCategory.getSpanishError());
	}
	
	
	@Test
	public void test_new_category_portuguese_max_char() {
		String name = DataGenerator.nombreFile();
		String nameLarge = StringUtils.getTextoLargo();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, nameLarge, name);
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
		
		newCategory.createCategory(name, name, nameLarge);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Inglés no puede superar los 80 caracteres", newCategory.getEnglishError());
	}
	
	
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
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_new_category_with_tags() {
		String name = DataGenerator.nombreFile();
		String tag = DataGenerator.nombreFile();
		
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
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTagPresent(tag));
	}
	
	@Test
	public void test_new_category_restricted(){
		String name = DataGenerator.nombreFile();
		String parts[] = ConfigElementsBO.getAccountPlatformTestName().split(" ");
		String platform = parts[1] + " " + parts[2];
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.searchRestrictedPlataform(platform);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newCategory.addRestricted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(detail.isRestrictedPlatformInList(platform));
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
