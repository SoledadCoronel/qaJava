package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class HelpCenter extends PageBase {
	
	
	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(id = "reason")
	WebElement reason;
	
	@FindBy(id = "issue")
	WebElement subject;
	
	@FindBy(id = "description")
	WebElement description;

	@FindBy(id = "submit")
	WebElement sendBtn;

	@FindBy(id = "cancel")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@id='message']/div")
	WebElement alertSuccess;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HelpCenter(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/help-center/";
	}
	
	/**
	 * Completar el Teléfono
	 * 
	 * @param num
	 */
	public void completePhone(String num) {
		phone.clear();
		phone.sendKeys(num);
	}
	
	/**
	 * Seleccionar Motivo del caso
	 * 
	 * @param text
	 */
	public void selectReason() {
		Select option = new Select(reason);
		option.selectByIndex(1);
	}
	
	/**
	 * Completar el Assunto
	 * 
	 * @param text
	 */
	public void completeSubject(String text) {
		subject.clear();
		subject.sendKeys(text);
	}
	
	/**
	 * Completar la Descripción
	 * 
	 * @param text
	 */
	public void completeDescription(String text) {
		description.clear();
		description.sendKeys(text);
	}
	
	/**
	 * Completar formulario
	 * @param phone
	 * @param reason
	 * @param subj
	 * @param desc
	 */
	public void completeForm(String phone, String subj, String desc) {
		completePhone(phone);
		selectReason();
		completeSubject(subj);
		completeDescription(desc);
	}
	
	/**
	 * Seleccionar Enviar
	 */
	public void selectSend() {
		sendBtn.click();
	}
	
	/**
	 * Seleccionar Volver
	 */
	public void selectCancel() {
		cancelBtn.click();
	}

	/**
	 * Obtener el alerta de succeso
	 * 
	 * @return String
	 */
	public String getAlert() {
		return alertSuccess.getText();
	}
}
