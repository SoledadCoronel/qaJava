package com.gointegro.Tests.Backoffice.Platform;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.PersonalizationConfig;
import com.gointegro.Pages.Backoffice_Platform.CreatePlatformRegional;
import com.gointegro.Pages.Backoffice_Platform.PlatformDetail;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewPlatformRegional extends TestBase{
	
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
	boolean country = true;
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
	
	@Before
	public void setUp() {
		driver = AllTestsBackofficePlatform.getDriver();
	}
	
	@Test
	public void test_new_platform_regional_verify_account_label() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountRegionalName(), newplat.getPlatformAccount());
	}
	
	@Test
	public void test_new_platform_regional_name_empty() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation("", filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorName());
	}
	
	@Test
	public void test_new_platform_regional_special_char_title() {
		platformname = StringUtils.getCaracteresEspeciales()+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(platformname, detail.getPlatformName());
	}
	
	@Test
	public void test_new_platform_regional_name_exist() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		newplat.selectSave();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una plataforma con este nombre para la cuenta "+ConfigElementsBO.getAccountRegionalName(), 
				newplat.getErrorMessage());
	}
	
	@Test
	public void test_new_platform_regional_web_empty() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, "", industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorWebSite());
	}
	
	@Test
	public void test_new_platform_regional_web_without_http() {
		platformname = DataGenerator.nombreFile();
		web =  DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("http://"+web, detail.getPlatformWebSite());
	}
	
	@Test
	public void test_new_platform_regional_web_invalid() {
		platformname = DataGenerator.nombreFile();
		web = platformname;
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("La URL ingresada es inválida.", newplat.getErrorWebSite());
	}
	
	@Test
	public void test_new_platform_regional_web_exist() {
		platformname = DataGenerator.nombreFile();
		String platformname2 = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname2, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.",newplat.getErrorMessage());
	}
	
	@Test
	public void test_new_platform_regional_filesize_empty() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, "", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorImgSize());
	}
	
	@Test
	public void test_new_platform_regional_filesize_not_number() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, "asdasd", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorImgSize());
	}
	
	@Test
	public void test_new_platform_regional_videosize_empty() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, "", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorVideoSize());
	}
	
	@Test
	public void test_new_platform_regional_videosize_not_number() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, "ssss", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorVideoSize());
	}
	
	@Test
	public void test_new_platform_regional_storage_empty() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, "", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorStorage());
	}
	
	@Test
	public void test_new_platform_regional_storage_not_number() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, "gygy", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorStorage());
	}
	
	@Test
	public void test_new_platform_regional_industry_not_selected() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, "Seleccione", userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("Por favor, seleccione una industria.", newplat.getErrorIndustry());
	}
	
	@Test
	public void test_new_platform_regional_users_range_not_selected() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, "Seleccione", 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSave();
		
		assertEquals("Por favor, seleccione una cantidad de usuarios/empleados.", newplat.getErrorUsersRange());
	}
	
	@Test
	public void test_new_platform_regional_disabled() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				true, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getDisablePlatform());
		
		driver.get(web);
		
		assertTrue(driver.getPageSource().contains("La plataforma se encuentra en mantenimiento, por favor vuelve a ingresar más tarde."));
	}
	
	@Test
	public void test_new_platform_regional_user_visibility() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, false, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ocultar", detail.getUserVisibility());
	}
	
	@Test
	public void test_new_platform_regional_google_code_empty() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, "", uservisib, socialact, timezone, tyc, country, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("", detail.getGoogleCode());
	}
	
	@Test
	public void test_new_platform_regional_social_disabled() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		newplat.selectSocial();
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getSocialStatus());
	}
	
	@Test
	public void test_new_platform_regional_without_timezone() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, "Ninguna", tyc, country, htmllog);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Malisimo el front que no trae el campo si esta vacio....
	}
	
	@Test
	public void test_new_platform_regional_tyc_empty() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, "", country, htmllog);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor, ingrese los Términos y Condiciones.", newplat.getErrorTermsAndConditions());
	}
	
	@Test
	public void test_new_platform_regional() {
		platformname = DataGenerator.nombreFile();
		web =  "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		PlatformDetail detail = newplat.selectSave();
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
	public void test_new_platform_regional_web_equals_account() {
		platformname = DataGenerator.nombreFile();
		web =  ConfigElementsBO.getWebSiteAccount();
		
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.", newplat.getErrorMessage());
	}
	
	@Test
	public void test_new_platform_regional_cancel() {
		loginBackoffice(driver);
		
		CreatePlatformRegional newplat = PageFactory.initElements(driver, CreatePlatformRegional.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String urlCreate = driver.getCurrentUrl();
		
		newplat.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(urlCreate, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
