package com.gointegro.Tests.Backoffice.Platform;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.PersonalizationConfig;
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Platform.CreatePlatform;
import com.gointegro.Pages.Backoffice_Platform.PlatformDetail;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewPlatformStandard extends TestBase{
	
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
	String timezone = "Africa/Dakar";
	String tyc = DataGenerator.nombreFile();
	String htmllog = DataGenerator.nombreFile();
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
	boolean requireReg = true;
	boolean usescard = true;
	boolean usesbirthdate = true;
	boolean usesGender = true;
	boolean requireVerif = true;
	String verif1 = "Documento";
	String verif2 = "Email";
	String identity = "Id";
	boolean requirepass = true;
	boolean recoverpass = false;
	boolean isnominated = false;
	String htmlSignUp = DataGenerator.nombreFile(); 
	
	@Before
	public void setUp() {
		driver = AllTestsBackofficePlatform.getDriver();
	}
	
	@Test
	public void test_new_platform_verify_account_label() {
		//Log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountPlatformTestName(), newplat.getPlatformAccount());
	}
	
	@Test
	public void test_new_platform_empty_title() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation("", filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorName());
	}
	
	@Test
	public void test_new_platform_special_char_title() {
		platformname = StringUtils.getCaracteresEspeciales()+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(platformname, detail.getPlatformName());
	}
	
	@Test
	public void test_new_platform_name_exist() {
		platformname = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una plataforma con este nombre para la cuenta "+ConfigElementsBO.getAccountPlatformTestName(), 
				newplat.getErrorMessage());
	}
	
	@Test
	public void test_new_platform_web_empty() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, "", industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorWebSite());
	}
	
	@Test
	public void test_new_platform_web_without_http() {
		platformname = DataGenerator.nombreFile();
		web = platformname+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("http://"+platformname+ConfigElementsBO.getHostName(), detail.getPlatformWebSite());
	}
	
	@Test
	public void test_new_platform_web_invalid() {
		platformname = DataGenerator.nombreFile();
		web = platformname;
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("La URL ingresada es inválida.", newplat.getErrorWebSite());
	}
	
	@Test
	public void test_new_platform_web_exist() {
		platformname = DataGenerator.nombreFile();
		String platformname2 = DataGenerator.nombreFile();
		web = "http://"+platformname+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname2, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.",newplat.getErrorMessage());
	}
	
	@Test
	public void test_new_platform_filesize_empty() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, "", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorImgSize());
	}
	
	@Test
	public void test_new_platform_filesize_not_numbers() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, "asd", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorImgSize());
	}
	
	@Test
	public void test_new_platform_videosize_empty() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, "", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorVideoSize());
	}
	
	@Test
	public void test_new_platform_videosize_not_number() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, "asd", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorVideoSize());
	}
	
	@Test
	public void test_new_platform_storage_empty() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, "", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", newplat.getErrorStorage());
	}
	
	@Test
	public void test_new_platform_storage_not_number() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, "asd", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("El campo debe ser un número entero", newplat.getErrorStorage());
	}
	
	@Test
	public void test_new_platform_industry_no_select() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, "Seleccione", userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor, seleccione una industria.", newplat.getErrorIndustry());
	}
	
	@Test
	public void test_new_platform_users_range_no_select() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, "Seleccione", 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor, seleccione una cantidad de usuarios/empleados.", newplat.getErrorUsersRange());
	}
	
	@Test
	public void test_new_platform_disabled() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				true, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getDisablePlatform());
		
		driver.get(web);
		
		assertTrue(driver.getPageSource().contains("La plataforma se encuentra en mantenimiento, por favor vuelve a ingresar más tarde."));
	}
	
	@Test
	public void test_new_platform_user_visibility() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, false, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ocultar", detail.getUserVisibility());
		//Falta la parte de front.
	}
	
	@Test
	public void test_new_platform_google_code_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, "", uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("", detail.getGoogleCode());
	}
	
	@Test
	public void test_new_platform_social_disable() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, false, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);	
		
		assertEquals("No", detail.getSocialStatus());
	}
	
	@Test
	public void test_new_platform_without_timezone() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, "Ninguna", tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Directamente el campo no existe si no elegis timezone en la vista ¬¬
	}
	
	@Test
	public void test_new_platform_tyc_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, "", htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		assertEquals("Por favor, ingrese los Términos y Condiciones.", newplat.getErrorTermsAndConditions());
	}
	
	@Test
	public void test_new_platform_html_login() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(htmllog, detail.getHtmlLogin());
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertEquals(htmllog, login.getHtmlLogin());
	}
	
	@Test
	public void test_new_platform_uniquefield_id() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization("Id", logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("usernameId", detail.getUniqueField());
	}
	
	@Test
	public void test_new_platform_uniquefield_document() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization("Documento", logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("document", detail.getUniqueField());
	}
	
	@Test
	public void test_new_platform_uniquefield_email() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization("Email", logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("email", detail.getUniqueField());
	}
	
	@Test
	public void test_new_platform_logourl_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, "", logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorLogoUrl());
	}
	
	@Test
	public void test_new_platform_logofooter_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, "", banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorLogoUrlFooter());
	}
	
	@Test
	public void test_new_platform_banner_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, "", 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorSignInBanner());
	}
	
	@Test
	public void test_new_platform_view_user_mails_false() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				false, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("no", detail.getShowUserMail());
	}
	
	@Test
	public void test_new_platform_backgroundcolor_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, "", BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorDefaultBackgroundColor());
	}
	
	@Test
	public void test_new_platform_background_color_header_footer_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, "", FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorDefaultBgColorHeaderFooter());
	}
	
	@Test
	public void test_new_platform_set_backgrounds_color() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		backgroundcolor = "#282828";
		BgColorHeaderFooter = "#882827";
		FontColor = "#944949";
		buttonFontColor = "#421717";
		buttonBackgroundColor = "#ad8e8e";
		defaultBorderColor = "#a621b8";
		iconsColor = "White";
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(backgroundcolor, detail.getBackgroundcolor());
		assertEquals(BgColorHeaderFooter, detail.getBackgroundheaderfooter());
		assertEquals(FontColor, detail.getTextheaderfooter());
		assertEquals(buttonFontColor, detail.getTextbtn());
		assertEquals(buttonBackgroundColor, detail.getBackgroundbtn());
		assertEquals(defaultBorderColor, detail.getBorderheaderfooter());
		assertEquals(iconsColor, detail.getColoricon());
	}
	
	@Test
	public void test_new_platform_login_with_password() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, true, recoverpass, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isPasswordPresent());
	}
	
	@Test
	public void test_new_platform_recover_password() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, true, true, isnominated, htmlSignUp);
		
		newplat.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isForgotPasswordPresent());
	}
	
	@Test
	public void test_new_platform_require_reg_false() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(false, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getRegistration());
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isSignUpPresent());
	}
	
	@Test
	public void test_new_platform_hmtl_sign_up() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(htmlSignUp, detail.getHtmlSignUp());
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.getSignInContent().contains(htmlSignUp));
	}
	
	@Test
	public void test_new_platform_uses_card() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, true, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getUsesCard());
	}
	
	@Test
	public void test_new_platform_uses_card_nominated() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, true, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, true, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Nominada", detail.getNominated());
	}
	
	@Test
	public void test_new_platform_uses_birthdate() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, true, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getBirthdate());
	}
	
	@Test
	public void test_new_platform_uses_gender() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, true, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getGender());
	}
	
	@Test
	public void test_new_platform_login_document() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				"Documento", requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("document", detail.getUserField());
	}
	
	@Test
	public void test_new_platform_login_email() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				"Email", requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("email", detail.getUserField());
	}
	
	@Test
	public void test_new_platform_login_id() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				"Id", requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("usernameId", detail.getUserField());
	}
	
	@Test
	public void test_new_platform_complete_banners() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.getSrcBannerLogin().isEmpty());
		assertFalse(detail.getSrcPrincipalLogo().isEmpty());
		assertFalse(detail.getSrcSecondaryLogo().isEmpty());
	}
	
	@Test
	public void test_new_platform_cancel() {
		loginBackoffice(driver);
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
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
