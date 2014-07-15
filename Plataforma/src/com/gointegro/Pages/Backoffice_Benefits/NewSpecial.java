package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class NewSpecial extends PageBase {
	
	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(id = "pt_BR")
	WebElement portuguese;
	
	@FindBy(id = "es_ES")
	WebElement spanish;
	
	@FindBy(id = "en_US")
	WebElement english;
	
	@FindBy(xpath = "//div[@id='translations']/div[1]/div/div/div/div")
	WebElement spanishErrorMsg;
	
	@FindBy(xpath = "//div[@id='translations']/div[2]/div/div/div/div")
	WebElement portugueseErrorMsg;
	
	@FindBy(xpath = "//div[@id='translations']/div[3]/div/div/div/div")
	WebElement englishErrorMsg;
	
	@FindBy(xpath = "//div[@id='valid-until-field']/div/div/div[1]")
	WebElement dateErrorMsg;
		
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@data-fields='image']/div/div/div")
	WebElement imageErrorMsg;
	
	@FindBy(xpath = "//div[@id='benefits']/div/div/div")
	WebElement benefitsErrorMsg;
	
	@FindBy(name = "search-companies")
	WebElement searchBenefits;
	
	@FindBy(xpath = "//div[@id='search-companies']/span/button")
	WebElement searchBenefitsBtn;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewSpecial(WebDriver driver) {
		super(driver);
	}

	/**
	 * Seleccionar el checkbox Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar el campo Español
	 * 
	 * @param name
	 */
	public void completeSpanish(String name) {
		spanish.clear();
		spanish.sendKeys(name);
	}
	
	/**
	 * Completar el campo Portugués
	 * 
	 * @param name
	 */
	public void completePortuguese(String name) {
		portuguese.clear();
		portuguese.sendKeys(name);
	}
	
	/**
	 * Completar el campo Inglés
	 * 
	 * @param name
	 */
	public void completeEnglish(String name) {
		english.clear();
		english.sendKeys(name);
	}
	
	/**
	 * Devuelve el mensaje de error del campo Español
	 */
	public String getSpanishError() {
		return spanishErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del campo Portugués
	 */
	public String getPortugueseError() {
		return portugueseErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del campo Inglés
	 */
	public String getEnglishError() {
		return englishErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de la Fecha de Vencimiento
	 */
	public String getDateError() {
		return dateErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de la imagen
	 * @return
	 */
	public String getImageError() {
		return imageErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Beneficios
	 * @return
	 */
	public String getBenefitsError() {
		return benefitsErrorMsg.getText();
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param date
	 */
	protected void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('validUntil')[1].value='"+date+"'");
	}
	
	/**
	 * Crear un especial
	 * 
	 * @param spanish
	 * @param portuguese
	 * @param english
	 * @param date
	 * @param imgFile
	 */
	public void createSpecial(String spanish, String portuguese, String english, String date, String imgFile, Boolean isDisabled) {
		completeSpanish(spanish);
		completePortuguese(portuguese);
		completeEnglish(english);
		selectDate(date);
		if(!imgFile.isEmpty()) {
			
		}
		if(isDisabled) {
			selectActive();
		}
	}
	
	/**
	 * Buscar un beneficio
	 * 
	 * @param name
	 */
	public void completeSearchBenefits(String name) {
		searchBenefits.clear();
		searchBenefits.sendKeys(name);
		searchBenefitsBtn.click();
	}
	
	/**
	 * Seleccionar el botón Guardar
	 */
	public void selectSave() {
		save.click();
	}
	
	/**
	 * Seleccionar el botón Guardar y nuevo
	 */
	public void selectSaveAndNew() {
		saveAndNew.click();
	}
	
	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancel() {
		cancel.click();
	}
}
