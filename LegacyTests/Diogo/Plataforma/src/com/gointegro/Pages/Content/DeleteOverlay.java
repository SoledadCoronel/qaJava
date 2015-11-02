package com.gointegro.Pages.Content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteOverlay extends com.gointegro.Pages.Celebration.DeleteOverlay {
	
	@FindBy(xpath = "//*[@id='delete-modal']/div[2]/div")
	WebElement alertMessage;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DeleteOverlay(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Devuelve el mensage de categoria con contenido
	 * 
	 * @return
	 */
	public String getAlertMessage() {
		return alertMessage.getText();
	}
	

}
