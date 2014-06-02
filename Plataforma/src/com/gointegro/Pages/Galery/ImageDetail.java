package com.gointegro.Pages.Galery;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class ImageDetail extends PageBase{
	
	@FindBy (className = "next-photo")
	private WebElement nextphoto;
	
	@FindBy (className = "previous-photo")
	private WebElement previousphoto;
	
	@FindBy (className = "current-photo")
	private WebElement currentphoto;
	
	@FindBy (xpath = "//div[@class='content-container']/div")
	private WebElement picactions;
	
	@FindBy (className = "modal-delete-button")
	private WebElement deletebtn;

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
	
	public void selectDelete() {
		makeVisiblePicActions();
		deletebtn.click();
	}

}
