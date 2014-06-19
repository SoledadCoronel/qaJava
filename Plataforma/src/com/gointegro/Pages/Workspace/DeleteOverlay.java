package com.gointegro.Pages.Workspace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Overlay de eliminar espacio
 * 
 * @author diogodarosa
 *
 */
public class DeleteOverlay extends PageBase {
	
	@FindBy (xpath = "//div[@id='delete-workspace-modal']//div[@class='modal-footer']/button")
	private WebElement confirmdelete;
	
	@FindBy (xpath = "//div[@id='delete-modal']/div[3]/button[1]")
	private WebElement confirmdeleteApps;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement canceldelete;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DeleteOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Confirmar eliminar para espacios
	 */
	public void selectConfirmDelete() {
		confirmdelete.click();
	}
	
	/**
	 * Confirmar eliminar para aplicaciones
	 */
	public void selectConfirmDeleteApps() {
		confirmdeleteApps.click();
	}
	
	/**
	 * Cancelar eliminar
	 */
	public void selectCancelDelete() {
		canceldelete.click();
	}


}
