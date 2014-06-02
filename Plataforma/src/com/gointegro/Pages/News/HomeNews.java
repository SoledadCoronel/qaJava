package com.gointegro.Pages.News;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsNews;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Util.StringUtils;

public class HomeNews extends PageBase {
	
	@FindBy(id = "createArticle")
	WebElement createNewsBtn;
	
	String titleNews = "article-title";
	
	String descriptionNews = "news-body";
	
	String dateNews = "news-date";
	
	String newsOptionsBtn = "div/div/div[@class='btn-group']/a";
	
	String editNews = "edit-article";
	
	String deleteNews = "delete-article";
	
	String image = "div/div[2]/img";
	
	@FindBy(xpath = "//*[@id='articles-list']/article")
	List<WebElement> newsList;
	
	@FindBy(tagName = "footer")
	WebElement footer;
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public HomeNews(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/app/news/" + ConfigElementsNews.getIdAppNews();
	}
	
	/**
	 * Seleccionar el boton Nueva Novedad
	 * 
	 * @return CreateNews
	 */
	public CreateNews selectCreateNews() {
		createNewsBtn.click();
		return PageFactory.initElements(driver, CreateNews.class);
	}
	
	/**
	 * Devuelve el titulo de la novedad
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getTitleNews(WebElement element) {
		return element.findElement(By.className(titleNews)).getText();	 
	}
	
	
	/**
	 * Devuelve la descripcion de la novedad
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getDescription(WebElement element) {
		return element.findElement(By.className(descriptionNews)).getText();	 
	}
	
	/**
	 * Devuelve la descripcion corta de la novedad 
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getShortDescription(WebElement element) {
		return StringUtils.RecortarTextoVerMas(element.findElement(By.className(descriptionNews)).getText());	 
	}
	
	/**
	 * Seleccionar el botón opciones
	 * 
	 * @param WebElement
	 */
	private void selectNewsOptionsButton(WebElement element) {
		element.findElement(By.xpath(newsOptionsBtn)).click();
	}
	
	/**
	 * Seleccionar el botón editar novedad
	 * 
	 * @param WebElement
	 */
	private void selectEditNews(WebElement element) {
		element.findElement(By.className(editNews)).click();
	}
	
	/**
	 * Seleccionar el botón eliminar novedad
	 * 
	 * @param WebElement
	 */
	private void selectDeleteNews(WebElement element) {
		element.findElement(By.className(deleteNews)).click();
		element.findElement(By.className(deleteNews)).click();
	}
	
	/**
	 * Seleccionar el botón de opciones y editar novedad
	 * 
	 * @param WebElement
	 */
	public void editNews(WebElement element) {
		selectNewsOptionsButton(element);
		selectEditNews(element);
	}
	
	/**
	 * Seleccionar el botón de opciones y eliminar novedad
	 * 
	 * @param WebElement
	 */
	public DeleteOverlay deleteNews(WebElement element) {
		selectNewsOptionsButton(element);
		selectDeleteNews(element);
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Devuelve la fecha de la novedad
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getDate(WebElement element) {
		String dateText = element.findElement(By.className(dateNews)).getText();
		String[] date;
		
		if(dateText.contains("|")) {
			date = dateText.split("\\|");
			dateText = date[0];
			dateText = dateText.substring(0, dateText.length() -1);
		}
		return dateText;
	}
	
	/**
	 * Devuelve la hora de la novedad
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getHour(WebElement element) {
		String hour = element.findElement(By.className(dateNews)).getText();
		String[] hourParts;
		
		if(hour.contains("|")) {
			hourParts = hour.split("\\|");
			hour = hourParts[1];
			hour = hour.substring(1, hour.length());
		}
		return hour;
	}
	
	/**
	 * Devuelve la si la novedad tiene una imagen
	 * 
	 * @param WebElement
	 * @return Boolean
	 */
	public Boolean isImagePresent(WebElement element) {
		return element.findElements(By.xpath(image)).size() > 0;
	}
	
	/**
	 * Devuelve el src de la imagen
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getImageSource(WebElement element) {
		return element.findElement(By.xpath(image)).getAttribute("src");
	}
	
	/**
	 * Devuelve la novedad de la lista de novedades
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getNewsElement(String name) {
		WebElement news = null;
		Boolean elementFound = false;
		
		//Timeout en 60 segundos
		for(int seconds = 0; seconds <= 20; seconds++) {
			if(isNewsOnList(name)) {
				elementFound = true;
				break;
			}
			scrollUpAndDown();
			Sleeper.sleepTight(3000);
		}
		
		if(elementFound) {
			for (WebElement element : newsList) {
				if (element.findElement(By.className(titleNews)).getText().contains(name)) {
					news = element;
					break;
				}
			}
		}
		
		return news;
	}
	
	/**
	 *  Devuelve si la novedad se encuentra en la lista
	 * 
	 * @param String
	 * @return Boolean
	 */
	private Boolean isNewsOnList(String name) {
		for (WebElement element : newsList) {
			if (element.findElement(By.className(titleNews)).getText().contains(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Hacer un scroll al footer y otro al tope de la pagina 
	 */
	private void scrollUpAndDown() {
		scrollToElement(footer);
		scrollToElement(createNewsBtn);
	}
	
	/**
	 * Hacer scroll a un elemento
	 * 
	 * @param WebElement
	 */
	private void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
	
}
