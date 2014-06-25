package com.gointegro.Tests.Profile;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.FileTab;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.FileDownloader;
import com.gointegro.Util.WaitTool;

public class testNewFile extends TestBase {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsProfile.getDriver();
	}
	
	
	@Test
	public void test_profile_upload_file() {
		String file = ConfigElements.getFileImagen();
		String date = DataGenerator.fechaactual();
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
		
		assertTrue(fileTab.isFileInList(name, date));
	}
	
	
	@Test
	public void test_profile_upload_file_check_user_link() {
		String file = ConfigElements.getFileImagen();
		String title = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
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
		
		assertTrue(fileTab.isFileInList(name, date));
		
		fileTab.selectPlaceLink(name);
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertTrue(driver.getCurrentUrl().contains(profile.getProfileURL()));
	}
	
	
	@Test
	public void test_profile_download_file() {
		String file = ConfigElements.getFileImagen();
		String title = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		String[] fileName = file.split("/");
		String name = fileName[fileName.length-1];
		FileDownloader downloadTestFile = new FileDownloader(driver);
		String downloadedFileAbsoluteLocation = null;
		
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
		
		assertTrue(fileTab.isFileInList(name, date));
		
		try {
			downloadedFileAbsoluteLocation = downloadTestFile.downloadFile(fileTab.getFileLink(name));
		} catch (Exception e) {
			
		}
		
		assertEquals(true, new File(downloadedFileAbsoluteLocation).exists());
		assertEquals(200, downloadTestFile.getHTTPStatusOfLastDownloadAttempt());
	}
	
	
	@Test
	public void test_profile_paging() {
		login(driver);
		
		FileTab fileTab = PageFactory.initElements(driver, FileTab.class);
		fileTab.open();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		fileTab.waitForFileListToLoad();
		
		fileTab.selectPaginate();
		WaitTool.waitForJQueryProcessing(driver, 30);
		
		fileTab.waitForFileListToLoad();
		
		assertTrue(fileTab.isSecondPageActive());
	}
	
	@Test
	public void test_profile_upload_file_check_social_wall() {
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
		
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(social.isFileInList(name));
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}