package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Benenfits.DetailBenefit;

public class SearchResult extends PageBase {
	
	@FindBy(xpath = "//table[@class='benefit-list']/tbody/tr/td[3]/a")
	WebElement seeBenefit;
	
	@FindBy(className = "number")
	WebElement resultsFound;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SearchResult(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar Ver Beneficio del primer beneficio de la lista
	 * 
	 * @return DetailBenefit
	 */
	public DetailBenefit selectSeeBenefit() {
		seeBenefit.click();
		return PageFactory.initElements(driver, DetailBenefit.class);
	}

	/**
	 * Obtener el mensaje de cantidad de resultados encontrados
	 * 
	 * @return String
	 */
	public String getResultsFoundMsg() {
		return resultsFound.getText();
	}
}
