package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBOBenefits;
import com.gointegro.Pages.Base.PageBase;

public class DetailSpecial extends PageBase {
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[4]")
	WebElement active;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	WebElement portuguese;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement spanish;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[2]")
	WebElement english;
	
	@FindBy(xpath = "//table/tbody/tr[3]/td[2]")
	WebElement validUntil;
	
	@FindBy(xpath = "//table/tbody/tr[3]/td[4]")
	WebElement image;
	
	@FindBy(xpath = "//section[@id='benefits']/div/table/tbody")
	WebElement benefitsList;
	
	@FindBy(xpath = "//header[@class='backoffice-header']/div/div[2]/button")
	WebElement edit;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailSpecial(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve Nombre Español
	 * 
	 * @return String
	 */
	public String getNameES() {
		return spanish.getText();
	}
	
	/**
	 * Devuelve Nombre Portugués
	 * 
	 * @return String
	 */
	public String getNamePT() {
		return portuguese.getText();
	}
	
	/**
	 * Devuelve Nombre Inglés
	 * 
	 * @return String
	 */
	public String getNameEN() {
		return english.getText();
	}
	
	/**
	 * Devuelve Fecha de vencimiento
	 * 
	 * @return String
	 */
	public String getValidUntil() {
		return validUntil.getText();
	}
	
	/**
	 * Devuelve Activo
	 * 
	 * @return String
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Devuelve Imagen
	 * 
	 * @return String
	 */
	public String getImage() {
		return image.getText();
	}
	
	/**
	 * Devuelve true si hay un beneficio en la lista
	 * 
	 * @return boolean
	 */
	public boolean isBenefitInList() {
		return benefitsList.getAttribute("innerHTML").contains(ConfigElementsBOBenefits.getCompanyName());
	}
	
	/**
	 * Seleccionar Editar
	 * 
	 * @return NewSpecial
	 */
	public NewSpecial selectEdit() {
		edit.click();
		return PageFactory.initElements(driver, NewSpecial.class);
	}
}
