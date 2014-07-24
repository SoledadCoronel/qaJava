package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailStore extends DetailCompany {
	
	@FindBy(id = "storeType")
	WebElement type;
	
	@FindBy(id = "contact")
	WebElement contact;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath = "//section[@id='paymentMachines']/div/div/a")
	WebElement newTerminal;
	
	@FindBy(xpath = "//section[@id='paymentMachines']/div/table/tbody/tr")
	List<WebElement> terminalList;
	
	@FindBy(id = "accordion")
	WebElement areaTitle;
	
	@FindBy(xpath = "//header[@class='backoffice-header']/div/div[2]/button")
	WebElement edit;
	
	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public DetailStore(WebDriver driver) {
		super(driver);
	}

	/**
	 * Devuelve Tipo de sucursal
	 */
	public String getType() {
		return type.getText();
	}
	
	/**
	 * Devuelve Contacto
	 */
	public String getContact() {
		return contact.getText();
	}
	
	/**
	 * Devuelve Email
	 */
	public String getEmail() {
		return email.getText();
	}
	
	/**
	 * Devuelve true si el area esta presente
	 * 
	 * @param area
	 * @return boolean
	 */
	public boolean isAreaTitlePresent(String area) {
		return areaTitle.getText().contains(area);
	}
	
	/**
	 * Seleccionar Nuevo terminal
	 * 
	 * @return NewTerminalOverlay
	 */
	public NewTerminalOverlay selectNewTerminal() {
		newTerminal.click();
		return PageFactory.initElements(driver, NewTerminalOverlay.class);
	}
	
	/**
	 * Devuelve un WebElement del contacto
	 * 
	 * @param name
	 * @return WebElement
	 */
	public WebElement getTerminalElement(String name) {
		WebElement element = null;
		
		for(WebElement ele : terminalList) {
			if(ele.findElements(By.xpath("./td/a")).size() > 0 && ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				element = ele;
			}
		}
		return element;
	}
	
	/**
	 * Devuelve true si el elemento esta activo
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean isTerminalActive(WebElement element) {
		return element.getAttribute("innerHTML").contains("glyphicon-ok");
	}
	
	/**
	 * Devuelve true si el contacto esta presente
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isTerminalInList(String name) {
		boolean isContactInList = false;
		
		for(WebElement ele : terminalList) {
			if(ele.findElements(By.xpath("./td/a")).size() > 0 && ele.findElement(By.xpath("./td/a")).getText().contains(name)) {
				isContactInList = true;
			}
		}
		return isContactInList;
	}
	
	/**
	 * Seleccionar Editar
	 */
	public NewStore selectEdit() {
		edit.click();
		return PageFactory.initElements(driver, NewStore.class);
	}
}
