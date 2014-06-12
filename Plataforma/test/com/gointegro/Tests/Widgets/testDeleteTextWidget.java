package com.gointegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.EditWidgets;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteTextWidget  extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWidgets.getDriver();
	}
	
	
	@Test
	public void test_text_delete() {
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
	
	    home.selectSaveBtn();
	    WaitTool.waitForJQueryProcessing(driver, 60);
	
	    home.selectConfigBtn();
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    WebElement widgetElement = home.getTextWidgetElementByTitle(title);
	    WaitTool.waitForJQueryProcessing(driver, 5);
	
	    //Elimino el widget
	    EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
	
	    DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
	    WaitTool.waitForJQueryProcessing(driver, 10);
	
	    deteleOverlay.selectConfirmDelete();
	    WaitTool.waitForJQueryProcessing(driver, 5);
	
	    assertFalse(editWidget.isWidgetInListByTitle(title));
	
	    home.selectSaveBtn();
	    WaitTool.waitForJQueryProcessing(driver, 60);
	}

	
	@Test
	public void test_text_delete_press_cancel_overlay() {
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

        home.selectSaveBtn();
        WaitTool.waitForJQueryProcessing(driver, 60);

        home.selectConfigBtn();
        WaitTool.waitForJQueryProcessing(driver, 20);

        WebElement widgetElement = home.getTextWidgetElementByTitle(title);
        WaitTool.waitForJQueryProcessing(driver, 5);

        //Elimino el widget
        EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);

        DeleteOverlay delete = editWidget.selectDeleteWidget(widgetElement);
        WaitTool.waitForJQueryProcessing(driver, 10);

        delete.selectCancelDelete();
        WaitTool.waitForJQueryProcessing(driver, 5);

        assertTrue(editWidget.isWidgetInListByTitle(title));

        home.selectSaveBtn();
        WaitTool.waitForJQueryProcessing(driver, 60);
	}

	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}
