package com.gointegro.Pages.Celebration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.DateTool;

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
	
	public void selectMonth(String date) {
		String monthtext = DateTool.getMonthText(date);
		String yeartext = DateTool.getYearText(date);
		while (!month.getText().equals(monthtext+" "+yeartext)) {
			next.click();
		}
	}
	
	public void selectDay(String StringDate) {
		String daytext = DateTool.getDayText(StringDate);
		//No se puede usar annotations, por eso volvemos al driver.findelement
		driver.findElement(By.xpath("//div[@class='datepicker-days']//td[contains(text(),'"+daytext+"')]")).click();
	}

}
