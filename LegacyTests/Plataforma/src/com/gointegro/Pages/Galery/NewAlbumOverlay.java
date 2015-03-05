package com.gointegro.Pages.Galery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class NewAlbumOverlay extends PageBase{
	
	@FindBy (id = "album-name")
	private WebElement albumname;
	
	@FindBy (xpath = "//div[@id='gallery-modal']/div[3]/button")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//div[@id='gallery-modal']/div[3]/button[2]")
	private WebElement cancelBtn;
	
	@FindBy (className = "data-error")
	private WebElement dataerrormsj;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewAlbumOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar nombre del album
	 * 
	 * @param albumname
	 */
	private void completeAlbumName(String albumnam) {
		albumname.clear();
		albumname.sendKeys(albumnam);
	}
	
	/**
	 * Crear un album
	 * 
	 * @param albumname
	 */
	public void createAlbum(String albumname) {
		completeAlbumName(albumname);
		saveBtn.click();
	}
	
	/**
	 * Cancelar la creacion de un album
	 * 
	 * @param albumname
	 */
	public void cancelCreateAlbum(String albumname) {
		completeAlbumName(albumname);
		cancelBtn.click();
	}
	
	/**
	 * Obtiene el mensaje de error debajo del textbox
	 * 
	 * @return String
	 */
	public String getErrorMsj() {
		return dataerrormsj.getText();
	}

}
