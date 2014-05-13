package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * Detalle de un post, solo se refiere al contenedor
 * Los feeds estan en TagFeed.java
 * 
 * @author gustavomoreira
 *
 */

public class DetailPost extends PageBase{
	
	@FindBy (className = "app-title")
	private WebElement title;
	

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailPost(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el titulo de la seccion
	 * 
	 */
	public String getTitle() {
		return title.getText();
	}

}
