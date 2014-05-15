package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
import com.gointegro.Util.WaitTool;

public class testEditCelebration {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Test
	public void test_edit_event_verify_data() {
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
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
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
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
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
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
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
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
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
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
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
	
	@Ignore
	public void test_edit_event_modify_category() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newcategory = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewEvent newevent = home.selectNewEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(newcategory, newevent);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditEvent editevent = celebrationlist.selectEditEvent();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		editevent.cleanCollaborators();
		editevent.completeCelebration(newcategory, date, celebrationtitle, descriptiontext, collaborator);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist = home.selectCategoryInSideBar(newcategory);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(newcategory, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
	}
	
	private HomeCelebrations createEvent(String collaborator, String celebrationtitle, String categoryname, String descriptiontext, String date, HomeCelebrations home) {
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, newevent);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return home;
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
