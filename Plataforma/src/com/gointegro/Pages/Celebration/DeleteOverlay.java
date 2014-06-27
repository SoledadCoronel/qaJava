package com.gointegro.Pages.Celebration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Delete overlay 
 * 
 * @author gustavomoreira
 *
 */
public class DeleteOverlay extends PageBase{
	
	@FindBy (xpath = "//div[@id='delete-modal']//div[@class='modal-footer']/button")
	private WebElement confirmdelete;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement canceldelete;
	
	@FindBy (className = "close")
	private WebElement closeoverlay;

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
	 * Confirmar eliminar
	 */
	public void selectConfirmDeleteAll(int num) {
		driver.findElement(By.xpath("//div[@id='delete-modal']["+num+"]//div[@class='modal-footer']/button")).click();
	}
	
	/**
	 * Cancelar eliminar
	 */
	public void selectCancelDelete() {
		canceldelete.click();
	}

}
