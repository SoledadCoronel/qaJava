package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;

public class AplicationEdit extends AplicationInstall{

	/**
	 * Constructor 
	 * 
	 * @param driver
	 * @param id_app
	 */
	public AplicationEdit(WebDriver driver, String id_app) {
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
	
	

}
