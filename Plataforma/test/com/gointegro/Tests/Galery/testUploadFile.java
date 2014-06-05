package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.DeleteAlbumOverlay;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.ImageDetail;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testUploadFile extends TestBase{
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}
	
	@Test
	public void test_upload_file_select_album() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
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
		upload.selectSave();
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.isPictureInAlbum());
	}
	
	@Test
	public void test_upload_file_no_select_album() {
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.selectSave();
		
		assertEquals("Debe seleccionar un álbum", upload.getErrorMsjAlbum());
	}
	
	@Test
	public void test_upload_file_invalid() {
		String testfile = ConfigElements.getFileNoImage();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		assertTrue(upload.getUploadErrorMsj().contains("Este archivo no es de un tipo válido de imagen"));
	}
	
	@Test
	public void test_upload_file_delete() {
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		DeleteAlbumOverlay delete = upload.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		//No le encuentro la vuelta falla siempre, me quemo la cabeza
		assertFalse(upload.isUploadedContentPresent());
	}
	
	@Test
	public void test_upload_file_title() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		String filetitle = DataGenerator.nombreFile();
		
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
		upload.setFileTitle(filetitle);
		upload.selectSave();
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(filetitle, img.getImageTitle());
	}
	
	@Test
	public void test_upload_file_cancel() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
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
		upload.selectCancel();
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	@Test
	public void test_upload_file_2_pictures() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
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
		upload.setOtherFile(testfile);
		
		upload.selectSave();
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(2, detail.albumsize());
	}
	
	@Test
	public void test_upload_file_second_picture_invalid() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		String testfile2 = ConfigElements.getFileNoImage();
		
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
		upload.setOtherFile(testfile2);
		
		assertTrue(upload.getUploadErrorMsj().contains("Este archivo no es de un tipo válido de imagen"));
		
		upload.selectCancel();
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
