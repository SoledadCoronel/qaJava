package com.gointegro.Pages.Benenfits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class DetailBenefit extends PageBase {
	
	
	@FindBy(className = "benefit-name")
	WebElement name;
	
	@FindBy(xpath = "//div[@class='details-text']/p")
	WebElement description;
	
	@FindBy(xpath = "//div[@class='shop-location']/p")
	WebElement address;
		
	String paymentMethodList = "//div[@class='text']/ul";
	
	String redeemingList = "//div[@class='access-item']";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailBenefit(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el nombre del beneficio
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Obtener la descripcion del beneficio
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Obtener la direccion del beneficio
	 * 
	 * @return String
	 */
	public String getAddress() {
		return address.getText();
	}
	
	/**
	 * Devuelve true si la forma de pago se encuentra en la lista
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isPaymentInList(String name) {
		return driver.findElement(By.xpath(paymentMethodList)).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si el medio de acceso se encuentra en la lista
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isRedeemingInList(String name) {
		return driver.findElement(By.xpath(redeemingList)).getAttribute("innerHTML").contains(name);
	}
 
}
