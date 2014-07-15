package com.gointegro.Pages.Backoffice_Account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class AccountList extends PageBase{
	
	@FindBy (name = "filters[name]")
	private WebElement filter;
	
	@FindBy (id = "name-filter-btn-close")
	private WebElement cancelfilter;
	
	@FindBy (id = "name-filter-btn-submit")
	private WebElement submitfilter;
	
	@FindBy (xpath = "//div[@id='basic-grid']/table/tbody/tr")
	private List<WebElement> grid;
	
	@FindBy (xpath = "//tr[@class='empty']/td")
	private WebElement empty;
	
	@FindBy (id = "page-first")
	private WebElement pagefirst;
	
	@FindBy (id = "page-prev")
	private WebElement pageprev;
	
	@FindBy (id = "page-next")
	private WebElement pagenext;
	
	@FindBy (id = "page-last")
	private WebElement pagelast;
	
	String tablexpath = "./td";
	
	String tablexpath2 = "./td[2]";

	/**
	 * Constructor
	 * @param driver
	 */
	public AccountList(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/list";
	}
	
	/**
	 * Obtener el elemento del listado por nombre
	 * 
	 * @param name
	 * 
	 * @return {@link WebElement}
	 */
	private WebElement getElementInListByName(String name) {
		WebElement e = null;
		
		for (WebElement element : grid) {
			if (element.findElement(By.xpath(tablexpath)).getText().contains(name)) {
				e = element.findElement(By.xpath(tablexpath));
				break;
			}
		}
		
		if (e == null) {
			e = empty;
		}
		
		return e;
	}
	
	/**
	 * Obtener el elemento para obtener el padre
	 * 
	 * @param host
	 * 
	 * @return {@link WebElement} 
	 */
	private WebElement getElementInListToFather(String name) {
		WebElement e = null;
		
		for (WebElement element : grid) {
			if (element.findElement(By.xpath(tablexpath)).getText().contains(name)) {
				e = element.findElement(By.xpath(tablexpath2));
				break;
			}
		}
		
		if (e == null) {
			e = empty;
		}
		
		return e;
	}
	
	/**
	 * Completar la busqueda por nombre
	 * 
	 * @param name
	 */
	private void setFilterName(String name) {
		filter.clear();
		filter.sendKeys(name);
		submitfilter.click();
		
		WaitTool.waitForJQueryProcessing(driver, 15);
	}
	
	public String getAccountFather(String name) {
		WebElement e = getElementInListToFather(name);
		return e.getText();
	}
	
	/**
	 * Buscar por nombre
	 * 
	 * @param name
	 * 
	 * @return String
	 */
	public String searchAccountByName(String name) {
		if (!name.isEmpty())
			setFilterName(name);
		
		WebElement platformname = getElementInListByName(name);
		return platformname.getText();
	}
	
	/**
	 * Obtener la cantidad de elementos del listado por pag.
	 * 
	 * @return int
	 */
	public int getListSize() {
		return grid.size();
	}
	
	/**
	 * Obtener el primer elemento del listado
	 * 
	 * @return String
	 */
	public String getFirstItemInList() {
		WebElement e = grid.get(0);
		
		return e.findElement(By.xpath(tablexpath)).getText();
	}
	
	/**
	 * Seleccionar la sengunda pagina de archivos
	 */
	public void selectPaginate() {
		if(driver.findElements(By.id("page-2")).size() > 0) {
			driver.findElement(By.id("page-2")).click();
		}
	}
	
	/**
	 * Seleccionar primera pagina
	 */
	public void selectFirstPage() {
		pagefirst.click();
	}
	
	/**
	 * Seleccionar la pagina anterior
	 */
	public void selectPrevPage() {
		pageprev.click();
	}
	
	/**
	 * Seleccionar la ultima pagina
	 */
	public void selectLastPage() {
		pagelast.click();
	}
	
	/**
	 * Seleccionar la pagina siguiente
	 */
	public void selectNextPage() {
		pagenext.click();
	}
	
	/**
	 * Cancelar la busqueda por name
	 */
	public void selectCancelSearchName() {
		cancelfilter.click();
	}

}
