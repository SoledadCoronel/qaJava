package com.gointegro.Pages.Platform;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Workspace.DeleteOverlay;

/**
 * PO. Administrar aplicaciones
 * 
 * @author diogodarosa
 *
 */
public class ApplicationAdmin extends PageBase {

	
	@FindBy(xpath = "//ul[@id='configureApplication']/li")
	List<WebElement> appList;
	
	String delete = "./div/p[@class='categ-confirm']/button[2]";
	
	String config = "./div/p[@class='categ-confirm']/button";
	
	String title = "./div/header/span";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public ApplicationAdmin(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el botón Eliminar aplicación
	 * 
	 * @param WebElement
	 */
	private void selectDeleteBtn(WebElement element) {
		element.findElement(By.xpath(delete)).click();
	}
	
	/**
	 * Seleccionar el botón Configurar aplicación
	 * 
	 * @param WebElement
	 */
	private void selectConfigBtn(WebElement element) {
		element.findElement(By.xpath(config)).click();
	}
	
	/**
	 * Seleccionar el botón Eliminar aplicación buscando por titulo
	 * 
	 * @param name
	 * @return DeleteOverlay
	 */
	public DeleteOverlay deleteApp(String name) {
		for(WebElement element : appList) {
			if(element.findElement(By.xpath(title)).getText().contains(name)) {
				selectDeleteBtn(element);
			}
		}
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Seleccionar el botón Configurar aplicación buscando por titulo
	 * 
	 * @param name
	 * @return AplicationInstall
	 */
	public AplicationInstall editApp(String name) {
		for(WebElement element : appList) {
			if(element.findElement(By.xpath(title)).getText().contains(name)) {
				selectConfigBtn(element);
			}
		}
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Cambiar el orden de las aplicaciones
	 * 
	 * @param appName1
	 * @param appName2
	 */
	public void changeAppOrder(String appName1, String appName2) {
		WebElement element1 = null;
		WebElement element2 = null;
		
		for(WebElement element : appList) {
			if(element.findElement(By.xpath(title)).getText().contains(appName1)) {
				element1 = element;
			}
			if(element.findElement(By.xpath(title)).getText().contains(appName2)) {
				element2 = element;
			}
		}
		changeOrder(element1, element2);
	}
	
	/**
	 * Cambiar el orden de los elementos, pone el primero ultimo.
	 * 
	 * @param WebElement
	 * @param WebElement
	 */
	private void changeOrder(WebElement widgetElement1, WebElement widgetElement2) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(widgetElement2).moveToElement(widgetElement1).release(widgetElement1).build();

		dragAndDrop.perform();
	}
	
}
