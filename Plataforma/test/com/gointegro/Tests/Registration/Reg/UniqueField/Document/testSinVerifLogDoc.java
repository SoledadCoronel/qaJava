package com.gointegro.Tests.Registration.Reg.UniqueField.Document;

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
import com.gointegro.Pages.Platform.PlatformSelectOverlay;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testSinVerifLogDoc {

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
		driver = AllTestsRegUniqDocument.getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}

	@Test
	public void test_SinVerif_LogDoc_WithoutGenderFNPass_row1() {
		common.readxls(1);
		
		common.configAccount(false, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
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
	public void test_SinVerif_LogDoc_WithoutGenderPass_row2() {
		common.readxls(2);
		
		common.configAccount(true, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
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
		assertTrue(signup.isBirthdatePresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
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
	public void test_SinVerif_LogDoc_WithoutFNPass_row3() {
		common.readxls(3);
		
		common.configAccount(false, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
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
		assertTrue(signup.isGenderPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
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
	public void test_SinVerif_LogDoc_WithoutPass_row4() {
		common.readxls(4);
		
		common.configAccount(true, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
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
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
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
	public void test_SinVerif_LogDoc_WithoutGenderFN_row5() {
		common.readxls(5);
		
		common.configAccount(false, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
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
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
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
	public void test_SinVerif_LogDoc_WithoutGender_row6() {
		common.readxls(6);
		
		common.configAccount(true, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setPassword("integro12");
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
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setPassword("integro12");
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
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
	public void test_SinVerif_LogDoc_WithoutFN_row7() {
		common.readxls(7);
		
		common.configAccount(false, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setPassword("integro12");
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
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setPassword("integro12");
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
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
	public void test_SinVerif_LogDoc_WithoutPass_row8() {
		common.readxls(8);
		
		common.configAccount(true, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), false, "", "", "");
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
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
		signup.setPassword("integro12");
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
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setGender();
		signup.setPassword("integro12");
		signup.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild2Id());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		PlatformSelectOverlay overlay = PageFactory.initElements(driver, PlatformSelectOverlay.class);
		overlay.selectPlatform(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().contains(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()));
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
