package com.gointegro.Tests.Content;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Content.AdminCategoryContent;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Content.NewCategoryOvelayContent;
import com.gointegro.Pages.Content.NewContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCategory extends AllTestsContent {

	private WebDriver driver;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_new_category_category_admin() {
		String categoryname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent admin = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admin.isCategoryInList(categoryname));
	}
	
	
	@Test
	public void test_new_category_empty_name() {
		String categoryname = "";
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent admin = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 20);

		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría no puede ser vacío", admin.getCategoryNameError());
	}
	
	
	@Test
	public void test_new_category_max_chars() {
		String categoryname = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent admin = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", admin.getMaxCharsError());
	}
	
	
	@Test
	public void test_new_existing_category() {
		String categoryname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent admin = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", admin.getSaveError());
	}
	
	
	@Test
	public void test_new_category_special_chars() {
		String categoryname = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent admin = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		admin.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admin.isCategoryInList(categoryname));
	}
	
	
	@Test
	public void test_new_category_special_chars_dropdown() {
		String categoryname = StringUtils.getCaracteresEspeciales() + DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		
		assertTrue(newContent.isCategoryOnList(categoryname));
	}
	
	
	@Test
	public void test_new_existing_category_dropdown() {
		String categoryname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", categoryOverlay.getCategoryNameExistsError());
	}
	
	
	@Test
	public void test_new_category_dropdown() {
		String categoryname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		
		assertTrue(newContent.getCategoryPresent().contains(categoryname));
	}
	
	
	@Test
	public void test_new_category_empty_name_dropdown() {
		String categoryname = "";
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		assertEquals("El nombre de la categoría no puede ser vacío", categoryOverlay.getCategoryNameError());
	}
	
	
	@Test
	public void test_new_category_max_chars_dropdown() {
		String categoryname = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent categoryOverlay = home.newCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		categoryOverlay.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", categoryOverlay.getCategoryNameError());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
	
	
	
}
