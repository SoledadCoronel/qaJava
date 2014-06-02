package com.gointegro.Pages.Galery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class UploadContent extends PageBase{

	@FindBy (className = "selected-item-placeholder")
	private WebElement selectalbum;
	
	@FindBy (xpath = "//*[@id=\"albumId\"]/div/ul//*[@id='albumId']")
	private WebElement albumname;
	
	@FindBy (className = "app-config")
	private WebElement pagetitle;
	
	@FindBy (name = "cover")
	private WebElement selectcover;
	
	@FindBy (css = "i.icon-trash.icon-large")
	private WebElement selectdeletefile;
	
	@FindBy (id = "title")
	private WebElement title;
	
	@FindBy (id = "save-button")
	protected WebElement savebtn;
	
	@FindBy (id = "cancel-button")
	protected WebElement cancelbtn;
	
	@FindBy (id = "contents-upload-new")
	private WebElement newcontentupload;
	
	@FindBy (className = "data-error")
	private WebElement errormsjalbum;
	
	@FindBy (xpath = "//div[@id='upload-errors']/div")
	private WebElement uploaderror;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public UploadContent(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el boton "Seleccionar Album"
	 */
	private void selectSeleccionarAlbum() {
		selectalbum.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Completar el nombre del album
	 * 
	 * @param name
	 */
	private void completeAlbumName(String name) {
		albumname.clear();
		albumname.sendKeys(name);		
		albumname.sendKeys(Keys.ENTER);
	}
	
	/**
	 * Create album
	 * 
	 * @param name
	 */
	public void completeAlbum(String name) {
		selectSeleccionarAlbum();
		completeAlbumName(name);
	}
	
	/**
	 * Seleccionar Guardar
	 */
	public void selectSave() {
		savebtn.click();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/**
	 * Obtener el mensaje de error del dropdown album
	 * 
	 * @return String
	 */
	public String getErrorMsjAlbum() {
		return errormsjalbum.getText();
	}
	
	/**
	 * Obtener el mensaje de error de upload error
	 * 
	 * @return String
	 */
	public String getUploadErrorMsj() {
		return uploaderror.getText();
	}
	
	/**
	 * Seleccionar Cancelar y aceptar el alert de javascript
	 */
	public void selectCancel() {
		cancelbtn.click();
		driver.switchTo().alert().accept();
	}

}
