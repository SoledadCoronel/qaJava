package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class HomeBenefits extends PageBase {
	
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
	public HomeBenefits(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/benefits/company/list";
	}

	/**
	 * Seleccionar el botón Nuevo Comercio
	 * 
	 * @return NewCompany
	 */
	public NewCompany selectNewCompany() {
		newCompany.click();
		return PageFactory.initElements(driver, NewCompany.class);
	}
	
	/**
	 * Seleccionar el botón Adminsitrar especiales
	 * 
	 * @return SpecialList
	 */
	public SpecialList selectAdminSpecials() {
		adminSpecials.click();
		return PageFactory.initElements(driver, SpecialList.class);
	}
	
	/**
	 * Seleccionar el botón Adminsitrar categorias
	 */
	public CategoriesList selectAdminCategory() {
		adminCategory.click();
		return PageFactory.initElements(driver, CategoriesList.class);
	}
}
