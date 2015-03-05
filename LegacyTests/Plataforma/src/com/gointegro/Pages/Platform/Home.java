package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsWorkspace;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Workspace.AdminWorkspace;
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
	
	@FindBy(xpath = "//li[@class='profile-pic']/a")
	private WebElement dropDownProfile;
	
	@FindBy(xpath = "//li[@class='profile-pic open']/ul/li[1]/a")
	private WebElement myProfileBtn;
	
	@FindBy(name = "q")
	private WebElement searchField;
	
	@FindBy(id = "search-button")
	private WebElement searchButton;
	
	private String workspaceURL = ConfigElements.getURL() + "/environment/" + ConfigElementsWorkspace.getEnvironmentName();

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Home(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL();
		
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
	 * Seleccionar Administrar espacios
	 * 
	 * @return AdminWorkspace
	 */
	public AdminWorkspace selectAdminWorkspace() {
		dropdownworkspacemenu.click();
		adminworkspace.click();
		return PageFactory.initElements(driver, AdminWorkspace.class);
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
	
	/**
	 * Seleccionar el drop down del perfil
	 */
	private void selectProfileDropDown() {
		dropDownProfile.click();
	}
	
	/**
	 * Seleccionar el drop down del perfil
	 */
	private void selectMyProfileBtn() {
		myProfileBtn.click();
	}
	
	/**
	 * Seleccionar el drop down del perfil y el botón Mi Perfil
	 */
	public Profile selectMyProfile() {
		selectProfileDropDown();
		selectMyProfileBtn();
		return PageFactory.initElements(driver, Profile.class);
	}
	
	/**
	 * Hacer una búsqueda
	 * 	
	 * @param text
	 * @return SearchResult
	 */
	public SearchResult searchForText(String text) {
		searchField.clear();
		searchField.sendKeys(text);
		
		searchButton.click();
		return PageFactory.initElements(driver, SearchResult.class);
	}
}
