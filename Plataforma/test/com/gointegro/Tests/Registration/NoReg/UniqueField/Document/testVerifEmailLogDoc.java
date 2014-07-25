package com.gointegro.Tests.Registration.NoReg.UniqueField.Document;

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

import com.gointegro.Helpers.ConfigElementsRegistration;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Pages.Registration.Verification;
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testVerifEmailLogDoc {

	private WebDriver driver;
	
	WorkbookUtils workbook = new WorkbookUtils();
	
	CommonTestMethods common;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};

	@Before
	public void setUp() throws Exception {
		driver = AllTestsNoRegUniqDocument.getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}

	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderFNPass_row97() {
		common.readxls(97);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(signup.getDocument(), workbook.getDocumento());
		
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderPass_row98() {
		common.readxls(98);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		
		
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFNPass_row99() {
		common.readxls(99);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(),"");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		
		
		signup.setGender();
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutPass_row100() {
		common.readxls(100);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderFN_row101() {
		common.readxls(101);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGender_row102() {
		common.readxls(102);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFN_row103() {
		common.readxls(103);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		
		signup.setPassword("integro12");
		signup.setGender();
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_row104() {
		common.readxls(104);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Email", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		
		signup.setPassword("integro12");
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
