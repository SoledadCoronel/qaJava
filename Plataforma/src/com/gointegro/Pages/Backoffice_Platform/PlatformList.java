package com.gointegro.Pages.Backoffice_Platform;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class PlatformList extends PageBase{
	
	@FindBy (name = "filters[name]")
	private WebElement filtername;
	
	@FindBy (id = "name-filter-btn-submit")
	private WebElement filternamesubmit;
	
	@FindBy (id = "name-filter-btn-close")
	private WebElement filternamecancel;
	
	@FindBy (name = "filters[host]")
	private WebElement filterhost;
	
	@FindBy (id = "host-filter-btn-close")
	private WebElement filterhostcancel;
	
	@FindBy (id = "host-filter-btn-submit")
	private WebElement filterhostsubmit;
	
	@FindBy(xpath = "//div[@id='basic-grid']/table/tbody/tr")
	List <WebElement> basicgrid;
	
	@FindBy (xpath = "//tr[@class='empty']/td")
	private WebElement empty;
	
	@FindBy (id = "btnCreateAction")
	private WebElement btnCreateAction;
	
	@FindBy (id = "page-first")
	private WebElement pagefirst;
	
	@FindBy (id = "page-prev")
	private WebElement pageprev;
	
	@FindBy (id = "page-next")
	private WebElement pagenext;
	
	@FindBy (id = "page-last")
	private WebElement pagelast;
	
	@FindBy (xpath = "//div[@id='basic-grid']/table/tbody/tr/td[3]")
	private WebElement cellSocial;
	
	String tablexpath = "./td";
	
	String tablexpath2 = "./td[2]";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlatformList(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/list";
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
		
		for (WebElement element : basicgrid) {
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
	 * Obtener el elemento del listado por host
	 * 
	 * @param host
	 * 
	 * @return {@link WebElement} 
	 */
	private WebElement getElementInListByHost(String host) {
		WebElement e = null;
		
		for (WebElement element : basicgrid) {
			if (element.findElement(By.xpath(tablexpath2)).getText().contains(host)) {
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
		filtername.clear();
		filtername.sendKeys(name);
		filternamesubmit.click();
		
		WaitTool.waitForJQueryProcessing(driver, 15);
	}
	
	/**
	 * Completar la busqueda por host
	 * 
	 * @param host
	 */
	private void setFilterHost(String host) {
		filterhost.clear();
		filterhost.sendKeys(host);
		filterhostsubmit.click();
		
		WaitTool.waitForJQueryProcessing(driver, 15);
	}
	
	/**
	 * Buscar por nombre
	 * 
	 * @param name
	 * 
	 * @return String
	 */
	public String searchPlatformByName(String name) {
		if (!name.isEmpty())
			setFilterName(name);
		
		WebElement platformname = getElementInListByName(name);
		return platformname.getText();
	}
	
	/**
	 * Obtener el innerHTML para validar que este tildado Actividad Social
	 * 
	 * @param name
	 * 
	 * @return String
	 */
	public String getSocialEnabled(String name) {
		searchPlatformByName(name);
		return cellSocial.getAttribute("innerHTML");
	}
	
	/**
	 * Buscar por host
	 * 
	 * @param host
	 * 
	 * @return String
	 */
	public String searchPlatformByHost(String host) {
		if (!host.isEmpty())
			setFilterHost(host);
		
		WebElement platformname = getElementInListByHost(host);
		return platformname.getText();
	}
	
	/**
	 * Obtener la cantidad de elementos del listado por pag.
	 * 
	 * @return int
	 */
	public int getListSize() {
		return basicgrid.size();
	}
	
	/**
	 * Obtener el primer elemento del listado
	 * 
	 * @return String
	 */
	public String getFirstItemInList() {
		WebElement e = basicgrid.get(0);
		
		return e.findElement(By.xpath(tablexpath)).getText();
	}
	
	/**
	 * Cancelar la busqueda por name
	 */
	public void selectCancelSearchName() {
		filternamecancel.click();
	}
	
	/**
	 * Cancelar la busqueda por host
	 */
	public void selectCancelSearchHost() {
		filterhostcancel.click();
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
	 * Seleccionar crear plataforma
	 */
	public void selectCreateAction() {
		btnCreateAction.click();
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

}
