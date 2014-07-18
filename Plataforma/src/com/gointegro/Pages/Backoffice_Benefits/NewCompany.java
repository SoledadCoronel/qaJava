package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

public class NewCompany extends PageBase {
	
	
	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "companyName")
	WebElement companyName;
	
	@FindBy(id = "taxId")
	WebElement taxId;
	
	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(id = "fax")
	WebElement fax;
	
	@FindBy(id = "webSite")
	WebElement siteLink;
	
	@FindBy (xpath = "//div[@data-fields='logo']/div/div/span/div/div/span[2]/a")
	WebElement logoUpload;
	
	@FindBy (xpath = "//div[@data-fields='logo']/div/div/span/div/div/span[2]/a/input")
	WebElement logoUploadInput;
	
	@FindBy (xpath = "//div[@data-fields='image1']/div/div/span/div/div/span[2]/a")
	WebElement image1UploadBtn;
	
	@FindBy (xpath = "//div[@data-fields='image1']/div/div/span/div/div/span[2]/a/input")
	WebElement image1UploadInput;
	
	@FindBy (xpath = "//div[@data-fields='image2']/div/div/span/div/div/span[2]/a")
	WebElement image2UploadBtn;
	
	@FindBy (xpath = "//div[@data-fields='image2']/div/div/span/div/div/span[2]/a/input")
	WebElement image2UploadInput;
	
	@FindBy (xpath = "//div[@data-fields='image3']/div/div/span/div/div/span[2]/a")
	WebElement image3UploadBtn;
	
	@FindBy (xpath = "//div[@data-fields='image3']/div/div/span/div/div/span[2]/a/input")
	WebElement image3UploadInput;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(xpath = "//li[@class='tagit-new']/input")
	WebElement tags;
	
	@FindBy(xpath = "//div[@class='input-group']/input")
	WebElement address;
	
	@FindBy(xpath = "//span[@class='input-group-btn']/button")
	WebElement addressBtn;
	
	@FindBy(name = "zipCode")
	WebElement zipCode;
	
	@FindBy(name = "floor")
	WebElement floor;
	
	@FindBy(name = "apartment")
	WebElement apartment;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@data-fields='name']/div/div/div")
	WebElement nameError;
	
	@FindBy(xpath = "//div[@data-fields='companyName']/div/div/div")
	WebElement companyNameError;
	
	@FindBy(xpath = "//div[@data-fields='taxId']/div/div/div")
	WebElement taxIdError;
	
	@FindBy(xpath = "//div[@data-fields='phone']/div/div/div")
	WebElement phoneError;
	
	@FindBy(xpath = "//div[@data-fields='logo']/div/div/div")
	WebElement logoError;
	
	@FindBy(xpath = "//div[@data-fields='description']/div/div/div")
	WebElement descriptionError;
	
	@FindBy(xpath = "//div[@data-fields='webSite']/div/div/div")
	WebElement siteLinkError;
	
	@FindBy(xpath = "//div[@class='geolocation']/section/div/div[1]/div")
	WebElement addressError;
	
	@FindBy(xpath = "//div[@data-fields='image1']/div/div/div")
	WebElement image1Error;
	
	@FindBy(xpath = "//div[@data-fields='image1']/div/div/div")
	WebElement image2Error;
	
	@FindBy(xpath = "//div[@data-fields='image1']/div/div/div")
	WebElement image3Error;
	
	@FindBy(xpath = "//div[@id='ms-categories']/div/ul/li")
	List<WebElement> categoryList;
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewCompany(WebDriver driver) {
		super(driver);
	}
 
	/**
	 * Seleccionar el checkbox Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar Nombre del comercio
	 */
	public void createName(String title) {
		name.clear();
		name.sendKeys(title);
	}
	
	/**
	 * Completar Razón social
	 */
	public void createCompanyName(String name) {
		companyName.clear();
		companyName.sendKeys(name);
	}
	
	/**
	 * Completar CUIT
	 */
	public void createTaxId(String id) {
		taxId.clear();
		taxId.sendKeys(id);
	}
	
	/**
	 * Completar Teléfono
	 */
	public void createPhone(String number) {
		phone.clear();
		phone.sendKeys(number);
	}
	
	/**
	 * Completar Fax
	 */
	public void createFax(String name) {
		fax.clear();
		fax.sendKeys(name);
	}
	
	/**
	 * Completar Sitio web
	 */
	public void createWebSite(String name) {
		siteLink.clear();
		siteLink.sendKeys(name);
	}
	
	/**
	 * Completar Descripción
	 */
	public void createDescription(String name) {
		description.clear();
		description.sendKeys(name);
	}
	
	/**
	 * Completar Ubicar en el Mapa
	 */
	public void createAddress(String name) {
		address.clear();
		address.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		addressBtn.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Completar Código postal
	 */
	public void createZipCode(String name) {
		zipCode.clear();
		zipCode.sendKeys(name);
	}
	
	/**
	 * Completar Piso / Oficina/ Local
	 */
	public void createFloor(String name) {
		floor.clear();
		floor.sendKeys(name);
	}
	
	/**
	 * Completar Departamento
	 */
	public void createApartment(String name) {
		apartment.clear();
		apartment.sendKeys(name);
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailCompany
	 */
	public DetailCompany selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailCompany.class);
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
	 * Crear un nuevo comercio
	 */
	public void createNewCompany(String name, String companyName, String taxId, String phone, String fax, String fileupload, String siteLink, String description, String address, String zipcode, Boolean isDisabled) {
		createName(name);
		createCompanyName(companyName);
		createTaxId(taxId);
		createPhone(phone);
		createFax(fax);
		
		if(!fileupload.isEmpty()) {
			ImageCropOverlay imageCrop = logoUpload(fileupload);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		
		createWebSite(siteLink);
		createDescription(description);
		
		if(isDisabled) {
			selectActive();
		}
		
		createAddress(address);
		createZipCode(zipcode);
		Sleeper.sleepTightInSeconds(2);
	}
	
	/**
	 * Completar Tags
	 * 
	 * @param name
	 */
	public void createTag(String name) {
		tags.clear();
		tags.sendKeys(name);
		tags.sendKeys(Keys.RETURN);
	}
	
	/**
	 * Ingresar una imagen menor a 188x95 para devolver un error
	 * 
	 * @param fileupload
	 */
	public void logoUploadSmallImg(String fileupload) {
		fileUpload(fileupload, logoUpload, logoUploadInput);
	}
	
	/**
	 * Ingresar una imagen mayor a 188x95 para devolver un ImageCropOverlay
	 * 
	 * @param fileupload
	 * @return ImageCropOverlay
	 */
	public ImageCropOverlay logoUpload(String fileupload) {
		fileUpload(fileupload, logoUpload, logoUploadInput);
		return PageFactory.initElements(driver, ImageCropOverlay.class);
	}
	
	/**
	 * Subir imagen a Imagen 1
	 * 
	 * @param fileupload
	 */
	public void image1Upload(String fileupload) {
		fileUpload(fileupload, image1UploadBtn, image1UploadInput);
	}
	
	/**
	 * Subir imagen a Imagen 1
	 * 
	 * @param fileupload
	 */
	public void image2Upload(String fileupload) {
		fileUpload(fileupload, image2UploadBtn, image2UploadInput);
	}
	
	/**
	 * Subir imagen a Imagen 1
	 * 
	 * @param fileupload
	 */
	public void image3Upload(String fileupload) {
		fileUpload(fileupload, image3UploadBtn, image3UploadInput);
	}
	
	/**
	 * Subir un archivo
	 * 
	 * @param fileupload
	 * @param buttonElement
	 * @param inputElement
	 */
	private void fileUpload(String fileupload, WebElement buttonElement, WebElement inputElement) {
		AttachmentUploads.attachmentByElement(driver, buttonElement);
		inputElement.sendKeys(fileupload);
	}
	
	/**
	 * Devuelve el mensaje de error del Nombre del comercio
	 * 
	 * @return String
	 */
	public String getNameError() {
		return nameError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del Razón social
	 * 
	 * @return String
	 */
	public String getCompanyNameError() {
		return companyNameError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del CUIT
	 * 
	 * @return String
	 */
	public String getTaxIdError() {
		return taxIdError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del Teléfono
	 * 
	 * @return String
	 */
	public String getPhoneError() {
		return phoneError.getText();
	}
	
	/**
	 * 
	 * Devuelve el mensaje de error del Logo principal
	 * 
	 * @return String
	 */
	public String getLogoError() {
		return logoError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del Sitio Web
	 * 
	 * @return String
	 */
	public String getWebSiteError() {
		return siteLinkError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de la Descripción
	 * 
	 * @return String
	 */
	public String getDescriptionError() {
		return descriptionError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Ubicación
	 * 
	 * @return String
	 */
	public String getAddressError() {
		return addressError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Imagen 1
	 * 
	 * @return String
	 */
	public String getImage1Error() {
		return image1Error.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Imagen 2
	 * 
	 * @return String
	 */
	public String getImage2Error() {
		return image2Error.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Imagen 3
	 * 
	 * @return String
	 */
	public String getImage3Error() {
		return image3Error.getText();
	}
	
	/**
	 * Seleccionar una categoria por el nombre
	 * 
	 * @param name
	 */
	public void selectCategory(String name) {
		for(WebElement element : categoryList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath("./span")).click();
				break;
			}
		}
	}
}
