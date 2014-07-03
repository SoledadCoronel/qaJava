package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class AccountDetail extends PageBase{
	
	@FindBy(className = "icon-edit")
	private WebElement linkEditar;
	
	@FindBy(xpath = "//div[@id='account']/span/div[2]/span")
	private WebElement name;
	
	@FindBy(xpath = "//div[@id='account']/span/div[4]/span")
	private WebElement website;
	
	@FindBy(xpath = "//div[@id='account']/span/div[6]/span")
	private WebElement salesforceId;
	
	@FindBy(xpath = "//div[@id='account']/span/div[8]/span")
	private WebElement regional;

	@FindBy(xpath = "//div[@id='account']/span/div[10]/span")
	private WebElement registration;
	
	@FindBy(xpath = "//div[@id='login-type']/div[2]/span")
	private WebElement logintype;
	
	@FindBy(xpath = "//div[@id='user-field']/div[2]/span")
	private WebElement userfield;
	
	@FindBy(xpath = "//div[@id='recover-password']/div[2]/span")
	private WebElement recoverpassword;
	
	@FindBy(xpath = "//div[@id='verif-field-1']/div[2]/span")
	private WebElement veriffield1;
	
	@FindBy(xpath = "//div[@id='verif-field-2']/div[2]/span")
	private WebElement veriffield2;
	
	@FindBy(xpath = "//div[@id='content']/div[11]/span/div[2]/span")
	private WebElement uniqueField;
	
	@FindBy(id = "showUserEmail")
	private WebElement showUserEmail;
	
	@FindBy(xpath = "//div[@id='content']/div[16]/span/div[2]/span")
	private WebElement backgroundcolor;
	
	@FindBy(xpath = "//div[@id='content']/div[17]/span/div[2]/span")
	private WebElement backgroundcolorheader;
	
	@FindBy(xpath = "//div[@id='content']/div[18]/span/div[2]/span")
	private WebElement textcolorheader;
	
	@FindBy(xpath = "//div[@id='content']/div[19]/span/div[2]/span")
	private WebElement textcolorbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[20]/span/div[2]/span")
	private WebElement backgroundcolorbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[21]/span/div[2]/span")
	private WebElement colorlineheader;
	
	@FindBy(xpath = "//div[@id='content']/div[22]/span/div[2]/span")
	private WebElement iconcolor;
	
	@FindBy(xpath = "//div[@id='content']/div[23]/span/div[2]/span")
	private WebElement defaultlang;
	
	@FindBy(xpath = "//div[@id='content']/div[24]/span/div[2]")
	private WebElement htmllogin;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AccountDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el nombre de la plataforma
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Obtener el website
	 * 
	 * @return String
	 */
	public String getWebSite() {
		return website.getText();
	}
	
	/**
	 * Obtener el salesforce Id
	 * 
	 * @return String
	 */
	public String getSalesForceId() {
		return salesforceId.getText();
	}
	
	/**
	 * Obtener si es regional
	 * 
	 * @return String
	 */
	public String getRegional() {
		return regional.getText();
	}
	
	/**
	 * Obtener el label registracion
	 * 
	 * @return String
	 */
	public String getRegistration() {
		return registration.getText();
	}

}
