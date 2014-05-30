package com.gointegro.Pages.News;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailNews extends PageBase {
	
	@FindBy(xpath = "//header[@class='titleEditable']/h3")
	WebElement title;
	
	@FindBy(className = "news-content-detail")
	WebElement description;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailNews(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve el titulo de la novedad
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}
	
	/**
	 * Devuelve la descripcion de la novedad
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}

}
