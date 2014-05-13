package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DeleteOverlay extends PageBase{
	
	@FindBy (xpath = "//div[@id='delete-modal']//div[@class='modal-footer']/button")
	private WebElement confirmdelete;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement canceldelete;
	
	@FindBy (className = "close")
	private WebElement closeoverlay;

	public DeleteOverlay(WebDriver driver) {
		super(driver);
	}
	
	public void selectConfirmDelete() {
		confirmdelete.click();
	}
	
	public void selectCancelDelete() {
		canceldelete.click();
	}

}
