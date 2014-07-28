package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.DetailTerminalOverlay;
import com.gointegro.Pages.Backoffice_Benefits.NewStore;
import com.gointegro.Pages.Backoffice_Benefits.NewTerminalOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditTerminal extends TestBase {
	
	String terminal = "45";
	String operator = DataGenerator.nombreFile();
	String observation = DataGenerator.nombreFile();
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_edit_terminal_disabled() {
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement terminalElement = detail.getTerminalElement(terminal);
		
		assertFalse(detail.isTerminalActive(terminalElement));
	}
	
	
	@Test
	public void test_edit_terminal_number() {
		terminal = "86";
		
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createNumber(terminal);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isTerminalInList(terminal));
	}
	
	
	@Test
	public void test_edit_terminal_operator() {
		String newoperator = DataGenerator.nombreFile();
		
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createOperator(newoperator);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newoperator, detail.getTerminalOperator(terminal));
	}
	
	
	@Test
	public void test_edit_terminal_observation() {
		String newobservation = DataGenerator.nombreFile();
		
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createObservations(newobservation);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectTerminal(terminal);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailTerminalOverlay detailTerminal = PageFactory.initElements(driver, DetailTerminalOverlay.class);
		
		assertEquals(newobservation, detailTerminal.getObservations());
	}
	
	
	@Test
	public void test_edit_terminal_cancel() {
		String newterminal = "67";
		
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createNumber(newterminal);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectCancelOnEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isTerminalInList(newterminal));
	}
	
	
	@Test
	public void test_edit_terminal_check_modal() {
		terminal = "67";
		operator = DataGenerator.nombreFile();
		observation = DataGenerator.nombreFile();
		
		DetailStore detail = createTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectEditTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createTerminal(terminal, operator, observation, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectTerminal(terminal);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailTerminalOverlay detailTerminal = PageFactory.initElements(driver, DetailTerminalOverlay.class);
		
		assertEquals("No", detailTerminal.getActive());
		assertEquals(terminal, detailTerminal.getTerminalNumber());
		assertEquals(operator, detailTerminal.getOperator());
		assertEquals(observation, detailTerminal.getObservations());
	}
	
	private DetailStore createTerminal() {
		String type = "Local";
		String name = DataGenerator.nombreFile();
		String companyName = DataGenerator.nombreFile();
		String taxId = "654855551";
		String phone = "15 84546655";
		String email = "test@mail.com";
		String siteLink = ConfigElements.getUrlTest();
		String address = "Avenida Alvarez Thomas 198, Buenos Aires, Argentina";
		String zipCode = "1222";
		
		loginBackoffice(driver);
		
		DetailCompany detailCompany = PageFactory.initElements(driver, DetailCompany.class);
		detailCompany.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewStore newStore = detailCompany.selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailStore detail = newStore.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newTerminal.selectSave();
		
		return detail;
	}
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
