package com.gointegro.Tests.News;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.News.CreateNews;
import com.gointegro.Pages.News.DetailNews;
import com.gointegro.Pages.News.FilterNews;
import com.gointegro.Pages.News.HomeNews;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testFilterNews extends TestBase {
	
private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsNews.getDriver();
	}
	

	@Test
	public void test_filter_semana_pasada() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
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
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		FilterNews filter = PageFactory.initElements(driver, FilterNews.class);
		filter.selectLastWeek();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertTrue(newsElement == null);
	}
	
	
	@Test
	public void test_filter_month() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String month = DateTool.getMonthText(date);
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
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
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		FilterNews filter = PageFactory.initElements(driver, FilterNews.class);
		
		assertTrue(filter.isMonthOnList(month));
		
		filter.selectMonth(month);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(titleText, home.getTitleNews(newsElement));
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
