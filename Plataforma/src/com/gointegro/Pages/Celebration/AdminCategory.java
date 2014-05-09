package com.gointegro.Pages.Celebration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AdminCategory extends PageBase {
	
	@FindBy (id = "new-category-btn")
	private WebElement newcategorybtn;
	
	@FindBy (className = "btn-edit")
	private WebElement editbtn;
	
	@FindBy (className = "btn-delete")
	private WebElement deletebtn;
	
	@FindBy (xpath = "//*[@id='categories-list']/li")
	private List<WebElement> categorieslist;
	
	@FindBy (name = "name")
	private WebElement categoryname;
	
	@FindBy (id = "btn-category-save")
	private WebElement savecategory;
	
	@FindBy (id = "btn-category-cancel")
	private WebElement cancelcategory;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	private WebElement saveerror;
	
	@FindBy (xpath = "//div[@id='name']/div/div/div")
	private WebElement categorynameerror;
	
	@FindBy (xpath = "//ul[@class='automation']/li/input")
	private WebElement automationbirthdaycheck;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	
	public AdminCategory(WebDriver driver) {
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
	 * Crean o editan una categoria
	 * 
	 * @param name Define el nombre de la categoria
	 * @param isAutomation Define si la categoria a crear/editar es del tipo automatica o no.
	 */
	
	public void createCategory (String name, boolean isAutomation) {
		newcategorybtn.click();
		completeCategoryName(name);
		if (isAutomation)
			automationbirthdaycheck.click();
		savecategory.click();
	}
	
	public void editCategory (String name, boolean isAutomation) {
		completeCategoryName(name);
		if (isAutomation)
			automationbirthdaycheck.click();
		savecategory.click();
	}
	
	/**
	 * Obtiene los mensajes de error mostrados
	 * 
	 * @return
	 */
	
	public String getSaveError() {
		return saveerror.getText();
	}
	
	public String getCategoryNameError() {
		return categorynameerror.getText();
	}
	
	/**
	 * Cancela la creacion de una categoria
	 * 
	 * @param name
	 */
	
	public void cancelCreateCategory(String name) {
		newcategorybtn.click();
		completeCategoryName(name);
		cancelcategory.click();
	}
	
	public void cancelEditCategory(String name) {
		completeCategoryName(name);
		cancelcategory.click();
	}
	
	/**
	 * Busca una categoria presente en el listado de categoria. Retorna true si la encuentra o false si no
	 * 
	 * @param name
	 * @return
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
	 * Muestra si una categoria es automatica basandose en si tiene un texto dado. 
	 * Para comprobar es necesario el assert en el test 
	 * 
	 * @param name
	 * @return
	 */
	
	public String getCategoryAutomationText(String name) {
		String textcontent = null;
		for (WebElement element : categorieslist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				textcontent = element.getText();
				break;
			}
			else {
				textcontent = null;
			}
		}
		return textcontent;
	}
	
	/**
	 * Obtiene el id de una categoria
	 * 
	 * @param name
	 * @return
	 */
	
	public String getCategoryId(String name) {
		String id = null;
		for (WebElement element : categorieslist) {
			if (element.findElement(By.className("span10")).getText().contains(name)){
				System.out.println(name);
				System.out.println(element.getAttribute("data-id"));
				id = element.getAttribute("data-id");
				break;
			}
		}
		
		return id;
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

}
