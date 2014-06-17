package com.gointegro.Tests.Workspace;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.AdminWorkspace;
import com.gointegro.Pages.Workspace.DeleteOverlay;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteWorkspace extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWorkspace.getDriver();
	}

	
	@Test
	public void test_delete_workspace_from_home() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		DeleteOverlay delete = workList.selectDeleteWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_delete_workspace_from_admin() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
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
		
		AdminWorkspace admin = home.selectAdminWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = admin.selectDeleteWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertFalse(admin.isWorkspaceInList(title));
		assertFalse(workList.isWorkspaceInList(title));
	}

	
	@Test
	public void test_delete_workspace_press_cancel() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
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
		
		AdminWorkspace admin = home.selectAdminWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = admin.selectDeleteWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		delete.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
	
		assertTrue(admin.isWorkspaceInList(title));
		assertTrue(workList.isWorkspaceInList(title));
	}
	
	
	@Test
	public void test_delete_workspace_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, true, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AdminWorkspace admin = home.selectAdminWorkspace();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = admin.selectDeleteWorkspace(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertFalse(admin.isWorkspaceInList(title));
		assertFalse(workList.isWorkspaceInList(title));
	}

	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}


}
