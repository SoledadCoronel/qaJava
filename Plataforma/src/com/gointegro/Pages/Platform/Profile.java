package com.gointegro.Pages.Platform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

/**
 * Profile. This class contains all elements of Profile.
 */

public class Profile extends PageBase{
	
	@FindBy (linkText = "Archivos")
	private WebElement linkArchivos;
	
	@FindBy (className = "table")
	private WebElement filetable;
	
	@FindBy (className = "followers-box")
	private WebElement followers;
	
	@FindBy (className = "following-box")
	private WebElement following;
	
	@FindBy (className = "wall")
	private WebElement linkWall;
	
	@FindBy (id = "head-updated_at")
	private WebElement orderDate;
	
	@FindBy (id = "user-name")
	private WebElement username;

	/** Constructor */
	public Profile(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile";
	}
	
	/** Select solapa Archivos */
	public void selectArchivos() {
		linkArchivos.click();
	}
	
	/** Select solapa Wall */
	public void selectWall () {
		linkWall.click();
	}
	
	/** Ordernar archivos por fecha 
	 * Los ordena de forma que el ultimo aparezca primero.
	 * */
	public void orderByDateFiles() {
		WaitTool.waitForJQueryProcessing(driver, 10);
		orderDate.click();
		WaitTool.waitForJQueryProcessing(driver, 10);
		orderDate.click();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/** Get el nombre del archivo posteado */
	public String getFileNameList() {
		return driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]/a")).getAttribute("text");
	}
	
	/** Get la location donde fue posteado un archivo */
	public String getLocationNameList() {
		return driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[3]/a")).getAttribute("text");
	}
	
	
	/** Get list of followers */
	private String getfollowing () {
		return following.getAttribute("outerHTML");
	}
	
	/** Search user in followers */
	public boolean searchfollowing (String following) {
		if (getfollowing().contains(following))
			return true;
		else
			return false;
	}
	
	
	/** Get list of followers */
	private String getfollowers () {
		return followers.getAttribute("outerHTML");
	}
	
	/** Search user in followers */
	public boolean searchfollowers (String follower) {
		if (getfollowers().contains(follower))
			return true;
		else
			return false;
	}
	
	/** Return user name profile */
	public String getUserName() {
		return username.getText();
	}

}
