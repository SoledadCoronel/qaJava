package com.gointegro.Pages.Content;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class NewContent extends PageBase{

	@FindBy(id = "title_ifr")
	WebElement title;
	
	@FindBy(id = "content_ifr")
	WebElement description;
	
	@FindBy(id = "accept")
	WebElement savebtn;
	
	@FindBy(id = "cancel")
	WebElement cancelbtn;
	
	@FindBy(id = "category-new")
	WebElement newCategory;
	
	@FindBy(id = "title-error")
	WebElement titleError;
	
	@FindBy(id = "content-error")
	WebElement descriptionError;
	
	@FindBy(id = "category")
	WebElement categorySelect;
	
	@FindBy(id = "bellowArticle")
	WebElement bellowArticle;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewContent(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/app/articles/1957/create";
	}
	
	
	/**
	 * Crear titulo para el contenido
	 * 
	 * @param String
	 */
	public void createTitle(String titleText) {
		driver.switchTo().frame(title);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + titleText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * Crear descripción para el contenido
	 * 
	 * @param String
	 */
	public void createDescription(String descriptionText) {
		driver.switchTo().frame(description);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + descriptionText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * Seleccionar nueva categoria
	 * 
	 * @return NewCategoryOverlay
	 */
	public NewCategoryOvelayContent selectNewCategory() {
		newCategory.click();
		return PageFactory.initElements(driver, NewCategoryOvelayContent.class);
	}
	
	/**
	 *  Seleccionar el botón guardar
	 *  
	 *  @return HomeContent
	 */
	public HomeContent selectSaveBtn() {
		savebtn.click();
		return PageFactory.initElements(driver, HomeContent.class);
	}
	
	/**
	 *  Seleccionar el botón cancelar
	 *  
	 *  @return HomeContent
	 */
	public HomeContent selectCancelBtn() {
		cancelbtn.click();
		return PageFactory.initElements(driver, HomeContent.class);
	}
	
	
	/**
	 *  Obtener el mensaje de error del titulo
	 *  
	 * @return String
	 */
	public String getTitleError() {
		return titleError.getText();
	}
	
	
	/**
	 *  Obtener el mensaje de error de descripción
	 *  
	 * @return String
	 */
	public String getDescriptionError() {
		return descriptionError.getText();
	}
	
	
	/**
	 * Verifica si el elemento es visible 
	 * 
	 * @return boolean
	 */
	public boolean isTitleErrorPresent() {
		return titleError.isDisplayed();
	}
	
	
	/**
	 * Verifica si el elemento es visible 
	 * 
	 * @return boolean
	 */
	public boolean isDescriptionErrorPresent() {
		return descriptionError.isDisplayed();
	}
	
	/**
	 *  Seccionar la categoria 
	 *  
	 * @param String
	 */
	public void setCategory(String categoryName) {
		new Select(categorySelect).selectByVisibleText(categoryName);
	}
	
	/**
	 *  Cambiar el orden del contido 
	 *  
	 * @param String
	 */
	public void setContentBellowOf(String contentTitle) {
		new Select(bellowArticle).selectByVisibleText(contentTitle);
	}
}
