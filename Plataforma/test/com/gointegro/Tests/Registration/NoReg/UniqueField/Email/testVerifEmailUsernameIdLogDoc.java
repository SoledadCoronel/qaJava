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

public class testVerifEmailUsernameIdLogDoc {

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
	public void test_VerifEmailUsernameId_LogDoc_WithoutGenderFNPass_row73() {
		common.readxls(73);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutGenderPass_row74() {
		common.readxls(74);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setBirthdate(workbook.getFechanac());
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutFNPass_row75() {
		common.readxls(75);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isGenderPresent());
		
		signup.setGender();
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutPass_row76() {
		common.readxls(76);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutGenderFN_row77() {
		common.readxls(77);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutGender_row78() {
		common.readxls(78);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_WithoutFN_row79() {
		common.readxls(79);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setPassword("integro12");
		signup.setGender();
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmailUsernameId_LogDoc_row80() {
		common.readxls(80);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), true, "Email", "Id", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldEmail(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldEmail());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getMail(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertEquals(workbook.getMail(), signup.getEmail());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setPassword("integro12");
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
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
