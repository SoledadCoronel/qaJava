package com.gointegro.Pages.Platform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.gointegro.Pages.Base.PageBase;

public class PlatformSelectOverlay extends PageBase{

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlatformSelectOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar una plataforma para loguear de acuerdo a el id que le pasamos
	 * 
	 * @param platformid
	 */
	public void selectPlatform(String platformid) {
		//No se pudo usar Annotations porque tiene que ser static final platformid, y claramente va variando.
		driver.findElement(By.xpath("//button[contains(@data-platform-id,'"+platformid+"')]")).click();
	}

}
