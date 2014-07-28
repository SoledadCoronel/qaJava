package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailTerminalOverlay extends PageBase {
	
	@FindBy(xpath = "//div[@class='modal-body']/section/div/div/table/tbody/tr[1]/td[2]")
	WebElement active;
	
	@FindBy(xpath = "//div[@class='modal-body']/section/div/div/table/tbody/tr[2]/td[2]")
	WebElement terminalNumber;
	
	@FindBy(xpath = "//div[@class='modal-body']/section/div/div/table/tbody/tr[3]/td[2]")
	WebElement operator;
	
	@FindBy(xpath = "//div[@class='modal-body']/section/div/div/table/tbody/tr[4]/td[2]")
	WebElement observation;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailTerminalOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener Activo
	 * 
	 * @return String
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Obtener Número de terminal
	 * 
	 * @return String
	 */
	public String getTerminalNumber() {
		return terminalNumber.getText();
	}
	
	/**
	 * Obtener Operador
	 * 
	 * @return String
	 */
	public String getOperator() {
		return operator.getText();
	}
	
	/**
	 * Obtener Observaciones
	 * 
	 * @return String
	 */
	public String getObservations() {
		return observation.getText();
	}
}
