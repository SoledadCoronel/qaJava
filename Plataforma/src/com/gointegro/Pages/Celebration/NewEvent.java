package com.gointegro.Pages.Celebration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class NewEvent extends PageBase{
	
	@FindBy (id = "collaborators-container-input")
	private WebElement collaborators;
	
	@FindBy (id = "title")
	private WebElement title;
	
	@FindBy (id = "description")
	private WebElement description;
	
	@FindBy (id = "accept")
	private WebElement savebtn;
	
	@FindBy (id = "cancel")
	private WebElement cancelbtn;
	
	@FindBy (id = "form-category-new")
	private WebElement newcategory;
	
	@FindBy (id = "categories")
	private WebElement categories;
	
	@FindBy (id = "date")
	private WebElement date;
	
	@FindBy (xpath = "//div[@class='collaborators']//div[@class='error']/div/div")
	private WebElement collaboratoserrormsj;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	private WebElement saveerror;
	
	@FindBy (xpath = "//span[@class='categories']//div[@class='error']/div/div")
	private WebElement categorieserrormsj;
	
	@FindBy (xpath = "//span[@class='date']//div[@class='error']/div/div")
	private WebElement dateerrormsj;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']/div/span")
	private WebElement textlabel;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']")
	private WebElement textlist;
	

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
	
	private void selectCategory(String categoryname) {
		new Select(categories).selectByVisibleText(categoryname);
	}
	
	private void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('date').value='"+date+"'");
	}
	
	private void completeTitle (String titletext) {
		title.clear();
		title.sendKeys(titletext);
	}
	
	private void completeDescription (String descriptiontext) {
		description.clear();
		description.sendKeys(descriptiontext);
	}
	
	private void completeCollaborator (String collaboratorname) {
		collaborators.clear();
		collaborators.sendKeys(collaboratorname); 
		WaitTool.waitForJQueryProcessing(driver, 5);
		selectColaboratorList(collaboratorname);
	}
	
	private void selectColaboratorList(String collaboratorname) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(textlist, collaboratorname));		
		textlabel.click();
	}
	
	public HomeCelebrations completeCelebration (String categoryname, String date, String titletext, String descriptiontext, String collaboratorname) {
		completeCollaborator(collaboratorname);
		completeTitle(titletext);
		completeDescription(descriptiontext);
		selectCategory(categoryname);
		selectDate(date);
		savebtn.click();
		
		return PageFactory.initElements(driver, HomeCelebrations.class);
	}
	

}
