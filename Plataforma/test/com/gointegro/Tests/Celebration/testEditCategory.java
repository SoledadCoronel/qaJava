package com.gointegro.Tests.Celebration;

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
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Celebration.NewCategoryOverlay;
import com.gointegro.Pages.Celebration.NewEvent;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditCategory extends AllTestsCelebration {
	
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

	@Test(groups = {"FunctTest"})
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
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categorynameedited));
		assertFalse(admincategory.isCategoryInList(categoryname));
	}
	
	@Test
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
	
	@Test
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
	
	@Test
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
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre de la categoría ya existe", admincategory.getSaveError());
	}
	
	@Test(groups = {"FunctTest"})
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
	
	@Test
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
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(admincategory.isCategoryInList(categorynameedited));
		assertTrue(admincategory.getCategoryAutomationText(categorynameedited).contains("Fecha de nacimiento"));
		assertFalse(admincategory.isCategoryInList(categoryname));
		
	}
	
	@Test
	public void test_edit_category_with_events() {
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  DataGenerator.nombreFile();
		String categoryname = DataGenerator.nombreFile();
		String descriptiontext = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String newcategoryname = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewEvent newevent = home.selectNewEvent();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(categoryname, false);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.selectNewEvent();
		
		home = newevent.completeCelebration(categoryname, date, celebrationtitle, descriptiontext, collaborator);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
		
		home.open();
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admincategory.selectCategoryEdit(categoryname);
		
		admincategory.editCategory(newcategoryname, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		home.open();
		
		admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(admincategory.isCategoryInList(newcategoryname));
		assertFalse(admincategory.isCategoryInList(categoryname));
		
		home.open();
		
		celebrationlist = home.selectCategoryInSideBar(newcategoryname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(newcategoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(descriptiontext, celebrationlist.getDescription());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(date, celebrationlist.getTodayDate());
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
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
