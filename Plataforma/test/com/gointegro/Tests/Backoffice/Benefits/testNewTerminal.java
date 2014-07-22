package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice_Benefits.DetailStore;
import com.gointegro.Pages.Backoffice_Benefits.NewTerminalOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewTerminal extends TestBase {
	
	String terminal = "45";
	String operator = DataGenerator.nombreFile();
	String observation = DataGenerator.nombreFile();
	
	private WebDriver driver;
		
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_new_terminal() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.isTerminalInList(terminal));
	}
	
	@Ignore
	@Test
	public void test_new_terminal_disabled() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(detail.isTerminalInList(terminal));
	}
	
	@Ignore
	@Test
	public void test_new_terminal_number_empty() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal("", operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("", newTerminal.getNumberError());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_number_max_char() {
		terminal = StringUtils.getTextoLargo();
		
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("", newTerminal.getNumberError());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_operator_empty() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, "", observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("", newTerminal.getOperatorError());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_operator_max_char() {
		operator = StringUtils.getTextoLargo();
		
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("", newTerminal.getOperatorError());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_observations_max_char() {
		observation = StringUtils.getTextoLargo();
		
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("", newTerminal.getObservationError());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_save_and_new() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectSaveAndNew();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(newTerminal.isNumberEmpty());
	}
	
	@Ignore
	@Test
	public void test_new_terminal_cancel() {
		DetailStore detail = PageFactory.initElements(driver, DetailStore.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewTerminalOverlay newTerminal = detail.selectNewTerminal();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.createTerminal(terminal, operator, observation, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newTerminal.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertFalse(detail.isTerminalInList(terminal));
	}
	
	
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
