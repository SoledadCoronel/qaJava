package com.gointegro.Tests.Profile;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.DataEditModal;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.WaitTool;

public class testEditProfileData extends TestBase {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = AllTestsProfile.getDriver();
	}

	
	@Test
	public void test_edit_profile_birthdate() {
		Random rand = new Random();
		String day = Integer.toString(rand.nextInt(31)+1);
		String date = day+"/10/1970";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		Profile profile = home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DataEditModal editModal = profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.completeBirthdate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(editModal.getBirthdate().contains(date));
	}
	
	
	@Test
	public void test_edit_profile_document() {
		Random rand = new Random();
		String documentId = Integer.toString(rand.nextInt(12345678));
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		Profile profile = home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DataEditModal editModal = profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.completeDocumentId(documentId);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(documentId, editModal.getDocument());
	}
	
	
	@Test
	public void test_edit_profile_time_zone() {
		String timeZone1 = "America/Noronha";
		String timeZone2 = "Pacific/Noumea";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		Profile profile = home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DataEditModal editModal = profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectTimeZone(timeZone1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(timeZone1, editModal.getTimeZone());
		
		//Cambio zona horaria
		editModal.selectTimeZone(timeZone2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(timeZone2, editModal.getTimeZone());
	}
	
	
	@Test
	public void test_edit_profile_change_language() {
		String lang1 = "Español";
		String lang2 = "English";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		Profile profile = home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DataEditModal editModal = profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectLanguage(lang2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(lang2, editModal.getLanguage());
		
		//Cambio zona horaria
		editModal.selectLanguage(lang1);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(lang1, editModal.getLanguage());
	}
	
	
	@Test
	public void test_edit_profile_press_cancel() {
		Random rand = new Random();
		String documentId = Integer.toString(rand.nextInt(12345678));
		String fullName[] = ConfigElements.getNombreUsuario().split("\\s");
		String name = fullName[0];
		String surname = fullName[1];
		String email = ConfigElements.getUsername();		
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		Profile profile = home.selectMyProfile();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DataEditModal editModal = profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.completeDocumentId(documentId);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		editModal.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		profile.selectDataEditModal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(name, editModal.getName());
		assertEquals(surname, editModal.getSurname());
		assertEquals(email, editModal.getEmail());
		assertNotEquals(documentId, editModal.getDocument());
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
