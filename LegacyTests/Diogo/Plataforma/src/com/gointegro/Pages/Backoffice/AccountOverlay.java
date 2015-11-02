package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AccountOverlay extends PageBase{
	
	@FindBy (name = "filters[name]")
	private WebElement filters;
	
	@FindBy (id = "btn-add")
	private WebElement btnAdd;
	
	@FindBy (id = "btn-cancel")
	private WebElement btncancel;
	
	@FindBy (xpath = "//button[contains(@class, 'btn-select-item')]")
	private WebElement btnselectitem;
	
	@FindBy (xpath = "//table[@id='itemsList']/tbody/tr/td")
	private WebElement listempty;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AccountOverlay(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar el filtro
	 * 
	 * @param account
	 */
	public void completeFilter(String account) {
		filters.clear();
		filters.sendKeys(account);
	}
	
	/**
	 * Seleccionar un elemento
	 */
	public void selectItem() {
		btnselectitem.click();
	}
	
	/**
	 * Seleccionar Asociar Cuenta
	 */
	public void selectAdd() {
		btnAdd.click();
	}
	
	/**
	 * Seleccionar Cancelar
	 */
	public void selectCancel() {
		btncancel.click();
	}
	
	/**
	 * Obtener el resultado de la busqueda con una lista vacia
	 * 
	 * @return String
	 */
	public String getListEmpty() {
		return listempty.getText(); 
	}

}