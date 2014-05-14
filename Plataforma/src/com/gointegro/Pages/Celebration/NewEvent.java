package com.gointegro.Pages.Celebration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

/**
 * PO. Nueva celebracion
 * 
 * @author gustavomoreira
 *
 */
public class NewEvent extends PageBase{
	
	@FindBy (id = "collaborators-container-input")
	private WebElement collaborators;
	
	@FindBy (id = "title")
	private WebElement title;
	
	@FindBy (id = "description")
	private WebElement description;
	
	@FindBy (id = "accept")
	private WebElement savebtn;
	
	@FindBy (id = "cancel")
	private WebElement cancelbtn;
	
	@FindBy (id = "form-category-new")
	private WebElement newcategory;
	
	@FindBy (id = "categories")
	private WebElement categories;
	
	@FindBy (id = "date")
	private WebElement date;
	
	@FindBy (xpath = "//div[@class='collaborators']//div[@class='error']/div/div")
	private WebElement collaboratoserrormsj;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	private WebElement saveerror;
	
	@FindBy (xpath = "//span[@class='title']//div[@class='error']/div/div")
	private WebElement titleerror;
	
	@FindBy (xpath = "//span[@class='description']//div[@class='error']/div/div")
	private WebElement descriptionerror;
	
	@FindBy (xpath = "//span[@class='categories']//div[@class='error']/div/div")
	private WebElement categorieserrormsj;
	
	@FindBy (xpath = "//span[@class='date']//div[@class='error']/div/div")
	private WebElement dateerrormsj;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']/div/span")
	private WebElement textlabel;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']")
	private WebElement textlist;
	
	@FindBy (id = "attachmentUpload")
	private WebElement attachementupload;
	
	@FindBy (xpath = "//div[@id='content-container']/span/div[2]/form/div/div/span[3]/span/div")
	private WebElement attachmenterror;
	

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewEvent(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar la categoria
	 * 
	 * @param categoryname
	 */
	private void selectCategory(String categoryname) {
		new Select(categories).selectByVisibleText(categoryname);
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param date
	 */
	private void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('date').value='"+date+"'");
	}
	
	/**
	 * Completar el titulo
	 * 
	 * @param titletext
	 */
	private void completeTitle (String titletext) {
		title.clear();
		title.sendKeys(titletext);
	}
	
	/**
	 * Completar la descripcion
	 * 
	 * @param descriptiontext
	 */
	private void completeDescription (String descriptiontext) {
		description.clear();
		description.sendKeys(descriptiontext);
	}
	
	/**
	 * Completar el colaborador
	 * 
	 * @param collaboratorname
	 */
	private void completeCollaborator (String collaboratorname) {
		collaborators.clear();
		collaborators.sendKeys(collaboratorname); 
		WaitTool.waitForJQueryProcessing(driver, 5);
		selectColaboratorList(collaboratorname);
	}
	
	/**
	 * Seleccionar un colaborador
	 * 
	 * @param collaboratorname
	 */
	private void selectColaboratorList(String collaboratorname) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElement(textlist, collaboratorname));		
		textlabel.click();
	}
	
	
	/**
	 * Seleccionar nueva categoria
	 * 
	 * @return NewCategoryOverlay
	 */
	public NewCategoryOverlay selectNewCategory() {
		newcategory.click();
		return PageFactory.initElements(driver, NewCategoryOverlay.class);
	}
	
	/**
	 * Buscar categoria presente
	 * 
	 * @return String
	 */
	public String getCategoryPresent() {
		return categories.getText();
	}
	
	/**
	 * Crear nueva celebracion
	 * 
	 * @param categoryname
	 * @param date
	 * @param titletext
	 * @param descriptiontext
	 * @param collaboratorname
	 * @return HomeCelebrations
	 */
	public HomeCelebrations completeCelebration (String categoryname, String date, String titletext, String descriptiontext, String collaboratorname) {
		if (!collaboratorname.isEmpty())
		completeCollaborator(collaboratorname);
		completeTitle(titletext);
		completeDescription(descriptiontext);
		selectCategory(categoryname);
		selectDate(date);
		savebtn.click();
		
		return PageFactory.initElements(driver, HomeCelebrations.class);
	}
	
	/**
	 * Obtener el mensaje de error al no poner una fecha
	 * 
	 * @return String
	 */
	public String getDateErrorMsj() {
		return dateerrormsj.getText();
	}
	
	/**
	 * Obtener el mensaje al dejar vacio titulo y colaborador
	 * 
	 * @return String
	 */
	public String getCollaboratorsError() {
		return collaboratoserrormsj.getText();
	}
	
	/**
	 * Obtener el mensaje de error debajo del title del form
	 * 
	 * @return String
	 */
	public String getSaveError() {
		return saveerror.getText();
	}
	
	/**
	 * Obtener el mensaje de error del titulo
	 * 
	 * @return String
	 */
	public String getTitleError() {
		return titleerror.getText();
	}
	
	/**
	 * Obtener el mensaje de error de la descripcion
	 * 
	 * @return String
	 */
	public String getDescriptionError() {
		return descriptionerror.getText();
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
	 * Obtener el mensaje de error del input de archivos
	 * 
	 * @return
	 */
	public String getAttachmentUploadError() {
		return attachmenterror.getText();
	}

}
