package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.DatePicker;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCelebration {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Test
	public void test_new_event() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		home.open();
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DatePicker datepicker = PageFactory.initElements(driver, DatePicker.class);
		datepicker.selectMonth(date);
		datepicker.selectDay(date);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_new_event_without_collaborator() {
		String collaborator = "";
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(date, celebrationlist.getTodayDate());
		
		home.open();
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DatePicker datepicker = PageFactory.initElements(driver, DatePicker.class);
		datepicker.selectMonth(date);
		datepicker.selectDay(date);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_new_event_without_title() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  "";
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		home.open();
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DatePicker datepicker = PageFactory.initElements(driver, DatePicker.class);
		datepicker.selectMonth(date);
		datepicker.selectDay(date);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_new_event_without_description() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = "";
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		home.open();
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DatePicker datepicker = PageFactory.initElements(driver, DatePicker.class);
		datepicker.selectMonth(date);
		datepicker.selectDay(date);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_new_event_undated() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha no puede estar vacía", newevent.getDateErrorMsj());
	}
	
	@Test
	public void test_new_event_empty() {
		String collaborator = "";
		String celebrationtitle =  "";
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = "";
		String date = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha no puede estar vacía", newevent.getDateErrorMsj());
		assertEquals("Ha ocurrido un error", newevent.getCollaboratorsError());
		assertEquals("No se pudo guardar la Celebración", newevent.getSaveError());
	}
	
	@Test
	public void test_new_event_title_more_than_80_characters() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  StringUtils.getTextoLargo();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No se pudo guardar la Celebración", newevent.getSaveError());
		assertEquals("El título supera el máximo de 80 caracteres", newevent.getTitleError());
	}
	
	@Test
	public void test_new_event_description_more_than_500_characters() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = StringUtils.getTextoLargo();
		String date = "26/12/2014";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La descripción no debería superar los 500 caracteres", newevent.getDescriptionError());
	}
	
	@Test
	public void test_new_event_uploadfile() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String fileupload = ConfigElements.getFileImagen();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newevent.fileUpload(fileupload);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		assertNotEquals("", celebrationlist.srcCelebImg());
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist.selectCelebImg();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertNotEquals("", celebrationlist.srcLightBoxImg());
	}

	private void createCategory(String categoryname, NewEvent newevent) {
		NewCategoryOverlay newcategory = newevent.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
