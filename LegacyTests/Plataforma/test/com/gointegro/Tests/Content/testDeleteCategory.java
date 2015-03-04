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
import com.gointegro.Pages.Content.DeleteOverlay;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Content.NewCategoryOvelayContent;
import com.gointegro.Pages.Content.NewContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteCategory extends AllTestsContent {
	
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
	public void test_delete_category() {
		String categoryName = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);

		adminCategory.createCategory(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = adminCategory.selectCategoryDelete(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(adminCategory.isCategoryInList(categoryName));
		
	}
	
	
	@Test
	public void test_delete_category_with_content() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String categoryName = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOvelayContent newcategory = newContent.selectNewCategory();
		
		newcategory.createCategory(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newContent.setCategory(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory = home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = adminCategory.selectCategoryDelete(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Esta categoría tiene contenidos asociados", delete.getAlertMessage());
		
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(adminCategory.isCategoryInList(categoryName));
		
	}
	
	
	@Test
	public void test_delete_category_cancel() {
		String categoryName = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategoryContent adminCategory= home.adminCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);

		adminCategory.createCategory(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		adminCategory.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = adminCategory.selectCategoryDelete(categoryName);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(adminCategory.isCategoryInList(categoryName));
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
	

}
