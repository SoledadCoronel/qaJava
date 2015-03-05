package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Constructor para el social Wall. El manejo de feeds y postform queda en otras clases respectivas
 * 
 * @author gustavomoreira
 *
 */

public class SocialWall extends PageBase{
	
	String firstFile = "//div[@class='well-profile']/ul/li/a";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SocialWall(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/social/wall";
	}

	/**
	 * Devuelve si el archivo se encuentra en el listado "Archivos de la plataforma"
	 * 
	 * @param name
	 * @return Boolean
	 */
	public Boolean isFileInList(String name) {
		Boolean isFileInList = false;
		
		if(driver.findElement(By.xpath(firstFile)).getText().contains(name)) {
			isFileInList = true;
		}	
		return isFileInList;
	}
}
