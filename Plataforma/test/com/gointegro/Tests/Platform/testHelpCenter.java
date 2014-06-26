package com.gointegro.Tests.Platform;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.HelpCenter;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testHelpCenter extends TestBase {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsPlatform.getDriver();
	}

	@Test
	public void test_helpcenter_contact() {
		String phone = "1555464552";
		String reason = "Sugerencia";
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
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
