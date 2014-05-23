package com.gointegro.Tests.Celebration;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Celebration.CelebrationList;
import com.gointegro.Pages.Celebration.DatePicker;
import com.gointegro.Pages.Celebration.HomeCelebrations;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Profile.DataEditModal;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testCategoryAutomatic {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsCelebration.getDriver();
	}

	@Test
	public void test() {
		String categoryname = DataGenerator.nombreFile();
		String collaborator = ConfigElements.getNombreUsuario();
		String celebrationtitle =  "Cumpleaños de "+ConfigElements.getNombreUsuario();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());

		String birthdate = getBirthdate();
		
		HomeCelebrations home = PageFactory.initElements(driver, HomeCelebrations.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminCategory admincategory = home.selectAdminCategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createCategory(admincategory, categoryname);
		
		wait1Minute();
		
		home.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CelebrationList celebrationlist = home.selectCategoryInSideBar(categoryname);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DatePicker datepicker = PageFactory.initElements(driver, DatePicker.class);
		datepicker.selectMonth(birthdate);
		datepicker.selectDay(birthdate);
		
		assertEquals(categoryname, celebrationlist.getCategory());
		assertEquals(celebrationtitle, celebrationlist.getTitle());
		assertEquals(collaborator, celebrationlist.getCollaboratonName());
		assertEquals(collaborator, celebrationlist.getImgAlt());
		assertEquals(birthdate, celebrationlist.getTodayDate());
	}
	
	/**
	 * Crea una categoria automatica
	 * 
	 * @param admincategory
	 * @param categoryname
	 */
	private void createCategory(AdminCategory admincategory, String categoryname) {
		admincategory.createCategory(categoryname,true);
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Obtiene la fecha de nacimiento de la persona
	 * 
	 * @return String
	 */
	private String getBirthdate() {
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		DataEditModal dataeditmodal = profile.selectDataEditModal();
		return dataeditmodal.getBirthdate();
	}
	
	private void wait1Minute() {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
		}
	}

}
