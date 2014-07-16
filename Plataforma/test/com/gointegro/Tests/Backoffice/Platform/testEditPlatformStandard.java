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
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Platform.CreatePlatform;
import com.gointegro.Pages.Backoffice_Platform.EditPlatform;
import com.gointegro.Pages.Backoffice_Platform.PlatformDetail;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditPlatformStandard extends TestBase{
	
	private WebDriver driver;
	
	/**
	 * Valores para cada new platform
	 */
	
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
	boolean recoverpass = true;
	boolean isnominated = false;
	String htmlSignUp = DataGenerator.nombreFile();
	
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
	public void test_edit_platform_verify() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		assertEquals(platformname, edit.getPlatformName());
		assertEquals(ConfigElementsBO.getAccountPlatformTestName(), edit.getPlatformAccount());
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
		assertEquals(htmllog, edit.getHtmlLogin());
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		assertFalse(person.getUniqueFieldStatus());		
		assertEquals(uniquefield, person.getUniqueField());
		assertFalse(person.getUserMail());
		assertEquals(backgroundcolor, person.getDefaulBackgroundColor());
		assertEquals(BgColorHeaderFooter, person.getDefaultBgColorHeaderFooter());
		assertEquals(FontColor, person.getDefaultFontColor());
		assertEquals(buttonFontColor, person.getButtonFontColor());
		assertEquals(buttonBackgroundColor, person.getButtonBackgroundColor());
		assertEquals(defaultBorderColor, person.getDefaultBorderColor());
		assertEquals(iconsColor, person.getIconsColor());
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		assertTrue(reg.getRequireRegistration());
		assertTrue(reg.getUsesBirthdate());
		assertTrue(reg.getUsesCard());
		assertTrue(reg.getUsesGender());
		assertTrue(reg.getRequireVerif());
		assertEquals(verif1, reg.getVerifField1());
		assertEquals(verif2, reg.getVerifField2());
		assertEquals(identity, reg.getIdentityField());
		assertTrue(reg.getUsesPassword());
		assertTrue(reg.getRecoverPassword());
	}
	
	@Test
	public void test_edit_platform_name_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation("", filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorName());
	}
	
	@Test
	public void test_edit_platform_name_special_char() {
		platformname = StringUtils.getCaracteresEspeciales()+DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(platformname, detail.getPlatformName());
	}
	
	@Test
	public void test_edit_platform_name_exist() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		String platformname2 = DataGenerator.nombreFile();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		detail = createPlatform(platformname2, web2);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web2, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una plataforma con este nombre para la cuenta "+ConfigElementsBO.getAccountPlatformTestName(), 
				edit.getErrorMessage());
	}
	
	@Test
	public void test_edit_platform_web_empty() {
		platformname = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, "", industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorWebSite());
	}
	
	@Test
	public void test_edit_platform_web_without_http() {
		platformname = DataGenerator.nombreFile();
		web = platformname+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("http://"+platformname+ConfigElementsBO.getHostName(), detail.getPlatformWebSite());
	}
	
	@Test
	public void test_edit_platform_web_invalid() {
		platformname = DataGenerator.nombreFile();
		web = platformname+ConfigElementsBO.getHostName();
		String webedited = platformname;
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, webedited, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("La URL ingresada es inválida.", edit.getErrorWebSite());
	}
	
	@Test
	public void test_edit_platform_web_exist() {
		platformname = DataGenerator.nombreFile();
		String platformname2 = DataGenerator.nombreFile();
		web = "http://"+platformname+ConfigElementsBO.getHostName();
		String web2 = "http://"+platformname2+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		detail = createPlatform(platformname2, web2);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname2, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La URL ingresada ya está siendo utilizada en el sistema.",edit.getErrorMessage());
	}
	
	@Test
	public void test_edit_platform_filesize_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, "", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorImgSize());
	}
	
	@Test
	public void test_edit_platform_filesize_not_numbers() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, "asd", videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorImgSize());
	}
	
	@Test
	public void test_edit_platform_videosize_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, "", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorVideoSize());
	}
	
	@Test
	public void test_edit_platform_videosize_not_number() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, "asd", storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorVideoSize());
	}
	
	@Test
	public void test_edit_platform_storage_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, "", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor ingrese el dato solicitado.", edit.getErrorStorage());
	}
	
	@Test
	public void test_edit_platform_storage_not_number() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, "asd", web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("El campo debe ser un número entero", edit.getErrorStorage());
	}
	
	@Test
	public void test_edit_platform_industry_not_select() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, "Seleccione", userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor, seleccione una industria.", edit.getErrorIndustry());
	}
	
	@Test
	public void test_edit_platform_uses_range_not_select() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, "Seleccione", 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor, seleccione una cantidad de usuarios/empleados.", edit.getErrorUsersRange());
	}
	
	@Test
	public void test_edit_platform_disabled() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				true, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Si", detail.getDisablePlatform());
		
		driver.get(web);
		
		assertTrue(driver.getPageSource().contains("La plataforma se encuentra en mantenimiento, por favor vuelve a ingresar más tarde."));
	}
	
	@Test
	public void test_edit_platform_user_visibility() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, true, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Mostrar", detail.getUserVisibility());
	}
	
	@Test
	public void test_edit_platform_google_code_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, "", uservisib, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("", detail.getGoogleCode());
	}
	
	@Test
	public void test_edit_platform_social_disabled() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, false, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getSocialStatus());
	}
	
	@Test
	public void test_edit_platform_without_time_zone() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, "Ninguna", tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		//Falta en la vista el campo... osea daleee... ¬¬
	}
	
	@Test
	public void test_edit_platform_tyc_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, "", htmllog);
		
		edit.selectSave();
		
		assertEquals("Por favor, ingrese los Términos y Condiciones.", edit.getErrorTermsAndConditions());
	}
	
	@Test
	public void test_edit_platform_html_login() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		htmllog = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(htmllog, detail.getHtmlLogin());
	}
	
	@Test
	public void test_edit_platform_change_logo_and_banner() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String logourl = ConfigElements.getFileImagenChange();
		String logofooter = ConfigElements.getFileImagenChange();
		String banner = ConfigElements.getFileImagenChange();
		
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		String principallogo = detail.getSrcPrincipalLogo();
		String secondlogo = detail.getSrcSecondaryLogo();
		String bannersign = detail.getSrcBannerLogin();
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(principallogo, detail.getSrcPrincipalLogo());
		assertNotEquals(secondlogo, detail.getSrcSecondaryLogo());
		assertNotEquals(bannersign, detail.getSrcBannerLogin());
	}
	
	@Test
	public void test_edit_platform_view_user_mails_true() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		htmllog = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				true, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("si", detail.getShowUserMail());
	}
	
	@Test
	public void test_edit_platform_background_color_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, "", BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorDefaultBackgroundColor());
	}
	
	@Test
	public void test_edit_platform_background_color_header_footer_empty() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, "", FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Por favor ingrese el dato solicitado.", person.getErrorDefaultBgColorHeaderFooter());
	}
	
	@Test
	public void test_edit_platform_change_colors() {
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
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
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
	public void test_edit_platform_change_password_setting() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, false, recoverpass, isnominated, htmlSignUp);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isPasswordPresent());
		
	}
	
	@Test
	public void test_edit_platform_change_recover_password() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, false, isnominated, htmlSignUp);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isForgotPasswordPresent());
	}
	
	@Test
	public void test_edit_platform_disable_registration() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(false, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isSignUpPresent());
	}
	
	@Test
	public void test_edit_platform() {
		//Prueba cambiandole unicamente el nombre, web,storage,filesize,industria y rango de usuarios.
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		String platformname2 = DataGenerator.nombreFile();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String filesize2 = "700";
		String storage2 = "1000";
		String industry2 = "Autos";
		String userRange2 = "100-300";
		String timezone2 = "Africa/Accra";
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname2, filesize2, videosize, storage2, web2, industry2, userRange2, 
				disablestatus, googlea, uservisib, socialact, timezone2, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountPlatformTestName(), detail.getAccountName());
		assertEquals(platformname2, detail.getPlatformName());
		assertEquals(filesize2+" KB", detail.getPlatformImgSize());
		assertEquals(web2, detail.getPlatformWebSite());
		assertEquals(storage2+" KB", detail.getPlatformStorage());
		assertEquals(industry2, detail.getIndustry());
		assertEquals(userRange2, detail.getUserRange());
		assertEquals(timezone2, detail.getTimeZone());
		assertEquals("No", detail.getDisablePlatform());
		assertEquals("Ocultar", detail.getUserVisibility());
		assertEquals("Si", detail.getSocialStatus());
		assertEquals(googlea, detail.getGoogleCode());
		assertEquals(htmllog, detail.getHtmlLogin());
	}
	
	@Test
	public void test_edit_platform_cancel() {
		platformname = DataGenerator.nombreFile();
		web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		String platformname2 = DataGenerator.nombreFile();
		String web2 = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String filesize2 = "700";
		String storage2 = "1000";
		String industry2 = "Autos";
		String userRange2 = "100-300";
		String timezone2 = "Africa/Accra";
		
		loginBackoffice(driver);
		
		PlatformDetail detail = createPlatform(platformname, web);
		
		EditPlatform edit = detail.selectEditar();
		
		edit.completeBasicInformation(platformname2, filesize2, videosize, storage2, web2, industry2, userRange2, 
				disablestatus, googlea, uservisib, socialact, timezone2, tyc, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		edit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountPlatformTestName(), detail.getAccountName());
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
		
		return detail;
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
