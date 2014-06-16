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
