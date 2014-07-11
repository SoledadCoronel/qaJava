package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class HomeBenefits extends PageBase {
	
	@FindBy(xpath = "//section/div[2]/a")
	WebElement newCompany;
	
	@FindBy(xpath = "//section/div[1]/div[2]/a[1]")
	WebElement adminSpecials;
	
	@FindBy(xpath = "//section/div[1]/div[2]/a[2]")
	WebElement adminCategory;
	
	@FindBy(xpath = "//div[@class='backgrid-company-list']/table/tbody/tr")
	List<WebElement> benefitsList;
	
	String benefit = "//div[@class='backgrid-company-list']/table/tbody/tr/td[@class='template']";
	
	@FindBy(name = "filters[name]")
	WebElement search;
	
	@FindBy(id = "name-filter-btn-submit")
	WebElement searchBtn;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HomeBenefits(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/benefits/company/list";
	}

	/**
	 * Seleccionar el botón Nuevo Comercio
	 * 
	 * @return NewCompany
	 */
	public NewCompany selectNewCompany() {
		newCompany.click();
		return PageFactory.initElements(driver, NewCompany.class);
	}
	
	/**
	 * Seleccionar el botón Adminsitrar especiales
	 * 
	 * @return SpecialList
	 */
	public SpecialList selectAdminSpecials() {
		adminSpecials.click();
		return PageFactory.initElements(driver, SpecialList.class);
	}
	
	/**
	 * Seleccionar el botón Adminsitrar categorias
	 */
	public CategoriesList selectAdminCategory() {
		adminCategory.click();
		return PageFactory.initElements(driver, CategoriesList.class);
	}
	
	/**
	 * Buscar un beneficio por el nombre
	 * 
	 * @param name
	 */
	public void searchBenefit(String name) {
		search.clear();
		search.sendKeys(name);
		searchBtn.click();
	}
	
	/**
	 * Devuelve un WebElement del beneficio
	 * 
	 * @param name
	 * @return
	 */
	public WebElement getBenefitElement(String name) {
		WebElement element = null;
		
		for(WebElement ele : benefitsList) {
			if(ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				element = ele;
			}
		}
		return element;
	}
	
	/**
	 * Devuelve el Nombre del Comercio
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getName(WebElement element) {
		return element.findElement(By.xpath("./td/a")).getText();
	}
	
	/**
	 * Devuelve el Pais
	 * 
	 * @param WebElement
	 * @return String
	 */
	public String getCountry(WebElement element) {
		return element.findElement(By.xpath("./td[2]")).getText();
	}
	
	/**
	 * Devuelve true si esta Activo
	 * 
	 * @param WebElement
	 * @return String
	 */
	public boolean isEnabled(WebElement element) {
		return element.getAttribute("innerHTML").contains("glyphicon-ok");
	}
	
		
}
