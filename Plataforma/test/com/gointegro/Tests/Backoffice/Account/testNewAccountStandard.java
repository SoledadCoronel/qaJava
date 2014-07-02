package com.gointegro.Tests.Backoffice.Account;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountStandard;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewAccountStandard extends TestBase{
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsAccount.getDriver();
	}
	
	@Test
	public void test_new_account_standard() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		AccountDetail detail = standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(accountname, detail.getName());
		assertEquals(salesforceid, detail.getSalesForceId());
		assertEquals("No posee", detail.getWebSite());
		assertEquals("No", detail.getRegional());
		assertEquals("No", detail.getRegistration());
	}
	
	@Test
	public void test_new_account_standard_name_empty() {
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount("", salesforceid);
		
		standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Required", standard.getNameError());
	}
	
	@Test
	public void test_new_account_standard_name_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid2);
		
		standard.selectSave();
		
		assertEquals("Ya existe una cuenta con el nombre "+accountname+".", standard.getErrorMsj());
	}
	
	@Test
	public void test_new_account_standard_salesforceid_empty() {
		String accountname = "Z"+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, "");
		
		standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El ID de Salesforce debe tener entre 15 y 18 caracteres.", standard.getSalesForceIdError());
	}
	
	@Test
	public void test_new_account_standard_saleforceid_litte() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 10);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El ID de Salesforce debe tener entre 15 y 18 caracteres.", standard.getSalesForceIdError());
	}
	
	@Test
	public void test_new_account_standard_salesforceid_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String accountname2 = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname2, salesforceid);
		
		standard.selectSave();
		
		assertEquals("El ID de Salesforce ingresado pertenece a otra cuenta.", standard.getErrorMsj());
	}
	
	@Test
	public void test_new_account_standard_cancel() {
		loginBackoffice(driver);
		
		String url = driver.getCurrentUrl();
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(url, driver.getCurrentUrl());
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
