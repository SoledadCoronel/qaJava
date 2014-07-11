package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;

public class RegistrationConfig extends PageBase{
	
	@FindBy (name = "requireRegistration")
	private WebElement requireRegistration;
	
	@FindBy (name = "usesCard")
	private WebElement usesCard;
	
	@FindBy (name = "isNominated")
	private WebElement isNominated;
	
	@FindBy (name = "usesBirthDate")
	private WebElement usesBirthDate;
	
	@FindBy (name = "usesGender")
	private WebElement usesGender;
	
	@FindBy (name = "requireVerification")
	private WebElement requireVerification;
	
	@FindBy (name = "verificationField1")
	private WebElement verificationField1;
	
	@FindBy (name = "verificationField2")
	private WebElement verificationField2;
	
	@FindBy (name = "identityField")
	private WebElement identityField;
	
	@FindBy (name = "hasPassword")
	private WebElement hasPassword;
	
	@FindBy (name = "recoverPassword")
	private WebElement recoverPassword;
	
	@FindBy (id = "c1_htmlSignUp_ifr")
	private WebElement htmlsignupifr;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public RegistrationConfig(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar requiere registracion
	 * 
	 * @param require
	 */
	private void selectRequireRegistration(boolean require) {
		if (require && !requireRegistration.isSelected())
			requireRegistration.click();
		else if (!require && requireRegistration.isSelected())
			requireRegistration.click();
	}
	
	/**
	 * Seleccionar usa tarjeta
	 * 
	 * @param card
	 */
	protected void selectUsesCard(boolean card) {
		if (card && !usesCard.isSelected())
			usesCard.click();
		else if (!card && usesCard.isSelected())
			usesCard.click();
	}
	
	/**
	 * Seleccionar usa fecha de cumpleaños
	 * 
	 * @param birthdate
	 */
	private void selectUsesBirthDate(boolean birthdate) {
		if (birthdate && !usesBirthDate.isSelected())
			usesBirthDate.click();
		else if (!birthdate && usesBirthDate.isSelected())
			usesBirthDate.click();
	}
	
	/**
	 * Seleccionar usa genero
	 * 
	 * @param gender
	 */
	private void selectUsesGender(boolean gender) {
		if (gender && !usesGender.isSelected())
			usesGender.click();
		else if (!gender && usesGender.isSelected())
			usesGender.click();
	}
	
	/**
	 * Seleccionar requiere verificacion
	 * 
	 * @param requireverif
	 */
	private void selectRequireVerification(boolean requireverif) {
		if (requireverif && !requireVerification.isSelected())
			requireVerification.click();
		else if (!requireverif && requireVerification.isSelected())
			requireVerification.click();
	}
	
	/**
	 * Seleccionar el primer campo de verificacion
	 * 
	 * @param field
	 */
	private void selectVerificationField1(String field) {
		Select select = new Select(verificationField1);
		select.selectByVisibleText(field);
	}
	
	/**
	 * Seleccionar el segundo campo de verificacion
	 * 
	 * @param field
	 */
	private void selectVerificationField2(String field) {
		Select select = new Select(verificationField2);
		select.selectByVisibleText(field);
	}
	
	/**
	 * Seleccionar el campo de usuario
	 * 
	 * @param field
	 */
	private void selectIdentityField(String field) {
		Select select = new Select(identityField);
		select.selectByVisibleText(field);
	}
	
	/**
	 * Seleccionar requiere password
	 * 
	 * @param password
	 */
	private void selectHasPassword(boolean password) {
		if (password && !hasPassword.isSelected())
			hasPassword.click();
		else if (!password && hasPassword.isSelected())
			hasPassword.click();
	}
	
	/**
	 * Seleccionar recuperar contraseña
	 * 
	 * @param recover
	 */
	private void selectRecoverPassword(boolean recover) {
		if (recover && !recoverPassword.isSelected())
			recoverPassword.click();
		else if (!recover && recoverPassword.isSelected())
			recoverPassword.click();
	}
	
	/**
	 * Seleccionar es nominada la tarjeta
	 * 
	 * @param nominated
	 */
	private void selectIsNominated(boolean nominated) {
		if (nominated && !isNominated.isSelected())
			isNominated.click();
		else if (!nominated && isNominated.isSelected())
			isNominated.click();
	}
	
	private void completeHtmlSignUp(String text) {
		driver.switchTo().frame(htmlsignupifr);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + text + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Completar la configuracion de la registracion
	 * 
	 * @param require
	 * @param card
	 * @param birthdate
	 * @param gender
	 * @param requireverif
	 * @param field
	 * @param field2
	 * @param fieldidentity
	 * @param password
	 * @param recover
	 * @param nominated 
	 * @param htmlsignup 
	 */
	public void completeConfigRegistration(boolean require, boolean card, boolean birthdate, boolean gender, 
			boolean requireverif, String field, String field2, String fieldidentity, boolean password, boolean recover, 
			boolean nominated, String htmlsignup) {
		selectRequireRegistration(require);
		if (require) {
			selectUsesCard(card);
			selectIsNominated(nominated);
			selectUsesBirthDate(birthdate);
			selectUsesGender(gender);
			selectRequireVerification(requireverif);
			if (requireverif) {
				selectVerificationField1(field);
				selectVerificationField2(field2);
			}
			selectIdentityField(fieldidentity);
			selectHasPassword(password);
			selectRecoverPassword(recover);
			if(!htmlsignup.isEmpty())
				completeHtmlSignUp(htmlsignup);
		}
	}
	
	/**
	 * Obtener el estado de requiere registracion
	 * 
	 * @return boolean
	 */
	public boolean getRequireRegistration() {
		return requireRegistration.isSelected();
	}
	
	/**
	 * Obtener el estado de usa tarjeta
	 * 
	 * @return boolean
	 */
	public boolean getUsesCard() {
		return usesCard.isSelected();
	}
	
	/**
	 * Obtener el estado de Usa fecha de nacimiento
	 * 
	 * @return boolean
	 */
	public boolean getUsesBirthdate() {
		return usesBirthDate.isSelected();
	}
	
	/**
	 * Obtener el estado de usa genero
	 * 
	 * @return boolean
	 */
	public boolean getUsesGender() {
		return usesGender.isSelected();
	}
	
	/**
	 * Obtener el estado de requiere verif
	 * 
	 * @return boolean
	 */
	public boolean getRequireVerif() {
		return requireVerification.isSelected();
	}
	
	/**
	 * Obtener el valor del primer campo de verificacion
	 * 
	 * @return String
	 */
	public String getVerifField1() {
		Select select = new Select(verificationField1);
		
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Obtener el valor del segundo campo de verificacion
	 * 
	 * @return String
	 */
	public String getVerifField2() {
		Select select = new Select(verificationField2);
		
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Obtener el campo de login
	 * 
	 * @return String
	 */
	public String getIdentityField() {
		Select select = new Select(identityField);
		
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Verificar si utiliza password
	 * 
	 * @return boolean
	 */
	public boolean getUsesPassword() {
		return hasPassword.isSelected();
	}
	
	/**
	 * Verificar si tiene recuperar password
	 * 
	 * @return boolean
	 */
	public boolean getRecoverPassword() {
		return recoverPassword.isSelected();
	}

}
