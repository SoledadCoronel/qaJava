package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class SelectStoreOverlay extends PageBase {
	
	
	@FindBy(xpath = "//div[@class='backgrid-list']/table/tbody/tr")
	WebElement storeList;
	
	@FindBy(xpath = "//div[@class='modal-header']/button")
	WebElement close;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SelectStoreOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar la primera sucursal de la lista y devolver su nombre
	 * 
	 * @return String
	 */
	public String selectFirstStore() {
		String name = "";
		
		if(storeList.findElements(By.xpath("./td/a")).size() > 0) {
			name = storeList.findElement(By.xpath("./td/a")).getText();
			storeList.findElement(By.xpath("./td[5]/a")).click();
		}
		return name;
	}
	
	/**
	 * Seleccionar Cerrar Modal
	 * 
	 * @return DetailBenefits
	 */
	public DetailBenefits selectClose() {
		close.click();
		return PageFactory.initElements(driver, DetailBenefits.class);
	}

}
