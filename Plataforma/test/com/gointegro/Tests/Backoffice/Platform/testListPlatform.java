package com.gointegro.Tests.Backoffice.Platform;

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
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.PersonalizationConfig;
import com.gointegro.Pages.Backoffice.RegistrationConfig;
import com.gointegro.Pages.Backoffice_Platform.CreatePlatform;
import com.gointegro.Pages.Backoffice_Platform.PlatformDetail;
import com.gointegro.Pages.Backoffice_Platform.PlatformList;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testListPlatform extends AllTestsBackofficePlatform {
	
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
	
	@Test
	public void test_list_platform_search_name() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(platformname, list.searchPlatformByName(platformname));
	}
	
	@Test
	public void test_list_platform_search_host() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(web.replace("http://", ""), list.searchPlatformByHost(web.replace("http://", "")));
	}
	
	@Test
	public void test_list_plaform_name_not_exist() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("No hay plataformas", list.searchPlatformByName(platformname+platformname));
	}
	
	@Test
	public void test_list_platform_name_cancel_search() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		int sizelist = list.getListSize();
		
		list.searchPlatformByName(platformname);
		
		list.selectCancelSearchName();
		WaitTool.waitForJQueryProcessing(driver, 15);
		
		assertEquals(sizelist, list.getListSize());
	}
	
	@Test
	public void test_list_platform_host_cancel_search() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		int sizelist = list.getListSize();
		
		list.searchPlatformByHost(web.replace("http://", ""));
		
		list.selectCancelSearchHost();
		WaitTool.waitForJQueryProcessing(driver, 15);
		
		assertEquals(sizelist, list.getListSize());
	}
	
	@Test
	public void test_list_platform_social_Enabled() {
		String platformname = DataGenerator.nombreFile();
		String web = "http://"+DataGenerator.nombreFile()+ConfigElementsBO.getHostName();
		
		loginBackoffice(driver);
		
		createPlatform(platformname, web);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(list.getSocialEnabled(platformname).isEmpty());
	}
	
	@Test
	public void test_list_platform_paging() {
		
		loginBackoffice(driver);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String text = list.getFirstItemInList();
		
		list.selectPaginate();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
	}
	
	@Test
	public void test_list_platform_page_change() {
		loginBackoffice(driver);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String text = list.getFirstItemInList();
		
		list.selectNextPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectFirstPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectLastPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
		text = list.getFirstItemInList();
		
		list.selectPrevPage();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(text, list.getFirstItemInList());
		
	}
	
	@Test
	public void test_list_platform_link_new_platform() {
		loginBackoffice(driver);
		
		PlatformList list = PageFactory.initElements(driver, PlatformList.class);
		list.open();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		list.selectCreateAction();
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/create", driver.getCurrentUrl());
	}
	
	private PlatformDetail createPlatform(String platformname, String web) {
		String filesize = "800";
		String videosize = "400";
		String storage = "2000";
		String industry = "Agro";
		String userRange = "0-100";
		boolean disablestatus = false;
		String googlea = DataGenerator.nombreFile();
		boolean uservisib = false;
		boolean socialact = true;
		boolean country = true;
		String timezone = "Africa/Dakar";
		String tyc = DataGenerator.nombreFile();
		String htmllog = DataGenerator.nombreFile();
		String uniquefield = "Documento";
		String logourl = ConfigElements.getFileImagen();
		String logofooter  = ConfigElements.getFileImagen();
		String banner = ConfigElements.getFileImagen();
		boolean showusermail = false;
		String backgroundcolor = "#aaaaaa";
		String BgColorHeaderFooter = "#aaaaaa";
		String FontColor = "#aaaaaa";
		String buttonFontColor = "#aaaaaa";
		String buttonBackgroundColor = "#aaaaaa";
		String defaultBorderColor = "#aaaaaa";
		String iconsColor = "White";
		boolean requireReg = true;
		boolean usescard = true;
		boolean usesbirthdate = true;
		boolean usesGender = true;
		boolean requireVerif = true;
		String verif1 = "Documento";
		String verif2 = "Email";
		String identity = "Id";
		boolean requirepass = true;
		boolean recoverpass = true;
		boolean isnominated = false;
		String htmlSignUp = DataGenerator.nombreFile();
		
		CreatePlatform newplat = PageFactory.initElements(driver, CreatePlatform.class);
		
		newplat.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newplat.completeBasicInformation(platformname, filesize, videosize, storage, web, industry, userRange, 
				disablestatus, googlea, uservisib, socialact, timezone, tyc, country, htmllog);
		
		PersonalizationConfig person = PageFactory.initElements(driver, PersonalizationConfig.class);
		
		person.completePersonalization(uniquefield, logourl, logofooter, banner, 
				showusermail, backgroundcolor, BgColorHeaderFooter, FontColor, buttonFontColor, buttonBackgroundColor, 
				defaultBorderColor, iconsColor);
		
		RegistrationConfig reg = PageFactory.initElements(driver, RegistrationConfig.class);
		
		reg.completeConfigRegistration(requireReg, usescard, usesbirthdate, usesGender, requireVerif, verif1, verif2, 
				identity, requirepass, recoverpass, isnominated, htmlSignUp);
		
		PlatformDetail detail = newplat.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return detail;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
