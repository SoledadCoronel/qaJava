package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class CategoriesList extends PageBase {
	 
	@FindBy(xpath = "//section/div[2]/button")
	WebElement newCategory;
	
	String categoryURL = ConfigElementsBO.getUrlBackoffice() + "/benefits/categories/list";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CategoriesList(WebDriver driver) {
		super(driver);
		URL = categoryURL;
	}

	/**
	 * Devuelve la url de Categoría
	 * 
	 * @return String
	 */
	public String getNewCategoryURL() {
		return categoryURL;
	}
	
	/**
	 * Seleccionar el botón Nueva Categoría
	 */
	public NewCategory selectNewCategory() {
		newCategory.click();
		return PageFactory.initElements(driver, NewCategory.class);
	}
}
