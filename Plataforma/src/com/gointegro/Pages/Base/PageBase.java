package com.gointegro.Pages.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

/**
 * Page Object base class.  It provides the base structure 
 * and properties for a page object to extend.  
 */

public class PageBase {
	
	/** Default URL */
	protected String URL;
	
	/** This page's WebDriver */
	protected WebDriver driver;
	
	/** Constructor */ 
	public PageBase(WebDriver driver){
		this.driver = driver;
	}
	
	/** Open the default page */
	public void open() {
		driver.get(URL);
	}
	
	/** Returns the page URL */ 
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	/** Returns the page Title */
	public String getTitle() {
		return driver.getTitle();
	}
	
	/** It's text present in WebElement */
	public boolean isTextPresent(By by, String text) {
		return driver.findElement(by).getText().equals(text);
	}
	
	/** Is the Element in page. */
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);//if it does not find the element throw NoSuchElementException, thus returns false. 
			return true;
			} catch (NoSuchElementException e) {
				return false;
		}
	}
	
	/**
	* Checks if the element is in the DOM and displayed. 
	* 
	* @param by - selector to find the element
	* @return true or false
	*/
	public boolean isElementPresentAndDisplay(By by) {
		try {			
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/** 
	   * Returns the first WebElement using the given method.  	   
	   * It shortens "driver.findElement(By)". 
	   * @param by 		element locater. 
	   * @return 		the first WebElement
	   */
	public WebElement getWebElement(By by){
		return driver.findElement(by); 			
	}

}
