package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElementsBO;

public class EditPlatform extends CreatePlatform {
	
	@FindBy (name = "defaultRole")
	private WebElement defaultRole;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EditPlatform(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/platform/"+ConfigElementsBO.getPlatformId()+"/edit";
	}
	
	/**
	 * Obtener el nombre de la plataforma
	 * 
	 * @return String
	 */
	public String getPlatformName() {
		return name.getAttribute("value");
	}
	
	/**
	 * Obtener el tamaño maximo de la imagen
	 * 
	 * @return String
	 */
	public String getImageSize() {
		return imageSize.getAttribute("value");
	}
	
	/**
	 * Obtener el tamaño maximo del video
	 * 
	 * @return String
	 */
	public String getVideoSize() {
		return videoSize.getAttribute("value");
	}
	
	/**
	 * Obtener el storage de la plataforma
	 * 
	 * @return String
	 */
	public String getStorage() {
		return storage.getAttribute("value");
	}
	
	/**
	 * Obtener la industria seleccionada
	 * 
	 * @return String
	 */
	public String getIndustry() {
		Select select = new Select(industry);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el rango de usuarios
	 * 
	 * @return String
	 */
	public String getUsersRange() {
		Select select = new Select(usersRange);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el estado de disable de la plataforma
	 * 
	 * @return boolean
	 */
	public boolean getDisableStatus() {
		boolean status = false;
		if (disable.getAttribute("checked") != null)
			status = true;
		
		return status;
	}
	
	/**
	 * Obtener el codigo de GA
	 * 
	 * @return String
	 */
	public String getGoogleAnaString() {
		return googleAnalyticsTracking.getAttribute("value");
	}
	
	/**
	 * Obtener la url de la plataforma
	 * 
	 * @return String
	 */
	public String getWebSite() {
		return webSite.getAttribute("value");
	}
	
	/**
	 * Obtener la visibilidad entre usuarios
	 * 
	 * @return String
	 */
	public String getVisibility() {
		Select select = new Select(userVisibility);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el estado del checkbox Habilitar Social
	 * 
	 * @return
	 */
	public boolean getSocialStatus() {
		boolean status = false;
		if (socialEnabled.getAttribute("checked") != null)
			status = true;
		
		return status;
	}
	
	/**
	 * Obtener la zona horaria de la plataforma
	 * 
	 * @return String
	 */
	public String getTimeZone() {
		Select select = new Select(timeZone);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el rol defecto de la plataforma
	 *
	 * @return String
	 */
	public String getRole() {
		Select select = new Select(defaultRole);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Seleccionar el rol definido
	 * 
	 * @param role
	 */
	public void setDefaultRole(String role) {
		Select select = new Select(defaultRole);
		select.selectByVisibleText(role);
	}

}
