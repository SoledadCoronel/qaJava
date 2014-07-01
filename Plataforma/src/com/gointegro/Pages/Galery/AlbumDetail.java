package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class AlbumDetail extends PageBase{

	@FindBy (id = "album-actions")
	private WebElement albumactions;
	
	@FindBy (linkText = "Editar")
	private WebElement editalbum;
	
	@FindBy (className = "delete-album-header")
	private WebElement deletealbum;
	
	@FindBy (xpath = "//header[@class='titleEditable']/h3")
	private WebElement albumtitle;
	
	@FindBy (xpath = "//div[@class='main-container']/ul/li")
	private List<WebElement> imagelist;
	
	@FindBy (xpath = "//li[contains(@id,'image-')]")
	private WebElement imageid;
	
	@FindBy (xpath = "//li/span/i[@class='icon-play']")
	private WebElement video;
	
	@FindBy (xpath = "//h3[@id='album-image-title']")
	private WebElement imagetitle;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AlbumDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar Album Actions
	 */
	private void selectAlbumActions() {
		albumactions.click();
	}
	
	/**
	 * Seleccionar la ultima imagen del album
	 * 
	 * @return {@link ImageDetail}
	 */
	public ImageDetail selectLastPictureInAlbum() {
		imagelist.get(imagelist.size()-1).click();
		
		return PageFactory.initElements(driver, ImageDetail.class);
	}
	
	/**
	 * Devuelve el size del album
	 * 
	 * @return int
	 */
	public int albumsize() {
		return imagelist.size();
	}
	
	/**
	 * Verificar que la imagen se muestre, solo funciona para albums con una sola imagen.
	 * 
	 * @return boolean
	 */
	public boolean isPictureInAlbum() {
		return imageid.isDisplayed();
	}
	
	/**
	 * Verificar que el video se muestre, solo funciona para albums con una sola imagen.
	 * 
	 * @return boolean
	 */
	public boolean isVideoInAlbum() {
		return video.isDisplayed();
	}
	
	/**
	 * Seleccionar Editar Album
	 * 
	 * @return {@link EditAlbum}
	 */
	public EditAlbum selectEditAlbum() {
		selectAlbumActions();
		WaitTool.waitForJQueryProcessing(driver, 5);
		editalbum.click();
		
		return PageFactory.initElements(driver, EditAlbum.class);
	}
	
	/**
	 * Obtener el titulo del album
	 * 
	 * @return String
	 */
	public String getAlbumTitle() {
		return albumtitle.getText();
	}
	
	/**
	 * Obtener el titulo de la imagen/video
	 * 
	 * @return String
	 */
	public String getImageTitle() {
		return imagetitle.getText();
	}
	
	/**
	 * Seleccionar Eliminar Album
	 * 
	 * @return {@link DeleteOverlay}
	 */
	public DeleteOverlay selectDeleteAlbum() {
		selectAlbumActions();
		WaitTool.waitForJQueryProcessing(driver, 5);
		deletealbum.click();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}

}
