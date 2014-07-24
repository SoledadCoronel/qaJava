package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class NewTerminalOverlay extends PageBase {
	
	@FindBy(xpath = "//div[contains(@class,'form-active')]/div/div/span/input")
	WebElement active;
	
	@FindBy(id = "number")
	WebElement number;
	
	@FindBy(id = "operator")
	WebElement operator;
	
	@FindBy(id = "observations")
	WebElement observations;
	
	@FindBy(xpath = "//div[contains(@class,'form-number')]/div/div/div")
	WebElement numberError;
	
	@FindBy(xpath = "//div[contains(@class,'form-operator')]/div/div/div")
	WebElement operatorError;
	
	@FindBy(xpath = "//div[contains(@class,'form-observations')]/div/div/div")
	WebElement observationsError;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewTerminalOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar Número de terminal
	 * 
	 * @param terminal
	 */
	public void createNumber(String terminal) {
		number.clear();
		number.sendKeys(terminal);
	}
	
	/**
	 * Devuelve el Número de terminal
	 * 
	 * @return boolean
	 */
	public boolean isNumberEmpty() {
		return number.getText().isEmpty();
	}
	
	/**
	 * Completar Operador
	 * 
	 * @param name
	 */
	public void createOperator(String name) {
		operator.clear();
		operator.sendKeys(name);
	}
	
	/**
	 * Completar Observaciones
	 * 
	 * @param obs
	 */
	public void createObservations(String obs) {
		observations.clear();
		observations.sendKeys(obs);
	}
	
	/**
	 * Crear Terminal
	 * 
	 * @param number
	 * @param operator
	 * @param observation
	 * @param isDisabled
	 */
	public void createTerminal(String number, String operator, String observation, boolean isDisabled) {
		createNumber(number);
		createOperator(operator);
		createObservations(observation);
		
		if(isDisabled) {
			selectActive();
		}
	}
	
	/**
	 * Obtener el mensaje de Error de terminal
	 * 
	 * @param terminal
	 */
	public String getNumberError() {
		return numberError.getText();
	}
	
	/**
	 * Obtener el mensaje de Error de Operador
	 * 
	 * @param terminal
	 */
	public String getOperatorError() {
		return operatorError.getText();
	}
	
	/**
	 * Obtener el mensaje de Error de Observaciones
	 * 
	 * @param terminal
	 */
	public String getObservationError() {
		return observationsError.getText();
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailCompany
	 */
	public void selectSave() {
		save.click();
	}
	
	/**
	 * Seleccionar el botón Guardar y nuevo
	 */
	public void selectSaveAndNew() {
		saveAndNew.click();
	}
	
	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancel() {
		cancel.click();
	}
}
