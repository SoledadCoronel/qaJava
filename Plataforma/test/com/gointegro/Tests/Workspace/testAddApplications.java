package com.gointegro.Tests.Workspace;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testAddApplications extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWorkspace.getDriver();
	}

	
	@Test
	public void test_add_application_gallery() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("galleries"));
	}
	
	
	@Test
	public void test_add_application_title_empty() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = "";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingrese el nombre de la aplicación", appInstall.getTitleErrorMsg());
		assertEquals("Existen errores en el formulario", appInstall.getSaveErrorMsg());
	}
	
	
	@Test
	public void test_add_application_max_visible_apps() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		int visibleApps = 2;
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(visibleApps);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		for(int i=0; i< visibleApps; i++) {
			createApp(workList, title, DataGenerator.nombreFile());
			WaitTool.waitForJQueryProcessing(driver, 10);
		}
		
		assertTrue(workList.isMoreButtonPresent(title));
	}
	
	
	@Test
	public void test_add_application_title_exists() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationInstall appInstall = PageFactory.initElements(driver, AplicationInstall.class);
		
		assertEquals("Ya existe una aplicación con el nombre ingresado.", appInstall.getSaveErrorMsg());
	}
	
	
	@Test
	public void test_add_application_title_max_chars() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationInstall appInstall = PageFactory.initElements(driver, AplicationInstall.class);
		
		assertEquals("Ingrese un nombre que no supere los 80 caracteres", appInstall.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_add_application_content() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallContent();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("articles"));
	}
	
	
	@Test
	public void test_add_application_news() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallNews();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("news"));
	}
	
	
	@Test
	public void test_add_application_social() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallAppSocial();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("social"));
	}
	
	
	@Test
	public void test_add_application_tournaments() {
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
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallTournaments();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, false);
		WaitTool.waitForJQueryProcessing(driver, 40);
		
		assertTrue(driver.getCurrentUrl().contains("tournaments"));
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	
	@Test
	public void test_add_application_celebrations() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallCelebration();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.setAppName(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.celebrationComplete("", true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("celebrations"));
	}
	
	private void createApp(WorkspaceList workList, String title, String appTitle) {
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallAppSocial();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
