package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;

public class NewFileOverlay extends PageBase {
	
	@FindBy(xpath = "//input[contains(@class, 'field-active')]")
	WebElement active;
	
	@FindBy(xpath = "//input[contains(@class, 'field-name')]")
	WebElement name;
	
	@FindBy(xpath = "//textarea[contains(@class, 'field-description')]")
	WebElement description;
	
	@FindBy (xpath = "//div[@data-fields='url']/div/div/span/div/div/span[2]/a/input")
	WebElement fileUpload;
	
	@FindBy(xpath = "//div[contains(@class, 'form-name')]/div/div/div")
	WebElement nameErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'form-description')]/div/div/div")
	WebElement descriptionErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class, 'form-url')]/div/div/div")
	WebElement fileErrorMsg;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement cancel;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewFileOverlay(WebDriver driver) {
		super(driver);
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
	 * Seleccionar Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar Nombre
	 * 
	 * @param title
	 */
	public void createName(String title) {
		name.clear(); 
		name.sendKeys(title);
	}
	
	/**
	 * Completar Descripción
	 * 
	 * @param desctext
	 */
	public void createDescription(String desctext) {
		description.clear(); 
		description.sendKeys(desctext);
	}
	
	/**
	 * Obtner Descripción
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Crear archivo
	 * 
	 * @param name
	 * @param description
	 * @param fileupload
	 * @param isEnabled
	 */
	public void createFile(String name, String description, String fileupload, boolean isEnabled) {
		createName(name);
		createDescription(description);
		fileUpload(fileupload);
		
		if(isEnabled) {
			selectActive();
		}
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailBenefits
	 */
	public DetailBenefits selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailBenefits.class);
	}
	
	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancel() {
		cancel.click();
	}
	
	/**
	 * Obtener el mensaje de error del Nombre
	 * 
	 * @return String
	 */
	public String getNameErrorMsg() {
		return nameErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error de la Descripción
	 * 
	 * @return String
	 */
	public String getDescriptionErrorMsg() {
		return descriptionErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del archivo
	 * 
	 * @return String
	 */
	public String getFileErrorMsg() {
		return fileErrorMsg.getText();
	}
}
