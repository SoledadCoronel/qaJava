package com.gointegro.Pages.Content;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsContent;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class NewContent extends PageBase {

	@FindBy(id = "title_ifr")
	WebElement title;
	
	@FindBy(id = "content_ifr")
	WebElement description;
	
	@FindBy(xpath = "//*[@class='mce-content-body ']/p")
	WebElement descriptionText;
	
	@FindBy(xpath = "//*[@class='mce-content-body ']/p")
	WebElement titleText;
	
	@FindBy(id = "accept")
	WebElement savebtn;
	
	@FindBy(id = "cancel")
	WebElement cancelbtn;
	
	@FindBy(id = "category-new")
	WebElement newCategory;
	
	@FindBy (id = "category")
	WebElement categories;
	
	@FindBy(id = "title-error")
	WebElement titleError;
	
	@FindBy(id = "content-error")
	WebElement descriptionError;
	
	@FindBy(id = "category")
	WebElement categorySelect;
	
	@FindBy(id = "bellowArticle")
	WebElement bellowArticle;
	
	@FindBy(xpath = "//div[@id='mce_24']/button")
	WebElement tinyLink;
	
	private String NewContentURL = ConfigElements.getURL()+"/app/articles/" + ConfigElementsContent.getIdAppContent() + "/create";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewContent(WebDriver driver) {
		super(driver);
		URL = NewContentURL;
	}
	
	public String getURL() {
		return NewContentURL;
	}
	/**
	 * Crear titulo para el contenido
	 * 
	 * @param String
	 */
	public void createTitle(String titleText) {
		driver.switchTo().frame(title);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + titleText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Devuelve la descripción del titulo
	 * 
	 * @param String
	 */
	public String getTitleText() {
		driver.switchTo().frame(title);
		String text = titleText.getText();
		
		driver.switchTo().defaultContent();
		return text;
	}
	
	
	/**
	 * Crear descripción para el contenido
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
	 * Crear descripción para el contenido con imagen
	 * 
	 * @param String
	 */
	public void createDescriptionWithPic(String imageFile) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" document.getElementById('mce_26').style.visibility = 'visible'");
		
		driver.findElement(By.xpath("//div[@id='mce_25']/button")).click();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='mce-container-body mce-abs-layout']/iframe")));
		
		driver.findElement(By.xpath("//p[@id='upload_form_container']/input")).sendKeys(imageFile);
		
		Sleeper.sleepTightInSeconds(10);
		WaitTool.waitForJQueryProcessing(driver, 10);	
	}
	
	/**
	 * Crear descripción para el contenido con link
	 * 
	 * @param String
	 */
	public void createDescriptionWithURL(String url) {
		tinyLink.click();
		WaitTool.waitForJQueryProcessing(driver, 10);

		driver.findElement(By.xpath("//input[@class='mce-textbox mce-placeholder']")).sendKeys(url);
		WaitTool.waitForJQueryProcessing(driver, 5);
	
		driver.findElement(By.xpath("//div[@class='mce-container mce-panel mce-foot']/div/div[2]/button")).click();
	}
	
	
	/**
	 * Devuelve la descripción del contenido
	 * 
	 * @param String
	 */
	public String getDescription() {
		driver.switchTo().frame(description);
		String text = descriptionText.getText();
		
		driver.switchTo().defaultContent();
		return text;
	}
	
	
	/**
	 * Seleccionar nueva categoria
	 * 
	 * @return NewCategoryOverlay
	 */
	public NewCategoryOvelayContent selectNewCategory() {
		newCategory.click();
		return PageFactory.initElements(driver, NewCategoryOvelayContent.class);
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
	 *  Seleccionar el botón guardar
	 *  
	 *  @return HomeContent
	 */
	public HomeContent selectSaveBtn() {
		savebtn.click();
		return PageFactory.initElements(driver, HomeContent.class);
	}
	
	/**
	 *  Seleccionar el botón cancelar
	 *  
	 *  @return HomeContent
	 */
	public HomeContent selectCancelBtn() {
		cancelbtn.click();
		return PageFactory.initElements(driver, HomeContent.class);
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
	 *  Obtener el mensaje de error de descripción
	 *  
	 * @return String
	 */
	public String getDescriptionError() {
		return descriptionError.getText();
	}
	
	
	/**
	 * Verifica si el elemento es visible 
	 * 
	 * @return boolean
	 */
	public boolean isTitleErrorPresent() {
		return titleError.isDisplayed();
	}
	
	
	/**
	 * Verifica si el elemento es visible 
	 * 
	 * @return boolean
	 */
	public boolean isDescriptionErrorPresent() {
		return descriptionError.isDisplayed();
	}
	
	/**
	 *  Seccionar la categoria 
	 *  
	 * @param String
	 */
	public void setCategory(String categoryName) {
		new Select(categorySelect).selectByVisibleText(categoryName);
	}
	
	/**
	 *  Devulve si la categoria esta en la lista
	 *  
	 * @param Boolean
	 */
	public Boolean isCategoryOnList(String categoryName) {
		Boolean isOnList = new Select(categorySelect).getOptions().contains(categoryName);
		return isOnList;
	}
	
	/**
	 *  Cambiar el orden del contido 
	 *  
	 * @param String
	 */
	public void setContentBellowOf(String contentTitle) {
		new Select(bellowArticle).selectByVisibleText(contentTitle);
	}
}
