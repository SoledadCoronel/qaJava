package com.gointegro.Tests.Workspace;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.ApplicationAdmin;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.DeleteOverlay;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteApplications extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWorkspace.getDriver();
	}
	
	@Test
	public void test_delete_application() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DeleteOverlay delete = appAdmin.deleteApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		delete.selectConfirmDeleteApps();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertFalse(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	
	@Test
	public void test_delete_press_cancel() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DeleteOverlay delete = appAdmin.deleteApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		delete.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
