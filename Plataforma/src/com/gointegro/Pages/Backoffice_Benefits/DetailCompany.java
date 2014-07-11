package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

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
	
	String tags = "//section[@id='tags']";
	
	String category = "//section[@id='categories']";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailCompany(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve Activo
	 */
	public String getActive() {
		return active.getText();
	}
	
	/**
	 * Devuelve Nombre del comercio
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Devuelve Razón social
	 */
	public String getCompanyName() {
		return companyName.getText();
	}

	/**
	 * Devuelve CUIT
	 */
	public String getTaxId() {
		return taxId.getText();
	}
	
	/**
	 * Devuelve Teléfono
	 */
	public String getPhone() {
		return phone.getText();
	}
	
	/**
	 * Devuelve Fax
	 */
	public String getFax() {
		return fax.getText();
	}
	
	/**
	 * Devuelve Sitio web
	 */
	public String getWebSite() {
		return siteLink.getText();
	}
	
	/**
	 * Devuelve Logo
	 */
	public String getLogo() {
		return logo.getText();
	}
	
	/**
	 * Devuelve Imagen 1
	 */
	public String getImage1() {
		return image1.getText();
	}
	
	/**
	 * Devuelve Imagen 2
	 */
	public String getImage2() {
		return image2.getText();
	}
	
	/**
	 * Devuelve Imagen 3
	 */
	public String getImage3() {
		return image3.getText();
	}
	
	
	
	/**
	 * Devuelve Descripción
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Devuelve Calle
	 */
	public String getStreet() {
		return street.getText();
	}
	
	/**
	 * Devuelve Altura
	 */
	public String getStreetNumber() {
		return streetNumber.getText();
	}
	
	/**
	 * Devuelve Piso/Oficina/Local
	 */
	public String getFloor() {
		return floor.getText();
	}
	
	/**
	 * Devuelve Departamento
	 */
	public String getApartment() {
		return apartment.getText();
	}
	
	/**
	 * Devuelve Código Postal
	 */
	public String getZipCode() {
		return zipCode.getText();
	}
	
	/**
	 * Devuelve Distrito
	 */
	public String getDistrict() {
		return district.getText();
	}
	
	/**
	 * Devuelve Localidad
	 */
	public String getCity() {
		return city.getText();
	}
	
	/**
	 * Devuelve Provincia
	 */
	public String getProvince() {
		return province.getText();
	}
	
	/**
	 * Devuelve Pais
	 */
	public String getCountry() {
		return country.getText();
	}
	
	/**
	 * Devuelve true si el Tag existe
	 */
	public boolean isTagPresent(String name) {
		return driver.findElement(By.xpath(tags)).getAttribute("innerHTML").contains(name);
	}
	
	/**
	 * Devuelve true si la categoria existe
	 */
	public boolean isCategoryPresent(String name) {
		return driver.findElement(By.xpath(category)).getAttribute("innerHTML").contains(name);
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
	
}
