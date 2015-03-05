package com.gointegro.Pages.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DeleteOverlay extends PageBase {
	
	@FindBy(xpath = "//div[@class='modal-footer']/a[1]")
	WebElement confirmdelete;

	@FindBy(xpath = "//div[@class='modal-footer']/a[2]")
	WebElement canceldelete;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DeleteOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Confirmar eliminar
	 */
	public void selectConfirmDelete() {
		confirmdelete.click();
	}
	
	/**
	 * Cancelar eliminar
	 */
	public void selectCancelDelete() {
		canceldelete.click();
	}
	
}
