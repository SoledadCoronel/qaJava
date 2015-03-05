package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * Page object que muestra todos los usuarios que dieron like a algo
 * 
 * @author gustavomoreira
 *
 */

public class ExcessLikers extends PageBase{
	
	@FindBy (xpath = "//table[@class='show-colabs']/tbody")
	private WebElement colabstable;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public ExcessLikers(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve un string con todos los colaboradores
	 * 
	 * @return
	 */
	public String getColabLikeList() {
		return colabstable.getText();
	}
	
	

}
