package com.gointegro.Tests.Backoffice.Account;

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
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountRegional;
import com.gointegro.Pages.Backoffice_Account.EditAccountRegional;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditAccountRegionalFather extends AllTestsAccount {
	
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
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void test_edit_account_regional_father_verify() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(accountname, edit.getName());
		assertEquals(web, edit.getSitioWeb());
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
	public void test_edit_account_regional_father_name_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo("", web, htmllog);
		
		edit.selectSave();
		
		assertEquals("Required", edit.getNameError());
	}
	
	@Test
	public void test_edit_account_regional_father_name_exist() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String accountname2 = "Z" + DataGenerator.nombreFile();
		String web2 = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		createAccountRegional(accountname2, web2, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname, web, htmllog);
		
		edit.selectSave();
		
		assertEquals("Ya existe una cuenta con el nombre "+accountname+".", edit.getErrorMsj());
	}
	
	@Test
	public void test_edit_account_regional_father_web_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname, "", htmllog);
		
		edit.selectSave();
		
		assertEquals("Required", edit.getWebSiteError());
	}
	
	@Test
	public void test_edit_account_regional_father_web_exist() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String accountname2 = "Z" + DataGenerator.nombreFile();
		String web2 = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		createAccountRegional(accountname2, web2, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname2, web, htmllog);
		
		edit.selectSave();
		
		assertEquals("Ya existe una cuenta o plataforma con el host "+web.replace("http://", "")+".", edit.getErrorMsj());
	}
	
	@Test
	public void test_edit_account_regional_father_web_without_http() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname, web.replace("http://", ""), htmllog);
		
		edit.selectSave();
		
		assertEquals("Invalid URL", edit.getWebSiteError());
	}
	
	@Test
	public void test_edit_account_regional_father_web_invalid() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname, accountname, htmllog);
		
		edit.selectSave();
		
		assertEquals("Invalid URL", edit.getWebSiteError());
	}
	
	@Test
	public void test_edit_account_regional_father_backgroundcolor_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);

		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, "", BgColorHeaderFooter,
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorDefaultBackgroundColor());
	}
	
	@Test
	public void test_edit_account_regional_father_bgcolorheaderfooter_empty() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		PersonalizationConfig person = PageFactory.initElements(driver,PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter,
				banner, showusermail, backgroundcolor, "",
				FontColor, buttonFontColor, buttonBackgroundColor,
				defaultBorderColor, iconsColor);

		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", person.getErrorDefaultBgColorHeaderFooter());
	}
	
	@Test
	public void test_edit_account_regional_father_html_login() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String htmllog2 = DataGenerator.nombreFile();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname, web, htmllog2);
		
		edit.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertEquals(htmllog2, login.getHtmlLogin());
	}
	
	@Test
	public void test_edit_account_regional_father_has_password() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);

		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		edit.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isPasswordPresent());
	}
	
	@Test
	public void test_edit_account_regional_father_forget_password() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, true, isnominated, htmlSignUp);

		edit.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertTrue(login.isForgotPasswordPresent());
	}
	
	@Test
	public void test_edit_account_regional_father_require_reg() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);
		
		reg.completeConfigRegistration(false, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, identity,
				requirepass, recoverpass, isnominated, htmlSignUp);

		edit.selectSave();
		
		driver.get(web);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		assertFalse(login.isSignUpPresent());
	}
	
	@Test
	public void test_edit_account_regional_father_login_document() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Documento",
				requirepass, recoverpass, isnominated, htmlSignUp);

		detail = edit.selectSave();
		
		assertEquals("document", detail.getUserField());
	}
	
	@Test
	public void test_edit_account_regional_father_login_email() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Email",
				requirepass, recoverpass, isnominated, htmlSignUp);

		detail = edit.selectSave();
		
		assertEquals("email", detail.getUserField());
	}
	
	@Test
	public void test_edit_account_regional_father_login_id() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		RegistrationConfig reg = PageFactory.initElements(driver,RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate,
				usesGender, requireVerif, verif1, verif2, "Id",
				requirepass, recoverpass, isnominated, htmlSignUp);

		detail = edit.selectSave();
		
		assertEquals("usernameId", detail.getUserField());
	}
	
	@Test
	public void test_edit_account_regional_father_cancel() {
		String accountname = "Z" + DataGenerator.nombreFile();
		String web = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		String accountname2 = "Z" + DataGenerator.nombreFile();
		String web2 = "http://" + DataGenerator.nombreFile()+ConfigElementsBO.getHostName();

		loginBackoffice(driver);
		
		AccountDetail detail = createAccountRegional(accountname, web, htmllog);
		
		detail.selectEdit();
		
		EditAccountRegional edit = PageFactory.initElements(driver, EditAccountRegional.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		edit.completeBasicInfo(accountname2, web2, htmllog);
		
		edit.selectCancel();
		
		assertEquals(accountname, detail.getName());
		assertEquals(web, detail.getWebSite());
	}
	
	private AccountDetail createAccountRegional(String accountname, String web, String htmllogin) {
		CreateAccountHome home = PageFactory.initElements(driver,CreateAccountHome.class);
		home.open();

		WaitTool.waitForJQueryProcessing(driver, 10);

		CreateAccountRegional regional = home.selectRegional();
		regional.completeBasicInfo(accountname, web, htmllogin);

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
		
		return detail;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
