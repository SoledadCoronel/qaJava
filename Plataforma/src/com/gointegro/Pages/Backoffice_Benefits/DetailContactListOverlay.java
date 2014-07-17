package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailContactListOverlay extends PageBase {
	
	@FindBy(xpath = "//table[contains(@class, 'table-contact-list')]/tbody/tr")
	List<WebElement> contactList;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailContactListOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Selecciona el primero contacto de la lista y devuelve el nombre
	 * 
	 * @return String
	 */
	public String selectFirstContact() {
		String name = "";
		
		for(WebElement ele : contactList) {
			if(ele.findElements(By.xpath("./td/a")).size() > 0) {
				ele.findElement(By.xpath("./td/a")).click();
				name = ele.findElement(By.xpath("./td/a")).getText();
			}
		}
		return name;
	}

}
