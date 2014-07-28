package com.gointegro.Tests.CommonMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Platform.EditPlatform;
import com.gointegro.Pages.Backoffice_User.CreateUser;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

/**
 * Aca meti unos metodos que se van a repetir por muchos lados, lo primero que puse son de registracion, algun dia capaz se agrande...
 * 
 * @author gustavomoreira
 *
 */
public class CommonTestMethods extends TestBase{
	
	private WebDriver driver;

	public CommonTestMethods(WorkbookUtils workbook, WebDriver driver) {
		super();
		this.workbook = workbook;
		this.driver = driver;
	}

	WorkbookUtils workbook = new WorkbookUtils();
	
	/**
	 * Configuraciones de la plataforma para el test
	 * 
	 * @param birthdate
	 * @param gender
	 * @param password
	 * @param idplatform
	 * @param verifstatus
	 * @param fieldver1
	 * @param fieldver2
	 * @param identity
	 */
	public void configPlatform(boolean birthdate, boolean gender, boolean password, String idplatform, boolean verifstatus,
			String fieldver1, String fieldver2, String identity) {
		loginBackoffice(driver);
		driver.get(ConfigElementsBO.getUrlBackoffice()+"/platform/"+idplatform+"/edit");
		WaitTool.waitForJQueryProcessing(driver, 10);
		EditPlatform edit = PageFactory.initElements(driver, EditPlatform.class);
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		reg.completeConfigRegistration(true, false, birthdate, gender, verifstatus, fieldver1, fieldver2, identity, password, true, false, "");
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
	public void readxls(int row) {
		try {
			workbook.readWorkbook(row);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void VerifRegistrationFields(SignUp signup) {
		assertTrue(signup.isNamePresent());
		assertEquals(workbook.getNombre(), signup.getName());
		assertTrue(signup.isSurnamePresent());
		assertEquals(workbook.getApellido(), signup.getSurname());
		assertTrue(signup.isEmailPresent());
	}

}
