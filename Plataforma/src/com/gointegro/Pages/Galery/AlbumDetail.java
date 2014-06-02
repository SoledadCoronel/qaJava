package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AlbumDetail extends PageBase{

	@FindBy (id = "album-actions")
	private WebElement albumactions;
	
	@FindBy (xpath = "//ul[@class='dropdown-menu']/li/a")
	private WebElement editalbum;
	
	@FindBy (className = "delete-album-header")
	private WebElement deletealbum;
	
	@FindBy (xpath = "//header[@class='titleEditable']/h3")
	private WebElement albumtitle;
	
	@FindBy (xpath = "//div[@class='main-container']/ul/li")
	private List<WebElement> imagelist;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AlbumDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar la ultima foto de un album. Esta foto es la ultima subida
	 */
	public void selectLastPictureInAlbum() {
		imagelist.get(imagelist.size()-1).click();
	}

}
