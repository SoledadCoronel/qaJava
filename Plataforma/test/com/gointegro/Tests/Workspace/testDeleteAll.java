package com.gointegro.Tests.Workspace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.AdminWorkspace;
import com.gointegro.Pages.Workspace.DeleteOverlay;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;

public class testDeleteAll extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsWorkspace.getDriver();
	}
	
	
	@Test
	public void test_delete_all_workspaces() {
		login(driver);
		
		AdminWorkspace admin = PageFactory.initElements(driver, AdminWorkspace.class);
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		int count = 0;
		int listSize = admin.getWorkSpaceCount();
		
		do {
			DeleteOverlay delete = admin.deleteFirst();
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			delete.selectConfirmDelete();
			WaitTool.waitForJQueryProcessing(driver, 10);
			
			count++;
			
			driver.get(admin.getAdminURL());
			WaitTool.waitForJQueryProcessing(driver, 20);
		} while (count < listSize);
	}

	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}