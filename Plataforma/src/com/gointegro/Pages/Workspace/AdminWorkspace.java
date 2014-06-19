package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class AdminWorkspace extends PageBase {
	
	
	String deleteBtn = "./div/p[@class='categ-confirm']/button[3]";
	
	String disableBtn = "./div/p[@class='categ-confirm']/button[2]";
	
	String configWorkspaceBtn = "./div/p[@class='categ-confirm']/button[1]";
	
	@FindBy(xpath = "//ul[@id='configureWorkspace']/li")
	List<WebElement> workspaceList;
	
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public AdminWorkspace(WebDriver driver) {
		super(driver);
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

}
