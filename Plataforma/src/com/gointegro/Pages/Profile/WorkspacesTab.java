package com.gointegro.Pages.Profile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;


public class WorkspacesTab extends PageBase {
	
	
	@FindBy(xpath = "//ul[@class='spaces']/li")
	List<WebElement> workspacesList;
	
	String unjoinBtn = "./button[@data-action='unjoin']";
	
	String title = "./header/h3";
	
	String goToWorkspace = "./button";
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public WorkspacesTab(WebDriver driver) {
		super(driver);
	}

	/**
	 * Seleccionar el botón Abandonar espacio
	 * 
	 * @param name
	 */
	public void selectUnjoin(String name) {
		for(WebElement element : workspacesList){
			if(element.findElement(By.xpath(title)).getText().contains(name)) {
				if(element.findElements(By.xpath(unjoinBtn)).size() > 0) {
					element.findElement(By.xpath(unjoinBtn)).click();
				}
			}
		}
	}
	
	/**
	 * Seleccionar el botón Ir al espacio 
	 * Solo para espacios publicos (donde "Ir al espacio" es el primer botón)
	 * 
	 * @param name
	 */
	public void selectGoToWorkspace(String name) {
		for(WebElement element : workspacesList){
			if(element.findElement(By.xpath(title)).getText().contains(name)) {
				if(element.findElements(By.xpath(goToWorkspace)).size() > 0) {
					element.findElement(By.xpath(goToWorkspace)).click();
				}
			}
		}
	}
	
}
