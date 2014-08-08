package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class PlatformDetail extends PageBase{
	
	/**
	 * Si son un asco pero lo necesito para el assert de la creacion y hasta que lo arreglen...
	 */
	
	@FindBy(className = "icon-edit")
	private WebElement linkEditar;
	
	@FindBy(xpath = "//div[@id='account']/div[2]/a")
	private WebElement account;
	
	@FindBy(xpath = "//div[@id='name']/div[2]")
	private WebElement platformname;
	
	@FindBy(xpath = "//div[@id='image-max-size']/div[2]")
	private WebElement imagemaxsize;
	
	@FindBy(xpath = "//div[@id='content']/div[6]/div[2]/a")
	private WebElement website;
	
	@FindBy(xpath = "//div[@id='content']/div[7]/div[2]")
	private WebElement storage;
	
	@FindBy(xpath = "//div[@id='content']/div[8]/div[2]")
	private WebElement industry;
	
	@FindBy(xpath = "//div[@id='content']/div[9]/div[2]")
	private WebElement usersRange;
	
	@FindBy(xpath = "//div[@id='content']/div[10]/div[2]")
	private WebElement mobileactivationcode;
	
	@FindBy(xpath = "//div[@id='content']/div[12]/div[2]")
	private WebElement timezone;
	
	@FindBy(xpath = "//div[@id='content']/div[13]/div/span")
	private WebElement disableplatform;
	
	@FindBy(xpath = "//div[@id='content']/div[14]/div/span")
	private WebElement userVisibility;
	
	@FindBy(xpath = "//div[@id='content']/div[15]/div/span")
	private WebElement socialEnabled;
	
	@FindBy(xpath = "//div[@id='content']/div[16]/div[2]")
	private WebElement googleanalytics;
	
	@FindBy(xpath = "//div[@id='content']/div[17]/div/span")
	private WebElement defaultrole;
	
	@FindBy(xpath = "//div[@id='content']/div[18]/div/span")
	private WebElement defaultlang;
	
	@FindBy(xpath = "//div[@id='content']/div[19]/div/span")
	private WebElement benefitsenabled;
	
	@FindBy(xpath = "//div[@id='content']/div[20]/div/span")
	private WebElement userstype;
	
	@FindBy(xpath = "//div[@id='login-type']/div[2]")
	private WebElement logintype;
	
	@FindBy(xpath = "//div[@id='user-field']/div[2]")
	private WebElement userfield;
	
	@FindBy(xpath = "//div[@id='recover-password']/div[2]/span")
	private WebElement recoverpassword;
	
	@FindBy(xpath = "//div[@id='content']/div[25]/div/span")
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
	
	@FindBy(xpath = "//div[@id='content']/div[32]/div[2]/span")
	private WebElement uniquefield;
	
	@FindBy(xpath = "//div[@id='content']/div[33]/div/span")
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
	
	@FindBy (xpath = "//div[contains(@class,'signin-customisation-html-view')]/div[2]")
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
	 * Seleccionar el link a Editar Plataforma
	 * 
	 * @return {@link EditPlatform}
	 */
	public EditPlatform selectEditar() {
		linkEditar.click();
		
		return PageFactory.initElements(driver, EditPlatform.class);
	}
	
	/**
	 * Obtener el nombre de la cuenta
	 * 
	 * @return String
	 */
	public String getAccountName() {
		return account.getText();
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
	 * Obtener el tamaño maximo de la imagen
	 * 
	 * @return String
	 */
	public String getPlatformImgSize() {
		return imagemaxsize.getText();
	}
	
	/**
	 * Obtener el storage de la plat
	 * 
	 * @return String
	 */
	public String getPlatformStorage() {
		return storage.getText();
	}
	
	/**
	 * Obtener la industria
	 * 
	 * @return String
	 */
	public String getIndustry() {
		return industry.getText();
	}
	
	/**
	 * Obtener el user range
	 * 
	 * @return String
	 */
	public String getUserRange() {
		return usersRange.getText();
	}
	
	/**
	 * Obtener la timezone
	 * 
	 * @return String
	 */
	public String getTimeZone() {
		return timezone.getText();
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
	
	/**
	 * Obtener el Fondo plataforma
	 * 
	 * @return String
	 */
	public String getBackgroundcolor() {
		return backgroundcolor.getText();
	}
	
	/**
	 * Obtener el Fondo header y footer
	 * 
	 * @return String
	 */
	public String getBackgroundheaderfooter() {
		return backgroundheaderfooter.getText();
	}
	
	/**
	 * Obtener el Texto header y footer
	 * 
	 * @return String
	 */
	public String getTextheaderfooter() {
		return textheaderfooter.getText();
	}
	
	/**
	 * Obtener el Texto botones
	 * 
	 * @return String
	 */
	public String getTextbtn() {
		return textbtn.getText();
	}
	
	/**
	 * Obtener el Fondo botones
	 * 
	 * @return String
	 */
	public String getBackgroundbtn() {
		return backgroundbtn.getText();
	}
	
	/**
	 * Obtener el Borde header y footer 
	 * 
	 * @return String
	 */
	public String getBorderheaderfooter() {
		return borderheaderfooter.getText();
	}
	
	/**
	 * Obtener el Íconos home
	 * 
	 * @return String
	 */
	public String getColoricon() {
		return coloricon.getText();
	}
	
	/**
	 * Obtener el Registración usuario
	 * 
	 * @return String
	 */
	public String getRegistration() {
		return registration.getText();
	}
	
	/**
	 * Obtener el Texto de registro
	 * 
	 * @return String
	 */
	public String getHtmlSignUp() {
		return useshtmlSignUp.getText();
	}
	
	/**
	 * Obtener el Usa tarjeta
	 * 
	 * @return String
	 */
	public String getUsesCard() {
		return usescard.getText();
	}
	
	/**
	 * Obtener el caso de que use tarjeta nominada
	 * 
	 * @return String
	 */
	public String getNominated() {
		return cardtype.getText();
	}
	
	/**
	 * Obtener el caso de que necesite fecha de nacimiento
	 * 
	 * @return String
	 */
	public String getBirthdate() {
		return usesBirthdate.getText();
	}
	
	/**
	 * Obtener si usa o no genero
	 * 
	 * @return String
	 */
	public String getGender() {
		return usesgender.getText();
	}
	
	/**
	 * Obtener el tipo de login
	 * 
	 * @return String
	 */
	public String getUserField() {
		return userfield.getText();
	}
	
	public String getSrcPrincipalLogo() {
		return principallogo.getAttribute("src");
	}
	
	public String getSrcSecondaryLogo() {
		return secondarylogo.getAttribute("src");
	}
	
	public String getSrcBannerLogin() {
		return bannerlogin.getAttribute("src");
	}

}
