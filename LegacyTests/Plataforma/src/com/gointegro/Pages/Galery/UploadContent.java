package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy (xpath = "//*[@id=\"albumId\"]/div/ul/li/a")
	private List<WebElement> dropdownmenu;
	
	@FindBy (xpath = "//div[@id='image-upload-container']/div[2]/div")
	private WebElement uploadedcontents;
	
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
	 * Seleccionar album en el dropdown
	 * 
	 * @param name
	 */
	private void selectAlbumDropdown(String name) {
		for (WebElement element : dropdownmenu) {
			if (element.getText().contains(name)) {
				element.click();
			}
		}
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
	 * Seleccionar un album
	 * 
	 * @param name
	 */
	public void selectAlbumInList(String name) {
		selectSeleccionarAlbum();
		selectAlbumDropdown(name);
	}
	
	/**
	 * Seleccionar Guardar
	 */
	public void selectSave() {
		savebtn.click();
		WaitTool.waitForJQueryProcessing(driver, 30);
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
	
	/**
	 * Seleccionar eliminar una imagen. El olerlay es el mismo para eliminar una imagen.
	 * 
	 * @return {@link DeleteOverlay}
	 */
	public DeleteOverlay selectDeletePicture() {
		selectdeletefile.click();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Ver si la imagen esta presente. Para esto devuelvo todo el innerHTML, y me fijo si esta cierto tag. Se intento de maneras menos cabezas pero bue... ¬¬
	 * 
	 * @return String
	 */
	public boolean isUploadedContentPresent() {
		return uploadedcontents.isDisplayed();
	}
	
	/**
	 * Completar el titulo de la imagen
	 * 
	 * @param filetitle
	 */
	public void setFileTitle(String filetitle) {
		title.clear();
		title.sendKeys(filetitle);
	}
	
	/**
	 * Agregar otra imagen
	 * 
	 * @param file
	 */
	public void setOtherFile(String file) {
		newcontentupload.sendKeys(file);
	}

}
