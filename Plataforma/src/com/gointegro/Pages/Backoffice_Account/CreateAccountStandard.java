package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Backoffice.AccountOverlay;
import com.gointegro.Pages.Base.PageBase;

public class CreateAccountStandard extends PageBase{
	
	@FindBy (name = "name")
	private WebElement name;
	
	@FindBy (name = "salesforceId")
	private WebElement salesforceId;
	
	@FindBy (xpath = "//div[@class='selection-list-container']/button")
	private WebElement searchAccount;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//div[@class='form-buttons']/button[2]")
	private WebElement cancelBtn;
	
	/**
	 * Mensajes de error
	 */
	
	@FindBy (xpath = "//div[contains(@class,'field-name')]/div/div")
	protected WebElement nameError;
	
	@FindBy (xpath = "//div[contains(@class,'field-salesforceId')]/div/div")
	protected WebElement salesforceIdError;
	
	@FindBy (xpath = "//div[@id='error-message']/p")
	protected WebElement errorMsj;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CreateAccountStandard(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar el nombre de la cuenta
	 * 
	 * @param accountname
	 */
	private void completeName(String accountname) {
		name.clear();
		name.sendKeys(accountname);
	}
	
	/**
	 * Completar el salesforceid
	 * 
	 * @param salesforce
	 */
	private void completeSaleforceId(String salesforce) {
		salesforceId.clear();
		salesforceId.sendKeys(salesforce);
	}
	
	/**
	 * Seleccionar cuenta principal overlay
	 * 
	 * @return
	 */
	public AccountOverlay selectDependentAccounts() {
		searchAccount.click();
		
		return PageFactory.initElements(driver, AccountOverlay.class);
	}
	
	/**
	 * Completar nombre y saleforce id
	 * 
	 * @param accountname
	 * @param salesforce
	 */
	public void completeAccount(String accountname, String salesforce) {
		completeName(accountname);
		completeSaleforceId(salesforce);
	}
	
	/**
	 * Seleccionar guardar
	 */
	public AccountDetail selectSave() {
		saveBtn.click();
		
		return PageFactory.initElements(driver, AccountDetail.class);
	}
	
	/**
	 * Seleccionar cancelar
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
	 * Obtener el mensaje de error del campo salesforce id
	 * 
	 * @return String
	 */
	public String getSalesForceIdError() {
		return salesforceIdError.getText();
	}
	
	/**
	 * Obtener el mensaje de error del top del form
	 * 
	 * @return String
	 */
	public String getErrorMsj() {
		return errorMsj.getText();
	}

}
