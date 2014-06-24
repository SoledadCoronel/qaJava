package com.gointegro.Pages.Profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Solapa Archivos
 * 
 * @author diogodarosa
 */
public class FileTab extends PageBase {
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr")
	List<WebElement> fileList;
	
	@FindBy(xpath = "//table[@class='table']/tbody/tr/td[@class='template']")
	WebElement fileListElement;
	
	@FindBy(name = "filters[filename]")
	WebElement searchField;
	
	@FindBy(id = "filename-filter-btn-submit")
	WebElement searchFieldBtn;
	
	@FindBy(xpath = "//div[@class='backgrid-paginator']/ul/li")
	List<WebElement> paginator;
	
	@FindBy(id = "head-updated_at")
	WebElement lastChangeSort;
	
	String fileName = "./td[2]/a";
	
	String placeLink = "./td[3]/a";
	
	String lastChange = "./td[4]";
	
	String deleteBtn = "./td[5]/a";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public FileTab(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/profile/#files";
	}
	
	
	/**
	 * Devuelve el elemento del archivo buscando por nombre
	 * 
	 * @param name
	 * @return WebElement
	 */
	private WebElement getFileElement(String name) {
		WebElement ele = null;
		
		for (WebElement element : fileList) {
			if (element.findElement(By.xpath(fileName)).getText().contains(name)) {
				ele = element;
				break;
			}
		}
		return ele;
	}
	
	/**
	 * Devuelve si el archivo se encuentra en la lista
	 * 
	 * @param name
	 * @return String
	 */
	public Boolean isFileInList(String name, String date) {
		Boolean isFileInList = false;
		
		for (WebElement element : fileList) {
			if (element.findElement(By.xpath(fileName)).getText().contains(name) && 
					element.findElement(By.xpath(lastChange)).getText().contains(date)) {
				isFileInList = true;
				break;
			}
		}
		return isFileInList;
	}

	/**
	 * Espera el listado de archivos cargar
	 */
	public void waitForFileListToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOf(fileListElement));
	}
	
	/**
	 * Crear un filtro
	 * 
	 * @param name
	 */
	public void createFilter(String name) {
		searchField.clear();
		searchField.sendKeys(name);
		searchFieldBtn.click();
	}
	
	/**
	 * Seleccionar el link Lugar
	 * 
	 * @param name
	 */
	public void selectPlaceLink(String name) {
		WebElement element = null;
		
		element = getFileElement(name);
		element.findElement(By.xpath(placeLink)).click();
	}
	
	/**
	 * Devuelve un WebElement del link del archivo
	 * 
	 * @param name
	 */
	public WebElement getFileLink(String name) {
		WebElement element = null;
		
		element = getFileElement(name);
		return element.findElement(By.xpath(fileName));
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
	 * Seleccionar la sengunda pagina de archivos
	 */
	public Boolean isSecondPageActive() {
		Boolean isPageActive = false;
		
		if(driver.findElements(By.xpath("//ul/li[@class='active']/a[@id='page-2']")).size() > 0) {
			isPageActive = true;
		}
		return isPageActive;
	}
	
	/**
	 * Seleccionar el botón eliminar
	 * 
	 * @param name
	 */
	public DeleteOverlay deleteFile(String name) {
		WebElement element = null;
		
		element = getFileElement(name);
		element.findElement(By.xpath(deleteBtn)).click();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	
	
}
