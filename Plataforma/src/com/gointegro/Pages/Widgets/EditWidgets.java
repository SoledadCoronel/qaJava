package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class EditWidgets extends PageBase {
	
	
	@FindBy(xpath = "//*[@id='environmentHome']/div[2]/ul/li")
	List<WebElement> widgetsList;
	
	String installedAppGalleryTitle = "./div[2]/div";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public EditWidgets(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve si una Aplicación se encuentra en la lista de widgets buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public String getGalleryAppWidgetId(String name) {
		String galleryAppId = "";
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("gallery.carousel")) {
				if(element.findElements(By.xpath(installedAppGalleryTitle)).size() > 0) {
					if(element.findElement(By.xpath(installedAppGalleryTitle)).getText().contains(name)) {
						galleryAppId = element.getAttribute("data-id");
						break;
					}
				}	
			}
		}
		return galleryAppId;
	}

}
