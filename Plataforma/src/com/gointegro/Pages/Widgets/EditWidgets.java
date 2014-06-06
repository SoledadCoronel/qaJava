package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class EditWidgets extends PageBase {
	
	
	@FindBy(xpath = "//*[@id='environmentHome']/div[2]/ul/li")
	List<WebElement> widgetsList;
	
	String installedAppGalleryTitle = "./div[2]/div";
	
	String optionsBtn = "./div[2]/a/i";
	
	String editBtn = "edit-btn";
	
	String deleteBtn = "delete-btn";
	
	
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

	/**
	 * Seleccionar el botón de opciones
	 * 
	 * @param WebElement
	 */
	private void selectOptions(WebElement element) {
		element.findElement(By.xpath(optionsBtn)).click();
	}
	
	/**
	 * Seleccionar el botón Editar
	 * 
	 * @param WebElement
	 */
	private void selectEditBtn(WebElement element) {
		element.findElement(By.className(editBtn)).click();
	}
	
	/**
	 * Seleccionar el botón Eliminar
	 * 
	 * @param WebElement
	 */
	private void selectDeleteBtn(WebElement element) {
		element.findElement(By.className(deleteBtn)).click();
	}
	
	/**
	 * Seleccionar el botón de opciones y Editar
	 * 
	 * @param WebElement
	 * @return NewModuleOverlay
	 */
	public NewModuleOverlay selectEditWidget(WebElement element) {
		selectOptions(element);
		selectEditBtn(element);
		return PageFactory.initElements(driver, NewModuleOverlay.class);
	}
	
	/**
	 * Seleccionar el botón de opciones y Eliminar
	 * 
	 * @param WebElement
	 */
	public void selectDeleteWidget(WebElement element) {
		selectOptions(element);
		selectDeleteBtn(element);
	}
	
	
	
	
	
}
