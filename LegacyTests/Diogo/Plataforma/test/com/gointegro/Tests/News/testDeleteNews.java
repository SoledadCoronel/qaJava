package com.gointegro.Tests.News;

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

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Pages.News.CreateNews;
import com.gointegro.Pages.News.DetailNews;
import com.gointegro.Pages.News.HomeNews;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteNews extends AllTestsNews {
	
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
	public void test_delete_news_home() {
		String titleText1 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText1);
		
		DeleteOverlay deleteOverlay = home.deleteNews(newsElement);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		deleteOverlay.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(home.getNewsElement(titleText1) == null);
	}
	
	
	@Test
	public void test_delete_news_detail() {
		String titleText1 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		DeleteOverlay deleteOverlay = detail.deleteNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		deleteOverlay.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(home.getNewsElement(titleText1) == null);
	}
	
	
	@Test
	public void test_delete_news_press_cancel() {
		String titleText1 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		DeleteOverlay deleteOverlay = detail.deleteNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		deleteOverlay.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
	}
	
	
	@Test
	public void test_delete_news_access_url() {
		String titleText1 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		String newsURL = home.getURL();
		
		DeleteOverlay deleteOverlay = detail.deleteNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		deleteOverlay.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.get(newsURL);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(driver.getCurrentUrl(), ConfigElements.getURL()+"/error404");
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
