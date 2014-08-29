package com.gointegro.Tests.Registration.Reg.UniqueField.Document;

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

import com.gointegro.Helpers.ConfigElementsRegistration;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.PlatformSelectOverlay;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testSinVerifLogUsernameId extends AllTestsRegUniqDocument{

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

	@BeforeMethod
	public void setUp() throws Exception {
		driver = getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}

	@Test
	public void test_SinVerif_LogDoc_WithoutGenderFNPass_row17() {
		common.readxls(17);
		
		common.configAccount(false, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.selectSignUp();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		PlatformSelectOverlay overlay = PageFactory.initElements(driver, PlatformSelectOverlay.class);
		overlay.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().contains(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()));
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutGenderPass_row18() {
		common.readxls(18);
		
		common.configAccount(true, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutFNPass_row19() {
		common.readxls(19);
		
		common.configAccount(false, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutPass_row20() {
		common.readxls(20);
		
		common.configAccount(true, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutGenderFN_row21() {
		common.readxls(21);
		
		common.configAccount(false, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutGender_row22() {
		common.readxls(22);
		
		common.configAccount(true, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setPassword("integro12");
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutFN_row23() {
		common.readxls(23);
		
		common.configAccount(false, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setPassword("integro12");
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogDoc_WithoutPass_row24() {
		common.readxls(24);
		
		common.configAccount(true, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentAccountUrl());
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isDocumentPresent());
		assertTrue(signup.isPlatformPresent());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
		signup.setPassword("integro12");
		signup.setUsernameId(workbook.getId());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		signup.setTyC();
	
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
