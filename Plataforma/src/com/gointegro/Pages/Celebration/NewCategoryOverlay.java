package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Nueva categoria desde overlay
 * 
 * @author gustavomoreira
 *
 */
public class NewCategoryOverlay extends PageBase{
	
	@FindBy (id = "category-name")
	private WebElement categoryname;
	
	@FindBy (id = "category-automations-0")
	private WebElement categoryautomation;
	
	@FindBy (name = "new-category")
	private WebElement savebtn;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement cancelbtn;
	
	@FindBy (className = "close")
	private WebElement closebtn;
	
	@FindBy (xpath = "//div[@class='modal-body']/div/div/div/div")
	private WebElement categorynameerror;
	
	@FindBy (xpath = "//div[@id='category-modal']/div[2]/div")
	private WebElement saveerror;
	

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewCategoryOverlay(WebDriver driver) {
		super(driver);
		
	}
	
	
	/** 
	 * Completa el nombre de la categoria
	 * 
	 * @param name
	 */
	private void completeCategoryName(String name) {
		categoryname.clear();
		categoryname.sendKeys(name);
	}
	
	
	/** 
	 * Crea la categoria.
	 * 
	 * @param name
	 * @param isAutomation
	 */
	public void createCategory(String name, boolean isAutomation) {
		completeCategoryName(name);
		if (isAutomation)
			categoryautomation.click();
		savebtn.click();
	}
	
	/**
	 * Obtiene los errores mostrados al crear una categoria
	 * 
	 * @return String
	 */
	public String getCategoryNameError() {
		return categorynameerror.getText();
	}
	
	/**
	 * Obtiene los mensajes de error mostrados debajo del textbox
	 * 
	 * @return String
	 */
	public String getSaveError() {
		return saveerror.getText();
	}
	
	/**
	 * Cancela la creacion de la categoria
	 * 
	 * @param name
	 */
	public void cancelCreate(String name) {
		completeCategoryName(name);
		cancelbtn.click();
	}
	
}
