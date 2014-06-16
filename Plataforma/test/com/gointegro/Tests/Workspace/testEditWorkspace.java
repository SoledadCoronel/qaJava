package com.gointegro.Tests.Workspace;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.AddColaboratorsOverlay;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditWorkspace extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	
	@Test
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

	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
