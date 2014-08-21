package com.gointegro.Tests.Celebration;

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

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testDeleteCategory extends AllTestsCelebration {
	
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
	public void test_delete_category_empty() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay deleteoverlay = admincategory.selectCategoryDelete(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		deleteoverlay.selectConfirmDelete();
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.isCategoryInSideBar(categoryname));
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admincategory.isCategoryInList(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_delete_category_automation() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, true);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay deleteoverlay = admincategory.selectCategoryDelete(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		deleteoverlay.selectConfirmDelete();
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.isCategoryInSideBar(categoryname));
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admincategory.isCategoryInList(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_delete_category_with_events() {
		//TODO
	}
	
	@Test
	public void test_delete_category_cancel() {
		//TODO
	}
	
	private void createCategory (String categoryname, boolean isAutomation) {
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,isAutomation);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.isCategoryInSideBar(categoryname));
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
