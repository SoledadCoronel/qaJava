package com.gointegro.Tests.Content;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Content.ContentList;
import com.gointegro.Pages.Content.HomeContent;
import com.gointegro.Pages.Content.NewContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditContent extends TestBase{
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsContent.getDriver();
	}
	
	
	@Test
	public void test_change_content_order_from_second_to_first() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el primer contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el segundo contenido y lo ordeno abajo del primero
		newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.setContentBellowOf(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el segundo contenido y lo ordeno en primero
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.setContentBellowOf("Primero");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ContentList contentList = PageFactory.initElements(driver, ContentList.class);
		List<WebElement> allContentList = contentList.getContentList(); 
		
		int location = contentList.findInList(allContentList, titleText2);
		
		assertTrue(allContentList.get(location).getText().equals(titleText2));
		assertTrue(allContentList.get(location+1).getText().equals(titleText1));
	}
	
	
	@Test
	public void test_edit_title_with_text() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText2, home.getTitle());
	}
	
	
	@Test
	public void test_edit_title_empty() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = "";
		String descriptionText = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newContent.isTitleErrorPresent());
	}
	
	
	@Test
	public void test_edit_title_special_chars() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = StringUtils.getCaracteresEspeciales();
		String descriptionText = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText2, home.getTitle());
	}
	
	
	@Test
	public void test_edit_title_max_characters() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = StringUtils.getTextoLargo();
		String descriptionText = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newContent.isTitleErrorPresent());
	}
	
	
	@Test
	public void test_edit_description_with_text() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(descriptionText2, home.getDescription());
	}
	
	
	@Test
	public void test_edit_description_empty() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = "";
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newContent.isDescriptionErrorPresent());
	}
	
	
	@Test
	public void test_edit_description_and_Title_and_press_cancel() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = StringUtils.getCaracteresEspeciales();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectCancelBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, home.getTitle());
		assertEquals(descriptionText1, home.getDescription());
	}
	
	
	@Test
	public void test_edit_description_special_chars() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Edito el contenido
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
				
		assertEquals(descriptionText2, home.getDescription());
	}
	
	@Test
	public void test_edit_check_data() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeContent home = PageFactory.initElements(driver, HomeContent.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo el contenido
		NewContent newContent = home.selectNewContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newContent.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newContent = home.editContent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, newContent.getTitleText());
		assertEquals(descriptionText1, newContent.getDescription());
	}
	
		
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}