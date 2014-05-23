package com.gointegro.Pages.Content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class ContentList extends PageBase {
	
	
	@FindBy(xpath = "//*[@id=\"middle-section\"]/aside/div/ul/li/a")
	WebElement title;
	
	
	public ContentList(WebDriver driver) {
		super(driver);
	}
	
	
	/*
	 * Obtiene el titulo del contenido en el menu lateral
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}

}
