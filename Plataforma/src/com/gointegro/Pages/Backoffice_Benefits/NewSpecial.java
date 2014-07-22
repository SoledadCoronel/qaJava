package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

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
	
	@FindBy (xpath = "//div[@data-fields='image']/div/div/span/div/div/span[2]/a/input")
	WebElement fileUpload;
	
	@FindBy(xpath = "//div[@data-fields='image']/div/div/div")
	WebElement imageErrorMsg;
	
	@FindBy(xpath = "//div[@id='benefits']/div/div/div")
	WebElement benefitsErrorMsg;
	
	@FindBy(name = "search-companies")
	WebElement searchCompany;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li")
	WebElement searchCompanyDropDown;
	
	@FindBy(xpath = "//div[@class='selectable-benefits']/table/tbody/tr/td[4]/input")
	WebElement selectableBenefits;
	
	@FindBy(xpath = "//div[@class='selected-benefits']/table/tbody/tr/td[4]/input")
	WebElement selectedBenefits;
	
	@FindBy(xpath = "//div[@class='col-sm-1']/a")
	WebElement addBenefitBtn;
	
	@FindBy(xpath = "//div[@class='col-sm-1']/a[2]")
	WebElement removeBenefitBtn;
	
	
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
	 * Devuelve el contenido del campo Español
	 * 
	 * @return String
	 */
	public String getSpanish() {
		return spanish.getText();
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
	 * 
	 * @return String
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
	 * Ingresar una imagen mayor a 188x95 para devolver un ImageCropOverlay
	 * 
	 * @param fileupload
	 * @return ImageCropOverlay
	 */
	public ImageCropOverlay imageUpload(String fileupload) {
		fileUpload(fileupload);
		return PageFactory.initElements(driver, ImageCropOverlay.class);
	}
	
	/**
	 * Ingresar una imagen menor a 188x95 para devolver un ImageCropOverlay
	 * 
	 * @param fileupload
	 */
	public void imageUploadSmall(String fileupload) {
		fileUpload(fileupload);
	}
	
	/**
	 * Subir un archivo
	 * 
	 * @param fileupload
	 */
	public void fileUpload(String fileupload) {
		AttachmentUploads.attachmentByElement(driver, fileUpload);
		fileUpload.sendKeys(fileupload);
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param date
	 */
	public void selectDate(String date) {
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
			ImageCropOverlay imageCrop = imageUpload(imgFile);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		if(isDisabled) {
			selectActive();
		}
	}
	
	/**
	 * Buscar un Comercio
	 * 
	 * @param name
	 */
	public void completeSearchCompany(String name) {
		searchCompany.clear();
		searchCompany.sendKeys(name);
		searchCompanyDropDown.click();
	}
	
	/**
	 * Seleccionar el primer beneficio
	 */
	public void selectFirstBenefit() {
		selectableBenefits.click();
		addBenefit();
	}
	
	/**
	 * Remover el primer beneficio del listado de agregados
	 */
	public void removefirstBenefit() {
		selectedBenefits.click();
		removeBenefit();
	}
	
	/**
	 * Seleccionar el boton para agregar beneficios
	 */
	public void addBenefit() {
		addBenefitBtn.click();
	}
	
	/**
	 * Seleccionar el boton para remover beneficios
	 */
	public void removeBenefit() {
		removeBenefitBtn.click();
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailSpecial
	 */
	public DetailSpecial selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailSpecial.class);
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
	
	/**
	 * Seleccionar un beneficio
	 * 
	 * @param name
	 */
	public void selectBenefit(String name) {
		
	}
}
