package com.gointegro.Tests.Platform;

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

import com.gointegro.Pages.Platform.HelpCenter;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testHelpCenter extends AllTestsPlatform {
	
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
	public void test_helpcenter_contact() {
		String phone = "1555464552";
		String subject = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		login(driver);
		
		HelpCenter help = PageFactory.initElements(driver, HelpCenter.class);
		help.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		help.completeForm(phone, subject, description);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		help.selectSend();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Su mensaje fue enviado exitósamente.", help.getAlert());
	}
	
	@Test
	public void test_helpcenter_contact_not_logged() {
		String name = DataGenerator.nombreFile();
		String surname = DataGenerator.nombreFile();
		String email = "test@gmail.com";
		String document = "23423434";
		String phone = "1555464552";
		String subject = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		
		HelpCenter help = PageFactory.initElements(driver, HelpCenter.class);
		help.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		help.completeFormNotLogged(name, surname, email, document, phone, subject, description);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		help.selectSend();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(help.getAlert().isEmpty());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
