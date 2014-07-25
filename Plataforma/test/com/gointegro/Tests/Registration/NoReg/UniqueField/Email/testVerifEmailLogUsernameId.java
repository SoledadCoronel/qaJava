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

public class testVerifEmailLogUsernameId {

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
	public void test_VerifEmail_LogEmail_WithoutGenderFNPass_row113() {
		common.readxls(113);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		
		assertEquals(signup.getDocument(), workbook.getDocumento());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
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
	public void test_VerifEmail_LogEmail_WithoutGenderPass_row114() {
		common.readxls(114);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
		signup.setBirthdate(workbook.getFechanac());
		
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
	public void test_VerifEmail_LogEmail_WithoutFNPass_row115() {
		common.readxls(115);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(),"");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
		signup.setGender();
		
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
	public void test_VerifEmail_LogEmail_WithoutPass_row116() {
		common.readxls(116);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
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
	public void test_VerifEmail_LogEmail_WithoutGenderFN_row117() {
		common.readxls(117);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);

		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
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
	public void test_VerifEmail_LogEmail_WithoutGender_row118() {
		common.readxls(118);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);

		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
		
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
	public void test_VerifEmail_LogEmail_WithoutFN_row119() {
		common.readxls(119);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
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
	public void test_VerifEmail_LogEmail_row120() {
		common.readxls(120);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), "", 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		signup.setUsernameId(workbook.getId());
		
		signup.setPassword("integro12");
		
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
