package com.gointegro.Tests.Widgets;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.HomeWidgets;
import com.gointegro.Pages.Widgets.NewModuleOverlay;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewBenefitWidget extends AllTestsWidgets {
	
	String title = DataGenerator.nombreFile();
	
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
	public void test_new_benefit_category() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFirstCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Sleeper.sleepTightInSeconds(4);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isBenefitCategoryWidgetInList(title));
	}
	
	
	@Test
	public void test_new_benefit_category_title_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFirstCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_category_category_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Seleccione por lo menos una opción.", newModule.getBenefitCategoryErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_category_location_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFirstCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitLocations();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe ingresar una ubicación válida.", newModule.getLocationError());
	}
	
	
	@Test
	public void test_new_benefit_category_with_location() {
		String address = "Argentina";
		
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectFirstCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.addLocation(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isBenefitCategoryWidgetInList(title));
	}
	
	
	@Test
	public void test_new_benefit_special() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isBenefitSpecialWidgetInList(title));
	}
	
	
	@Test
	public void test_new_benefit_special_title_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_special_location_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitLocations();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe ingresar una ubicación válida.", newModule.getLocationError());
	}
	
	
	@Test
	public void test_new_benefit_special_with_location() {
		String address = "Argentina";
		
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.addLocation(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(home.isBenefitSpecialWidgetInList(title));
	}
	
	
	@Test
	public void test_new_benefit_highlighted() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitHighlighted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectDiscount();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Sleeper.sleepTightInSeconds(4);
		
		assertTrue(home.isBenefitHighlightedWidgetInList(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	
	@Test
	public void test_new_benefit_highlighted_title_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitHighlighted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectDiscount();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_new_benefit_highlighted_search() {
		String discount = "Sony";
		
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitHighlighted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.searchDiscount(discount);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Sleeper.sleepTightInSeconds(4);
		
		assertTrue(home.isBenefitHighlightedWidgetInList(title));
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	
	@Test
	public void test_new_benefit_ranking() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitRanking();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		HomeWidgets home = newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Sleeper.sleepTightInSeconds(4);
		
		home.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 60);
		
		assertTrue(home.isBenefitRankingWidgetInList(title));
	}
	
	
	@Test
	public void test_new_benefit_ranking_title_empty() {
		NewModuleOverlay newModule = selectBenefitWidget();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectBenefitRanking();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newModule.selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newModule.selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Este campo es obligatorio.", newModule.getTitleErrorMsg());
	}
	
	private NewModuleOverlay selectBenefitWidget() {
		login(driver);
		
		HomeWidgets home = PageFactory.initElements(driver, HomeWidgets.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		home.selectConfigBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewModuleOverlay newModule = home.addNewModule();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		newModule.selectBenefits();
		WaitTool.waitForJQueryProcessing(driver, 5);
			
		return newModule;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
