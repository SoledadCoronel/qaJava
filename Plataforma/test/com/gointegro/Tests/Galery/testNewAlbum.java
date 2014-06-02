package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Galery.AdminAlbum;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewAlbum extends TestBase{
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}

	@Test
	public void test_new_album_home_galery() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_home_empty() {
		String albumname = "";
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título del álbum es requerido", albumover.getErrorMsj());
	}
	
	@Test
	public void test_new_album_home_max_characters() {
		String albumname = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título supera el máximo de 80 caracteres", albumover.getErrorMsj());
	}
	
	@Test
	public void test_new_album_home_repeted() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del album ya existe", albumover.getErrorMsj());
	}
	
	@Test
	public void test_new_album_home_special_char() {
		String albumname = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_home_cancel() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.cancelCreateAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_admin() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admin.isAlbumInList(albumname));
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_admin_empty() {
		String albumname = "";
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título del álbum es requerido", admin.getFieldErrorMsj());
		assertEquals("Ocurrió un error al crear el álbum", admin.getErrorMsj());
	}
	
	@Test
	public void test_new_album_admin_max_char() {
		String albumname = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título supera el máximo de 80 caracteres", admin.getFieldErrorMsj());
		assertEquals("Ocurrió un error al crear el álbum", admin.getErrorMsj());
	}
	
	@Test
	public void test_new_album_admin_exist() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del album ya existe", admin.getErrorMsj());
	}
	
	@Test
	public void test_new_album_admin_special_char() {
		String albumname = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admin.isAlbumInList(albumname));
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_admin_cancel() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.newAlbum(albumname, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admin.isAlbumInList(albumname));
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_file_upload() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.completeAlbum(albumname);
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_file_upload_no_select_album() {
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Debe seleccionar un álbum", upload.getErrorMsjAlbum());
		upload.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	@Test
	public void test_new_album_file_upload_repeted() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.completeAlbum(albumname);
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del album ya existe", upload.getUploadErrorMsj());
		upload.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	@Test
	public void test_new_album_file_upload_cancel() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.completeAlbum(albumname);
		upload.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_new_album_file_upload_specia_char() {
		String albumname = StringUtils.getCaracteresEspeciales();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.completeAlbum(albumname);
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
