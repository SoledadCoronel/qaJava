package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Overlay para agregar colaboradores
 * 
 * @author diogodarosa
 *
 */
public class AddColaboratorsOverlay extends PageBase {
	
	
	@FindBy(name = "filters[fullname]")
	WebElement nameFilter;
	
	@FindBy(id = "btnCancel")
	WebElement cancelBtn;
	
	@FindBy(id = "btnJoin")
	WebElement saveBtn;
	
	@FindBy(xpath = "//table[@id='collaboratorsList']/tbody/tr")
	List<WebElement> collabList;
	
	String colabName = "./td[2]/div";
	
	String addColabBtn = "./td[3]/button";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public AddColaboratorsOverlay(WebDriver driver) {
		super(driver);
	}

	
	/**
	 * Crear filtro de colaborador
	 * 
	 * @param String
	 */
	public void createFilterWithName(String name) {
		nameFilter.clear();
		nameFilter.sendKeys(name);
		nameFilter.sendKeys(Keys.RETURN);
	}

	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancelBtn() {
		cancelBtn.click();
	}
	
	/**
	 * Seleccionar el botón Aceptar
	 */
	public void selectSaveBtn() {
		saveBtn.click();
	}
	
	/**
	 * Agregar el colaborador al espacio
	 * 
	 * @param String
	 */
	public void selectColabInList(String name) {
		
		for(WebElement element : collabList) {
			if(element.findElement(By.xpath(colabName)).getText().contains(name)) {
				makeVisibleAddColab(element.findElement(By.xpath(addColabBtn)));
				element.findElement(By.xpath(addColabBtn)).click();
			}
		}
	}
	
	/**
	 * Vuelve visible las acciones de la foto
	 */
	private void makeVisibleAddColab(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','display:block;')", element);
	}
	
	
}

