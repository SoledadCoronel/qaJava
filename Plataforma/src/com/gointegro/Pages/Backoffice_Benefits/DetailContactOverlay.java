package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailContactOverlay extends PageBase {
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[1]/td[2]")
	WebElement active;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[2]/td[2]")
	WebElement name;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[3]/td[2]")
	WebElement area;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[4]/td[2]")
	WebElement position;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[5]/td[2]")
	WebElement document;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[6]/td[2]")
	WebElement email;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[7]/td[2]")
	WebElement phone;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[8]/td[2]")
	WebElement observation;
	
	@FindBy(xpath = "//section[contains(@class, 'contact-basic-information')]/div/div/table/tbody/tr[9]/td[2]")
	WebElement cellphone;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailContactOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve Activo
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Devuelve el Nombre
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Devuelve la Area
	 */
	public String getArea() {
		return area.getText();
	}
	
	/**
	 * Devuelve la Posición
	 */
	public String getPosition() {
		return position.getText();
	}
	
	/**
	 * Devuelve el Documento
	 */
	public String getDocument() {
		return document.getText();
	}
	
	/**
	 * Devuelve la Email
	 */
	public String getEmail() {
		return email.getText();
	}
	
	/**
	 * Devuelve el Telefono
	 */
	public String getPhone() {
		return phone.getText();
	}
	
	/**
	 * Devuelve las Observaciones
	 */
	public String getObservation() {
		return observation.getText();
	}
	
	/**
	 * Devuelve el Celular
	 */
	public String getCellphone() {
		return cellphone.getText();
	}
}

