package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class CreatePlatform extends PageBase{
	
	@FindBy (name = "name")
	protected WebElement name;
	
	@FindBy (name = "imageSize")
	protected WebElement imageSize;
	
	@FindBy (name = "videoSize")
	protected WebElement videoSize;
	
	@FindBy (name = "storage")
	protected WebElement storage;
	
	@FindBy (name = "webSite")
	protected WebElement webSite;
	
	@FindBy (name = "industry")
	protected WebElement industry;
	
	@FindBy (name = "usersRange")
	protected WebElement usersRange;
	
	@FindBy (name = "disable")
	protected WebElement disable;
	
	@FindBy (name = "googleAnalyticsTracking")
	protected WebElement googleAnalyticsTracking;
	
	@FindBy (name = "userVisibility")
	protected WebElement userVisibility;
	
	@FindBy (name = "socialEnabled")
	protected WebElement socialEnabled;
	
	@FindBy (name = "timeZone")
	protected WebElement timeZone;
	
	@FindBy (name = "benefitsEnabled")
	protected WebElement benefitsEnabled;
	
	@FindBy (id = "save")
	protected WebElement saveBtn;
	
	@FindBy (id = "save-and-new")
	protected WebElement saveNewBtn;
	
	@FindBy (id = "cancel")
	protected WebElement cancelBtn;
	
	@FindBy (xpath = "//div[contains(text(),'Cuenta')]/div/span/span")
	protected WebElement accountname;
	
	@FindBy (id = "c1_termsAndConditions_ifr")
	protected WebElement termsAndConditions;
	
	@FindBy (id = "c1_htmlLogin_ifr")
	protected WebElement htmlLogin;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreatePlatform(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/create";
	}
	
	/**
	 * Completar el nombre de la plataforma
	 * 
	 * @param platname
	 */
	protected void setPlatformName(String platname) {
		name.clear();
		name.sendKeys(platname);
	}
	
	/**
	 * Completar el size de la imagen
	 * 
	 * @param size
	 */
	protected void setImageSize(String size) {
		imageSize.clear();
		imageSize.sendKeys(size);
	}
	
	/**
	 * Completar el size de los videos
	 * 
	 * @param size
	 */
	protected void setVideoSize(String size) {
		videoSize.clear();
		videoSize.sendKeys(size);
	}
	
	/**
	 * Completar el storage de la plataforma
	 * 
	 * @param size
	 */
	protected void setStorage(String size) {
		storage.clear();
		storage.sendKeys(size);
	}
	
	/**
	 * Completar el website de la plataforma
	 * 
	 * @param web
	 */
	protected void setWebSite(String web) {
		webSite.clear();
		webSite.sendKeys(web);
	}
	
	/**
	 * Elegir una industria
	 * 
	 * @param indus
	 */
	protected void setIndustry(String indus) {
		Select select = new Select(industry);
		select.selectByVisibleText(indus);
	}
	
	/**
	 * Elegir un rango de usuarios
	 * 
	 * @param range
	 */
	protected void setUserRange(String range) {
		Select select = new Select(usersRange);
		select.selectByVisibleText(range);
	}
	
	/**
	 * Setear el status de disable de la plataforma
	 * 
	 * @param status
	 */
	protected void setDisable(boolean status) {
		if (status && disable.getAttribute("checked") == null)
			disable.click();
		else if (!status && disable.getAttribute("checked") != null)
			disable.click();
		else {}
	}
	
	/**
	 * Completar el codigo de GA
	 * 
	 * @param code
	 */
	protected void setGoogleAnalyticsCode(String code) {
		googleAnalyticsTracking.clear();
		googleAnalyticsTracking.sendKeys(code);
	}
	
	/**
	 * Completar la visibilidad entre usuarios
	 * 
	 * @param status
	 */
	protected void setUserVisibility(boolean status) {
		Select select = new Select(userVisibility);
		if (status) 
			select.selectByVisibleText("Mostrar");
		else
			select.selectByVisibleText("Ocultar");
	}
	
	/**
	 * Habilitar o no social
	 * 
	 * @param status
	 */
	protected void setSocialEnabled(boolean status) {
		if (status && socialEnabled.getAttribute("checked") == null)
			socialEnabled.click();
		else if (!status && socialEnabled.getAttribute("checked") != null)
			socialEnabled.click();
		else {}
	}
	
	/**
	 * Seleccionar la zona horaria
	 * 
	 * @param time
	 */
	protected void setTimeZone(String time) {
		Select select = new Select(timeZone);
		select.selectByVisibleText(time);
	}
	
	/**
	 * Completar los terminos y condiciones
	 * 
	 * @param tyc
	 */
	protected void setTermsAndConditions(String tyc) {
		driver.switchTo().frame(termsAndConditions);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + tyc + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Completar el texto de inicio de sesion
	 * 
	 * @param htmllog
	 */
	protected void setHtmlLogin(String htmllog) {
		driver.switchTo().frame(htmlLogin);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + htmllog + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Guardar los cambios
	 */
	public void selectSave() {
		saveBtn.click();
	}
	
	/**
	 * Cancelar
	 */
	public void selectCancel() {
		cancelBtn.click();
	}
	
	/**
	 * Completar los campos basicos de la plataforma
	 * 
	 * @param platname
	 * @param imgsize
	 * @param videosize
	 * @param storagesize
	 * @param web
	 * @param indus
	 * @param range
	 * @param disablestatus
	 * @param code
	 * @param uservisstatus
	 * @param socialstatus
	 * @param time
	 * @param tyc 
	 * @param htmllog 
	 */
	public void completeBasicInformation(String platname, String imgsize, String videosize, 
			String storagesize, String web, String indus, String range, boolean disablestatus, 
			String code, boolean uservisstatus, boolean socialstatus, String time, String tyc, String htmllog) {
		setPlatformName(platname);
		setImageSize(imgsize);
		setVideoSize(videosize);
		setStorage(storagesize);
		setWebSite(web);
		setIndustry(indus);
		setUserRange(range);
		setDisable(disablestatus);
		setGoogleAnalyticsCode(code);
		setUserVisibility(uservisstatus);
		setSocialEnabled(socialstatus);
		setTimeZone(time);
		setTermsAndConditions(tyc);
		setHtmlLogin(htmllog);
	}
	
	/**
	 * Obtener la cuenta
	 * 
	 * @return String
	 */
	public String getPlatformAccount() {
		return accountname.getText();
	}

}
