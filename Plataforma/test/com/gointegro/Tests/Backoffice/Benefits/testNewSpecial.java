package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBOBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailSpecial;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewSpecial;
import com.gointegro.Pages.Backoffice_Benefits.SpecialList;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewSpecial extends AllTestsBackOfficeBenefits {
	
	
	private WebDriver driver;

	String spanish = DataGenerator.nombreFile();
	String portuguese = DataGenerator.nombreFile();
	String english = DataGenerator.nombreFile();
	String date = DataGenerator.fechamanana();
	String image = ConfigElements.getFileImagen();
	String benefit = ConfigElementsBOBenefits.getCompanyName();
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}

	
	@Test
	public void test_new_special() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSearchCompany(benefit);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectFirstBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.addBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailSpecial detail = newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(spanish, detail.getNameES());
		assertEquals(portuguese, detail.getNamePT());
		assertEquals(english, detail.getNameEN());
		assertEquals("Si", detail.getActive());
		//assertEquals(date, detail.getValidUntil());
		assertTrue(detail.getImage().endsWith(".jpg"));
		assertTrue(detail.isBenefitInList());
	}
	
	
	@Test
	public void test_new_special_save_and_new() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSearchCompany(benefit);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectFirstBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.addBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(driver.getCurrentUrl().contains("/collection/create"));
		assertTrue(newSpecial.getSpanish().isEmpty());
	}
	
	
	@Test
	public void test_new_special_press_cancel() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(special.getSpecialURL(), driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_new_special_empty_spanish() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial("", portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español es obligatorio", newSpecial.getSpanishError());	
	}
	
	
	@Test
	public void test_new_special_empty_portuguese() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, "", english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Portugués es obligatorio", newSpecial.getPortugueseError());
	}
	
	
	@Test
	public void test_new_special_empty_english() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, "", date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Inglés es obligatorio", newSpecial.getEnglishError());	
	}
	
	
	@Test
	public void test_new_special_spanish_max_char() {
		String largeText = StringUtils.getTextoLargo(); 
				
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(largeText, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Español no puede superar los 80 caracteres", newSpecial.getSpanishError());
	}
	
	
	@Test
	public void test_new_special_portugues_max_char() {
		String largeText = StringUtils.getTextoLargo(); 
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, largeText, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Portugués no puede superar los 80 caracteres", newSpecial.getPortugueseError());
	}
	
	
	@Test
	public void test_new_special_english_max_char() {
		String largeText = StringUtils.getTextoLargo(); 
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, largeText, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El campo Categoría en Inglés no puede superar los 80 caracteres", newSpecial.getEnglishError());
	}
	
	
	@Test
	public void test_new_special_disabled() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.completeSearchCompany(benefit);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectFirstBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newSpecial.addBenefit();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailSpecial detail = newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No", detail.getActive());
	}
	
	
	@Test
	public void test_new_special_expiration_date_yesterday() {
		date = DateTool.getYesterday();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La fecha de vencimiento no puede ser menor a la fecha de hoy", newSpecial.getDateError());
	}
	
	
	@Test
	public void test_new_special_without_benefit() {
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, image, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El especial debe tener al menos un beneficio relacionado", newSpecial.getBenefitsError());
	}
	
	
	@Test
	public void test_new_special_small_image() {
		image = ConfigElements.getFileImageSmall();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SpecialList special = home.selectAdminSpecials();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewSpecial newSpecial = special.selectNewSpecial();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.createSpecial(spanish, portuguese, english, date, "", false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newSpecial.imageUploadSmall(image);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El tamaño de la imagen debe ser mayor a 973x267", newSpecial.getImageError());
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
