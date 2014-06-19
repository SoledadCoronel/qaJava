package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsWorkspace;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Administrar espacios
 * 
 * @author diogodarosa
 */
public class AdminWorkspace extends PageBase {
	
	@FindBy(xpath = "//ul[@id='configureWorkspace']/li")
	List<WebElement> workspaceList;
	
	@FindBy(xpath = "//section[@class='spaces_administrator']/div")
	WebElement saveAlert;
	
	String deleteBtn = "./div/p[@class='categ-confirm']/button[3]";
	
	String disableBtn = "./div/p[@class='categ-confirm']/button[2]";
	
	String configWorkspaceBtn = "./div/p[@class='categ-confirm']/button[1]";
	
	String adminURL = ConfigElements.getURL() + "/environment/" + ConfigElementsWorkspace.getEnvironmentName() + "/workspaces/sort";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public AdminWorkspace(WebDriver driver) {
		super(driver);
		URL = adminURL;
	}
	
	/**
	 * Devuelve la URL de Administrar espacios
	 */
	public String getAdminURL() {
		return adminURL;
	}
	
	/**
	 * Seleccionar el botón Eliminar espacio
	 * 
	 * @param name
	 */
	public DeleteOverlay selectDeleteWorkspace(String name) {
		for(WebElement element : workspaceList) {
			if(element.getAttribute("data-name").contains(name)) {
				element.findElement(By.xpath(deleteBtn)).click();
			}
		}
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Devuelve si el espacio se encuentra en la lista
	 * 
	 * @param name
	 * @return Boolean
	 */
	public Boolean isWorkspaceInList(String name) {
		Boolean isWorkspaceInList = false;
		
		for(WebElement element : workspaceList) {
			if(element.getAttribute("data-name").contains(name)) {
				isWorkspaceInList = true;
			}
		}
		return isWorkspaceInList;
	}
	
	
	public void waitForSaveAlertPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class='spaces-administrator']/p/div")));
	}
	
	/**
	 * Cambiar el orden de los espacios
	 * 
	 * @param name1
	 * @param name2
	 */
	public void changeWorkspaceOrder(String name1, String name2) {
		WebElement element1 = null;
		WebElement element2 = null;
		
		for(WebElement element : workspaceList) {
			if(element.getAttribute("data-name").contains(name1)) {
				element1 = element;
			}
			if(element.getAttribute("data-name").contains(name2)) {
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
	private void changeOrder(WebElement element1, WebElement element2) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(element2).moveToElement(element1).release(element1).build();

		dragAndDrop.perform();
	}
	
	/**
	 * Seleccionar el botón Eliminar espacio
	 * 
	 * @param name
	 */
	public DeleteOverlay deleteFirst() {
		for(WebElement element : workspaceList) {
			element.findElement(By.xpath(deleteBtn)).click();
			break;
		}
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Devuelve el total de espacios en el listado
	 * @return
	 */
	public int getWorkSpaceCount() {
		return workspaceList.size();
	}

}
