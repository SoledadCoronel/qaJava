package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

public class AplicationEdit extends AplicationInstall{

	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public AplicationEdit(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el nombre de la app
	 * 
	 * @return String
	 */
	public String getAppName() {
		return appname.getText();
	}
	
	/**
	 * Obtener la descrip de la app
	 * 
	 * @return
	 */
	public String getDescription() {
		return description.getText();
	}
	
	public void saveEdit() {
		saveBtn();
	}
	

}
