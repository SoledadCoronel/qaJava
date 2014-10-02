package com.gointegro.Pages.Celebration;

import java.util.List;

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
	
	@FindBy (xpath = "//div[@class='datepicker-days']/table/tbody/tr")
	List<WebElement> days;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DatePicker(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Selecciona el mes del datepicker, si supera el año 2016 sin encontrarlo tira un break para no loopear forever.
	 * Tiene como corte el 2016, hardcodeado
	 * 
	 * @param date
	 */
	public void selectMonth(String date) {
		String monthtext = DateTool.getMonthText(date);
		
		while (!month.getText().contains(monthtext)) {
			next.click();
			if (month.getText().contains("2016")) {
				break;
			}
		}
	}
	
	/**
	 * Seleccionar un dia en el datepicker
	 * 
	 * @param StringDate
	 */
	public void selectDay(String StringDate) {
		String daytext = DateTool.getDayText(StringDate);
		String dayNumber = DateTool.removeZeroInt(daytext);
		
		for(WebElement day : days) {
			if(day.findElements(By.xpath("/td[class='day']")).size() > 0 && day.findElement(By.xpath("/td[class='day']")).getText().contentEquals(dayNumber)) {
				day.findElement(By.xpath("/td[class='day']")).click();
				break;
			}
		}
	}

}
