package com.gointegro.Tests.Platform;

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
import com.gointegro.Pages.Workspace.JoinWorkSpace;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;



public class testNewWorkspace extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	
	@Test
	public void test_create_workspace_deactivated() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectDisabled();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_create_workspace_activated() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.isWorkspaceInList(title));
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_create_workspace_title_empty() {
		String title = "";
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);

		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Existen errores en el formulario", workspace.getSaveErrorMsg());
		assertEquals("Campo obligatorio", workspace.getTitleErrorMsg());
	}

	
	@Test
	public void test_create_workspace_description_empty() {
		String title = DataGenerator.nombreFile();
		String description = "";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Existen errores en el formulario", workspace.getSaveErrorMsg());
		assertEquals("Campo obligatorio", workspace.getDescriptionErrorMsg());
	}

	
	@Test
	public void test_create_workspace_private_without_basic_user() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectPrivate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		JoinWorkSpace joinWorkspace = home.selectJoinWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(joinWorkspace.isWorkspaceInList(title));
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertFalse(workList.isWorkspaceInList(title));
	}
	
	
	@Test
	public void test_create_workspace_private_with_basic_user() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String basicUser = ConfigElements.getNameOtherUser();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectPrivate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AddColaboratorsOverlay addColab = workspace.selectAddColabs();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.createFilterWithName("Juan Jose");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		addColab.selectColabInList(basicUser);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		addColab.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		JoinWorkSpace joinWorkspace = home.selectJoinWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(joinWorkspace.isWorkspaceInList(title));
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_create_workspace_public_dont_add_all() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectJoinAll();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.isWorkspaceInList(title));
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		JoinWorkSpace joinWorkspace = home.selectJoinWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(joinWorkspace.isWorkspaceInList(title));
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_create_workspace_mark_as_new() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectMarkAsNew();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(workList.isNewLabelPresent(title));
	}

	
	@Test
	public void test_create_workspace_with_url() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String url = "https://www.google.com.ar";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectExternalUrlBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createExternalUrl(url);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workList.selectWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		String parentHandle = driver.getWindowHandle();
		
		for(String winHandle : driver.getWindowHandles()) {
			if(winHandle != parentHandle) {
				driver.switchTo().window(winHandle);
			}
		}
		
		assertTrue(driver.getCurrentUrl().indexOf(url) != -1);
	}
	

	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
	
}
