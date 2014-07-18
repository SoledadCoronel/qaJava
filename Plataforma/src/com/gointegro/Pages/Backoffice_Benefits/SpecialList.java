package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class SpecialList extends PageBase {
	
	@FindBy(xpath = "//section/div[2]/a")
	WebElement newSpecial;
	
	String specialURL = ConfigElementsBO.getUrlBackoffice() + "/benefits/collection/list";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SpecialList(WebDriver driver) {
		super(driver);
		URL = specialURL;
	}
	
	/**
	 * Devuelve la URL de Especiales
	 * 
	 * @return String
	 */
	public String getSpecialURL() {
		return specialURL;
	}
	
	/**
	 * Seleccionar el botón Nuevo Especial
	 * 
	 * @return NewSpecial
	 */
	public NewSpecial selectNewSpecial() {
		newSpecial.click();
		return PageFactory.initElements(driver, NewSpecial.class);
	}

}
