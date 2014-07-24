package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class DetailBenefits extends PageBase {
	
	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(id = "owner")
	WebElement owner;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "targetUserType")
	WebElement targetUserType;
	
	@FindBy(id = "discount")
	WebElement discount;
	
	@FindBy(id = "highlight")
	WebElement highlight;
	
	@FindBy(id = "validFrom")
	WebElement validFrom;
	
	@FindBy(id = "expires")
	WebElement expires;
	
	@FindBy(id = "validUntil")
	WebElement validUntil;
	
	@FindBy(id = "image")
	WebElement image;
	
	@FindBy(id = "benefitCode")
	WebElement benefitCode;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(id = "restrictedPlatforms-input")
	WebElement restrictedPlatforms_input;
	
	String category = "//section[@id='categories']/div/div/ul";
	
	@FindBy(xpath = "//section[@id='files']/div/div/a")
	WebElement newDocument;
	
	String documentsList = "//section[@id='files']/div/table/tbody";
	
	String fileLink = "//section[@id='files']/div/table/tbody/tr/td/a";
	
	@FindBy(xpath = "//section[@id='visible-files']/div/div/a")
	WebElement newVisibleFile;
	
	String visibleFileList = "//section[@id='visible-files']/div/table/tbody";
	
	String visibleFileLink = "//section[@id='visible-files']/div/table/tbody/tr/td/a";
	
	String tags = "//section[@id='tags']/div/div/span";
	
	@FindBy(xpath = "//header[@class='backoffice-header']/div/div[2]/button")
	WebElement edit;
	
	@FindBy(xpath = "//section[@id='files']/div/table/tbody/tr/td[5]/a")
	WebElement editFile;
	
	@FindBy(xpath = "//section[@id='visible-files']/div/table/tbody/tr/td[5]/a")
	WebElement editVisibleFile;
	
	@FindBy(xpath = "//td[@id='redeemingMethods']/ul")
	WebElement redeemingList;
	
	@FindBy(xpath = "//td[@id='validDays']/ul")
	WebElement validDaysList;
	
	@FindBy(xpath = "//td[@id='paymentMethods']/ul")
	WebElement paymentMethodsList;
	
	/**
	 * 
	 * @param driver
	 */
	public DetailBenefits(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Obtener Activo
	 * 
	 * @return String
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Obtener Responsable
	 * 
	 * @return String
	 */
	public String getOwner() {
		return owner.getText();
	}
	
	/**
	 * Obtener Nombre
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Obtener Segmento
	 * 
	 * @return String
	 */
	public String getTargetUser() {
		return targetUserType.getText();
	}
	
	/**
	 * Obtener Tipo de oferta
	 * 
	 * @return String
	 */
	public String getDiscount() {
		return discount.getText();
	}
	
	/**
	 * Obtener Destacado
	 * 
	 * @return String
	 */
	public String getHighlight() {
		return highlight.getText();
	}
	
	/**
	 * Obtener Valido desde
	 * 
	 * @return String
	 */
	public String getValidFrom() {
		return validFrom.getText();
	}
	
	/**
	 * Obtener Valido Hasta
	 * 
	 * @return String
	 */
	public String getValidUntil() {
		return validUntil.getText();
	}

	/**
	 * Obtener Vencimiento
	 * 
	 * @return String
	 */
	public String getExpires() {
		return expires.getText();
	}
	
	/**
	 * Obtener Imagen
	 * 
	 * @return String
	 */
	public String getImage() {
		return image.getText();
	}
	
	/**
	 * Obtener Codigo de beneficio
	 * 
	 * @return String
	 */
	public String getBenefitCode() {
		return benefitCode.getText();
	}
	
	/**
	 * Devuelve true si el Tag existe
	 */
	public boolean isTagPresent(String name) {
		return driver.findElement(By.id("tags")).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si la lista de Tags esta vacia
	 * 
	 * @return boolean
	 */
	public boolean isTagListEmpty() {
		return driver.findElement(By.xpath(tags)).getText().isEmpty();
	}
	
	/**
	 * Obtener Titulo
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}
	
	/**
	 * Obtener Descripción
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Devuelve true si la categoria existe
	 */
	public boolean isCategoryPresent(String name) {
		return driver.findElement(By.xpath(category)).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si la categoria existe
	 * 
	 * @return boolean
	 */
	public boolean isCategoryListEmpty() {
		return driver.findElement(By.xpath(category)).getText().isEmpty();
	}
	
	/**
	 * Devuelve true si el Modo de Acceso existe
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isRedeemingPresent(String name) {
		return driver.findElement(By.id("redeemnig")).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si Dias Validos existe
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isValidDaysPresent(String name) {
		return driver.findElement(By.id("validDays")).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si el Medios de Pago existe
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isPaymentMethodPresent(String name) {
		return driver.findElement(By.id("paymentMethods")).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si el Modo de Acceso esta vacio
	 * 
	 * @return boolean
	 */
	public boolean isRedeemingListEmpty() {
		return redeemingList.getText().isEmpty();
	}
	
	/**
	 * Devuelve true si Dias Validos esta vacio
	 * 
	 * @return boolean
	 */
	public boolean isValidDaysListEmpty() {
		return validDaysList.getText().isEmpty();
	}
	
	/**
	 * Devuelve true si el Medios de Pago existe
	 * 
	 * @return boolean
	 */
	public boolean isPaymentMethodListEmpty() {
		return paymentMethodsList.getText().isEmpty();
	}
	
	/**
	 * Seleccionar Nuevo Documentos Internos
	 * 
	 * @return NewFileOverlay
	 */
	public NewFileOverlay selectNewDocument() {
		newDocument.click();
		return PageFactory.initElements(driver, NewFileOverlay.class);
	}
	
	/**
	 * Devuelve true si el archivo se encuntra en la lista
	 * 
	 * @return boolean
	 */
	public boolean isFileInList(String name) {
		boolean isFile = false;
		if(driver.findElements(By.xpath(documentsList)).size() > 0 && driver.findElement(By.xpath(documentsList)).getAttribute("innerHTML").contains(name)) {
			isFile = true;
		}
		return isFile;
	}
	
	/**
	 * Devuelve el link del archivo
	 */
	public String getFileLink() {
		return driver.findElement(By.xpath(fileLink)).getAttribute("href");
	}
	
	/**
	 * Devuelve true si el archivo esta activo
	 * 
	 * @return String
	 */
	public boolean isFileEnabled() {
		return driver.findElement(By.xpath(documentsList)).getAttribute("innerHTML").contains("glyphicon-ok");
	}
	
	/**
	 * Seleccionar el editar del primer Documento interno
	 * 
	 * @return NewFileOverlay
	 */
	public NewFileOverlay editFirstFile() {
		editFile.click();
		return PageFactory.initElements(driver, NewFileOverlay.class);
	}
	
	/**
	 * Seleccionar Nuevo Anexos Públicos
	 * 
	 * @return NewFileOverlay
	 */
	public NewFileOverlay selectNewVisibleFiles() {
		newVisibleFile.click();
		return PageFactory.initElements(driver, NewFileOverlay.class);
	}
	
	/**
	 * Devuelve true si el archivo se encuntra en la lista
	 * 
	 * @return boolean
	 */
	public boolean isVisibleFileInList(String name) {
		boolean isFile = false;
		if(driver.findElements(By.xpath(visibleFileList)).size() > 0 && driver.findElement(By.xpath(visibleFileList)).getAttribute("innerHTML").contains(name)) {
			isFile = true;
		}
		return isFile;
	}
	
	/**
	 * Devuelve el link del archivo
	 */
	public String getVisibleFileLink() {
		return driver.findElement(By.xpath(visibleFileLink)).getAttribute("href");
	}
	
	/**
	 * Devuelve true si el archivo esta activo
	 * 
	 * @return String
	 */
	public boolean isVisibleFileEnabled() {
		return driver.findElement(By.xpath(visibleFileList)).getAttribute("innerHTML").contains("glyphicon-ok");
	}

	/**
	 * Seleccionar el editar del primer Anexo publico
	 * 
	 * @return NewFileOverlay
	 */
	public NewFileOverlay editFirstVisibleFile() {
		editVisibleFile.click();
		return PageFactory.initElements(driver, NewFileOverlay.class);
	}
	
	/**
	 * Seleccionar Editar
	 * 
	 * @return NewBenefits
	 */
	public NewBenefits selectEdit() {
		edit.click();
		return PageFactory.initElements(driver, NewBenefits.class);
	}
}
