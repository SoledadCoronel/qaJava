package com.gointegro.Tests.News;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.News.CreateNews;
import com.gointegro.Pages.News.DetailNews;
import com.gointegro.Pages.News.HomeNews;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditNews extends TestBase {
	
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsNews.getDriver();
	}

	
	@Test
	public void test_edit_news_title_with_text() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
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
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText2, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText2);
		
		assertEquals(titleText2, home.getTitleNews(newsElement));
		assertTrue(descriptionText.contains(home.getShortDescription(newsElement)));
		assertEquals(DateTool.getDateAsText(date).toLowerCase(), home.getDate(newsElement));
		assertEquals(hour + " hs", home.getHour(newsElement));
	}
	
	
	@Test
	public void test_edit_news_title_with_text_from_home() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
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
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText1);
		
		//Edito la novedad
		home.editNews(newsElement);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText2, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement2 = home.getNewsElement(titleText2);
		
		assertEquals(titleText2, home.getTitleNews(newsElement2));
		assertTrue(descriptionText.contains(home.getShortDescription(newsElement2)));
		assertEquals(DateTool.getDateAsText(date).toLowerCase(), home.getDate(newsElement2));
		assertEquals(hour + " hs", home.getHour(newsElement2));
	}
	
	
	@Test
	public void test_edit_news_title_empty() {
		String titleText1 = DataGenerator.nombreFile();
		String titleText2 = "";
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText1, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createTitle(titleText2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título no puede estar vacío.", createNews.getTitleError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	
	@Test
	public void test_edit_news_description_with_text() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText1, detail.getDescription());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(descriptionText2, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(descriptionText2, home.getDescription(newsElement));
	}
	
	
	@Test
	public void test_edit_news_description_empty() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText1 = StringUtils.getTextoLargo();
		String descriptionText2 = "";
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText1, detail.getDescription());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createDescription(descriptionText2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El detalle no puede estar vacío.", createNews.getDescriptionError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_edit_news_date_empty() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String date2 = "";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectDate(date2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("La fecha de publicación es obligatoria.", createNews.getDateError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_edit_news_change_date() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String date2 = DataGenerator.fechamanana();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectDate(date2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(DateTool.getDateAsText(date2).toLowerCase(), home.getDate(newsElement));
	}
	
	
	@Test
	public void test_edit_news_change_hour() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "15:00";
		String hour2 = "16:48";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
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
		
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createHour(hour2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(hour2 + " hs", home.getHour(newsElement));
	}
	
	
	@Test
	public void test_edit_news_hour_empty() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "15:00";
		String hour2 = "";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
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
		
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.createHour(hour2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		//verifico que los 2 primeros caracteres sean numeros
		assertTrue(home.getHour(newsElement).substring(0, 1).matches("\\d+"));
	}
	
	
	@Test
	public void test_edit_news_uncheck_social() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "15:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
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
		
		Comment comment = PageFactory.initElements(driver, Comment.class);
		
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		assertTrue(comment.isCommentBoxPresent());
		
		//Edito la novedad
		detail.editNews();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(comment.isCommentBoxPresent());
	}
	
	
	@Test
	public void test_edit_news_change_image() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String imageFile1 = ConfigElements.getFileImagen();
		String imageFile2 = ConfigElements.getFileImagenChange();
		String date = DataGenerator.fechaactual();
		String hour = "15:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.fileUpload(imageFile1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement newsElement = home.getNewsElement(titleText);
		String imageSrc1 = home.getImageSource(newsElement);
		
		//Edito la novedad
		home.editNews(newsElement);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.fileUpload(imageFile2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement2 = home.getNewsElement(titleText);
		assertNotEquals(imageSrc1, home.getImageSource(newsElement2));
	}
	
	
	@Test
	public void test_edit_news_remove_image() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String imageFile1 = ConfigElements.getFileImagen();
		String date = DataGenerator.fechaactual();
		String hour = "15:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//Creo la novedad
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.fileUpload(imageFile1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		//Edito la novedad
		home.editNews(newsElement);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createNews.removeFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement2 = home.getNewsElement(titleText);
		assertFalse(home.isImagePresent(newsElement2));
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
	
	
}
