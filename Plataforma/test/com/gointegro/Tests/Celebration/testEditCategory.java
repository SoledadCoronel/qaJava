package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditCategory {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Ignore
	public void test_edit_category() {
		String categoryname = DataGenerator.nombreFile();
		String categorynameedited = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.editCategory(categorynameedited, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categorynameedited));
		assertFalse(admincategory.isCategoryInList(categoryname));
	}
	
	@Ignore
	public void test_edit_category_empty() {
		String categoryname = DataGenerator.nombreFile();
		String categorynameedited = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.editCategory(categorynameedited, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría no puede ser vacío", admincategory.getCategoryNameError());
		assertEquals("Ocurrió un error al editar la categoría", admincategory.getSaveError());
	}
	
	@Ignore
	public void test_edit_category_lot_of_characters() {
		String categoryname = DataGenerator.nombreFile();
		String categorynameedited = StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.editCategory(categorynameedited, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", admincategory.getCategoryNameError());
		assertEquals("Ocurrió un error al editar la categoría", admincategory.getSaveError());
	}
	
	@Ignore
	public void test_edit_category_repeated() {
		String categoryname = DataGenerator.nombreFile();
		String categoryname2 = 	DataGenerator.nombreFile();	
		String categoryname3 = categoryname;
		
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		createCategory(categoryname2, false);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname2);
		
		admincategory.editCategory(categoryname3, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", admincategory.getSaveError());
	}
	
	@Ignore
	public void test_edit_category_cancel() {
		String categoryname = DataGenerator.nombreFile();
		String categorynameedited = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.cancelEditCategory(categorynameedited);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admincategory.isCategoryInList(categorynameedited));
		assertTrue(admincategory.isCategoryInList(categoryname));
	}
	
	@Ignore
	public void test_edit_category_automation() {
		String categoryname = DataGenerator.nombreFile();
		String categorynameedited = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		createCategory(categoryname, false);
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.editCategory(categorynameedited, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categorynameedited));
		assertTrue(admincategory.getCategoryAutomationText(categorynameedited).contains("Fecha de nacimiento"));
		assertFalse(admincategory.isCategoryInList(categoryname));
		
	}
	
	@Test
	public void test_edit_category_with_events() {
		// TODO
	}
	

	private void createCategory (String categoryname, boolean isAutomation) {
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,isAutomation);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.isCategoryInSideBar(categoryname));
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
