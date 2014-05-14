package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.EditEvent;
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
	public void test() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newCelebrationtitle = DataGenerator.nombreFile();
		
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
		
		//TODO
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
		//Logout logout = PageFactory.initElements(driver, Logout.class);
		//logout.open();
	}

}
