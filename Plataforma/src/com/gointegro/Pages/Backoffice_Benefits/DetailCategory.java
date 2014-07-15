package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailCategory extends PageBase {
	
	
	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]")
	WebElement portuguese;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	WebElement spanish;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[4]")
	WebElement english;
	
	@FindBy(xpath = "//section[@id='categories']/div/div/a")
	WebElement newSubcategory;
	
	@FindBy(xpath = "//ol[@class='breadcrumb']/li[4]/a")
	WebElement breadCrumbCategory;
	
	@FindBy(xpath = "//section[@id='categories']/div/table/tbody/tr")
	List<WebElement> subcategoryList;
	
	String tags = "//section[@id='tags']/div/div";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailCategory(WebDriver driver) {
		super(driver);
	}

	/**
	 * Devuelve Categoría Español
	 */
	public String getCatES() {
		return spanish.getText();
	}
	
	/**
	 * Devuelve Categoría Portugués
	 */
	public String getCatPT() {
		return portuguese.getText();
	}
	
	/**
	 * Devuelve Categoría Inglés
	 */
	public String getCatEN() {
		return english.getText();
	}
	
	/**
	 * Devuelve true si el tag esta presente
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isTagPresent(String name) {
		return driver.findElement(By.xpath(tags)).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve Categoría Español
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Seleccionar Nuevo
	 */
	public void selectNewSubCategory() {
		newSubcategory.click();
	}
	
	/**
	 * Seleccionar la categoria padre de una subcategoria en el breadcrumb
	 */
	public void selectBreadcrumbCategory(){
		breadCrumbCategory.click();
	}
	
	/**
	 * Devuelve true si la subcategoria se encuentra en la lista
	 * 
	 * @param name
	 * @return
	 */
	public boolean isSubCategoryInLsit(String name) {
		boolean isSubInList = false;
		
		for(WebElement element : subcategoryList) {
			if(element.findElement(By.xpath("./td/a")).getText().contains(name)) {
				isSubInList = true;
			}
		}
		return isSubInList;
	}
}
