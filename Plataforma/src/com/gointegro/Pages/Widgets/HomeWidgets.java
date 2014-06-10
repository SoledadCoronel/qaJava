package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class HomeWidgets extends PageBase {
	
	@FindBy(xpath = "//span[@class='adm-action']/a")
	WebElement configbtn;
	
	@FindBy(xpath = "//header[@class='app-name']/div[1]/button")
	WebElement addModulebtn;
	
	@FindBy(className = "new-widget")
	WebElement newModulebtn;
	
	@FindBy(xpath = "//div[@class='app-action']/div/button[1]")
	WebElement savebtn;
	
	@FindBy(xpath = "//div[@class='app-action']/div/button[2]")
	WebElement cancelbtn;
	
	@FindBy(xpath = "//*[@id='environmentHome']/div[2]/ul/li")
	List<WebElement> widgetsList;
	
	String textHTMLTitle = "./div/div/div/header";
	
	String textHTMLDescription = "./div/div/div/div/p";
	
	String imageBanner = "banner";
	
	String imageLink = "banner-external-url";
	
	String installedAppTitle = "./div/div/div/header";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public HomeWidgets(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/environment/ideas";
	}
	
	/**
	 * Seleccionar el botón Agregar Módulo
	 */
	private void selectAddModule() {
		addModulebtn.click();
	}
	
	/**
	 * Seleccionar el botón Nuevo Módulo
	 */
	private void selectNewModule() {
		newModulebtn.click();
	}
	
	/**
	 * Seleccionar el botón Agregar Módulo y Nuevo Módulo
	 * 
	 * @return NewModuleOverlay
	 */
	public NewModuleOverlay addNewModule() {
		selectAddModule();
		selectNewModule();
		return PageFactory.initElements(driver, NewModuleOverlay.class);
	}
	
	/**
	 * Seleccionar el botón guardar
	 */
	public void selectSaveBtn() {
		savebtn.click();
	}

	/**
	 * Seleccionar el botón cancelar
	 */
	public void selectCancelBtn() {
		cancelbtn.click();
	}
	
	/**
	 * Seleccionar el botón configurar
	 */
	public void selectConfigBtn() {
		configbtn.click();
	}
	
	/**
	 *  Devuelve el titulo del widget Text / HTML
	 *  
	 * @param WebElement
	 * @return String
	 */
	public String getTextTitle(WebElement element) {
		return element.findElement(By.xpath(textHTMLTitle)).getText();
	}
	
	/**
	 * Devuelve un WebElement del widget buscando por titulo
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getTextWidgetElementByTitle(String name) {
		WebElement widget = null;
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("html-text")) {
				if(element.findElements(By.xpath(textHTMLTitle)).size() > 0) {				
					if(element.findElement(By.xpath(textHTMLTitle)).getText().contains(name)) {
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
		return element.findElement(By.xpath(textHTMLDescription)).getText();
	}
	
	/**
	 * Devuelve un WebElement del widget Text/HTML buscando por descripción
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getTextWidgetElementByDescription(String name) {
		WebElement widget = null;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("html-text")) {
				if(element.findElement(By.xpath(textHTMLDescription)).getText().contains(name)) {
					widget = element;
					break;
				}
			}
		}
		return widget;
	}
	
	
	/**
	 * Devuelve si un Banner se encuentra en la lista de widgets buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isImageWidgetOnList(String name) {
		Boolean isImageOnList = false;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("banner")) {
				if(element.findElement(By.className(imageBanner)).getAttribute("alt").contains(name)) {
					isImageOnList= true;
					break;
				}
			}
		}
		return isImageOnList;
	}
	
	/**
	 * Devuelve el nombre de la imagen del Banner buscando por el titulo
	 * 
	 * @param String
	 * @return String
	 */
	public String getImageWidgetImageName(String name) {
		String imageName = "";
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("banner")) {
				if(element.findElement(By.className(imageBanner)).getAttribute("alt").contains(name)) {
					imageName= element.findElement(By.className(imageBanner)).getAttribute("src");
					break;
				}
			}
		}
		return imageName;
	}
	
	/**
	 * Devuelve un WebElement del Banner buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public WebElement getBannerElement(String name) {
		WebElement bannerElement = null;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("banner")) {
				if(element.findElement(By.className(imageBanner)).getAttribute("alt").contains(name)) {
					bannerElement = element;
					break;
				}
			}
		}
		return bannerElement;
	}
	
	/**
	 * Devuelve el link del Banner
	 * 
	 * @param String
	 * @return Boolean
	 */
	public String getBannerLinkUrl(WebElement element) {
		String link = element.findElement(By.className(imageLink)).getAttribute("href");
		
		if(link.substring(link.length() -1).contains("/")) {
			link = link.substring(0, link.length() -1);
		}
		return link;
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
				if(element.findElements(By.xpath(installedAppTitle)).size() > 0 ) {
					if(element.findElement(By.xpath(installedAppTitle)).getText().contains(name)) {
						isInstalledAppInList= true;
						break;
					}
				}
			}
		}
		return isInstalledAppInList;
	}
	
	/**
	 * Devuelve un WebElement de la aplicacion Celebraciones buscando por el titulo
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getCelebrationAppElement(String name) {
		WebElement celebrationElement = null;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("celebration.feed")) {
				if(element.findElements(By.xpath(installedAppTitle)).size() > 0 ) {
					if(element.findElement(By.xpath(installedAppTitle)).getText().contains(name)) {
						celebrationElement = element;
						break;
					}
				}
			}
		}
		return celebrationElement;
	}
	
	/**
	 * Devuelve si una Aplicación se encuentra en la lista de widgets buscando por el titulo
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isInstalledGalleryAppWidgetInList(String appId) {
		Boolean isInstalledAppInList = false;
		
		for(WebElement element : widgetsList) {
			if(element.getAttribute("class").contains("gallery.carousel") && element.getAttribute("data-id").contains(appId)) {
				isInstalledAppInList= true;
				break;		
			}
		}
		return isInstalledAppInList;
	}
	
	
}
