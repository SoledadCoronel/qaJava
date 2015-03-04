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

import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testDeleteInstalledAppWidget extends AllTestsWidgets {
	
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
	public void test_delete_app_celebration() {
		String title = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectInstalledApps();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectApplicationCelebration();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = home.getCelebrationAppElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Elimino el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    deteleOverlay.selectConfirmDelete();
	    WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(editWidget.isWidgetInListByTitle(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	}
	
	
	@Test
	public void test_delete_app_celebration_press_cancel_overlay() {
		String title = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectInstalledApps();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectApplicationCelebration();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = home.getCelebrationAppElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Elimino el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    deteleOverlay.selectCancelDelete();
	    WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(editWidget.isWidgetInListByTitle(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	}
	
	
	@Test
	public void test_delete_app_gallery() {
		String title = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectInstalledApps();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectApplicationGallery();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectPicturesInGallery(10);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = editWidget.getGalleryAppWidgetElement(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Elimino el widget
		DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    deteleOverlay.selectConfirmDelete();
	    WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(editWidget.isWidgetInListByTitle(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	}
	
	
	@Test
	public void test_delete_app_gallery_press_cancel_overlay() {
		String title = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectInstalledApps();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectApplicationGallery();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectPicturesInGallery(10);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = editWidget.getGalleryAppWidgetElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Elimino el widget
		DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    deteleOverlay.selectCancelDelete();
	    WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(editWidget.isWidgetInListByTitle(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
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
