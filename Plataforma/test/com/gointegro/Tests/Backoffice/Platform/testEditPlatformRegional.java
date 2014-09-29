package com.gointegro.Tests.Backoffice.Platform;

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
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.PersonalizationConfig;
import com.gointegro.Pages.Backoffice_Platform.CreatePlatformRegional;
import com.gointegro.Pages.Backoffice_Platform.EditPlatform;
import com.gointegro.Pages.Backoffice_Platform.PlatformDetail;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditPlatformRegional extends AllTestsBackofficePlatform {
	
	private WebDriver driver;
	String platformname = DataGenerator.nombreFile();
	String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
	String filesize = "800";
	String videosize = "400";
	String storage = "2000";
	String industry = "Agro";
	String userRange = "0-100";
	boolean disablestatus = false;
	String googlea = DataGenerator.nombreFile();
	boolean uservisib = false;
	boolean socialact = true;
	boolean country = false;
	String timezone = "Africa/Dakar";
	String tyc = DataGenerator.nombreFile();
	String htmllog = "";
	
	String uniquefield = "Documento";
	String logourl = ConfigElements.getFileImagen();
	String logofooter  = ConfigElements.getFileImagen();
	String banner = ConfigElements.getFileImagen();
	boolean showusermail = false;
	String backgroundcolor = "#aaaaaa";
	String BgColorHeaderFooter = "#aaaaaa";
	String FontColor = "#aaaaaa";
	String buttonFontColor = "#aaaaaa";
	String buttonBackgroundColor = "#aaaaaa";
	String defaultBorderColor = "#aaaaaa";
	String iconsColor = "White";
	
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
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_platform_regional_verify() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		assertEquals(platformname, edit.getPlatformName());
		assertEquals(ConfigElementsBO.getAccountRegionalName(), edit.getPlatformAccount());
		assertEquals(filesize, edit.getImageSize());
		assertEquals(videosize, edit.getVideoSize());
		assertEquals(storage, edit.getStorage());
		assertEquals(web, edit.getWebSite());
		assertEquals(industry, edit.getIndustry());
		assertEquals(userRange, edit.getUsersRange());
		assertEquals(disablestatus, edit.getDisableStatus());
		assertEquals(googlea, edit.getGoogleAnaString());
		assertEquals("Ocultar", edit.getVisibility()); //Por default esta en false asi que es ocultar.
		assertEquals(socialact, edit.getSocialStatus());
		assertEquals(timezone, edit.getTimeZone());
		assertEquals(tyc, edit.getTyC());
	}
	
	@Test
	public void test_edit_platform_regional_name_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation("", filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorName());
	}
	
	@Test
	public void test_edit_platform_regional_name_special_char() {
		String platformnamechanged = StringUtils.getCaracteresEspeciales()+DataGenerator.nombreFile();
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformnamechanged, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(platformnamechanged, detail.getPlatformName());
	}
	
	@Test
	public void test_edit_platform_regional_name_exist() {
		platformname = DataGenerator.nombreFile();
		String platformname2 = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		detail = createPlatform(platformname2, web2);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, false, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una plataforma con este nombre para la cuenta "+ConfigElementsBO.getAccountRegionalName(), 
				edit.getErrorMessage());
	}
	
	@Test
	public void test_edit_platform_regional_web_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, "", industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorWebSite());
	}
	
	@Test
	public void test_edit_platform_regional_web_without_http() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("http://"+web2, detail.getPlatformWebSite());
	}
	
	@Test
	public void test_edit_platform_regional_web_invalid() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = platformname;
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("La URL ingresada es inválida.", edit.getErrorWebSite());
	}
	
	@Test
	public void test_edit_platform_regional_web_exist() {
		platformname = DataGenerator.nombreFile();
		String platformname2 = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		detail = createPlatform(platformname2, web2);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname2, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.",edit.getErrorMessage());
	}
	
	@Test
	public void test_edit_platform_regional_filesize_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, "", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorImgSize());
	}
	
	@Test
	public void test_edit_platform_regional_filesize_not_number() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, "asdasd", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorImgSize());
	}
	
	@Test
	public void test_edit_platform_regional_videosize_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, "", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorVideoSize());
	}
	
	@Test
	public void test_edit_platform_regional_videosize_not_number() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, "dasd", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorVideoSize());
	}
	
	@Test
	public void test_edit_platform_regional_storage_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, "", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorStorage());
	}
	
	@Test
	public void test_edit_platform_regional_storage_not_number() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, "asdsad", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorStorage());
	}
	
	@Test
	public void test_edit_platform_regional_industry_not_selected() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, "Seleccione", userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor, seleccione una industria.", edit.getErrorIndustry());
	}
	
	@Test
	public void test_edit_platform_regional_users_range_not_selected() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, "Seleccione", 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor, seleccione una cantidad de usuarios/empleados.", edit.getErrorUsersRange());
	}
	
	@Test
	public void test_edit_platform_regional_disabled() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				true, googlea, uservisib, socialact, timezone, tyc, false, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getDisablePlatform());
		
		driver.get(web);
		
		assertTrue(driver.getPageSource().contains("La plataforma se encuentra en mantenimiento, por favor vuelve a ingresar más tarde."));
	}
	
	@Test
	public void test_edit_platform_regional_user_visibility() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, false, socialact, timezone, tyc, country, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ocultar", detail.getUserVisibility());
	}
	
	@Test
	public void test_edit_platform_regional_google_code_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, "", uservisib, socialact, timezone, tyc, country, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("", detail.getGoogleCode());
	}
	
	@Test
	public void test_edit_platform_regional_social_disabled() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, false, timezone, tyc, false, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getSocialStatus());
	}
	
	@Test
	public void test_edit_platform_regional_without_timezone() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, "Ninguna", tyc, country, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Falta el campo en la vista
	}
	
	@Test
	public void test_edit_platform_regional_tyc_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, "", country, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor, ingrese los Términos y Condiciones.", edit.getErrorTermsAndConditions());
	}
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_platform_regional() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, false, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountRegionalName(), detail.getAccountName());
		assertEquals(platformname, detail.getPlatformName());
		assertEquals(filesize+" KB", detail.getPlatformImgSize());
		assertEquals(web, detail.getPlatformWebSite());
		assertEquals(storage+" KB", detail.getPlatformStorage());
		assertEquals(industry, detail.getIndustry());
		assertEquals(userRange, detail.getUserRange());
		assertEquals(timezone, detail.getTimeZone());
		assertEquals("No", detail.getDisablePlatform());
		assertEquals("Ocultar", detail.getUserVisibility());
		assertEquals("Si", detail.getSocialStatus());
		assertEquals(googlea, detail.getGoogleCode());
	}
	
	@Test
	public void test_edit_platform_regional_web_equals_account() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = ConfigElementsBO.getWebSiteAccount();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.", edit.getErrorMessage());
	}
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_platform_regional_cancel() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		String platformname2 = DataGenerator.nombreFile();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname2, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		edit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountRegionalName(), detail.getAccountName());
		assertEquals(platformname, detail.getPlatformName());
		assertEquals(filesize+" KB", detail.getPlatformImgSize());
		assertEquals(web, detail.getPlatformWebSite());
		assertEquals(storage+" KB", detail.getPlatformStorage());
		assertEquals(industry, detail.getIndustry());
		assertEquals(userRange, detail.getUserRange());
		assertEquals(timezone, detail.getTimeZone());
		assertEquals("No", detail.getDisablePlatform());
		assertEquals("Ocultar", detail.getUserVisibility());
		assertEquals("Si", detail.getSocialStatus());
		assertEquals(googlea, detail.getGoogleCode());
	}
	
	private PlatformDetail createPlatform(String platformname, String web) {
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, true, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
