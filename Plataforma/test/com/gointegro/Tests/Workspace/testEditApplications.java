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
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditApplications extends TestBase {
	
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWorkspace.getDriver();
	}

	
	@Test
	public void test_edit_application_title_empty () {
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
		
		appAdmin.editApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp("", description, true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Existen errores en el formulario", appInstall.getSaveErrorMsg());
		assertEquals("Ingrese el nombre de la aplicación", appInstall.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_edit_application_title() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		String appTitle2 = DataGenerator.nombreFile();
		
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
		
		appAdmin.editApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle2, description, true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle2));
	}
	
	
	@Test
	public void test_edit_application_change_order () {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		String appTitle2 = DataGenerator.nombreFile();
		
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
		
		workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle2, description, true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(appTitle, workList.getFirstAppName(title));
		
		appAdmin.changeAppOrder(appTitle, appTitle2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(appTitle2, workList.getFirstAppName(title));
	}
	
	
	@Test
	public void test_edit_application_change_to_deactivated_access_url() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectDisabled();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(appURL, driver.getCurrentUrl());
	}
	

	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
