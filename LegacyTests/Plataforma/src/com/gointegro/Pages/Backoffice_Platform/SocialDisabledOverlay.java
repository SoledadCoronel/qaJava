package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class SocialDisabledOverlay extends PageBase {
	
	@FindBy(xpath = "//div[@class='modal-footer']/button")
	WebElement close;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SocialDisabledOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el botón Cerrar
	 */
	public void selectClose() {
		close.click();
	}

}
