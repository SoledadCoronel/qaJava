package com.gointegro.Pages.Galery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DeleteAlbumOverlay extends PageBase{
	
	@FindBy (xpath = "//div[@id='delete-modal']/div[3]/button")
	private WebElement savebtn;
	
	@FindBy (xpath = "//div[@id='delete-modal']/div[3]/button[2]")
	private WebElement cancelbtn;
	
	@FindBy (xpath = "//div[@id='delete-modal']//div[@class='modal-body']/div")
	private WebElement alerterror;
	
	@FindBy (xpath = "//div[@id='delete-modal']//div[@class='modal-body']/p")
	private WebElement msjbody;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DeleteAlbumOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Confirmar eliminar
	 */
	public void confirmDelete() {
		savebtn.click();
	}
	
	/**
	 * Cancelar eliminar
	 */
	public void cancelDelete() {
		cancelbtn.click();
	}
	
	/**
	 * Obtener el aviso de imagenes asociadas
	 * 
	 * @return String
	 */
	public String getAlert() {
		return alerterror.getText();
	}
	
	/**
	 * Obtener el mensaje dentro del body del modal
	 * 
	 * @return String
	 */
	public String getMsjBody() {
		return msjbody.getText();
	}

}
