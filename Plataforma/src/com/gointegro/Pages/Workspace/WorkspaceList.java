package com.gointegro.Pages.Workspace;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.ApplicationAdmin;

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
	
	String addApp = "./div/ul/li[4]/a";
	
	String adminApps = "./div/ul/li[5]/a";
	
	String application = "./li[2]/a";
	
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
	
	/**
	 * Seleccionar el botón Agregar aplicación
	 * 
	 * @param WebElement
	 */
	private void selectAddApplication(WebElement element) {
		element.findElement(By.xpath(addApp)).click();
	}
	
	/**
	 * Seleccionar el botón opciones y Agregar aplicación
	 * 
	 * @param String
	 * @return AplicationAdd
	 */
	public AplicationAdd selectAddAplicactions(String name) {
		WebElement element = getWorkspaceElement(name);
		selectOptionsBtn(element);
		selectAddApplication(element);
		return PageFactory.initElements(driver, AplicationAdd.class);
	}
	
	/**
	 * Seleccionar el botón Administrar aplicaciones
	 * 
	 * @param WebElement
	 */
	private void selectAdminApp(WebElement element) {
		element.findElement(By.xpath(adminApps)).click();
	}
	
	/**
	 * Seleccionar el botón opciones y Administrar aplicaciones
	 * 
	 * @param String
	 * @return ApplicationAdmin
	 */
	public ApplicationAdmin selectAdminApps(String name) {
		WebElement element = getWorkspaceElement(name);
		selectOptionsBtn(element);
		selectAdminApp(element);
		return PageFactory.initElements(driver, ApplicationAdmin.class);
	}
	
	/**
	 * Devuelve si la aplicación existe en el espacio apropriado
	 * 
	 * @param workspaceName
	 * @param appName
	 * @return Boolean
	 */
	public Boolean isApplicationInWorkspace(String workspaceName, String appName) {
		Boolean isAppPresent = false;
		
		WebElement element = getWorkspaceElement(workspaceName);
		if(element.findElements(By.xpath(application)).size() > 0) {
			if(element.findElement(By.xpath(application)).getAttribute("title").contains(appName)) {
				isAppPresent = true;
			}
		}
		return isAppPresent;
	}
	
	/**
	 * Devuelve el nombre de la primera aplicación en el espacio
	 * 
	 * @param workspaceName
	 * @return String
	 */
	public String getFirstAppName(String workspaceName) {
		String name = "";
		
		WebElement element = getWorkspaceElement(workspaceName);
		
		if(element.findElements(By.xpath(application)).size() > 0) {
			name = element.findElement(By.xpath(application)).getAttribute("title");
		}
		return name;
	}
	
	/**
	 * Devuelve si el texto "Ver más..." esta presente
	 * 
	 * @param name
	 * @return Boolean
	 */
	public Boolean isMoreButtonPresent(String name) {
		Boolean isAppPresent = false;
		
		WebElement element = getWorkspaceElement(name);
		
		if(element.getAttribute("innerHTML").contains("Ver más...")) {
			isAppPresent = true;
		}
		return isAppPresent;
	}
	
	/**
	 * Devuelve el index del espacio en el listado
	 * 
	 * @param name
	 * @return int
	 */
	public int getWorkspaceIndex(String name) {
		int index = 0;
		name = name.toUpperCase();
		
		for(WebElement element : workspaceList) {
			if(element.findElement(By.xpath("./li")).getText().contains(name)) {
				break;
			}
			index++;
		}
		return index;
	}	
	
}
