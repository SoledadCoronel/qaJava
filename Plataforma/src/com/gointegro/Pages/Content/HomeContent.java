package com.gointegro.Pages.Content;

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
	
	public NewContent editContent() {
		selectContentOption();
		selectEditContent();
		
		return PageFactory.initElements(driver, NewContent.class);
	}

}
