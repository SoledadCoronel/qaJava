package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class PlatformDetail extends PageBase{
	
	/**
	 * Si son un asco pero lo necesito para el assert de la creacion y hasta que lo arreglen...
	 */
	
	@FindBy(xpath = "//div[@id='account']/div[2]/a")
	private WebElement account;
	
	@FindBy(xpath = "//div[@id='name']/div[2]")
	private WebElement platformname;
	
	@FindBy(xpath = "//div[@id=image-max-size]/div[2]")
	private WebElement imagemaxsize;
	
	@FindBy(xpath = "//div[@id='content']/div[6]/div[2]/a")
	private WebElement website;
	
	@FindBy(xpath = "//div[@id='content']/div[7]/div")
	private WebElement storage;
	
	@FindBy(xpath = "//div[@id='content']/div[8]/div")
	private WebElement industry;
	
	@FindBy(xpath = "//div[@id='content']/div[9]/div")
	private WebElement usersRange;
	
	@FindBy(xpath = "//div[@id='content']/div[10]/div")
	private WebElement mobileactivationcode;
	
	@FindBy(xpath = "//div[@id='content']/div[11]/div")
	private WebElement timezone;
	
	@FindBy(xpath = "//div[@id='content']/div[12]/div/span")
	private WebElement disableplatform;
	
	@FindBy(xpath = "//div[@id='content']/div[13]/div/span")
	private WebElement userVisibility;
	
	@FindBy(xpath = "//div[@id='content']/div[14]/div/span")
	private WebElement socialEnabled;
	
	@FindBy(xpath = "//div[@id='content']/div[15]/div[2]")
	private WebElement googleanalytics;
	
	@FindBy(xpath = "//div[@id='content']/div[16]/div/span")
	private WebElement defaultrole;
	
	@FindBy(xpath = "//div[@id='content']/div[17]/div/span")
	private WebElement defaultlang;
	
	@FindBy(xpath = "//div[@id='content']/div[18]/div/span")
	private WebElement benefitsenabled;
	
	@FindBy(xpath = "//div[@id='content']/div[19]/div/span")
	private WebElement userstype;
	
	@FindBy(xpath = "//div[@id='login-type']/div[2]")
	private WebElement logintype;
	
	@FindBy(xpath = "//div[@id='user-field']/div[2]")
	private WebElement userfield;
	
	@FindBy(xpath = "//div[@id='recover-password']/div[2]/span")
	private WebElement recoverpassword;
	
	@FindBy(xpath = "//div[@id='content']/div[24]/div/span")
	private WebElement registration;
	
	@FindBy(xpath = "//div[@id='uses-htmlSignUp']/div[2]/p")
	private WebElement useshtmlSignUp;
	
	@FindBy(xpath = "//div[@id='uses-birthdate']/div[2]/span")
	private WebElement usesBirthdate;
	
	@FindBy(xpath = "//div[@id='uses-card']/div[2]/span")
	private WebElement usescard;
	
	@FindBy(xpath = "//div[@id='card-type']/div[2]")
	private WebElement cardtype;
	
	@FindBy(xpath = "//div[@id='uses-gender']/div[2]/span")
	private WebElement usesgender;
	
	@FindBy(xpath = "//div[@id='content']/div[30]/div")
	private WebElement verification;
	
	@FindBy(xpath = "//div[@id='content']/div[31]/div/span")
	private WebElement uniquefield;
	
	@FindBy(xpath = "//div[@id='content']/div[32]/div/span")
	private WebElement showusersmail;
	
	@FindBy(xpath = "//div[@id='principal-logo']/div[2]/img")
	private WebElement principallogo;
	
	@FindBy(xpath = "//div[@id='secondary-logo']/div[2]/img")
	private WebElement secondarylogo;
	
	@FindBy(xpath = "//div[@id='banner-login']/div[2]/img")
	private WebElement bannerlogin;
	
	@FindBy(xpath = "//div[@id='content']/div[37]/div[2]")
	private WebElement backgroundcolor;
	
	@FindBy(xpath = "//div[@id='content']/div[38]/div[2]")
	private WebElement backgroundheaderfooter;
	
	@FindBy(xpath = "//div[@id='content']/div[39]/div[2]")
	private WebElement textheaderfooter;
	
	@FindBy(xpath = "//div[@id='content']/div[40]/div[2]")
	private WebElement textbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[41]/div[2]")
	private WebElement backgroundbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[42]/div[2]")
	private WebElement borderheaderfooter;
	
	@FindBy(xpath = "//div[@id='content']/div[43]/div[2]")
	private WebElement coloricon;
	
	@FindBy (xpath = "//div[contains(@class,'signin-customisation-html-view')]/div[2]/p")
	protected WebElement htmlsignin;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlatformDetail(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/"+ConfigElementsBO.getPlatformId()
				+"/view";
	}
	
	/**
	 * Obtener el nombre de la plataforma
	 * 
	 * @return String
	 */
	public String getPlatformName() {
		return platformname.getText();
	}
	
	/**
	 * Obtener el website de la plataforma
	 * 
	 * @return String
	 */
	public String getPlatformWebSite() {
		return website.getText();
	}
	
	/**
	 * Obtener el estado de la plataforma
	 * 
	 * @return String
	 */
	public String getDisablePlatform() {
		return disableplatform.getText();
	}
	
	/**
	 * Obtener la visibilidad entre usuarios
	 * 
	 * @return String
	 */
	public String getUserVisibility() {
		return userVisibility.getText();
	}
	
	/**
	 * Obtener el codigo de google analytics
	 * 
	 * @return String
	 */
	public String getGoogleCode() {
		return googleanalytics.getText();
	}
	
	/**
	 * Obtener el estado de social
	 * 
	 * @return String
	 */
	public String getSocialStatus() {
		return socialEnabled.getText();
	}
	
	/**
	 * Obtener el HTML Inicio de Sesión
	 * 
	 * @return String
	 */
	public String getHtmlLogin() {
		return htmlsignin.getText();
	}
	
	/**
	 * Obtener el campo unico de la plataforma
	 * 
	 * @return String
	 */
	public String getUniqueField() {
		return uniquefield.getText();
	}
	
	/**
	 * Obtener el estado de Mostrar mail del usuario
	 * 
	 * @return String
	 */
	public String getShowUserMail() {
		return showusersmail.getText();
	}
	
	public String getBackgroundcolor() {
		return backgroundcolor.getText();
	}
	
	public String getBackgroundheaderfooter() {
		return backgroundheaderfooter.getText();
	}
	
	public String getTextheaderfooter() {
		return textheaderfooter.getText();
	}
	
	public String getTextbtn() {
		return textbtn.getText();
	}
	
	public String getBackgroundbtn() {
		return backgroundbtn.getText();
	}
	
	public String getBorderheaderfooter() {
		return borderheaderfooter.getText();
	}
	
	public String getColoricon() {
		return coloricon.getText();
	}

}
