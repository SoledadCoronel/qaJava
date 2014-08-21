package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import java.io.File;

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
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.ImageDetail;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.FileDownloader;
import com.gointegro.Util.WaitTool;

public class testImageDetail extends AllTestsGalery {
	
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
	public void test_img_detail_view() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(img.getSrcImg().isEmpty());
	}
	
	@Test
	public void test_img_detail_download() {
		FileDownloader downloadTestFile = new FileDownloader(driver);
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		String downloadedFileAbsoluteLocation = null;
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		try {
			downloadedFileAbsoluteLocation = downloadTestFile.downloadFile(img.downloadLink());
		} catch (Exception e) {
			
		}
		
		assertEquals(true, new File(downloadedFileAbsoluteLocation).exists());
		
		assertEquals(200, downloadTestFile.getHTTPStatusOfLastDownloadAttempt());
	}
	
	@Test
	public void test_img_detail_next_picture() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String pic1 = img.getSrcImg();
		img.selectNextPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		String pic2 = img.getSrcImg();
		
		assertNotEquals(pic1, pic2);
	}
	
	@Test
	public void test_img_detail_previous_picture() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String pic1 = img.getSrcImg();
		img.selectPreviousPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		String pic2 = img.getSrcImg();
		
		assertNotEquals(pic1, pic2);
	}
	
	@Test
	public void test_img_detail_basic_user() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		loginBasicUser(driver);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(img.getSrcImg().isEmpty());
		
		assertFalse(img.getActionsSource().contains("modal-delete-button"));
	}
	
	@Test
	public void test_img_detail_basic_user_download() {
		FileDownloader downloadTestFile = new FileDownloader(driver);
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		String downloadedFileAbsoluteLocation = null;
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		loginBasicUser(driver);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		try {
			downloadedFileAbsoluteLocation = downloadTestFile.downloadFile(img.downloadLink());
		} catch (Exception e) {
			
		}
		
		assertEquals(true, new File(downloadedFileAbsoluteLocation).exists());
		
		assertEquals(200, downloadTestFile.getHTTPStatusOfLastDownloadAttempt());
	}
	
	@Test
	public void test_img_detail_basic_user_next_picture() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		loginBasicUser(driver);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String pic1 = img.getSrcImg();
		img.selectNextPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		String pic2 = img.getSrcImg();
		
		assertNotEquals(pic1, pic2);
	}
	
	@Test
	public void test_img_detail_basic_user_previous_picture() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		loginBasicUser(driver);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String pic1 = img.getSrcImg();
		img.selectPreviousPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		String pic2 = img.getSrcImg();
		
		assertNotEquals(pic1, pic2);
	}
	
	@Test
	public void test_video_detail_copy_link() {
		String albumname = DataGenerator.nombreFile();
		String filename = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileMP4Video();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.selectAlbumInList(albumname);
		upload.setFileTitle(filename);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail video = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(filename, detail.getImageTitle());
		
		video.selectCopyLink();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String videoURL = video.copyLink();
		driver.get(videoURL);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_video_detail_next_video() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileMP4Video();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail video = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		video.selectCopyLink();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String vid1 = video.copyLink();
		video.selectNextPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);

		video.selectCopyLink();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String vid2 = video.copyLink();
		
		assertNotEquals(vid1, vid2);
	}
	
	@Test
	public void test_video_detail_previous_video() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileMP4Video();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail video = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		video.selectCopyLink();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String vid1 = video.copyLink();
		video.selectNextPicture();
		WaitTool.waitForJQueryProcessing(driver, 5);

		video.selectCopyLink();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String vid2 = video.copyLink();
		
		assertNotEquals(vid1, vid2);
	}
	
	private void createAddFile(String testfile, String albumname, HomeGalery home, boolean otherfile) {
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.selectAlbumInList(albumname);
		if (otherfile)
			upload.setOtherFile(testfile);
		upload.selectSave();
	}
	
	private void createAlbum(String albumname, HomeGalery home) {
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
