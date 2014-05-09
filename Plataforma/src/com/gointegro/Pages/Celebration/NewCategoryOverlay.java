package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

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
	 * Cosntructor
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
	 * isAutomation define si la categoria sera automatica o no
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
	 * @return
	 */
	
	public String getCategoryNameError() {
		return categorynameerror.getText();
	}
	
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
