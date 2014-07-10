package com.gointegro.Pages.Content;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsContent;
import com.gointegro.Pages.Celebration.AdminCategory;
import com.gointegro.Pages.Content.DeleteOverlay;

public class AdminCategoryContent extends AdminCategory {

	
	@FindBy (id = "newCategoryBtn")
	private WebElement newcategorybtn;
	
	@FindBy (id = "btnCategorySave")
	private WebElement savecategory;
	
	@FindBy (id = "btnCategoryCancel")
	private WebElement cancelcategory;
	
	@FindBy (xpath = "//*[@id='admin-categories']/ul/li")
	private List<WebElement> categorieslist;
	
	@FindBy (xpath = "//div[@id='flash-messages']/div")
	private WebElement saveerror;
	
	@FindBy (xpath = "//*[@id='admin-categories']/ul[contains(@class,'categories-list')]/div/div/div/div/div")   
	private WebElement categorynameerror;
	
	@FindBy (xpath = "//*[@id='admin-categories']/div[3]/div/div/div/div")   
	private WebElement maxcharserror;
	
	
	public AdminCategoryContent(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/app/articles/" + ConfigElementsContent.getIdAppContent() + "/categories/admin";
	}
	
	
	/**
	 * Crear una categoria
	 * 
	 * @param name Define el nombre de la categoria
	 */
	public void createCategory(String name) {
		newcategorybtn.click();
		completeCategoryName(name);
		
		savecategory.click();
	}
	
	
	/**
	 * Cancela la edicion de una categoria
	 * 
	 * @param name
	 */
	public void cancelEditCategory(String name) {
		completeCategoryName(name);
		cancelcategory.click();
	}
	
	
	/**
	 * Editar una categoria
	 * 
	 * @param name
	 * @param isAutomation
	 */
	public void editCategory (String name) {
		completeCategoryName(name);

		savecategory.click();
	}
	
	/**
	 * Busca una categoria presente en el listado de categoria. Retorna true si la encuentra o false si no
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isCategoryInList(String name) {
		boolean status = false;
		for (WebElement element : categorieslist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				status = true;
				break;
			}
			else {
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Obtiene el mensaje de error mostrado debajo del textbox
	 * 
	 * @return String
	 */
	public String getCategoryNameError() {
		return categorynameerror.getText();
	}
	
	
	/**
	 * Obtiene el mensaje de error mostrado debajo del textbox
	 * 
	 * @return String
	 */
	public String getMaxCharsError() {
		return maxcharserror.getText();
	}
	
	
	/**
	 * Selecciona el boton editar de una categoria dada
	 * 
	 * @param name
	 */
	public void selectCategoryEdit(String name) {
		for (WebElement element : categorieslist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				element.findElement(By.className("btn-edit")).click();
				break;
			}
		}
	}
	
	
	/**
	 * Abre el overlay de delete para la categoria dada
	 * 
	 * @param name
	 * @return DeleteOverlay
	 */
	public DeleteOverlay selectCategoryDelete(String name) {
		DeleteOverlay deleteoverlay = null;
		for (WebElement element : categorieslist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				element.findElement(By.className("btn-delete")).click();
				deleteoverlay = PageFactory.initElements(driver, DeleteOverlay.class);
				break;
			}
			else {
				deleteoverlay = null;
			}
		}
		return deleteoverlay;
	}
	
	
	/**
	 * Obtiene los mensajes de error mostrados
	 * 
	 * @return String
	 */
	public String getSaveError() {
		return saveerror.getText();
	}
	
}
