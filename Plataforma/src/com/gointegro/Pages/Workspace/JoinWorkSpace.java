package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Listado de espacios publicos para unirse
 * 
 * @author diogodarosa
 *
 */
public class JoinWorkSpace extends PageBase {
	
	@FindBy(className = "spaces-list")
	List<WebElement> joinList;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public JoinWorkSpace(WebDriver driver) {
		super(driver);
	}

	/**
	 * Devuelve true si el espacio se encuentra en el listado de espacios a unirse
	 * 
	 * @param String
	 * @return Boolean
	 */
	public Boolean isWorkspaceInList(String name) {
		Boolean isWorkspaceInList = false;
		
		if(driver.findElement(By.className("spaces-list")).getAttribute("innerHTML").contains(name)) {
			isWorkspaceInList = true;
		}
		return isWorkspaceInList;
	}
	
	
}
