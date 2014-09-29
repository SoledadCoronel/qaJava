package com.gointegro.Tests.Celebration;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Backoffice_User.CreateUser;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testCelebrationWorkspaces extends AllTestsCelebration {

	private WebDriver driver;
	String name = DataGenerator.nombreFile();
	String birthdate = getTomorrowDayMonth();
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(groups = {"FunctTest"})
	public void test_public_autojoin_workspace_celebration() {
		String workspaceTitle = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String categoryname = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(workspaceTitle);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AplicationAdd addApp = workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationInstall install = addApp.selectInstallCelebration();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		install.completeInstallApp(workspaceTitle, "asd", true, false, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		HomeCelebrations homeCeleb = PageFactory.initElements(driver, HomeCelebrations.class);
		NewCategoryOverlay newcat = homeCeleb.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newcat.createCategory(categoryname, true);
		Sleeper.sleepTightInSeconds(180);
		
		String appURL = driver.getCurrentUrl();
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createUser();
		
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login(driver);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = homeCeleb.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(celebrationlist.isCollaboratorInList(name));
	}
	
	private void createUser() {
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		String surname = DataGenerator.nombreFile();
		boolean regStatus = true;
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, "", document, birthdate, "", "", "", "", regStatus, "", "", "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	private String getTomorrowDayMonth() {
		String date = DataGenerator.fechamanana();
		String parts[] = date.split("/");
		String dayMonth = parts[0]+"/"+parts[1];
		
		return dayMonth+"/1980";
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}
