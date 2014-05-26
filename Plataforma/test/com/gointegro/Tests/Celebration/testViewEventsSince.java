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
import com.gointegro.Pages.Celebration.DatePicker;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.AplicationEdit;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.WaitTool;

public class testViewEventsSince {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Ignore
	public void test_event_since_days_in() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = DateTool.getYesterday();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationEdit appedit = home.selectAdminApp();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appedit.celebrationComplete("15", false);
		appedit.saveEdit();
		
		home.open();
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
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
	
	@Ignore
	public void test_event_since_days_out() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = DateTool.getYesterday();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationEdit appedit = home.selectAdminApp();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appedit.celebrationComplete("1", false);
		appedit.saveEdit();
		
		home.open();
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		celebrationlist.getEmptyEvent();
	}
	
	@Test
	public void test_event_out_month_actual() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = DateTool.setPreviousMonth();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationEdit appedit = home.selectAdminApp();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appedit.celebrationComplete("", true);
		appedit.saveEdit();
		
		home.open();
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		celebrationlist.getEmptyEvent();
	}
	
	@Test
	public void test_event_in_month_past() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = DateTool.setPreviousMonth();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationEdit appedit = home.selectAdminApp();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appedit.celebrationComplete("", false);
		appedit.saveEdit();
		
		home.open();
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
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
	}
	
	@Test
	public void test_event_out_month_past() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = DateTool.setLastMonth();
		String fileupload = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationEdit appedit = home.selectAdminApp();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appedit.celebrationComplete("", false);
		appedit.saveEdit();
		
		home.open();
		
		home = createEvent(collaborator, celebrationtitle, categoryname, descriptiontext, date, home, fileupload);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		celebrationlist.getEmptyEvent();
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
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
