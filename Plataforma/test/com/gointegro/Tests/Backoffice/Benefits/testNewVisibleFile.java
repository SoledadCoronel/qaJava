package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.NewBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewFileOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewVisibleFile extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_new_file_name_empty() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isVisibleFileInList(name));
		assertTrue(detail.isVisibleFileInList(desc));
		assertTrue(detail.isVisibleFileEnabled());
	}
	
	
	@Test
	public void test_new_file_name_max_char() {
		String name = StringUtils.getTextoLargo();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre no puede superar los 80 caracteres", newFile.getNameErrorMsg());
	}
	
	
	@Test
	public void test_new_file_description_max_char() {
		String name = DataGenerator.nombreFile();
		String desc = StringUtils.getTextoLargo();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La descripción no puede superar los 500 caracteres", newFile.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_new_file_empty() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, "", true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe subir un archivo", newFile.getFileErrorMsg());
	}
	
	
	@Test(groups = {"BOFunctTest"})
	public void test_new_file_cancel() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isVisibleFileInList(name));
	}
	
	
	@Test
	public void test_new_file_check_link() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewVisibleFiles();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.getVisibleFileLink().isEmpty());
	}
	
	private DetailBenefits createBenefit() {
		String owner = DataGenerator.nombreFile();
		String name = DataGenerator.nombreFile();
		String targetUser = "Clientes";
		String discount = "2x1";
		String validFrom = DataGenerator.fechaactual();
		String fileupload = ConfigElements.getFileImagen();
		String benefitCode = "54aAsd4542";
		String title = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewBenefits newBenefit = detail.selectNewBenefit(); 
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newBenefit.selectSave();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
