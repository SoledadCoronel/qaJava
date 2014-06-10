package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class EditWidgets extends PageBase {
	
	
	@FindBy(xpath = "//*[@id='environmentHome']/div[2]/ul/li")
	List<WebElement> widgetsList;
	
	String widgets = "//*[@id='environmentHome']/div[2]/ul";
	
	String installedAppGalleryTitle = "./div[2]/div";
	
	String celebAppTitle = "./div[2]/div[2]/div/header";
	
	String textHTMLTitle = "./div[3]/div[2]/div/header";
	
	String editedTextHTMLTitle = "./li/div/div[2]/div/header";
	
	String editedTextHTMLDescription = "./li/div/div[2]/div/div/p";
	
	String imagesCarouselEdited = "./li/div/div/div/div/div";
	
	String imagesCarousel = "./div[2]/div/div/div/div";
	
	String optionsBtn = "icon-pencil";
	
	String editBtn = "edit-btn";
	
	String deleteBtn = "delete-btn";
	
	String widgetHandle = "./div[6]";
	
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public EditWidgets(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Seleccionar el botón de opciones
	 * 
	 * @param WebElement
	 */
	private void selectOptions(WebElement element) {
		element.findElement(By.className(optionsBtn)).click();
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
	
	/**
	 *  Devuelve el titulo del widget Text / HTML
	 *  
	 * @param WebElement
	 * @return String
	 */
	public String getTextTitle(WebElement element) {
		return element.findElement(By.xpath(editedTextHTMLTitle)).getText();
	}
	
	/**
	 * Devuelve un WebElement del widget buscando por titulo
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getEditedTextWidgetElementByTitle(String name) {
		WebElement widget = null;
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("html-text")) {
				if(element.findElements(By.xpath(editedTextHTMLTitle)).size() > 0) {
					if(element.findElement(By.xpath(editedTextHTMLTitle)).getText().contains(name)) {
						widget = element;
						break;
					}
				}
			}
		}
		return widget;
	}
	
	/**
	 *  Devuelve la dsecripción del widget Text / HTML
	 *  
	 * @param WebElement
	 * @return String
	 */
	public String getTextDescription(WebElement element) {
		return element.findElement(By.xpath(editedTextHTMLDescription)).getText();
	}
	
	/**
	 * Devuelve un WebElement del widget buscando por descripción
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getEditedTextWidgetElementByDescription(String name) {
		WebElement widget = null;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("html-text")) {
				if(element.findElement(By.xpath(editedTextHTMLDescription)).getText().contains(name)) {
					widget = element;
					break;
				}
			}
		}
		return widget;
	}
	
	/**
	 * Devuelve si el widget se encuentra en la lista buscando por titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isWidgetInListByTitle(String name) {
		Boolean isPresent = false;
		
		if(driver.findElement(By.xpath(widgets)).getAttribute("innerHTML").contains(name)){
			isPresent = true;
		}
		return isPresent;
	}
	
	/**
	 * Cambiar el orden de los widgets, pone el primero ultimo.
	 * 
	 * @param String
	 * @param String
	 */
	public void changeOrder(WebElement widgetElement1, WebElement widgetElement2) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(widgetElement2).moveToElement(widgetElement1).release(widgetElement1).build();

		dragAndDrop.perform();
	}
	
	/**
	 * Devuelve la fila en que se encuentra el widget
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getRowForElement(WebElement element) {
		return element.getAttribute("data-row");
	}
	
	/**
	 * Devuelve la columna en que se encuentra el widget
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getColForElement(WebElement element) {
		return element.getAttribute("data-col");
	}
	
	/**
	 * Cambia el tamaño del widget
	 * 
	 * @param WebElement
	 */
	public void resizeWidget(WebElement element) {
		WebElement handle = element.findElement(By.xpath(widgetHandle));
		
		Actions builder = new Actions(driver);
		Action dragAndDrop =  builder.moveToElement(element).clickAndHold(handle).moveByOffset(20, 90).release().build();
		
		dragAndDrop.perform();
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
	 * Devuelve el numero de imagenes despues de editar el widget
	 * 
	 * @return int
	 */
	public int getEditedGalleryCarouselCount(WebElement element) {
		return element.findElements(By.xpath(imagesCarouselEdited)).size();
	}
	
	/**
	 * Devuelve el numero de imagenes del widget
	 * 
	 * @return int
	 */
	public int getGalleryCarouselCount(WebElement element) {
		return element.findElements(By.xpath(imagesCarousel)).size();
	}
	
	/**
	 * Devuelve un webelement de una galeria buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public WebElement getGalleryAppWidgetElement(String name) {
		WebElement galleryElment= null;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("gallery.carousel")) {
				if(element.findElements(By.xpath(installedAppGalleryTitle)).size() > 0) {
					if(element.findElement(By.xpath(installedAppGalleryTitle)).getText().contains(name)) {
						galleryElment= element;
						break;		
					}
				}
			}
		}
		return galleryElment;
	}
	
	/**
	 * Devuelve si una Aplicación se encuentra en la lista de widgets buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isInstalledCellebrationAppWidgetinList(String name) {
		Boolean isInstalledAppInList = false;
		
		for(WebElement element : widgetsList) {
			
			if(element.getAttribute("class").contains("celebration.feed")) {
				if(element.findElements(By.xpath(celebAppTitle)).size() > 0 ) {
					if(element.findElement(By.xpath(celebAppTitle)).getText().contains(name)) {
						isInstalledAppInList= true;
						break;
					}
				}
			}
		}
		return isInstalledAppInList;
	}
	
}
