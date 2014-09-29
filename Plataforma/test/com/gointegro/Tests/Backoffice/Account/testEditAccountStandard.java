package com.gointegro.Tests.Backoffice.Account;

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

import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountStandard;
import com.gointegro.Pages.Backoffice_Account.EditAccountStandard;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditAccountStandard extends AllTestsAccount {
	
private WebDriver driver;

private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule 
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_account_standard_verify() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		assertEquals(accountname, edit.getName());
		assertEquals(salesforceid, edit.getSalesforceId());
	}
	
	@Test
	public void test_edit_account_standard_change_name() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String accountname2 = "Z"+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname2, salesforceid);
		
		detail = edit.selectSave();
		
		assertEquals(accountname2, detail.getName());
		assertEquals(salesforceid, detail.getSalesForceId());
		assertEquals("No", detail.getRegional());
		assertEquals("No", detail.getRegistration());
	}
	
	@Test
	public void test_edit_account_standard_name_empty() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount("", salesforceid);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", edit.getNameError());
	}
	
	@Test
	public void test_edit_account_standard_name_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String accountname2 = "Z"+DataGenerator.nombreFile();
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		detail = createAccount(accountname2, salesforceid2);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname, salesforceid2);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una cuenta con el nombre "+accountname+".", edit.getErrorMsj());
	}
	
	@Test
	public void test_edit_account_standard_change_salesforceid() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname, salesforceid2);
		
		detail = edit.selectSave();
		
		assertEquals(accountname, detail.getName());
		assertEquals(salesforceid2, detail.getSalesForceId());
		assertEquals("No", detail.getRegional());
		assertEquals("No", detail.getRegistration());
	}
	
	@Test
	public void test_edit_account_standard_salesforceid_empty() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname, "");
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El ID de Salesforce debe tener entre 15 y 18 caracteres.", edit.getSalesForceIdError());
	}
	
	@Test
	public void test_edit_account_standard_salesforceid_little() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 10);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname, salesforceid2);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El ID de Salesforce debe tener entre 15 y 18 caracteres.", edit.getSalesForceIdError());
	}
	
	@Test
	public void test_edit_account_standard_salesforceid_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String accountname2 = "Z"+DataGenerator.nombreFile();
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		detail = createAccount(accountname2, salesforceid2);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname2, salesforceid);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El ID de Salesforce ingresado pertenece a otra cuenta.", edit.getErrorMsj());
	}
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_account_standard_cancel() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String accountname2 = "Z"+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname2, salesforceid);
		
		edit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(accountname, detail.getName());
		assertEquals(salesforceid, detail.getSalesForceId());
		assertEquals("No", detail.getRegional());
		assertEquals("No", detail.getRegistration());
	}
	
	private AccountDetail createAccount(String accountname, String salesforceid) {
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		AccountDetail detail = standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
