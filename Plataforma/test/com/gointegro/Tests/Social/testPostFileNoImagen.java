package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

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
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;


/**
 * Test que postean un archivo que no sea una imagen.
 * 
 * @author gustavomoreira
 *
 */
public class testPostFileNoImagen extends AllTests {
	
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
	public void test_Post_File_No_Imagen_en_Social_Wall() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		//Abro otra pagina cualquiera antes de volver a recargar appsocial (falla si no lo hago)
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.selectArchivos();
		profile.orderByDateFiles();
		assertTrue(ConfigElements.getFileNoImage().contains(profile.getFileNameList()));
		assertTrue("Muro de la plataforma".equals(profile.getLocationNameList()));
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
	}
	
	@Test
	public void test_Post_File_No_Imagen_en_Social_App() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		//Abro otra pagina cualquiera antes de volver a recargar appsocial (falla si no lo hago)
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appsocial.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.selectArchivos();
		profile.orderByDateFiles();
		assertTrue(ConfigElements.getFileNoImage().contains(profile.getFileNameList()));
		assertTrue(ConfigElements.getNombreEspacio().equals(profile.getLocationNameList()));
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Post_File_No_Imagen_en_mi_Perfil() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		//Abro otra pagina cualquiera antes de volver a recargar appsocial (falla si no lo hago)
		driver.get(ConfigElements.getURL());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		profile.open();
		WaitTool.setImplicitWait(driver, 3);
		feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.selectArchivos();
		profile.orderByDateFiles();
		assertTrue(ConfigElements.getFileNoImage().contains(profile.getFileNameList()));
		assertTrue(ConfigElements.getNombreUsuario().equals(profile.getLocationNameList()));
	}
	
	@Test
	public void test_Post_File_No_Imagen_en_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprof = PageFactory.initElements(driver, OtherProfile.class);
		otherprof.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		profile.selectArchivos();
		profile.orderByDateFiles();
		assertTrue(ConfigElements.getFileNoImage().contains(profile.getFileNameList()));
		assertTrue(ConfigElements.getNameOtherUser().equals(profile.getLocationNameList()));
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
