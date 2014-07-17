package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewSpecial;
import com.gointegro.Pages.Backoffice_Benefits.SpecialList;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewSpecial extends TestBase {
	
	
	private WebDriver driver;

	String spanish = DataGenerator.nombreFile();
	String portuguese = DataGenerator.nombreFile();
	String english = DataGenerator.nombreFile();
	String date = DataGenerator.fechaactual();
	String image = ConfigElements.getFileImagen();
	String benefit = "";
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}

	@Ignore //FALTA ASSERT
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
		
		newSpecial.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		
	}
	
	@Ignore //FALTA ASSERT
	@Test
	public void test_new_special_save_and_new() {
		
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
	
	@Ignore
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
	
	@Ignore
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
	
	@Ignore //FALTA ASSERT
	@Test
	public void test_new_special_disabled() {
		
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
		image = ConfigElements.getFileImagen();
		
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
		
		assertEquals("El tamaño de la imagen debe ser mayor a 973x267", newSpecial.getImageError());
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
