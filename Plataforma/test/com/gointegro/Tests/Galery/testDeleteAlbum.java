package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Galery.AdminAlbum;
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.DeleteOverlay;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testDeleteAlbum extends TestBase{
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}
	
	@Test
	public void test_delete_album_admin_empty() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = admin.deleteAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admin.isAlbumInList(albumname));
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_admin_cancel() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = admin.deleteAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admin.isAlbumInList(albumname));
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_admin_not_empty() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbumFile(albumname, home, testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = admin.deleteAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Este álbum tiene imágenes asociadas", delete.getAlert());
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admin.isAlbumInList(albumname));
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_detail() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = detail.selectDeleteAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("¿Esta seguro que desea eliminar el álbum \""+albumname +"\" y todo su contenido?", delete.getMsjBody());
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_detail_cancel() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = detail.selectDeleteAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("¿Esta seguro que desea eliminar el álbum \""+albumname +"\" y todo su contenido?", delete.getMsjBody());
		
		delete.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumname));
		assertTrue(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_detail_not_empty() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbumFile(albumname, home, testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = detail.selectDeleteAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("¿Esta seguro que desea eliminar el álbum \""+albumname +"\" y todo su contenido?", delete.getMsjBody());
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_delete_album_access() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String url = driver.getCurrentUrl();
		
		DeleteOverlay delete = detail.selectDeleteAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.get(url);
		
		assertTrue(driver.getCurrentUrl().contains("error404"));
	}
	
	private void createAlbum(String albumname, HomeGalery home) {
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
	}
	
	private void createAlbumFile(String albumname, HomeGalery home, String testfile) {
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.completeAlbum(albumname);
		upload.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
