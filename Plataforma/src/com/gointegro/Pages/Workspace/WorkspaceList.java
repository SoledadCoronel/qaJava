package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;


/**
 * PO. Menu lateral con el listado de espacios
 * 
 * @author diogodarosa
 *
 */
public class WorkspaceList extends PageBase {
	
	@FindBy(xpath = "//div[@id='list']/ul")
	List<WebElement> workspaceList;
	
	String options = "./div/a[2]";
	
	String edit = "./div/ul/li[1]/a";
	
	String delete = "./div/ul/li[2]/a";
	
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public WorkspaceList(WebDriver driver) {
		super(driver);
	}

	
	/**
	 * Devuelve true si el espacio se encuentra en el listado de espacios
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isWorkspaceInList(String name) {
		Boolean isWorkspaceInList = false;
		name = name.toUpperCase();
		
		if(driver.findElement(By.id("list")).getAttribute("innerHTML").toUpperCase().contains(name)) {
			isWorkspaceInList = true;
		}
		return isWorkspaceInList;
	}
	
	/**
	 * Devuelve si el label Nuevo esta presente
	 * 
	 * @param WebElement
	 * @return Boolean
	 */
	public Boolean isNewLabelPresent(String name) {
		Boolean isLabelPresent = false;
		name = name.toUpperCase();
		
		for(WebElement element : workspaceList) {
			if(element.findElement(By.xpath("./li")).getText().contains(name+"NUEVO")) {
				isLabelPresent = true;
			}
		}
		return isLabelPresent;
	}
	
	/**
	 * Seleccionar el espacio por nombre
	 * 
	 * @param String
	 */
	public void selectWorkspace(String name) {
		name = name.toUpperCase();
		
		for(WebElement element : workspaceList) {
			if(element.findElement(By.xpath("./li")).getText().contains(name)) {
				element.findElement(By.xpath("./li/a")).click();
			}
		}
	}
	
	/**
	 * Devuelve si el espacio tiene una URL externa
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean hasUrl(String name) {
		Boolean hasUrl = false;
		name = name.toUpperCase();
		
		for(WebElement element : workspaceList) {
			if(element.findElement(By.xpath("./li")).getText().contains(name)) {
				if(element.findElements(By.xpath("./li/a")).size() > 0) {
					hasUrl = true;
				}
			}
		}
		return hasUrl;
	}
	
	/**
	 * Devuelve un WebElement del espacio
	 * 
	 * @param String
	 * @return WebElement
	 */
	public WebElement getWorkspaceElement(String name) {
		WebElement element = null;
		name = name.toUpperCase();
		
		for(WebElement ele : workspaceList) {
			if(ele.findElement(By.xpath("./li")).getText().contains(name)) {
				element = ele;
			}
		}
		return element;
	}
	
	/**
	 * Seleccionar el botón opciones y Configurar espacio
	 * 
	 * @param String
	 */
	public void selectEditWorkspace(String name) {
		WebElement element = getWorkspaceElement(name);
		selectOptionsBtn(element);
		selectEditBtn(element);
	}
	
	/**
	 * Seleccionar el botón opciones
	 * 
	 * @param Webelement
	 */
	private void selectOptionsBtn(WebElement element) {
		element.findElement(By.xpath(options)).click();
	}
	
	/**
	 * Seleccionar el botón Configurar espacio
	 * 
	 * @param Webelement
	 */
	private void selectEditBtn(WebElement element) {
		element.findElement(By.xpath(edit)).click();
	}
	
	/**
	 * Seleccionar el botón Eliminar espacio
	 * 
	 * @param Webelement
	 */
	private void selectDeleteBtn(WebElement element) {
		element.findElement(By.xpath(delete)).click();
	}
	
	/**
	 * Seleccionar el botón opciones y Configurar espacio
	 * 
	 * @param String
	 * @return DeleteOverlay
	 */
	public DeleteOverlay selectDeleteWorkspace(String name) {
		WebElement element = getWorkspaceElement(name);
		selectOptionsBtn(element);
		selectDeleteBtn(element);
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
}
