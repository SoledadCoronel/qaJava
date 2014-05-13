package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Manejo del datepicker con el calendario
 * 
 * @author gustavomoreira
 *
 */
public class DatePicker extends PageBase{

	@FindBy (className = "prev")
	private WebElement prev;
	
	@FindBy (className = "next")
	private WebElement next;
	
	@FindBy (className = "datepicker-switch")
	private WebElement month;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DatePicker(WebDriver driver) {
		super(driver);
	}
	
	public void selectMonth() {
		
		while (!month.getText().equals("Diciembre 2014")) {
			next.click();
		}
		
		System.out.println(month.getText());
	}

}
