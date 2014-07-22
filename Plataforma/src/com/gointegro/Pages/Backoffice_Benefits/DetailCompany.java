package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Helpers.ConfigElementsBOBenefits;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class DetailCompany extends PageBase {
	
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
	
	@FindBy (xpath = "//td[@id='image1']/a")
	WebElement image1;

	@FindBy (xpath = "//td[@id='image2']/a")
	WebElement image2;
	
	@FindBy (xpath = "//td[@id='image3']/a")
	WebElement image3;
	
	@FindBy (xpath = "//td[@id='logo']/a")
	WebElement logo;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy (xpath = "//header[@class='backoffice-header']/div/div[2]/button")
	WebElement editbtn;
	
	/**
	 * UBICACIÓN
	 */
	
	@FindBy(id = "street")
	WebElement street;
	
	@FindBy(id = "streetNumber")
	WebElement streetNumber;
	
	@FindBy(id = "floor")
	WebElement floor;
	
	@FindBy(id = "apartment")
	WebElement apartment;
	
	@FindBy(id = "zipCode")
	WebElement zipCode;
	
	@FindBy(id = "administrative_area_level_3")
	WebElement district;
	
	@FindBy(id = "administrative_area_level_2")
	WebElement city;
	
	@FindBy(id = "administrative_area_level_1")
	WebElement province;
	
	@FindBy(id = "country")
	WebElement country;
	
	/**
	 * OTROS
	 */
	String tags = "//section[@id='tags']/div/div/span";
	
	String category = "//section[@id='categories']/div/div/ul";
	
	@FindBy(xpath = "//section[@id='contacts']/div/div/a")
	WebElement newContact;
	
	@FindBy(xpath = "//section[@id='contacts']/div/table/tbody/tr")
	List<WebElement> contactsList;
	
	@FindBy(xpath = "//section[@id='benefits']/div/div/a")
	WebElement newBenefit;
	
	@FindBy(xpath = "//section[@id='stores']/div/div/a")
	WebElement newStore;
	
	String companyURL = ConfigElementsBO.getUrlBackoffice() + "/benefits/company/" + ConfigElementsBOBenefits.getCompanyId() + "/view"; 
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailCompany(WebDriver driver) {
		super(driver);
		URL = companyURL;
	}
	
	/**
	 * Devuelve la URL de la vista
	 */
	public String getURL() {
		return companyURL;
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
	 * Devuelve Nombre del comercio
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Devuelve Razón social
	 * 
	 * @return String
	 */
	public String getCompanyName() {
		return companyName.getText();
	}

	/**
	 * Devuelve CUIT
	 * 
	 * @return String
	 */
	public String getTaxId() {
		return taxId.getText();
	}
	
	/**
	 * Devuelve Teléfono
	 * 
	 * @return String
	 */
	public String getPhone() {
		return phone.getText();
	}
	
	/**
	 * Devuelve Fax
	 * 
	 * @return String
	 */
	public String getFax() {
		return fax.getText();
	}
	
	/**
	 * Devuelve Sitio web
	 * 
	 * @return String
	 */
	public String getWebSite() {
		return siteLink.getText();
	}
	
	/**
	 * Devuelve Logo
	 * 
	 * @return String
	 */
	public String getLogo() {
		return logo.getText();
	}
	
	/**
	 * Devuelve Imagen 1
	 * 
	 * @return String
	 */
	public String getImage1() {
		return image1.getText();
	}
	
	/**
	 * Devuelve Imagen 2
	 * 
	 * @return String
	 */
	public String getImage2() {
		return image2.getText();
	}
	
	/**
	 * Devuelve Imagen 3
	 * 
	 * @return String
	 */
	public String getImage3() {
		return image3.getText();
	}
	
	/**
	 * Devuelve Descripción
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Devuelve Calle
	 * 
	 * @return String
	 */
	public String getStreet() {
		return street.getText();
	}
	
	/**
	 * Devuelve Altura
	 * 
	 * @return String
	 */
	public String getStreetNumber() {
		return streetNumber.getText();
	}
	
	/**
	 * Devuelve Piso/Oficina/Local
	 * 
	 * @return String
	 */
	public String getFloor() {
		return floor.getText();
	}
	
	/**
	 * Devuelve Departamento
	 * 
	 * @return String
	 */
	public String getApartment() {
		return apartment.getText();
	}
	
	/**
	 * Devuelve Código Postal
	 * 
	 * @return String
	 */
	public String getZipCode() {
		return zipCode.getText();
	}
	
	/**
	 * Devuelve Distrito
	 * 
	 * @return String
	 */
	public String getDistrict() {
		return district.getText();
	}
	
	/**
	 * Devuelve Localidad
	 * 
	 * @return String
	 */
	public String getCity() {
		return city.getText();
	}
	
	/**
	 * Devuelve Provincia
	 * 
	 * @return String
	 */
	public String getProvince() {
		return province.getText();
	}
	
	/**
	 * Devuelve Pais
	 * 
	 * @return String
	 */
	public String getCountry() {
		return country.getText();
	}
	
	/**
	 * Devuelve true si el Tag existe
	 * 
	 * @return boolean
	 */
	public boolean isTagPresent(String name) {
		return driver.findElement(By.xpath(tags)).getAttribute("innerHTML").contains(name);
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
	 * Devuelve true si la categoria existe
	 * 
	 * @return boolean
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
	 * Seleccionar Editar
	 * 
	 * @return NewCompany
	 */
	public NewCompany selectEdit() {
		editbtn.click();
		return PageFactory.initElements(driver, NewCompany.class);
	}
	
	/**
	 * Seleccionar Nuevo contacto
	 * 
	 * @return NewContactOverlay
	 */
	public NewContactOverlay selectNewContact() {
		newContact.click();
		return PageFactory.initElements(driver, NewContactOverlay.class);
	}
	
	/**
	 * Devuelve un WebElement del contacto
	 * 
	 * @param name
	 * @return WebElement
	 */
	public WebElement getContactElement(String name) {
		WebElement element = null;
		
		WaitTool.waitForElement(driver, By.xpath("//section[@id='contacts']/div/table/tbody/tr"), 10);
		
		for(WebElement ele : contactsList) {
			if(ele.findElements(By.xpath("./td/a")).size() > 0 && ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				element = ele;
			}
		}
		return element;
	}
	
	/**
	 * Devuelve true si el contacto esta presente
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isContactInList(String name) {
		boolean isContactInList = false;
		
		for(WebElement ele : contactsList) {
			if(ele.findElements(By.xpath("./td/a")).size() > 0 && ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				isContactInList = true;
			}
		}
		return isContactInList;
	}
	
	/**
	 * Devuelve el Nombre del contacto
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getContactName(WebElement element) {
		return element.findElement(By.xpath("./td/a")).getText();
	}
	
	/**
	 * Devuelve el Nombre del contacto
	 * 
	 * @return DetailContactOverlay
	 */
	public DetailContactOverlay selectContact(WebElement element) {
		element.findElement(By.xpath("./td/a")).click();
		return PageFactory.initElements(driver, DetailContactOverlay.class);
	}
	
	/**
	 * Devuelve el Area del contacto
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getContactArea(WebElement element) {
		return element.findElement(By.xpath("./td[2]")).getText();
	}
	
	/**
	 * Devuelve la Posición del contacto
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getContactPosition(WebElement element) {
		return element.findElement(By.xpath("./td[3]")).getText();
	}
	
	/**
	 * Devuelve true si el contacto esta activo
	 * 
	 * @param WebElement
	 * @return String
	 */
	public boolean isContactEnabled(WebElement element) {
		return element.findElements(By.xpath("./td[4]/span[contains(@class, 'glyphicon-ok')]")).size() > 0;
	}
	
	/**
	 * Seleccionar Nuevo beneficio
	 * 
	 * @return NewBenefits
	 */
	public NewBenefits selectNewBenefit() {
		newBenefit.click();
		return PageFactory.initElements(driver, NewBenefits.class);
	}
	
	/**
	 * Seleccionar Nueva Sucursal
	 * 
	 * @return NewStore
	 */
	public NewStore selectNewStore() {
		newStore.click();
		return PageFactory.initElements(driver, NewStore.class);
	}
	
}
