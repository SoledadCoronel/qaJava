package com.gointegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditInstalledAppWidget extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWidgets.getDriver();
	}

	
	@Test
	public void test_edit_app_celebration_title_with_text() {
		String title = DataGenerator.nombreFile();
		String title2 = DataGenerator.nombreFile();
		
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
		
		newModule.createCelebrationTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = home.getCelebrationAppElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createCelebrationTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertTrue(editWidget.isWidgetInListByTitle(title2));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	}
	
	@Ignore
	@Test
	public void test_edit_app_celebration_title_empty() {
		String title = DataGenerator.nombreFile();
		String title2 = "";
		
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
		
		newModule.createCelebrationTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement = home.getCelebrationAppElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createCelebrationTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
		
		newModule.selectCancelBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	@Ignore
	@Test
	public void test_edit_app_gallery_title_empty() {
		String title = DataGenerator.nombreFile();
		String title2 = "";
		
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
		
		//Edito el widget
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
		
		newModule.selectCancelBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	@Ignore
	@Test
	public void test_edit_app_gallery_remove_images() {
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
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement widgetElement = editWidget.getGalleryAppWidgetElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		int imagesCount = editWidget.getGalleryCarouselCount(widgetElement);
		
		//Edito el widget
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		newModule.selectPicturesInGallery(1);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(imagesCount > editWidget.getEditedGalleryCarouselCount(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
	}
	
	@Ignore
	@Test
	public void test_edit_app_gallery_add_images() {
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

		newModule.selectPicturesInGallery(1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement widgetElement = editWidget.getGalleryAppWidgetElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		int imagesCount = editWidget.getGalleryCarouselCount(widgetElement);
		
		//Edito el widget
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectPicturesInGallery(6);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		System.out.println("count: " + imagesCount);
		System.out.println("real: " + editWidget.getEditedGalleryCarouselCount(widgetElement));
		
		assertTrue(imagesCount < editWidget.getEditedGalleryCarouselCount(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
