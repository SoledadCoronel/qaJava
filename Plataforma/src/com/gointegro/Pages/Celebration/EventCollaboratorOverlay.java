package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class EventCollaboratorOverlay extends PageBase{
	
	@FindBy (xpath = "//div[@class='modal-header']/h3")
	private WebElement headertitle;
	
	@FindBy (xpath = "//table[@class='show-colabs']/tbody")
	private WebElement colabstable;
	
	@FindBy (xpath = "//div[@class='modal-footer']/a")
	private WebElement closemodal;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EventCollaboratorOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtiene los colaboradores de una lista
	 * 
	 * @return String
	 */
	public String getCollaborators() {
		return colabstable.getText();
	}
	
	/**
	 * Obtiene el titulo del overlay
	 * 
	 * @return
	 */
	public String getHeaderTitle() {
		return headertitle.getText();
	}
	
	/**
	 * Cerrar el modal
	 */
	public void closeModal() {
		closemodal.click();
	}
	
}
