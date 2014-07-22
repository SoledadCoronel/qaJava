package com.gointegro.Tests.Registration.NoReg.UniqueField.Document;

import static org.junit.Assert.*;

import java.io.IOException;

import jxl.read.biff.BiffException;

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

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Helpers.ConfigElementsRegistration;
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Platform.EditPlatform;
import com.gointegro.Pages.Backoffice_User.CreateUser;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Pages.Registration.Verification;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testVerifDocEmailLogDoc extends TestBase{
	
	private WebDriver driver;
	
	WorkbookUtils workbook = new WorkbookUtils();
	
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
	}

	@Test
	public void test_VerifDocEmail_LogDoc_WithoutGenderFNPass() {
		readxls(1);
		
		configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getMail());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertEquals(workbook.getNombre(), signup.getName());
		assertTrue(signup.isSurnamePresent());
		assertEquals(workbook.getApellido(), signup.getSurname());
		assertTrue(signup.isEmailPresent());
		assertEquals(workbook.getMail(), signup.getEmail());
		
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
	public void test_VerifDocEmail_LogDoc_WithoutGenderPass() {
		readxls(2);
		
		configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getMail());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertEquals(workbook.getNombre(), signup.getName());
		assertTrue(signup.isSurnamePresent());
		assertEquals(workbook.getApellido(), signup.getSurname());
		assertTrue(signup.isEmailPresent());
		assertEquals(workbook.getMail(), signup.getEmail());
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
	public void test_VerifDocEmail_LogDoc_WithoutFNPass() {
		readxls(3);
		
		configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				workbook.getMail(), workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getMail());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertEquals(workbook.getNombre(), signup.getName());
		assertTrue(signup.isSurnamePresent());
		assertEquals(workbook.getApellido(), signup.getSurname());
		assertTrue(signup.isEmailPresent());
		assertEquals(workbook.getMail(), signup.getEmail());
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
	
	@After
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/**
	 * Configuraciones de la plataforma para el test
	 * 
	 * @param birthdate
	 * @param gender
	 * @param password
	 * @param idplatform
	 */
	public void configPlatform(boolean birthdate, boolean gender, boolean password, String idplatform) {
		loginBackoffice(driver);
		driver.get(ConfigElementsBO.getUrlBackoffice()+"/platform/"+idplatform+"/edit");
		WaitTool.waitForJQueryProcessing(driver, 10);
		EditPlatform edit = PageFactory.initElements(driver, EditPlatform.class);
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		reg.completeConfigRegistration(true, false, birthdate, gender, true, "Documento", "Email", "Documento", password, true, false, "");
		edit.selectSave();
	}
	
	/**
	 * Completar el usario en bo
	 * 
	 * @param idplatform
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param surname
	 * @param usernameid
	 * @param document
	 */
	public void createUserBO(String idplatform, String name, String email, String birthdate, String surname, 
			String usernameid, String document) {
		driver.get(ConfigElementsBO.getUrlBackoffice()+"/platforms/"+idplatform+"/user/create");
		WaitTool.waitForJQueryProcessing(driver, 10);
		CreateUser create = PageFactory.initElements(driver, CreateUser.class);
		create.completeInformation(true, name, surname, email, "", document, birthdate, "Masculino", "", "", usernameid, false, "", 
				"", "ROLE_BASIC");
		create.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/**
	 * Lee del workbook el row que le pidas
	 * 
	 * @param row
	 */
	private void readxls(int row) {
		try {
			workbook.readWorkbook(row);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
