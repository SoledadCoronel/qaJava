package com.gointegro.Pages.Content;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class NewContent extends PageBase{

	@FindBy(id = "title_ifr")
	WebElement title;
	
	@FindBy(id = "content_ifr")
	WebElement description;
	
	@FindBy(id = "accept")
	WebElement savebtn;
	
	@FindBy(id = "category-new")
	WebElement newCategory;
	
	@FindBy(id = "title-error")
	WebElement titleError;
	
	@FindBy(id = "content-error")
	WebElement descriptionError;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewContent(WebDriver driver) {
		super(driver);
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
}
