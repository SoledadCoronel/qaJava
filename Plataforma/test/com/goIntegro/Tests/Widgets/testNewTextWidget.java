package com.goIntegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewTextWidget extends TestBase {
	
private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWidgets.getDriver();
	}
	
	
	@Test
	public void test_text_widget_title_visible() {
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
		
		newModule.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title, home.getTextTitle(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		WebElement widgetElement2 = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title, home.getTextTitle(widgetElement2));
	}
	
	
	@Test
	public void test_text_widget_title_not_visible() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
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
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement = home.getTextWidgetElementByDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(description, home.getTextDescription(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		WebElement widgetElement2 = home.getTextWidgetElementByDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(description, home.getTextDescription(widgetElement2));
	}
	
	
	@Test
	public void test_text_widget_title_empty() {
		String title = "";
		String description = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
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
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	//Titulo no permite catacteres especiales
	
	@Test
	public void test_text_widget_title_special_chars() {
		String title = StringUtils.getCaracteresEspeciales();
		String description = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
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
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title, home.getTextTitle(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		WebElement widgetElement2 = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title, home.getTextTitle(widgetElement2));
	}
	
	
	@Test
	public void test_text_widget_description_empty() {
		String title = DataGenerator.nombreFile();
		String description = "";
		
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
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_text_widget_description_special_chars() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getCaracteresEspeciales() + DataGenerator.fechaactual();
		
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
		
		newModule.selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement = home.getTextWidgetElementByDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(description, home.getTextDescription(widgetElement));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		WebElement widgetElement2 = home.getTextWidgetElementByDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(description, home.getTextDescription(widgetElement2));
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
