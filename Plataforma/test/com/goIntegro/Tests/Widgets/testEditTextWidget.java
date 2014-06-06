package com.goIntegro.Tests.Widgets;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditTextWidget extends TestBase {
	
private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWidgets.getDriver();
	}
	
	
	@Test
	public void test_text_edit_title_with_text() {
		String title = DataGenerator.nombreFile();
		String title2 = DataGenerator.nombreFile();
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
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		NewModuleOverlay newModule2 = editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule2.makeTitleVisible();
		WaitTool.waitForJQueryProcessing(driver, 5);
		newModule2.makeTitleVisible2();
		
		
		newModule2.createTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule2.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement2 = home.getTextWidgetElementByTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title2, home.getTextTitle(widgetElement2));
	}
	
	@Ignore
	@Test
	public void test_text_edit_title_empty() {
		String title = DataGenerator.nombreFile();
		String title2 = "";
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
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	@Ignore
	@Test
	public void test_text_edit_title_not_visible() {
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
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement2 = home.getTextWidgetElementByDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//assertFalse(home.is);
	}
	
	@Ignore
	@Test
	public void test_text_edit_description_with_text() {
		
	}
	
	@Ignore
	@Test
	public void test_text_edit_description_empty() {
		
	}
	
	@Ignore
	@Test
	public void test() {
		String title = "new twxto";
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement widgetElement = home.getTextWidgetElementByTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(title, home.getTextTitle(widgetElement));
		
		//Edito el widget
		EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		editWidget.selectEditWidget(widgetElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
