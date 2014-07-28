package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class NewContactForStore extends PageBase {
	
	@FindBy(xpath = "//form[@class='form-horizontal']/div[2]/div/div/div/div/span/input")
	WebElement firstname;
	
	@FindBy(xpath = "//form[@class='form-horizontal']/div[3]/div/div/div/div/span/input")
	WebElement surname;
	
	@FindBy(xpath = "//div[@class='modal-footer']/section/button[1]")
	WebElement save;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewContactForStore(WebDriver driver) {
		super(driver);
	}

	/**
	 * Crear Nombre
	 * @param name
	 */
	public void createFirstName(String name) {
		firstname.clear();
		firstname.sendKeys(name);
	}
	
	/**
	 * Crear Apellido
	 * 
	 * @param name
	 */
	public void createSurname(String name) {
		surname.clear();
		surname.sendKeys(name);
	}

	/**
	 * Seleccionar Guardar
	 */
	public void selectSave() {
		save.click();
	}
}
