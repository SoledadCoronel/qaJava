package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

public class AplicationInstall extends PageBase{
	
	@FindBy (id = "app-name")
	protected WebElement appname;
	
	@FindBy (xpath = "//div[@id='description']/textarea")
	protected WebElement description;
	
	@FindBy (id = "selected-icon")
	protected WebElement selectedicon;
	
	@FindBy (name = "disable")
	protected WebElement radioactive;
	
	@FindBy (xpath = "//div[@class='controls']/label[2]/input")
	protected WebElement radiodisactive;
	
	@FindBy (id = "socialEnabled")
	protected WebElement socialEnabled;
	
	@FindBy (name = "displayStrategy")
	protected WebElement radiodaysPast;
	
	@FindBy (xpath = "(//input[@name='displayStrategy'])[2]")
	protected WebElement radiomonthsPast;
	
	@FindBy (name = "daysPast")
	protected WebElement daysPast;
	
	@FindBy (name = "monthsPast")
	protected WebElement monthsPast;
	
	@FindBy (id = "accept")
	protected WebElement accept;
	
	@FindBy (id = "cancel")
	protected WebElement cancel;
	
	@FindBy (name = "tournamentList")
	protected WebElement tournamentlist;
	
	@FindBy(xpath = "//div[@id='name']/span")
	protected WebElement titleErrorMsg;
	
	@FindBy(xpath = "//div[@id='install-app-view']/div")
	protected WebElement saveErrorMsg;
	
	@FindBy(xpath = "//div[@id='tree-categories-list']/ul[1]/li/label")
	protected WebElement category;
	
	@FindBy(xpath = "//span[@id='categories-error']")
	protected WebElement categoryErrorMsg;
	
	@FindBy(xpath = "//input[@id='categories-list_1_select_all']")
	protected WebElement subcategory;
	
	@FindBy(id= "collections-radio")
	protected WebElement benefitSpecials;
	
	@FindBy (id = "attachmentUpload")
	protected WebElement attachementupload;
	
	@FindBy (className = "has-locations")
	protected WebElement locations;
	
	@FindBy (name = "txt-search")
	protected WebElement locationInput;
	
