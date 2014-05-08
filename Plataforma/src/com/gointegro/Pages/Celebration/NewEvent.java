package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class NewEvent extends PageBase{
	
	@FindBy (id = "collaborators-container-input")
	protected WebElement collaborators;
	
	@FindBy (id = "title")
	protected WebElement title;
	
	@FindBy (id = "description")
	protected WebElement description;
	
	@FindBy (id = "accept")
	protected WebElement savebtn;
	
	@FindBy (id = "cancel")
	protected WebElement cancelbtn;
	
	@FindBy (id = "form-category-new")
	protected WebElement newcategory;
	
	@FindBy (id = "categories")
	protected WebElement categories;
	
	@FindBy (id = "date")
	protected WebElement date;
	
	@FindBy (xpath = "//div[@class='collaborators']//div[@class='error']/div/div")
	protected WebElement collaboratoserrormsj;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	protected WebElement saveerror;
	
	@FindBy (xpath = "//span[@class='categories']//div[@class='error']/div/div")
	protected WebElement categorieserrormsj;
	
	@FindBy (xpath = "//span[@class='date']//div[@class='error']/div/div")
	protected WebElement dateerrormsj;

	public NewEvent(WebDriver driver) {
		super(driver);
	}
	
	public NewCategoryOverlay selectNewCategory() {
		newcategory.click();
		return PageFactory.initElements(driver, NewCategoryOverlay.class);
	}
	
	public String getCategoryPresent() {
		return categories.getText();
	}

}
