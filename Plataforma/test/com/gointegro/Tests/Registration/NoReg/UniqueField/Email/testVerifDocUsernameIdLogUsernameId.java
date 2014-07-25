package com.gointegro.Tests.Registration.NoReg.UniqueField.Email;

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

public class testVerifDocUsernameIdLogUsernameId {

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
		driver = AllTestsNoRegUniqEmail.getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutGenderFNPass_row65() {
		common.readxls(65);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutGenderPass_row66() {
		common.readxls(66);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setBirthdate(workbook.getFechanac());
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutFNPass_row67() {
		common.readxls(67);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		
		signup.setGender();
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutPass_row68() {
		common.readxls(68);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutGenderFN_row69() {
		common.readxls(69);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutGender_row70() {
		common.readxls(70);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
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
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_WithoutFN_row71() {
		common.readxls(71);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
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
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogUsernameId_row72() {
		common.readxls(72);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Documento", "Id", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setPassword("integro12");
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
