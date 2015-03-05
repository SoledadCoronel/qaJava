package com.gointegro.Pages.Galery;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class ImageDetail extends PageBase{
	
	@FindBy (className = "next-photo")
	private WebElement nextphoto;
	
	@FindBy (className = "previous-photo")
	private WebElement previousphoto;
	
	@FindBy (className = "current-photo")
	private WebElement currentphoto;
	
	@FindBy (id = "video-player_flash_api")
	private WebElement currentvideo;
	
	@FindBy (xpath = "//div[@class='content-container']/div")
	private WebElement picactions;
	
	@FindBy (xpath = "//div[@class='content-container']/div[2]")
	private WebElement picactionsVideo;
	
	@FindBy (className = "modal-delete-button")
	private WebElement deletebtn;
	
	@FindBy (id = "album-image-title")
	private WebElement imagetitle;
	
	@FindBy (className = "download-link")
	private WebElement downloadlink;

	@FindBy (className = "copy-link")
	private WebElement copylink;
	
	@FindBy (id = "copy-link-video")
	private WebElement videolink;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public ImageDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Vuelve visible las acciones de la foto
	 */
	private void makeVisiblePicActions() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','display:block;')", picactions);
	}
	
	/**
	 * Vuelve visible las acciones del video
	 */
	private void makeVisibleVidActions() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','display:block;')", picactionsVideo);
	}
	
	/**
	 * Eliminar imagen
	 * 
	 * @return {@link DeleteOverlay}
	 */
	public DeleteOverlay selectDelete() {
		makeVisiblePicActions();
		deletebtn.click();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Eliminar video
	 * 
	 * @return {@link DeleteOverlay}
	 */
	public DeleteOverlay selectDeleteVideo() {
		makeVisibleVidActions();
		deletebtn.click();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Obtener el link de descarga del archivo
	 * 
	 * @return {@link WebElement}
	 */
	public WebElement downloadLink() {
		makeVisiblePicActions();
		WebElement _downloadLink = downloadlink;
		return _downloadLink;
	}
	
	/**
	 * Seleccionar el botón Copiar Link
	 */
	public void selectCopyLink() {
		makeVisiblePicActions();
		copylink.click();
	}
	
	/**
	 * Obtener el link del Video
	 * 
	 * @return String
	 */
	public String copyLink() {
		return videolink.getAttribute("value");
	}
	
	/**
	 * Obtener el titulo de la imagen
	 * 
	 * @return String
	 */
	public String getImageTitle() {
		return imagetitle.getText();
	}
	
	/**
	 * Obtener el src de la imagen 
	 * 
	 * @return String
	 */
	public String getSrcImg() {
		return currentphoto.getAttribute("src");
	}
	
	/**
	 * Obtener el src del video 
	 * 
	 * @return String
	 */
	public String getSrcVideo() {
		return currentvideo.getAttribute("data");
	}
	
	/**
	 * Seleccionar siguiente imagen
	 */
	public void selectNextPicture() {
		nextphoto.click();
	}
	
	/**
	 * Seleccionar la imagen previa
	 */
	public void selectPreviousPicture() {
		previousphoto.click();
	}
	
	/**
	 * Obtener el source de las Actions para ver si un link esta presente o no.
	 * 
	 * @return String
	 */
	public String getActionsSource() {
		return picactions.getAttribute("outerHTML");
	}

}
