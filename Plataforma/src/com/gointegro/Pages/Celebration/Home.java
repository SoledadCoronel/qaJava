package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class Home extends PageBase{
	
	@FindBy(xpath = "//header[@class='app-name'/div/a")
	private WebElement neweventheader;
	
	@FindBy(id = "btn-admin-categories")
	private WebElement admincategbtn;
	
	@FindBy(id = "category-new")
	private WebElement newcategory;
	
	@FindBy(id = "admin-categories")
	private WebElement admincategories;
	
	@FindBy(id = "events-filter-today")
	private WebElement filtertoday;

	public Home(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/app/celebrations/"+ConfigElements.getIdAppCelebraciones();
	}
	
	public NewEvent selectNewEvent() {
		neweventheader.click();
		return PageFactory.initElements(driver, NewEvent.class);
	}
	
	private void selectCategoryMenu() {
		admincategbtn.click();
	}

}
