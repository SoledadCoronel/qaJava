package com.gointegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testOrderSizeWidgets  extends AllTestsWidgets {
	
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
	public void test_widget_change_position() {
		String title = DataGenerator.nombreFile();
		String title2 = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();

		String rowElement;
		String colElement;
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		//Creo primer widget
		newModule.createTextWidget(title, description);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Creo segundo widget
		home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.createTextWidget(title2, description);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		WebElement widgetElement1 = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement widgetElement2 = home.getTextWidgetElementByTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		rowElement = editWidget.getRowForElement(widgetElement1);
		colElement = editWidget.getColForElement(widgetElement1);
		
		editWidget.changeOrder(widgetElement1, widgetElement2);
		
		assertEquals(rowElement, editWidget.getRowForElement(widgetElement2));
		assertEquals(colElement, editWidget.getColForElement(widgetElement2));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
	}
	
	@Test
	public void test_widget_resize() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();

		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		//Creo primer widget
		newModule.createTextWidget(title, description);
		
		WebElement widgetElement = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		int ySize = widgetElement.getSize().height;
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		editWidget.resizeWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		int ySize2 = widgetElement.getSize().height;
		
		assertTrue(ySize < ySize2);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
	}
	
	private boolean isAlertPresent(){
	     try{
	         driver.switchTo().alert();
	         return true;
	     }
	     catch(Exception e){
	    	 return false;
	     }
    }
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		if(isAlertPresent()) {
			driver.switchTo().alert();
	        driver.switchTo().alert().accept();
	        driver.switchTo().defaultContent();
		}
	}
}
