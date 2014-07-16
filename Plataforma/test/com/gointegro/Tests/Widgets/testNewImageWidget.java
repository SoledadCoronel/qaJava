package com.gointegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewImageWidget extends TestBase {
	
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
		driver = AllTestsWidgets.getDriver();
	}
	
	
	@Test
	public void test_new_banner() {
		String title = DataGenerator.nombreFile();
		String imageFile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(newModule.isVisibleTitleEnabled());
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isImageWidgetOnList(title));
	}
	
	
	@Test
	public void test_new_banner_with_link() {
		String title = DataGenerator.nombreFile();
		String imageFile = ConfigElements.getFileImagen();
		String link = "http://www." + title + ".com";
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectLinkCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createLink(link);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
	
		WebElement bannerElement = home.getBannerElement(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.isImageWidgetOnList(title));
		assertEquals(link, home.getBannerLinkUrl(bannerElement));
	}
	
	
	@Test
	public void test_new_banner_without_link() {
		String title = DataGenerator.nombreFile();
		String imageFile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectLinkCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	
		assertEquals("Ingrese una URL válida.", newModule.getImageWidgetLinkErrorMsg());
	}
	
	
	@Test
	public void test_new_banner_without_title() {
		String title = "";
		String imageFile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectLinkCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_banner_without_image() {
		String title = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);

		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	
		assertEquals("Es necesario que suba una imagen.", newModule.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_new_banner_invalid_link() {
		String title = DataGenerator.nombreFile();
		String imageFile = ConfigElements.getFileImagen();
		String link = "www.algo.com.com.a";
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectImageBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectLinkCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createLink(link);
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		newModule.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	
		assertEquals("Ingrese una URL válida.", newModule.getImageWidgetLinkErrorMsg());
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
	
	
}
