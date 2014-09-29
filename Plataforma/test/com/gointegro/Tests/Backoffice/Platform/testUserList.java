package com.gointegro.Tests.Backoffice.Platform;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Backoffice_User.CreateUser;
import com.gointegro.Pages.Backoffice_User.UserDetail;
import com.gointegro.Pages.Backoffice_User.UserList;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testUserList extends AllTestsBackofficePlatform {

	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(groups = {"BOFunctTest"})
	public void test_search_user_by_name() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		
		createUser(name, surname, document, email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserList list = PageFactory.initElements(driver, UserList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(list.searchUser(name));
	}
	
	@Test
	public void test_search_user_by_surname() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		
		createUser(name, surname, document, email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserList list = PageFactory.initElements(driver, UserList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(list.searchUser(surname));
	}
	
	@Test
	public void test_search_user_by_email() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		
		createUser(name, surname, document, email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserList list = PageFactory.initElements(driver, UserList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(list.searchUser(email));
	}
	
	@Test
	public void test_search_user_by_document() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String document = DataGenerator.nombreFile();
		String email = DataGenerator.nombreFile() + "@mail.com";
		
		createUser(name, surname, document, email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserList list = PageFactory.initElements(driver, UserList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(list.searchUser(document));
	}
	
	
	private CreateUser createUser(String name, String surname, String document, String email) {
		String usernameId = DataGenerator.nombreFile();
		String adminissionDate = "09/10/2010";
		String birthdate = "04/11/1990";
		String gender = "Masculino";
		String phone = "20349829";
		String cellphone = "00293483";
		boolean regStatus = true;
		String integrationId = DataGenerator.nombreFile();
		String regDate = DataGenerator.fechaactual();
		String role = "ROLE_BASIC";
		
		loginBackoffice(driver);
		
		CreateUser newUser = PageFactory.initElements(driver, CreateUser.class);
		newUser.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newUser.completeInformation(true, name, surname, email, adminissionDate, document, birthdate, gender, phone, cellphone, usernameId, regStatus, regDate, integrationId, role);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		UserDetail detail = newUser.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail.selectEdit();
	}
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
}
