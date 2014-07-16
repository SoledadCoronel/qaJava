package com.gointegro.Tests.Backoffice.Account;

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

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Backoffice_Account.AccountDetail;
import com.gointegro.Pages.Backoffice_Account.CreateAccountHome;
import com.gointegro.Pages.Backoffice_Account.CreateAccountStandard;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewAccountRegionalChild extends TestBase{
	
	private WebDriver driver;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Rule 
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@Before
	public void setUp() {
		driver = AllTestsAccount.getDriver();
	}
	
	@Test
	public void test_new_account_regional_child() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
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
		
		AccountDetail detail = standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);

		assertEquals(ConfigElementsBO.getAccountRegionalFather(), detail.getAccountFather());		
	}
	
	@Test
	public void test_new_account_regional_child_no_exist() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
		CreateAccountHome home = PageFactory.initElements(driver, CreateAccountHome.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CreateAccountStandard standard = home.selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		standard.completeAccount(accountname, salesforceid);
		
		AccountOverlay overlay = standard.selectDependentAccounts();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		overlay.completeFilter(DataGenerator.nombreFile()+DataGenerator.nombreFile());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No se encontraron elementos para mostrar", overlay.getListEmpty());
	}
	
	@Test
	public void test_new_account_regional_child_cancel_overlay() {
		String accountname = "Z"+DataGenerator.nombreFile();
		String salesforceid = DataGenerator.nombreFile().substring(0, 15);
		
		loginBackoffice(driver);
		
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
		overlay.selectCancel();
		
		AccountDetail detail = standard.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);

		assertFalse(detail.isFatherAccountPresent());
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
