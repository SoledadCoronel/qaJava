package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.DeleteOverlay;
import com.gointegro.Pages.Galery.EditAlbum;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.ImageDetail;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.FileDownloader;
import com.gointegro.Util.WaitTool;

public class testDeleteImage extends TestBase{
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}
	
	@Test
	public void test_delete_img_detail() {
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
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_detail_cancel() {
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
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_detail_2_pictures() {
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
		

		
		String urlalbum = detail.getURL();
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.get(urlalbum);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_access_url() {
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
			downloadedFileAbsoluteLocation = img.getSrcImg();
		} catch (Exception e) {
			
		}
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		WebDriver _driver = new FirefoxDriver();
		
		login(_driver);

		_driver.get(downloadedFileAbsoluteLocation);
		
		assertNotEquals(200, downloadTestFile.getHTTPStatusOfLastDownloadAttempt());
		
		_driver.close();
	}
	
	@Test
	public void test_delete_img_edit_album() {
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
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_cancel() {
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
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_cancel_overlay() {
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
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_2_pictures() {
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
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
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
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
