package com.gointegro.Tests.Content;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Content.AdminCategoryContent;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditCategory extends TestBase{

	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsContent.getDriver();
	}
	
	
	@Test
	public void test_edit_category() {
		String categoryName1 = DataGenerator.nombreFile();
		String categoryName2 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.selectCategoryEdit(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.editCategory(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(adminCategory.isCategoryInList(categoryName2));
	}
	
	
	@Test
	public void test_edit_category_empty() {
		String categoryName1 = DataGenerator.nombreFile();
		String categoryName2 = "";
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.selectCategoryEdit(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.editCategory(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría no puede ser vacío", adminCategory.getCategoryNameError());
	}
	
	
	@Test
	public void test_edit_category_max_chars() {
		String categoryName1 = DataGenerator.nombreFile();
		String categoryName2 = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.selectCategoryEdit(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.editCategory(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", adminCategory.getCategoryNameError());
	}
	
	
	@Test
	public void test_edit_existing_category() {
		String categoryName1 = DataGenerator.nombreFile();
		String categoryName2 = DataGenerator.nombreFile();
		String categoryName3 = categoryName1;
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.createCategory(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.selectCategoryEdit(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.editCategory(categoryName3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", adminCategory.getSaveError());
	}
	
	
	@Test
	public void test_edit_category_press_cancel() {
		String categoryName1 = DataGenerator.nombreFile();
		String categoryName2 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.selectCategoryEdit(categoryName1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.cancelEditCategory(categoryName2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(adminCategory.isCategoryInList(categoryName2));
		assertTrue(adminCategory.isCategoryInList(categoryName1));
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
	
}
