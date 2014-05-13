package com.gointegro.Pages.Celebration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsCelebration;
import com.gointegro.Pages.Base.PageBase;

public class HomeCelebrations extends PageBase{
	
	@FindBy(xpath = "//header[@class='app-name']/div/a")
	private WebElement neweventheader;
	
	@FindBy(id = "btn-admin-categories")
	private WebElement admincategbtn;
	
	@FindBy(id = "category-new")
	private WebElement newcategory;
	
	@FindBy(id = "admin-categories")
	private WebElement admincategories;
	
	@FindBy(id = "events-filter-today")
	private WebElement filtertoday;
	
	@FindBy(xpath = "//*[@id='category-list']/ul/li")
	private List<WebElement> categorylist;

	/** Constructor */
	
	public HomeCelebrations(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/app/celebrations/"+ConfigElementsCelebration.getIdAppCelebraciones();
	}
	
	/** Private methods */
	
	public NewEvent selectNewEvent() {
		neweventheader.click();
		return PageFactory.initElements(driver, NewEvent.class);
	}
	
	private void selectCategoryMenu() {
		admincategbtn.click();
	}
	
	/** Public methods */
	
	public NewCategoryOverlay selectNewCategory() {
		selectCategoryMenu();
		newcategory.click();
		return PageFactory.initElements(driver, NewCategoryOverlay.class);
	}
	
	public AdminCategory selectAdminCategory() {
		selectCategoryMenu();
		admincategories.click();
		return PageFactory.initElements(driver, AdminCategory.class);
	}
	
	public NewEvent selectNewCelebration() {
		neweventheader.click();
		return PageFactory.initElements(driver, NewEvent.class);
	}
	
	public boolean isCategoryInSideBar(String name) {
		boolean status = false;
		for (WebElement element : categorylist) {
			if (element.getText().contains(name)) {
				status = true;
				break;
			}
			else {
				status = false;
			}
		}
		return status;
	}
	
	public CelebrationList selectCategoryInSideBar(String categoryname) {
		for (WebElement element : categorylist) {
			if (element.getText().contains(categoryname)) {
				//Como la categoria por defecto queda seleccionada hay que hacer "doble click" para que funcione, 
				//queda asi total no afecta en nada
				element.click();
				element.click();
				break;
			}
			else {
				//
			}
		}
		return PageFactory.initElements(driver, CelebrationList.class);
	}

}
