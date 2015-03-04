package com.gointegro.Tests.Login;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Login;

public class testLogin {
	
	private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void test() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		
	}

	@After
	public void tearDown() {
		//driver.quit
	}
}
