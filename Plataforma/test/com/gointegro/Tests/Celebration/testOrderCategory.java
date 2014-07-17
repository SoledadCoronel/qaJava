package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testOrderCategory extends TestBase{
	
	private WebDriver driver;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Test
	public void test_order_category() {
		String category1name = DataGenerator.nombreFile();
		String category2name = DataGenerator.nombreFile();
		String category3name = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(category1name,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		home.open();
		
		newcategory = home.selectNewCategory();
		
		newcategory.createCategory(category2name,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		home.open();
		
		newcategory = home.selectNewCategory();
		
		newcategory.createCategory(category3name,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.changeOrder(category1name, category2name, category3name);
		
		assertEquals(2, admincategory.getElementIdInList(category1name));
		assertEquals(0, admincategory.getElementIdInList(category2name));
		assertEquals(1, admincategory.getElementIdInList(category3name));
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Este listado es distinto porque tiene en cuenta el texto todas las categorias y el header de listado como elementos propios.
		assertEquals(4, home.getElementIdInList(category1name));
		assertEquals(2, home.getElementIdInList(category2name));
		assertEquals(3, home.getElementIdInList(category3name));
		
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
