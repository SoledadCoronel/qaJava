package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

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
import com.gointegro.Util.WaitTool;

public class testEditFile extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test(groups = {"BOFunctTest"})
	public void test_edit_file_disabled() {
		DetailBenefits detail = createFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewFileOverlay newFile = detail.editFirstFile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isFileEnabled());	
	}
	
	
	@Test
	public void test_edit_file_name() {
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewFileOverlay newFile = detail.editFirstFile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createName(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isFileInList(title));
	}
	
	
	@Test
	public void test_edit_file_description() {
		String desctext = DataGenerator.nombreFile();
		
		DetailBenefits detail = createFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewFileOverlay newFile = detail.editFirstFile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createDescription(desctext);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isFileInList(desctext));
	}
	
	
	@Test
	public void test_edit_file_document() {
		String fileupload = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewFileOverlay newFile = detail.editFirstFile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.fileUpload(fileupload);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.getFileLink().isEmpty());
	}
	
	
	@Test
	public void test_edit_file_cancel() {
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createFile();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewFileOverlay newFile = detail.editFirstFile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createName(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isFileInList(title));
	}
	
	private DetailBenefits createFile() {
		String owner = DataGenerator.nombreFile();
		String name = DataGenerator.nombreFile();
		String targetUser = "Clientes";
		String discount = "2x1";
		String validFrom = DataGenerator.fechaactual();
		String fileupload = ConfigElements.getFileImagen();
		String benefitCode = "54aAsd4542";
		String title = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		loginBackoffice(driver);
		
		DetailCompany detailCompany = PageFactory.initElements(driver, DetailCompany.class);
		detailCompany.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewBenefits newBenefit = detailCompany.selectNewBenefit(); 
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newFile.selectSave();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
