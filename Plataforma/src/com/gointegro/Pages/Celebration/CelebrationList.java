package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class CelebrationList extends PageBase{
	
	@FindBy (className = "name")
	private WebElement name;
	
	@FindBy (className = "title")
	private WebElement title;
	
	@FindBy (className = "category-name")
	private WebElement categoryname;
	
	@FindBy (className = "media-object")
	private WebElement media;
	
	@FindBy (id = "event-options")
	private WebElement eventoptions;
	
	@FindBy (id = "edit-event")
	private WebElement eventedit;
	
	@FindBy (id = "delete-event")
	private WebElement eventdelete;
	
	

	public CelebrationList(WebDriver driver) {
		super(driver);
	}

}
