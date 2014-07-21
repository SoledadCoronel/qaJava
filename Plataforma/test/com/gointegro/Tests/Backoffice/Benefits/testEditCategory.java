package com.gointegro.Tests.Backoffice.Benefits;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;

public class testEditCategory extends TestBase {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	@Ignore
	@Test
	public void test_edit_category_disabled() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_enabled() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_portuguese() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_spanish() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_english() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_add_tags() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_tags_empty() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_save_and_new() {
		
	}
	
	@Ignore
	@Test
	public void test_edit_category_cancel() {
		
	}
	
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
