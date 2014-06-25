package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class ImageCropOverlay extends PageBase {
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[1]")
	WebElement close;
	
	@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
	WebElement save;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public ImageCropOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el botón Guardar
	 */
	public void selectSave() {
		save.click();
	}
	
	/**
	 * Seleccionar el botón Cerrar
	 */
	public void selectClose() {
		close.click();
	}
	

}
