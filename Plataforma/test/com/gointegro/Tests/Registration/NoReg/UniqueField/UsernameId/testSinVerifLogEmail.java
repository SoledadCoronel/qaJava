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
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testSinVerifLogEmail {

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
	public void test_SinVerif_LogEmail_WithoutGenderFNPass_row153() {
		common.readxls(153);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGenderPass_row154() {
		common.readxls(154);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutFNPass_row155() {
		common.readxls(155);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		signup.setGender();
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutPass_row156() {
		common.readxls(156);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();

		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());

		
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGenderFN_row157() {
		common.readxls(157);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());

		
		
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGender_row158() {
		common.readxls(158);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();

		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutFN_row159() {
		common.readxls(159);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		signup.setPassword("integro12");
		signup.setGender();
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_row160() {
		common.readxls(160);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldUsernameId(), false, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldUsernameId());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setUsernameId(workbook.getId());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		
		signup.setPassword("integro12");
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
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
