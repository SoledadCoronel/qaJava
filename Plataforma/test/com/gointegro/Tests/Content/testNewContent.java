package com.gointegro.Tests.Content;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Content.ContentList;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Content.NewCategoryOvelayContent;
import com.gointegro.Pages.Content.NewContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewContent extends TestBase{
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsContent.getDriver();
	}
	
	@Ignore
	@Test
	public void test_new_content_without_category(){
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		
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
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		
		assertEquals(titleText, home.getTitle());
		assertEquals(descriptionText, home.getDescription());
		assertEquals(titleText, contentList.getTitle());
	}
	
	@Ignore
	@Test
	public void test_new_content_with_category(){
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String categoryName = DataGenerator.nombreFile();
		
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
		
		createCategory(categoryName, newContent);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		
		assertEquals(titleText, home.getTitle());
		assertEquals(descriptionText, home.getDescription());
		assertEquals(titleText, contentList.getTitle());
	}
	
	@Ignore
	@Test
	public void test_title_max_characters() {
		String titleText = StringUtils.getTextoLargo();
		String descriptionText = StringUtils.getTextoLargo();
		
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
		
		assertTrue(newContent.isTitleErrorPresent());
	}
	
	@Test
	public void test_create_content_with_basic_user() {
		
		loginBasicUser(driver);
		
		NewContent home = PageFactory.initElements(driver, NewContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertNotEquals(driver.getCurrentUrl(), home.getURL());
	}
	
	@Ignore
	@Test
	public void test_empty_title_and_description() {
		String titleText = "";
		String descriptionText = "";
		
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
		
		assertTrue(newContent.isTitleErrorPresent());
		assertTrue(newContent.isDescriptionErrorPresent());
	}
	
	@Ignore
	@Test
	public void test_special_chars() {
		String titleText = StringUtils.getCaracteresEspeciales();
		String descriptionText = StringUtils.getTextoLargo();
		
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
		
		assertEquals(titleText, home.getTitle());
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
