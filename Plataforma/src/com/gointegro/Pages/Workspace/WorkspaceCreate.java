package com.gointegro.Pages.Workspace;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Util.WaitTool;

/**
 * PO. Formulario de Nuevo espacio
 * 
 * @author diogodarosa
 */
public class WorkspaceCreate extends PageBase {
	
	
	@FindBy(id = "enabled")
	WebElement enabled;
	
	@FindBy(id = "disabled")
	WebElement disabled;
	
	@FindBy(name = "name")
	WebElement title;
	
	@FindBy(id = "external-url")
	WebElement externalUrlBtn;
	
	@FindBy(name = "externalUrl")
	WebElement externalUrlInput;
	
	@FindBy(name = "close-url")
	WebElement closeUrl;
	
	@FindBy(id = "workspace-description")
	WebElement description;
	
	@FindBy(id = "private")
	WebElement privateRadio;
	
	@FindBy(id = "public")
	WebElement publicRadio;
	
	@FindBy(id = "add-colabs")
	WebElement addColabsBtn;
	
	@FindBy(id = "workspace-label")
	WebElement markAsNew;
	
	@FindBy(id = "workspace-visibleApp")
	WebElement visibleApps;
	
	@FindBy(id = "save")
	WebElement save;
	
	@FindBy(id = "cancel")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@data-fields='name']/div/div")
	WebElement titleErroMsg;
	
	@FindBy(xpath = "//div[@data-fields='description']/div/div")
	WebElement descriptionErroMsg;
	
	@FindBy(xpath = "//div[@class='main-container']/div/div/span")
	WebElement saveErroMsg;
	
	@FindBy(xpath = "//label[@for='workspace-autojoin']")
	WebElement joinAllCheckBox;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public WorkspaceCreate(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el botón Activado
	 */
	public void selectEnabled() {
		enabled.click();
	}
	
	/**
	 * Seleccionar el botón Desactivado
	 */
	public void selectDisabled() {
		disabled.click();
	}
	
	/**
	 * Seleccionar el botón cerrar url
	 */
	public void selectCloseUrl() {
		closeUrl.click();
	}
	/**
	 * Seleccionar el botón Direccionar a una URL externa
	 */
	public void selectExternalUrlBtn() {
		externalUrlBtn.click();
	}
	
	/**
	 * Seleccionar el botón Direccionar a una URL externa
	 * 
	 * @param url
	 */
	public void createExternalUrl(String url) {
		externalUrlInput.clear();
		externalUrlInput.sendKeys(url);
	}
	
	/**
	 *  Crear titulo para el espacio
	 *  
	 *  @param name
	 */
	public void createTitle(String name) {
		title.clear();
		title.sendKeys(name);
	}
	
	/**
	 *  Crear descripcion para el espacio
	 *  
	 *  @param name
	 */
	public void createDescription(String name) {
		description.clear();
		description.sendKeys(name);
	}
	
	/**
	 * Seleccionar el botón Privado
	 */
	public void selectPrivate() {
		privateRadio.click();
	}
	
	/**
	 * Seleccionar el botón Publico
	 */
	public void selectPublic() {
		publicRadio.click();
	}
	
	/**
	 *  Seleccionar el botón cancelar
	 */
	public void selectCancelBtn() {
		cancel.click();
	}
	
	/**
	 * Seleccionar el botón Agregar colaboradores
	 */
	public AddColaboratorsOverlay selectAddColabs() {
		addColabsBtn.click();
		return PageFactory.initElements(driver, AddColaboratorsOverlay.class);
	}
	
	/**
	 * Seleccionar el botón Aplicaciones visibles
	 */
	public void selectVisibleAppsNum() {
		visibleApps.click();
	}
	
	/**
	 * Seleccionar el botón Etiquetar este espacio como NUEVO
	 */
	public void selectMarkAsNew() {
		markAsNew.click();
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param date
	 */
	public void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('workspace-labelDate').value='"+date+"'");
	}
	
	/**
	 *  Seleccionar el botón cancelar
	 */
	public AplicationAdd selectSaveBtn() {
		save.click();
		return PageFactory.initElements(driver, AplicationAdd.class);
	}
	
	/**
	 * Crear un espacio
	 * 
	 * @param title
	 * @param description
	 * @param isEnabled
	 * @param isPrivate
	 * @param url
	 */
	public void createWorkspace(String title, String description, Boolean isEnabled, Boolean isPrivate, String url) {
		
		if(isEnabled) {
			selectEnabled();
		} else {
			selectDisabled();
		}
		
		createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		if(isPrivate) {
			selectPrivate();
		} else {
			selectPublic();
		}
		
		if(!url.isEmpty()) {
			selectExternalUrlBtn();
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			createExternalUrl(url);
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
	}
	
	
	/**
	 *  Devuelve el mensage de error del titulo
	 *  
	 *  @return String
	 */
	public String getTitleErrorMsg() {
		return titleErroMsg.getText();
	}
	
	/**
	 *  Devuelve el mensage de error de la descripción
	 *  
	 *  @return String
	 */
	public String getDescriptionErrorMsg() {
		return descriptionErroMsg.getText();
	}
	
	/**
	 *  Devuelve el mensage de error del formulario
	 *  
	 *  @return String
	 */
	public String getSaveErrorMsg() {
		return saveErroMsg.getText();
	}
	
	/**
	 * Seleccionar el check box Agregar automáticamente a todos
	 */
	public void selectJoinAll() {
		joinAllCheckBox.click();
	}
	

}
