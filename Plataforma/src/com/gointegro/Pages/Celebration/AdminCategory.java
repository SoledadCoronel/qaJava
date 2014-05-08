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
	
	@FindBy (xpath = "//ul[@class='automations']/li/input")
	private WebElement automationbirthdaycheck;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	
	public AdminCategory(WebDriver driver) {
		super(driver);
	}
	
	private void completeCategoryName(String name) {
		categoryname.clear();
		categoryname.sendKeys(name);
	}
	
	public void createCategory (String name, boolean isAutomation) {
		newcategorybtn.click();
		completeCategoryName(name);
		if (isAutomation)
			automationbirthdaycheck.click();
		savecategory.click();
	}
	
	public String getSaveError() {
		return saveerror.getText();
	}
	
	public String getCategoryNameError() {
		return categorynameerror.getText();
	}
	
	public void cancelCreateCategory(String name) {
		newcategorybtn.click();
		completeCategoryName(name);
		cancelcategory.click();
	}
	
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
	
	public String getCategoryAutomationText(String name){
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

}
