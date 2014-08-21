package com.gointegro.Tests.Collaborators;

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

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Collaborators.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.WaitTool;

public class testSearchCollaborator extends AllTestsCollaborators {
	
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
	public void test_search_by_first_name() {
		String nameParts[] = ConfigElements.getNombreUsuario().split("\\s");
		String name = nameParts[0];
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);

		home.searchFullName(name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(home.isUserInList(name));
	}
	
	
	@Test
	public void test_search_by_email() {
		String email = ConfigElements.getUsername();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);

		home.searchEmail(email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(home.isUserInList(email));
	}
	
	
	@Test
	public void test_search_go_to_user_profile() {
		String email = ConfigElements.getUsername();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);

		home.searchEmail(email);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectCollaborator(email);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		String userProfileURL = ConfigElements.getURL() + "/profile/" + ConfigElements.getSlugMiPerfil();
		
		assertEquals(userProfileURL, driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_search_pagination() {
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);

		home.selectPaginate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(home.isSecondPageActive());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
