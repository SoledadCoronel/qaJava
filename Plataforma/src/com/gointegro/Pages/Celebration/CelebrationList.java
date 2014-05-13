package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.DateTool;

public class CelebrationList extends PageBase{
	
	@FindBy (className = "name")
	private WebElement name;
	
	@FindBy (className = "title")
	private WebElement title;
	
	@FindBy (xpath = "//div[@class='category-day']/a")
	private WebElement categoryname;
	
	@FindBy (className = "description")
	private WebElement description;
	
	@FindBy (className = "media-object")
	private WebElement media;
	
	@FindBy (id = "event-options")
	private WebElement eventoptions;
	
	@FindBy (id = "edit-event")
	private WebElement eventedit;
	
	@FindBy (id = "delete-event")
	private WebElement eventdelete;
	
	@FindBy (className = "todayview-date")
	private WebElement todayviewdate;
	
	

	public CelebrationList(WebDriver driver) {
		super(driver);
	}
	
	private String getTodayViewDate () {
		return todayviewdate.getAttribute("datetime");
	}
	
	public String getTodayDate() {
		return DateTool.TimeFormatTodayViewDate(getTodayViewDate());
	}
	
	public String getCollaboratonName() {
		return name.getText();
	}
	
	public String getCategory() {
		return categoryname.getText();
	}
	
	public String getTitle() {
		return title.getText();
	}
	
	public String getDescription() {
		return description.getText();
	}
	
	public String getImgAlt() {
		return media.getAttribute("alt");
	}
	

}