	@FindBy (xpath = "//ul[@id='-list']/li/div/div/button")
	protected WebElement locationBtn;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AplicationInstall(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar nombre
	 * 
	 * @param name
	 */
	public void setAppName(String name) {
		appname.clear();
		appname.sendKeys(name);
	}
	
	/**
	 * Completar descripcion
	 * 
	 * @param descr
	 */
	protected void setDescription(String descr) {
		description.clear();
		description.sendKeys(descr);
	}
	
	/**
	 * Activa social o desactiva social
	 * 
	 * @param activeSocial activa = true, desactiva = false.
	 */
	protected void selectSocialEnabled(boolean activeSocial) {
		if (activeSocial) {
			if (!socialEnabled.isSelected())
				socialEnabled.click();
		}
		else {
			if (socialEnabled.isSelected())
				socialEnabled.click();
		}
	}
	
	/**
	 * Seleccionar Estado Activa
	 */
	protected void selectActive() {
		radioactive.click();
	}
	
	/**
	 * Seleccionar Estado Desactivada
	 */
	protected void selectDisactive() {
		radiodisactive.click();
	}
	
	/**
	 * Seleccionar el status de la app
	 * 
	 * @param status
	 */
	protected void setStatus (boolean status) {
		if (status)
			selectActive();
		else
			selectDisactive();
	}
	
	/**
	 * Seleccionar Mostrar Celebraciones desde Una cantidad de dias atras
	 */
	protected void selectDaysPast() {
		radiodaysPast.click();
	}
	
	/**
	 * Seleccionar Mostrar celebracioens desde el primeo de un mes dado
	 */
	protected void selectMonthsPast() {
		radiomonthsPast.click();
	}
	
	/**
	 * Completar celebraciones desde una cantidad de dias atras
	 * 
	 * @param num
	 */
	protected void setDaysPast(String num) {
		daysPast.clear();
		daysPast.sendKeys(num);
	}
	
	/**
	 * Seleccionar un mes para mostrar
	 * 
	 * @param month false "Mes anterior" - true "Mes actual"
	 */
	protected void setMonthsPast(boolean month) {
		if (month)
			new Select(monthsPast).selectByVisibleText("Mes actual");
		else
			new Select(monthsPast).selectByVisibleText("Mes anterior");
	}
	
	/**
	 * Seleccionar Guardar
	 */
	public void saveBtn() {
		accept.click();
	}
	
	/**
	 * Cancelar
	 */
	protected void cancelBtn() {
		cancel.click();
	}
	
	/**
	 * Completar dias atras
	 * 
	 * @param num
	 */
	protected void daysPastComplete(String num) {
		selectDaysPast();
		setDaysPast(num);
	}
	
	/**
	 * Completar meses atras
	 * 
	 * @param month
	 */
	protected void monthsPastComplete(boolean month) {
		selectMonthsPast();
		setMonthsPast(month);
	}
	
	
	/**
	 * Completa los campos especiales para el caso de una app de Celebraciones
	 * 
	 * @param num si esta vacio pasa directamente a tomar en cuenta el mes
	 * @param month
	 */
	public void celebrationComplete(String num, boolean month) {
		if (!num.isEmpty()) {
			daysPastComplete(num);
		}
		else
			monthsPastComplete(month);
	}
	
	/**
	 * Seleccionar un torneo por nombre
	 * 
	 * @param tournament
	 */
	public void selectTournament(String tournament) {
		Select droplist = new Select(tournamentlist);
		droplist.selectByVisibleText(tournament);
	}
	
	/**
	 * Completar los campos standard de todas las app
	 * 
	 * @param name
	 * @param descr
	 * @param status
	 * @param activeSocial
	 */
	public void completeInstallApp(String name, String descr, boolean status, boolean activeSocial, boolean isappsocial) {
		setAppName(name);
		setDescription(descr);
		setStatus(status);
		if (isappsocial) {
			selectSocialEnabled(activeSocial);
		}
		saveBtn();
	}
	
	/**
	 * Devuelve el mensaje de error del titulo
	 * 
	 * @return String
	 */
	public String getTitleErrorMsg() {
		return titleErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error al guardar los cambios
	 * 
	 * @return String
	 */
	public String getSaveErrorMsg() {
		return saveErrorMsg.getText();
	}

	/**
	 * Completar los campos de Filtro Beneficios
	 * 
	 * @param name
	 * @param descr
	 * @param status
	 */
	public void completeInstallBenefitFilter(String name, String descr, boolean isEnabled, boolean hasCategories, boolean hasSpecial) {
		setAppName(name);
		setDescription(descr);
		setStatus(isEnabled);
		
		if(hasCategories) {
			selectFirstBenefitCategory();
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			selectFirstBenefitSubCategory();
		}
		else if(hasSpecial) {
			selectBenefitSpecials();
		}
		
	}	
	
	/**
	 * Seleccionar la primera categoria de Filtro Beneficios 
	 */
	public void selectFirstBenefitCategory() {
		category.click();
	}
	
	/**
	 * Seleccionar todas las subCategorias de la primera categoria de Filtro Beneficios 
	 */
	public void selectFirstBenefitSubCategory() {
		subcategory.click();
	}
	
	/**
	 * Seleccionar el tipo de filtro Especiales de Filtro Beneficios
	 */
	public void selectBenefitSpecials() {
		benefitSpecials.click();
	}
	
	/**
	 * Devuelve el mensaje de error de categorias
	 * 
	 * @return String
	 */
	public String getCategoriesError() {
		return categoryErrorMsg.getText();
	}
	
	/**
	 * Ingresar una imagen miniatura
	 * 
	 * @param fileupload
	 */
	public void fileUpload(String fileupload) {
		AttachmentUploads.SocialWallAttachment(driver);
		attachementupload.sendKeys(fileupload);
		AttachmentUploads.waitBar(driver);
	}
	
	/**
	 * Seleccionar Ubicaciones de Filtro Beneficios
	 */
	public void selectBenefitLocations() {
		locations.click();
	}
	
	/**
	 * Completar Ubicaciones
	 * 
	 * @param address
	 */
	public void addLocation(String address) {
		selectBenefitLocations();
		
		locationInput.clear();
		locationInput.sendKeys(address);
		
		locationBtn.click();
	}
}
