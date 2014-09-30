package com.gointegro.Tests.Workspace;

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
import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.ApplicationAdmin;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.AddColaboratorsOverlay;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditApplications extends AllTestsWorkspace {
	
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
	
	
	@Test
	public void test_edit_application_benefit_map_change_to_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		String user = ConfigElements.getNombreUsuario();
		String nameSplit[] = ConfigElements.getNombreUsuario().split("\\s");
		String surname = nameSplit[1];
		
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
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsCategoryMap();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, description, true, false, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectPrivate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AddColaboratorsOverlay addColab = workspace.selectAddColabs();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.createFilterWithName(surname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.selectColabInList(user);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		addColab.selectSaveBtn();
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
	
	
	@Test
	public void test_edit_application_benefit_filter_change_to_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		String user = ConfigElements.getNombreUsuario();
		String nameSplit[] = ConfigElements.getNombreUsuario().split("\\s");
		String surname = nameSplit[1];
		
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
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsFilter();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallBenefitFilter(appTitle, description, true, false, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectPrivate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AddColaboratorsOverlay addColab = workspace.selectAddColabs();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.createFilterWithName(surname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.selectColabInList(user);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		addColab.selectSaveBtn();
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

	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
