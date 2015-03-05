package com.gointegro.Pages.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsContent;
import com.gointegro.Pages.Base.PageBase;

public class HomeContent extends PageBase{
	
	
	@FindBy(className = "new-article")
	private WebElement newContent;
	
	@FindBy(css = "p")
	WebElement title;
	
	@FindBy(css = "div.span24.content > p")
	WebElement description;
	
	@FindBy(xpath = "//button[@title='Editar']")
	WebElement contentOptions;
	
	@FindBy(className = "editArticle")
	WebElement editContent;
	
	@FindBy(className = "delete-article")
	WebElement deleteContent;
	
	@FindBy(name = "btn-category-new")
	WebElement categoryOptions;
	
	@FindBy(id = "category-new")
	WebElement newCategory;
	
	@FindBy(xpath = "//header[@class='app-name']/div/ul[@class='dropdown-menu']/li[2]/a")
	WebElement adminCategory;
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HomeContent(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/app/articles/"+ConfigElementsContent.getIdAppContent();
	}
	
	
	/**
	 * Seleccionar el botón Nuevo contenido
	 * 
	 * @return NewContent
	 */
	public NewContent selectNewContent() {
		newContent.click();
		return PageFactory.initElements(driver, NewContent.class);
	}
	
	
	/**
	 * Obtiner el titulo
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}
	
	
	/**
	 * Obtiner la descripción
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Devuelve si hay una imagen en la descripción
	 * 
	 * @return Boolean
	 */
	public Boolean hasImage() {
		Boolean hasImage = false;
		
		if(driver.findElement(By.xpath("//div[@class='main-container']/div")).getAttribute("innerHTML").contains("<img")) {
			hasImage = true;
		}
		return hasImage;
	}
	
	/**
	 * Seleccionar content option
	 */
	private void selectContentOption() {
		contentOptions.click();
	}
	
	/**
	 * Seleccionar editar contenido
	 */
	private void selectEditContent() {
		editContent.click();
	}
	
	/**
	 * Seleccionar content option y editar contenido
	 * 
	 * @return NewContent
	 */
	public NewContent editContent() {
		selectContentOption();
		selectEditContent();
		
		return PageFactory.initElements(driver, NewContent.class);
	}
	
	/**
	 * Seleccionar eliminar contenido
	 */
	private void selectDeleteContent() {
		deleteContent.click();
	}
	
	/**
	 * Seleccionar content option y editar contenido
	 * 
	 * @return NewContent
	 */
	public NewContent deleteContent() {
		selectContentOption();
		selectDeleteContent();
		
		return PageFactory.initElements(driver, NewContent.class);
	}
	
	/**
	 * Seleccionar category option
	 */
	public void selectCategoryOption() {
		categoryOptions.click();
	}
	
	/**
	 * Seleccionar nueva categoria
	 */
	public void selectNewCategory() {
		newCategory.click();
	}
	
	/**
	 * Seleccionar administrar categorias
	 */
	public void selectAdminCategory() {
		adminCategory.click();
	}
	
	/**
	 * Seleccionar category option y nueva categoria
	 * 
	 * @return AdminCategoryContent
	 */
	public NewCategoryOvelayContent newCategory() {
		selectCategoryOption();
		selectNewCategory();
		
		return PageFactory.initElements(driver, NewCategoryOvelayContent.class);
	}
	
	/**
	 * Seleccionar category option y administrar categorias
	 * 
	 * @return AdminCategoryContent
	 */
	public AdminCategoryContent adminCategory() {
		selectCategoryOption();
		selectAdminCategory();
		
		return PageFactory.initElements(driver, AdminCategoryContent.class);
	}

}
