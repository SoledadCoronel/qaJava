package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class TermsAndConditions extends PageBase{
	
	@FindBy (xpath = "//div[@id='termsAndConditionsModal']/div[@class='modal-body']/p")
	private WebElement textcontain;
	
	@FindBy (xpath = "//div[@id='termsAndConditionsModal']/div[@class='modal-footer']/button")
	private WebElement closebtn;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public TermsAndConditions(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el html con los tyc
	 * 
	 * @return String
	 */
	public String getTyCText() {
		return textcontain.getAttribute("innerHTML");
	}
	
	/**
	 * Cerrar el modal
	 */
	public void closeModal() {
		closebtn.click();
	}

}
