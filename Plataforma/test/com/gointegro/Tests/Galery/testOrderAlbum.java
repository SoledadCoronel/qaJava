package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gointegro.Pages.Galery.AdminAlbum;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testOrderAlbum extends TestBase{
	
	private WebDriver driver;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}

	@Test
	public void test_order_album() {
		String albumname = DataGenerator.nombreFile();
		String albumname2 = DataGenerator.nombreFile();
		String albumname3 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.changeOrder(albumname, albumname2, albumname3);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(2, admin.getElementIdInList(albumname));
		assertEquals(0, admin.getElementIdInList(albumname2));
		assertEquals(1, admin.getElementIdInList(albumname3));
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(3, home.getElementIdInList(albumname));
		assertEquals(1, home.getElementIdInList(albumname2));
		assertEquals(2, home.getElementIdInList(albumname3));
		
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
