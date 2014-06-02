package com.gointegro.Pages.Galery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAlbum extends UploadContent{

	@FindBy (id = "name")
	private WebElement albumname;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EditAlbum(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar le nombre del album
	 * 
	 * @param name
	 */
	private void completeAlbumName(String name) {
		albumname.clear();
		albumname.sendKeys(name);
	}
	
	/**
	 * Obtener el texto de editar album
	 * 
	 * @return String
	 */
	public String getAlbumName() {
		return albumname.getAttribute("value");
	}
	
	/**
	 * Cambiar el nombre del album
	 * 
	 * @param name
	 * @param savecancel
	 * @return {@link AlbumDetail}
	 */
	public AlbumDetail editAlbum(String name, boolean savecancel) {
		completeAlbumName(name);
		if (savecancel)
			savebtn.click();
		else
			cancelbtn.click();
		
		return PageFactory.initElements(driver, AlbumDetail.class);
	}
	
	

}
