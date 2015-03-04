package com.gointegro.Pages.Content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

 /**
  * 
  *  PO. Nueva categoria desde overlay (versión content)
  * 
  * @author diogodarosa
  *
  */
public class NewCategoryOvelayContent extends PageBase{
	
	@FindBy (name = "name")
	private WebElement categoryname;
	
	@FindBy (xpath = "//*[@id='modal-new-cat']/div[3]/button[1]")
	private WebElement savebtn;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement cancelbtn;
	
	@FindBy (className = "close")
	private WebElement closebtn;
	
	@FindBy (xpath = "//*[@id='modal-new-cat']/div[2]/div[1]")
	private WebElement categoryNameExistsError;
	
	@FindBy (xpath = "//div[@id='category-modal']/div[2]/div")
	private WebElement saveerror;
	
	@FindBy (xpath = ".//*[@id='name']/div/div")
	WebElement categorynameerror;

	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewCategoryOvelayContent(WebDriver driver) {
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
	 */
	public void createCategory(String name) {
		completeCategoryName(name);
		savebtn.click();
	}
	
	/**
	 * Obtiene los errores mostrados al crear una categoria
	 * 
	 * @return String
	 */
	public String getCategoryNameExistsError() {
		return categoryNameExistsError.getText();
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
