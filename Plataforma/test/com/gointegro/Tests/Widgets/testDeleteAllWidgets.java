package com.gointegro.Tests.Widgets;

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
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;

public class testDeleteAllWidgets extends TestBase {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsWidgets.getDriver();
	}
	
	@Test
	public void test_delete_all_widgets() {
		login(driver);
		
	    HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
	    home.open();
	    WaitTool.waitForJQueryProcessing(driver, 5);
	
	    home.selectConfigBtn();
	    WaitTool.waitForJQueryProcessing(driver, 10);
	    
	    int count = 1;
	    do {
	    	WebElement widgetElement = home.getFirstWidgetElement();
		    WaitTool.waitForJQueryProcessing(driver, 5);
		
		    EditWidgets editWidget = PageFactory.initElements(driver, EditWidgets.class);
		
		    DeleteOverlay deteleOverlay = editWidget.selectDeleteWidget(widgetElement);
		    WaitTool.waitForJQueryProcessing(driver, 10);
		
		    deteleOverlay.selectConfirmDeleteAll(count);
		    WaitTool.waitForJQueryProcessing(driver, 5);
		    
		    count++;
	    } while(home.listCount() > 0);
	    
	    home.selectSaveBtn();
	    WaitTool.waitForJQueryProcessing(driver, 60);   
	}
	

	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
