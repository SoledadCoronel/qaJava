package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO que maneja el FeedFiles de la derecha
 * 
 * @author gustavomoreira
 *
 */

public class FeedFiles extends PageBase {
	
	/** Constructor */
	public FeedFiles(WebDriver driver) {
		super(driver);
		
	}
	
	/** Get Files in div */
	public String getFeedFiles() {
		return driver.findElement(By.xpath("//div[@class='well-profile']/ul/li/a")).getAttribute("title");
	}

}
