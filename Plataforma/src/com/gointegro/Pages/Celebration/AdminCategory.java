package com.gointegro.Pages.Celebration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AdminCategory extends PageBase {
	
	@FindBy (id = "new-category-btn")
	private WebElement newcategorybtn;
	
	@FindBy (id = "categories-list")
	private List<WebElement> categorieslist;
	
	@FindBy (className = "btn-edit")
	private WebElement editbtn;
	
	@FindBy (className = "btn-delete")
	private WebElement deletebtn;

	public AdminCategory(WebDriver driver) {
		super(driver);
	}

}
