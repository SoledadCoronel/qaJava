package com.gointegro.Tests.Content;

import static org.junit.Assert.*;

import java.util.List;

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
import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Pages.Content.ContentList;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Content.NewCategoryOvelayContent;
import com.gointegro.Pages.Content.NewContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteContent extends TestBase{
	
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
		driver = AllTestsContent.getDriver();
	}
	
	
	@Test
	public void delete_content_with_no_category() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent = home.deleteContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = PageFactory.initElements(driver, DeleteOverlay.class);
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		
		assertNotEquals(titleText, home.getTitle());
		assertNotEquals(descriptionText, home.getDescription());
		assertNotEquals(titleText, contentList.getTitle());
	}
	

	@Test
	public void delete_content_with_category() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(titleText, newContent);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.setCategory(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent = home.deleteContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = PageFactory.initElements(driver, DeleteOverlay.class);
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		List<WebElement> allContentList = contentList.getContentList(); 
		
		assertNotEquals(titleText, home.getTitle());
		assertFalse(contentList.isContentOnList(allContentList, titleText));
	}
	
	
	@Test
	public void delete_content_press_cancel() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent = home.deleteContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = PageFactory.initElements(driver, DeleteOverlay.class);
		delete.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		
		assertEquals(titleText, home.getTitle());
		assertEquals(descriptionText, home.getDescription());
		assertEquals(titleText, contentList.getTitle());
	}
	
	
	@Test
	public void delete_content_and_acces_by_url() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo() + DataGenerator.horaactual();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String contentUrl = home.getURL();
		
		newContent = home.deleteContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = PageFactory.initElements(driver, DeleteOverlay.class);
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.get(contentUrl);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(driver.getCurrentUrl(), ConfigElements.getURL()+"/error404");
	}
	
	
	private void createCategory(String categoryname, NewContent newContent) {
		NewCategoryOvelayContent newcategory = newContent.selectNewCategory();
		
		newcategory.createCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
