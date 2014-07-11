package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class CategoriesList extends PageBase {
	 
	@FindBy(xpath = "//section/div[2]/a")
	WebElement newCategory;
	
	@FindBy(name = "filters[name]")
	WebElement search;
	
	@FindBy(id = "name-filter-btn-submit")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@class='backgrid-category-list']/table/tbody/tr")
	List<WebElement> categoryList;
	
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
	
	/**
	 * Buscar una categoria por el nombre
	 * 
	 * @param name
	 */
	public void searchCategory(String name) {
		search.clear();
		search.sendKeys(name);
		searchBtn.click();
	}
	
	/**
	 * Devuelve un WebElement del beneficio
	 * 
	 * @param name
	 * @return
	 */
	public WebElement getCategoryElement(String name) {
		WebElement element = null;
		
		for(WebElement ele : categoryList) {
			if(ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				element = ele;
			}
		}
		return element;
	}
	
	/**
	 * Devuelve el Nombre en Español
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getNameES(WebElement element) {
		return element.findElement(By.xpath("./td/a")).getText();
	}
	
	/**
	 * Devuelve el Nombre en Portugués
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getNamePT(WebElement element) {
		return element.findElement(By.xpath("./td[2]/a")).getText();
	}
	
	/**
	 * Devuelve el Nombre en Inglés
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getNameEN(WebElement element) {
		return element.findElement(By.xpath("./td[3]/a")).getText();
	}
	
	/**
	 * Devuelve true si esta Activo
	 * 
	 * @param WebElement
	 * @return boolean
	 */
	public boolean isActive(WebElement element) {
		return element.findElements(By.xpath("./td[4]/span[contains(@class, 'glyphicon-ok')]")).size() > 0;
	}
	
}
