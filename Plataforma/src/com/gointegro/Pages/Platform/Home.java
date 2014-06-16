package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsWorkspace;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Workspace.JoinWorkSpace;
import com.gointegro.Pages.Workspace.WorkspaceCreate;

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
	
	@FindBy(xpath = "//div[@class='user-info']/div/a")
	private WebElement joinWorkspaceBtn;
	
	private String workspaceURL = ConfigElements.getURL() + "/environment/" + ConfigElementsWorkspace.getEnvironmentName();

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
	
	/**
	 * Abre la URL del ambiente de tests para crear espacios
	 */
	public void openWorkspaceEnv() {
		driver.get(workspaceURL);
	}
	
	/**
	 * Seleccionar el botón Unirme a otro espacio
	 * 
	 * @return JoinWorkSpace
	 */
	public JoinWorkSpace selectJoinWorkspace() {
		joinWorkspaceBtn.click();
		return PageFactory.initElements(driver, JoinWorkSpace.class);
	}
}
