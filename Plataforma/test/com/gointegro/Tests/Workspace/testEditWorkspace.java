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
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.AddColaboratorsOverlay;
import com.gointegro.Pages.Workspace.AdminWorkspace;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditWorkspace extends AllTestsWorkspace {
	
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
	public void test_edit_workspace_change_to_deactivated() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, false, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 40);
		
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_edit_workspace_change_to_activated() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, false, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_edit_workspace_title_empty() {
		String title = DataGenerator.nombreFile();
		String title2 = "";
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title2, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals("Existen errores en el formulario", workspace.getSaveErrorMsg());
		assertEquals("Campo obligatorio", workspace.getTitleErrorMsg());
	}

	
	@Test
	public void test_edit_workspace_description_empty() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String description2 = "";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description2, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals("Existen errores en el formulario", workspace.getSaveErrorMsg());
		assertEquals("Campo obligatorio", workspace.getDescriptionErrorMsg());
	}

	
	@Test
	public void test_edit_workspace_change_to_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String user = ConfigElements.getNombreUsuario();
		String nameSplit[] = ConfigElements.getNombreUsuario().split("\\s");
		String surname = nameSplit[1];
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, true, "");
		
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
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_edit_workspace_change_to_public() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, true, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectJoinAll();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 40);
		
		assertTrue(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_edit_workspace_public_remove_add_all() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String user = ConfigElements.getNombreUsuario();
		String nameSplit[] = ConfigElements.getNombreUsuario().split("\\s");
		String surname = nameSplit[1];
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectJoinAll();
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
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_edit_workspace_remove_mark_as_new() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectMarkAsNew();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.isNewLabelPresent(title));
		
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectMarkAsNew();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(workList.isNewLabelPresent(title));
	}

	
	@Test
	public void test_edit_workspace_remove_url() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String url = "https://www.google.com";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, url);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.hasUrl(title));
		
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectCloseUrl();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(workList.hasUrl(title));
	}
	
	
	@Test
	public void test_edit_change_order() {
		String title = DataGenerator.nombreFile();
		String title2 = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title2, description, true, false, "");
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AdminWorkspace admin = home.selectAdminWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		int index = workList.getWorkspaceIndex(title2);
		
		admin.changeWorkspaceOrder(title, title2);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		admin.waitForSaveAlertPresent();
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		assertTrue(index > workList.getWorkspaceIndex(title2));
	}
	
	
	@Test
	public void test_edit_application_check_options_are_saved() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String url = "https://www.google.com";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, false, false, url);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectJoinAll();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		workList.selectEditWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(url, workspace.getExternalURL());
		assertFalse(workspace.isJoinAllSelected());
	}

	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
