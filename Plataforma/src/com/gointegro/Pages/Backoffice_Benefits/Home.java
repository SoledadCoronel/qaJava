package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class Home extends PageBase {
	
	@FindBy(xpath = "//section/div[2]/button")
	WebElement newCompany;
	
	@FindBy(xpath = "//section/div[1]/div[2]/a[1]")
	WebElement adminSpecials;
	
	@FindBy(xpath = "//section/div[1]/div[2]/a[2]")
	WebElement adminCategory;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Home(WebDriver driver) {
		super(driver);
	}

	/**
	 * Seleccionar el botón Nuevo Comercio
	 */
	public void selectNewCompany() {
		newCompany.click();
	}
	
	/**
	 * Seleccionar el botón Adminsitrar especiales
	 */
	public void selectAdminSpecials() {
		adminSpecials.click();
	}
	
	/**
	 * Seleccionar el botón Adminsitrar categorias
	 */
	public void selectAdminCategory() {
		adminCategory.click();
	}
}
