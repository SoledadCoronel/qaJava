package com.gointegro.Tests.Registration.NoReg.UniqueField.UsernameId;

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

public class testVerifDocLogDoc {

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
		driver = AllTestsNoRegUniqUsernameId.getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}

	@Test
	public void test_VerifDoc_LogDoc_WithoutGenderFNPass_row9() {
		common.readxls(9);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(signup.getDocument(), workbook.getDocumento());
		
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutGenderPass_row10() {
		common.readxls(10);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setEmail(workbook.getMail());
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutFNPass_row11() {
		common.readxls(11);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(),"");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutPass_row12() {
		common.readxls(12);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutGenderFN_row13() {
		common.readxls(13);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutGender_row14() {
		common.readxls(14);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_WithoutFN_row15() {
		common.readxls(15);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDoc_LogDoc_row16() {
		common.readxls(16);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), true, "Documento", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
