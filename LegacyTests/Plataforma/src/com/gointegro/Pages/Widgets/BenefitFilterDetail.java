package com.gointegro.Pages.Widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class BenefitFilterDetail extends PageBase {
	
	@FindBy(xpath = "//div[@class='special-benefit']/img")
	WebElement image;
	
	@FindBy(xpath = "//li[@data-filter='collection']")
	WebElement specialFilter;
	
	@FindBy(name = "txt-search")
	WebElement locationSearch;
	
	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public BenefitFilterDetail(WebDriver driver) {
		super(driver);
	}

	/**
	 * Devuelve true si la imagen esta presente
	 * 
	 * @return boolean
	 */
	public boolean isImagePresent() {
		return image.isDisplayed();
	}
	
	/**
	 * Devuelve true si el filtro Especiales esta presente
	 * 
	 * @return boolean
	 */
	public boolean isSpecialFilterPresent() {
		return specialFilter.isDisplayed();
	}
	
	/**
	 * Obtener la Ubicación
	 * 
	 * @return String
	 */
	public String getLocation() {
		return locationSearch.getAttribute("value"); 
	}
	
}
