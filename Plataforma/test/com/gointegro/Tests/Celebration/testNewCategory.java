package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewCategory {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Test
	public void test_new_category_category_menu() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.isCategoryInSideBar(categoryname));
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_new_category_new_event() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = newevent.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newevent.getCategoryPresent().contains(categoryname));
		
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categoryname));
	}
	
	@Test
	public void test_new_category_category_admin() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(admincategory.isCategoryInList(categoryname));
		
		home.open();
		
		assertTrue(home.isCategoryInSideBar(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_new_category_overlay_empty() {
		String categoryname = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría no puede ser vacío", newcategory.getCategoryNameError());
		assertEquals("Ocurrió un error al crear la categoría", newcategory.getSaveError());
	}
	
	@Test
	public void test_new_category_admin_empty() {
		String categoryname = "";
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría no puede ser vacío", admincategory.getCategoryNameError());
		assertEquals("Ocurrió un error al crear la categoría", admincategory.getSaveError());
	}
	
	@Test
	public void test_new_category_overlay_lot_of_characters() {
		String categoryname = StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", newcategory.getCategoryNameError());
		assertEquals("Ocurrió un error al crear la categoría", newcategory.getSaveError());
	}
	
	@Test
	public void test_new_category_admin_lot_of_characters() {
		String categoryname = StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría debe contener como máximo 80 caracteres", admincategory.getCategoryNameError());
		assertEquals("Ocurrió un error al crear la categoría", admincategory.getSaveError());
	}
	
	@Test
	public void test_new_category_overlay_repeated() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", newcategory.getSaveError());
	}
	
	@Test
	public void test_new_category_admin_repeated() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre de la categoría ya existe", admincategory.getSaveError());
	}
	
	@Test
	public void test_new_category_automation_overlay() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.createCategory(categoryname,true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.isCategoryInSideBar(categoryname));
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.getCategoryAutomationText(categoryname).contains("Fecha de nacimiento"));
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_new_category_automation_admin() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.createCategory(categoryname,true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(admincategory.isCategoryInList(categoryname));
		assertTrue(admincategory.getCategoryAutomationText(categoryname).contains("Fecha de nacimiento"));
		
		home.open();
		
		assertTrue(home.isCategoryInSideBar(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_new_category_cancel_overlay() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewCategoryOverlay newcategory = home.selectNewCategory();
		
		newcategory.cancelCreate(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(home.isCategoryInSideBar(categoryname));
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admincategory.isCategoryInList(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@Test
	public void test_new_category_cancel_admin() {
		String categoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.cancelCreateCategory(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(admincategory.isCategoryInList(categoryname));
		
		home.open();
		
		assertFalse(home.isCategoryInSideBar(categoryname));
		
		NewEvent newevent = home.selectNewEvent();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(newevent.getCategoryPresent().contains(categoryname));
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
