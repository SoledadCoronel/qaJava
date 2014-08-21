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

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.AccountList;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountStandard;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testListAccount extends AllTestsAccount {
	
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
	
	@Test
	public void test_list_account_search() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		createAccount(accountname, salesforceid);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals(accountname, list.searchAccountByName(accountname));	
	}
	
	@Test
	public void test_list_account_search_no_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals("No hay cuentas", list.searchAccountByName(accountname+accountname));
	}
	
	@Test
	public void test_list_account_cancel_search() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		createAccount(accountname, salesforceid);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		int sizelist = list.getListSize();
		
		list.searchAccountByName(accountname);
		
		list.selectCancelSearchName();
		WaitTool.waitForJQueryProcessing(driver, 15);
		
		assertEquals(sizelist, list.getListSize());
	}
	
	@Test
	public void test_list_account_paging() {
		loginBackoffice(driver);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		String text = list.getFirstItemInList();
		
		list.selectPaginate();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
	}
	
	@Test
	public void test_list_account_change_page() {
		loginBackoffice(driver);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		String text = list.getFirstItemInList();
		
		list.selectNextPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectFirstPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectLastPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectPrevPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
	}
	
	@Test
	public void test_list_account_regional_father() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		createAccount(accountname, salesforceid);
		
		AccountList list = PageFactory.initElements(driver, AccountList.class);
		list.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		list.searchAccountByName(accountname);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertEquals(ConfigElementsBO.getAccountRegionalFather(), list.getAccountFather(accountname));
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
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
