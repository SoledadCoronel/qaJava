package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Base.PageBase;

public class CreateAccountRegional extends PageBase{
	
	@FindBy (name = "name")
	protected WebElement name;
	
	@FindBy (name = "webSite")
	protected WebElement website;
	
	@FindBy (xpath = "//div[@class='selection-list-container']/button")
	protected WebElement searchAccount;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button")
	protected WebElement saveBtn;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button[2]")
	protected WebElement cancelBtn;
	
	@FindBy (id = "c2_htmlLogin_ifr")
	protected WebElement htmlLogin;
	
	/**
	 * Mensajes de error
	 */
	
	@FindBy (xpath = "//div[contains(@class,'field-name')]/div/div")
	protected WebElement nameError;
	
	@FindBy (xpath = "//div[contains(@class,'field-webSite')]/div/div")
	protected WebElement webSiteError;
	
	@FindBy (xpath = "//div[@id='error-message']/p")
	protected WebElement errorMsj;
	

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateAccountRegional(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar el nombre de la cuenta
	 * 
	 * @param accountname
	 */
	protected void completeName(String accountname) {
		name.clear();
		name.sendKeys(accountname);
	}
	
	/**
	 * Completar el webSite
	 * 
	 * @param web
	 */
	protected void completeWebSite(String web) {
		website.clear();
		website.sendKeys(web);
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
	 * Select search account
	 * 
	 * @return {@link AccountOverlay}
	 */
	public AccountOverlay selectDependentAccounts() {
		searchAccount.click();
		
		return PageFactory.initElements(driver, AccountOverlay.class);
	}
	
	public void completeBasicInfo(String accountname, String web, String htmllog) {
		completeName(accountname);
		completeWebSite(web);
		setHtmlLogin(htmllog);
	}
	
	/**
	 * Select save btn
	 * 
	 * @return {@link AccountDetail}
	 */
	public AccountDetail selectSave() {
		saveBtn.click();
		
		return PageFactory.initElements(driver, AccountDetail.class);
	}
	
	/**
	 * Select cancel btn
	 */
	public void selectCancel() {
		cancelBtn.click();
	}
	
	/**
	 * Obtener el mensaje de error del nombre
	 * 
	 * @return String
	 */
	public String getNameError() {
		return nameError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del website
	 * 
	 * @return String
	 */
	public String getWebSiteError() {
		return webSiteError.getText();
	}
	
	/**
	 * Obtener el mensaje de error superior
	 * 
	 * @return String
	 */
	public String getErrorMsj() {
		return errorMsj.getText();
	}

}
