package com.gointegro.Pages.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class Verification extends PageBase{
	
	@FindBy (id = "_verificationValue1")
	private WebElement _verificationValue1;
	
	@FindBy (id = "_verificationValue2")
	private WebElement _verificationValue2;
	
	@FindBy (id = "verificationSubmit")
	private WebElement verificationSubmit;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Verification(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar el primer campo de verificacion
	 * 
	 * @param value1
	 */
	private void complete_verificationValue1(String value1) {
		_verificationValue1.clear();
		_verificationValue1.sendKeys(value1);
	}
	
	/**
	 * Completar el segundo campo de verificacion
	 * 
	 * @param value2
	 */
	private void complete_verificationValue2(String value2) {
		_verificationValue2.clear();
		_verificationValue2.sendKeys(value2);
	}
	
	/**
	 * Seleccionar Aceptar
	 */
	public SignUp selectVerifSubmit() {
		verificationSubmit.click();
		
		return PageFactory.initElements(driver, SignUp.class);
	}
	
	/**
	 * Completar la verificacion
	 * 
	 * @param value1
	 * @param value2
	 */
	public void completeVerif(String value1, String value2) {
		complete_verificationValue1(value1);
		if (!value2.isEmpty())
			complete_verificationValue2(value2);
		
	}

}
