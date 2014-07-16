package com.gointegro.Tests.Backoffice.Account;

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
import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountRegional;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewAccountRegionalFather extends TestBase {

	private WebDriver driver;

	String htmllog = DataGenerator.nombreFile();
	String uniquefield = "Documento";
	String logourl = ConfigElements.getFileImagen();
	String logofooter = ConfigElements.getFileImagen();
	String banner = ConfigElements.getFileImagen();
	boolean showusermail = false;
	String backgroundcolor = "#aaaaaa";
	String BgColorHeaderFooter = "#aaaaaa";
	String FontColor = "#aaaaaa";
	String buttonFontColor = "#aaaaaa";
	String buttonBackgroundColor = "#aaaaaa";
	String defaultBorderColor = "#aaaaaa";
	String iconsColor = "Blanco";
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
	String htmlSignUp = "";
	
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
		driver = AllTestsAccount.getDriver();
	}
	
	@Test
	public void test_new_account_regional_father() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		AccountDetail detail = regional.selectSave();

		assertEquals(accountname, detail.getName());
		assertEquals(web, detail.getWebSite());
		assertEquals("document", detail.getUniqueField());
		assertEquals("no", detail.getShowUserMail());
		assertEquals("Usuario y Password", detail.getLoginType());
		assertEquals("usernameId", detail.getUserField());
		assertEquals("document", detail.getVerifField1());
		assertEquals("email", detail.getVerifField2());
	}
	
	@Test
	public void test_new_account_regional_father_name_empty() {
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo("", web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", regional.getNameError());
	}
	
	@Test
	public void test_new_account_regional_father_name_exist() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String web2 = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web2, htmllog);

		person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		assertEquals("Ya existe una cuenta con el nombre "+accountname+".", regional.getErrorMsj());
	}
	
	@Test
	public void test_new_account_regional_father_web_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, "", htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", regional.getWebSiteError());
	}
	
	@Test
	public void test_new_account_regional_father_web_without_http() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		assertEquals("Invalid URL", regional.getWebSiteError());
	}
	
	@Test
	public void test_new_account_regional_father_web_invalid() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = DataGenerator.nombreFile();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		assertEquals("Invalid URL", regional.getWebSiteError());
	}
	
	@Test
	public void test_new_account_regional_father_web_exist() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String accountname2 = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();		

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		regional = home.selectRegional();
		regional.completeBasicInfo(accountname2, web, htmllog);

		person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		assertEquals("Ya existe una cuenta o plataforma con el host "+web.replace("http://", ""), regional.getErrorMsj());
	}
	
	@Test
	public void test_new_account_regional_father_principal_logo_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, "", logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorLogoUrl());
	}
	
	@Test
	public void test_new_account_regional_father_logo_footer_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, "",
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorLogoUrlFooter());
	}
	
	@Test
	public void test_new_account_regional_father_banner_signin_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				"", showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorSignInBanner());
	}
	
	@Test
	public void test_new_account_regional_father_backgroundcolor_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, "", BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorDefaultBackgroundColor());
	}
	
	@Test
	public void test_new_account_regional_father_background_header_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, "",
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorDefaultBgColorHeaderFooter());
	}
	
	@Test
	public void test_new_account_regional_father_html_login() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.getSignInContent().contains(htmlSignUp));
	}
	
	@Test
	public void test_new_account_regional_father_has_password() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isPasswordPresent());
	}
	
	@Test
	public void test_new_account_regional_father_forget_password() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, true, isnominated, htmlSignUp);

		regional.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isForgotPasswordPresent());
	}
	
	@Test
	public void test_new_account_regional_father_require_reg() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(false, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		regional.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isSignUpPresent());
	}
	
	@Test
	public void test_new_account_regional_father_login_document() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Documento",
				requirepass, recoverpass, isnominated, htmlSignUp);

		AccountDetail detail = regional.selectSave();
		
		assertEquals("document", detail.getUserField());
	}
	
	@Test
	public void test_new_account_regional_father_login_email() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Email",
				requirepass, recoverpass, isnominated, htmlSignUp);

		AccountDetail detail = regional.selectSave();
		
		assertEquals("email", detail.getUserField());
	}
	
	@Test
	public void test_new_account_regional_father_login_id() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Id",
				requirepass, recoverpass, isnominated, htmlSignUp);

		AccountDetail detail = regional.selectSave();
		
		assertEquals("usernameId", detail.getUserField());
	}
	
	@Test
	public void test_new_account_regional_father_cancel() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);

		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllog);
		
		String url = driver.getCurrentUrl();

		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);
		
		regional.selectCancel();
		
		assertNotEquals(url, driver.getCurrentUrl());
	}

	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
