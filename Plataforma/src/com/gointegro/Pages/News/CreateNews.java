package com.gointegro.Pages.News;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;

public class CreateNews extends PageBase {
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "content_ifr")
	WebElement description;
	
	@FindBy (id = "attachmentUpload")
	WebElement attachmentUpload;
	
	@FindBy(id = "title-error")
	WebElement titleError;
	
	@FindBy(id = "content-error")
	WebElement descriptionError;
	
	@FindBy(id = "publicationDate-error")
	WebElement dateError;
	
	@FindBy(id = "publicationHour")
	WebElement hour;
	
	@FindBy(id = "publicationDate")
	WebElement date;
	
	@FindBy(id = "socialEnabled")
	WebElement socialCheckBox;
	
	@FindBy(id = "accept")
	WebElement savebtn;
	
	@FindBy(id = "cancel")
	WebElement cancelbtn;
	
	@FindBy(xpath = "//header[@class='titleEditable']/div")
	WebElement saveError;
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateNews(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Crear titulo para la novedad
	 * 
	 * @param String
	 */
	public void createTitle(String titleText) {
		title.clear();
		title.sendKeys(titleText);
	}
	
	/**
	 * Crear descripción para la novedad
	 * 
	 * @param String
	 */
	public void createDescription(String descriptionText) {
		driver.switchTo().frame(description);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + descriptionText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 *  Seleccionar el check box Social
	 *  
	 */
	public void selectSocialCheckBox() {
		socialCheckBox.click();
	}
	
	/**
	 *  Seleccionar el botón guardar
	 *  
	 *  @return DetailNews
	 */
	public DetailNews selectSaveBtn() {
		savebtn.click();
		return PageFactory.initElements(driver, DetailNews.class);
	}
	
	/**
	 *  Seleccionar el botón cancelar
	 *  
	 *  @return HomeNews
	 */
	public HomeNews selectCancelBtn() {
		cancelbtn.click();
		return PageFactory.initElements(driver, HomeNews.class);
	}
	
	/**
	 *  Obtener el mensaje de error del titulo
	 *  
	 * @return String
	 */
	public String getTitleError() {
		return titleError.getText();
	}
	
	
	/**
	 *  Obtener el mensaje de error de la descripción
	 *  
	 * @return String
	 */
	public String getDescriptionError() {
		return descriptionError.getText();
	}
	
	/**
	 *  Obtener el mensaje de error de guardar
	 *  
	 * @return String
	 */
	public String getSaveError() {
		return saveError.getText();
	}
	
	/**
	 *  Obtener el mensaje de error del datePicker
	 *  
	 * @return String
	 */
	public String getDateError() {
		return dateError.getText();
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param String
	 */
	public void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('publicationDate').value='"+date+"'");
	}
	
	/**
	 * Crear la hora para la novedad
	 * 
	 * @param String
	 */
	public void createHour(String hourText) {
		hour.clear();
		hour.sendKeys(hourText);
	}
	
	/**
	 * Ingresar una imagen miniatura
	 * 
	 * @param fileupload
	 */
	public void fileUpload(String fileupload) {
		AttachmentUploads.SocialWallAttachment(driver);
		attachmentUpload.sendKeys(fileupload);
		AttachmentUploads.waitBar(driver);
	}
	
	
}
