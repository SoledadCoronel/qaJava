package com.gointegro.Tests.Collaborators;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Collaborators.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;

public class testSearchCollaborator extends TestBase {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsCollaborators.getDriver();
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
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
