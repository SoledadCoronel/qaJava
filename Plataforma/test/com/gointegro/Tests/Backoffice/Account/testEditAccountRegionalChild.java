package com.gointegro.Tests.Backoffice.Account;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountStandard;
import com.gointegro.Pages.Backoffice_Account.EditAccountStandard;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditAccountRegionalChild extends TestBase{
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsAccount.getDriver();
	}
	
	@Test
	public void test_edit_account_child_erase_child_relation() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		AccountOverlay overlay = edit.selectDependentAccounts();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		overlay.completeFilter(ConfigElementsBO.getAccountRegionalFather());
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectItem();
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectAdd();
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isFatherAccountPresent());
		
		//Bloqueado por https://gointegro.atlassian.net/browse/PLATAFORMAII-3366
	}
	
	@Test
	public void test_edit_account_child_cancel() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		AccountOverlay overlay = edit.selectDependentAccounts();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		overlay.completeFilter(ConfigElementsBO.getAccountRegionalFather());
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectItem();
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectCancel();
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountRegionalFather(), detail.getAccountFather());
	}
	
	@Test
	public void test_edit_account_child_change_father() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		AccountOverlay overlay = edit.selectDependentAccounts();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		overlay.completeFilter(ConfigElementsBO.getAccountRegionalFather2());
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectItem();
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectAdd();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getAccountRegionalFather2(), detail.getAccountFather());
	}
	
	@Test
	public void test_edit_account_child_verify_fields() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		assertEquals(accountname, edit.getName());
		assertEquals(salesforceid, edit.getSalesforceId());
		assertEquals(ConfigElementsBO.getAccountRegionalFather(), edit.getPrincipalAccount());
	}
	
	@Test
	public void test_edit_account_child_name_empty() {
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
	public void test_edit_account_child_name_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(ConfigElementsBO.getAccountRegionalFather(), salesforceid);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ya existe una cuenta con el nombre "+ConfigElementsBO.getAccountRegionalFather()+".", edit.getErrorMsj());
	}
	
	@Test
	public void test_edit_account_child_salesforceid_empty() {
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
	public void test_edit_account_child_salesforceid_exist() {
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
	
	@Test
	public void test_edit_account_child() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		String accountname2 = "Z"+DataGenerator.nombreFile();
		String salesforceid2 = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		AccountDetail detail = createAccount(accountname, salesforceid);
		
		EditAccountStandard edit = detail.selectEdit();
		
		edit.completeAccount(accountname2, salesforceid2);
		
		detail = edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(accountname2, detail.getName());
		assertEquals(salesforceid2, detail.getSalesForceId());
	}
	
	private AccountDetail createAccount(String accountname, String salesforceid) {
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		AccountOverlay overlay = standard.selectDependentAccounts();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		overlay.completeFilter(ConfigElementsBO.getAccountRegionalFather());
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectItem();
		WaitTool.waitForJQueryProcessing(driver, 10);
		overlay.selectAdd();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AccountDetail detail = standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail;
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
