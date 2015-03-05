package com.gointegro.Pages.News;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class FilterNews extends PageBase {
	
	
	@FindBy(xpath = "//div[@class='tree-container']/ul/li")
	List<WebElement> filterList;
	
	@FindBy(xpath = "//a[@data-filter-type='last-week']")
	WebElement lastWeekBtn;
	
	String monthInList = "label/a";
	
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public FilterNews(WebDriver driver) {
		super(driver);
	}

	
	/**
	 * Devuelve si el mes se encuentra en el filtro
	 * 
	 * @param String
	 */
	public Boolean isMonthOnList(String month) {
		Boolean isMonthOnList = false;
		
		for (WebElement element: filterList) {
		      if (element.getText().contains(month)){
		    	  isMonthOnList = true;
		    	  break;
		      }
		}
		return isMonthOnList;
	}
	
	/**
	 * Seleccionar el mes en el filtro
	 * 
	 * @param String
	 */
	public void selectMonth(String month) {
		for (WebElement element: filterList) {
		      if (element.getText().contains(month)){
		    	  element.findElement(By.xpath(monthInList)).click();
		    	  break;
		      }
		}
	}
	
	public void selectLastWeek() {
		lastWeekBtn.click();
	}
	
	
}
