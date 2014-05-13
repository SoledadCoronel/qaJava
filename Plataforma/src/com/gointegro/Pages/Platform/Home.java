package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

/**
 * PageObject de la home
 * 
 * @author gustavomoreira
 *
 */
public class Home extends PageBase{
	
	@FindBy(name = "Nuevo espacio")
    private WebElement workspacecreate;
	
	@FindBy(name = "dropdown-workspace-menu")
	private WebElement dropdownworkspacemenu;
	
	@FindBy(linkText = "Administrar espacios")
	private WebElement adminworkspace;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Home(WebDriver driver) {
		super(driver);
		
	}
	
	/** 
	 * Create Workspace
	 * 
	 * @return WorkspaceCreate
	 */
	public WorkspaceCreate workspaceCreate() {
		workspacecreate.click();
		
		return PageFactory.initElements(driver, WorkspaceCreate.class);
	}
	
	
	

}
