package com.gointegro.Tests.Widgets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewInstalledAppWidget extends AllTestsWidgets {
	
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
	public void test_new_app_celebration() {
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
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		assertTrue(home.isInstalledCellebrationAppWidgetinList(title));
	}
	
	
	@Test
	public void test_new_app_celebration_title_empty() {
		String title = "";
		
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_app_celebration_without_category() {
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
		WaitTool.waitForJQueryProcessing(driver, 10);
			
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectCategories();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Seleccione al menos una categoría.", newModule.getCategoryErrorMsg());
	}
	
	
	@Test
	public void test_new_app_gallery() {
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
		
		EditWidgets editWidgets = PageFactory.initElements(driver, EditWidgets.class);
		String galleryId = editWidgets.getGalleryAppWidgetId(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isInstalledGalleryAppWidgetInList(galleryId));
	}
	
	
	@Test
	public void test_new_app_gallery_empty_title() {
		String title = "";
		
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
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_app_gallery_without_images() {
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
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Seleccione al menos una imagen.", newModule.getNoImageErrorMsg());
	}

	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
