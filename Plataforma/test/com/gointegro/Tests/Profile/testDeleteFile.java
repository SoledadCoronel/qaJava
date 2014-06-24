package com.gointegro.Tests.Profile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.DeleteOverlay;
import com.gointegro.Pages.Profile.FileTab;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testDeleteFile extends TestBase {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsProfile.getDriver();
	}

	@Test
	public void test_delete_file() {
		String file = ConfigElements.getFileImagen();
		String title = DataGenerator.nombreFile();
		String[] fileName = file.split("/");
		String name = fileName[fileName.length-1];
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		PostForm postForm = PageFactory.initElements(driver, PostForm.class);
		postForm.completePostFileImagen(title, file);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		FileTab fileTab = PageFactory.initElements(driver, FileTab.class);
		fileTab.open();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		fileTab.waitForFileListToLoad();
		
		fileTab.createFilter(name);
		fileTab.waitForFileListToLoad();
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.orderByDateFiles();
		
		DeleteOverlay delete = fileTab.deleteFile(name);
		delete.selectConfirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		fileTab.waitForFileListToLoad();
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WallFeeds wall = PageFactory.initElements(driver, WallFeeds.class);
		
		assertNotEquals(title, wall.getFeedContent());
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
