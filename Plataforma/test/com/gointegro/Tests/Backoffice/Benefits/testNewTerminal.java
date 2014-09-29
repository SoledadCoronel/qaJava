package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.NewStore;
import com.gointegro.Pages.Backoffice_Benefits.NewTerminalOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewTerminal extends AllTestsBackOfficeBenefits {
	
	String terminal = "45";
	String operator = DataGenerator.nombreFile();
	String observation = DataGenerator.nombreFile();
	
	private WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_new_terminal() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.isTerminalInList(terminal));
	}
	
	
	@Test
	public void test_new_terminal_disabled() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WebElement terminalElement = detail.getTerminalElement(terminal);
		
		assertFalse(detail.isTerminalActive(terminalElement));
	}
	
	
	@Test
	public void test_new_terminal_number_empty() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal("", operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Este campo no puede estar vacío", newTerminal.getNumberError());
	}
	
	
	@Test
	public void test_new_terminal_number_max_char() {
		String newterminal = StringUtils.getTextoLargo();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(newterminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El número de terminal no puede superar los 80 caracteres", newTerminal.getNumberError());
	}
	
	
	@Test
	public void test_new_terminal_operator_empty() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, "", observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Este campo no puede estar vacío", newTerminal.getOperatorError());
	}
	
	
	@Test
	public void test_new_terminal_operator_max_char() {
		String newoperator = StringUtils.getTextoLargo();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, newoperator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El operador de la terminal no puede superar los 80 caracteres", newTerminal.getOperatorError());
	}
	
	
	@Test
	public void test_new_terminal_observations_max_char() {
		String newobservation = StringUtils.getTextoLargo();
		
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, newobservation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El campo observaciones no puede superar los 500 caracteres", newTerminal.getObservationError());
	}
	
	
	@Test(groups = {"BOFunctTest"})
	public void test_new_terminal_save_and_new() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newTerminal.isNumberEmpty());
	}
	
	
	@Test(groups = {"BOFunctTest"})
	public void test_new_terminal_cancel() {
		DetailStore detail = createStore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(detail.isTerminalInList(terminal));
	}
	
	
	private DetailStore createStore() {
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
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewStore newStore = detail.selectNewStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newStore.createNewStore(type, name, phone, companyName, taxId, email, siteLink, address, zipCode, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newStore.selectContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return newStore.selectSave();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
