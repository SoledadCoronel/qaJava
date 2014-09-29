package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.EditEvent;
import com.gointegro.Pages.Celebration.EventCollaboratorOverlay;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditCelebration extends AllTestsCelebration {
	
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

	@Test(groups = {"FunctTest"})
	public void test_edit_event_verify_data() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		
		assertEquals(collaborator, editevent.getCollaboratorsContainer());
		assertEquals(celebrationtitle, editevent.getEventTitle());
		assertEquals(categoryname, editevent.getCategory());
		assertEquals(descriptiontext, editevent.getEventDescription());
		assertEquals(date, editevent.getEventeDate());
	}
	
	@Test
	public void test_edit_event_add_collaborator() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newcollaborator = ConfigElements.getNameOtherUser();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, newcollaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator+" y otra persona más", celebrationlist.getCollaboratonName()); //Falla siempre hasta que javier arregle JS unified
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		EventCollaboratorOverlay eventcolaboverlay = celebrationlist.selectCollaboratosList();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(eventcolaboverlay.getCollaborators().contains(newcollaborator) && eventcolaboverlay.getCollaborators().contains(collaborator));
	}
	
	@Test
	public void test_edit_event_modify_collaborator() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newcollaborator = ConfigElements.getNameOtherUser();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.cleanCollaborators();
		editevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, newcollaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(newcollaborator, celebrationlist.getCollaboratonName());
		assertEquals(newcollaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_modify_title() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newtitle = DataGenerator.nombreFile();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, newtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(newtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_modify_description() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newdescription = DataGenerator.nombreFile();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, celebrationtitle, newdescription, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(newdescription, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_modify_category() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newcategoryname = DataGenerator.nombreFile();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(newcategoryname,false);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(newcategoryname, date, celebrationtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(newcategoryname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newcategoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
	}
	
	@Test
	public void test_edit_event_modify_date() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newdate = "27/12/2014";
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, newdate, celebrationtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(newdate, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_delete_picture() {
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
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.deleteUploadFile();
		editevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		assertFalse(celebrationlist.isElementPresent());
		
	}
	
	@Test
	public void test_edit_event_add_picture() {
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
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.uploadNewFile(fileupload);
		editevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		assertNotEquals("", celebrationlist.srcCelebImg());
	}
	
	@Test
	public void test_edit_event_delete_title() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newtitle = "";
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, newtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_title_more_than_80_characters() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newtitle = StringUtils.getTextoLargo();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, newtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No se pudo guardar la Celebración", editevent.getSaveError());
		assertEquals("El título supera el máximo de 80 caracteres", editevent.getTitleError());
	}
	
	@Test
	public void test_edit_event_delete_description() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newdescription = "";
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, celebrationtitle, newdescription, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	@Test
	public void test_edit_event_title_more_than_500_characters() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newdescription = StringUtils.getTextoLargo();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, date, celebrationtitle, newdescription, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La descripción no debería superar los 500 caracteres", editevent.getDescriptionError());
	}
	
	@Test
	public void test_edit_event_empty_date() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newdate = "";
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editevent.completeCelebration(categoryname, newdate, celebrationtitle, descriptiontext, "");
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha no puede estar vacía", editevent.getDateErrorMsj());
	}
	
	@Test(groups = {"FunctTest"})
	public void test_edit_event_cancel() {
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
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		editevent.deleteUploadFile();
		home = editevent.cancelCreation();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		assertTrue(celebrationlist.isElementPresent());
	}
	
	private HomeCelebrations createEvent(String collaborator, String celebrationtitle, String categoryname, String descriptiontext, String date, HomeCelebrations home, String fileupload) {
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		if (!fileupload.isEmpty())
			newevent.fileUpload(fileupload);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return home;
	}
	
	private void createCategory(String categoryname, NewEvent newevent) {
		NewCategoryOverlay newcategory = newevent.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
