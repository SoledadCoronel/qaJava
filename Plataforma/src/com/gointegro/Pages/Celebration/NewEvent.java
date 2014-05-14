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
	protected WebElement collaborators;
	
	@FindBy (id = "title")
	protected WebElement title;
	
	@FindBy (id = "description")
	protected WebElement description;
	
	@FindBy (id = "accept")
	protected WebElement savebtn;
	
	@FindBy (id = "cancel")
	protected WebElement cancelbtn;
	
	@FindBy (id = "form-category-new")
	protected WebElement newcategory;
	
	@FindBy (id = "categories")
	protected WebElement categories;
	
	@FindBy (id = "date")
	protected WebElement date;
	
	@FindBy (xpath = "//div[@class='collaborators']//div[@class='error']/div/div")
	protected WebElement collaboratoserrormsj;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	protected WebElement saveerror;
	
	@FindBy (xpath = "//span[@class='title']//div[@class='error']/div/div")
	protected WebElement titleerror;
	
	@FindBy (xpath = "//span[@class='description']//div[@class='error']/div/div")
	protected WebElement descriptionerror;
	
	@FindBy (xpath = "//span[@class='categories']//div[@class='error']/div/div")
	protected WebElement categorieserrormsj;
	
	@FindBy (xpath = "//span[@class='date']//div[@class='error']/div/div")
	protected WebElement dateerrormsj;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']/div/span")
	protected WebElement textlabel;
	
	@FindBy (xpath = "//div[@id='collaborators']//div[@class='text-list']")
	protected WebElement textlist;
	
	@FindBy (id = "attachmentUpload")
	protected WebElement attachementupload;
	

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
	protected void selectCategory(String categoryname) {
		new Select(categories).selectByVisibleText(categoryname);
	}
	
	/**
	 * Completar la fecha
	 * 
	 * @param date
	 */
	protected void selectDate(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('date').value='"+date+"'");
	}
	
	/**
	 * Completar el titulo
	 * 
	 * @param titletext
	 */
	protected void completeTitle (String titletext) {
		title.clear();
		title.sendKeys(titletext);
	}
	
	/**
	 * Completar la descripcion
	 * 
	 * @param descriptiontext
	 */
	protected void completeDescription (String descriptiontext) {
		description.clear();
		description.sendKeys(descriptiontext);
	}
	
	/**
	 * Completar el colaborador
	 * 
	 * @param collaboratorname
	 */
	protected void completeCollaborator (String collaboratorname) {
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
	protected void selectColaboratorList(String collaboratorname) {
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
	 * Cancelar la creacion de un evento
	 */
	public HomeCelebrations cancelCreation() {
		cancelbtn.click();
		return PageFactory.initElements(driver, HomeCelebrations.class);
	}

}
