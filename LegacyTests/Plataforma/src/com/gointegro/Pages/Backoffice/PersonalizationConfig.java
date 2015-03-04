package com.gointegro.Pages.Backoffice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;

public class PersonalizationConfig  extends PageBase{
	
	@FindBy (name = "uniqueField")
	private WebElement uniqueField;
	
	@FindBy (name = "file-logoUrl")
	private WebElement filelogoUrl;
	
	@FindBy (name = "file-logoUrlFooter")
	private WebElement filelogoUrlFooter;
	
	@FindBy (name = "file-signinBannerUrl")
	private WebElement filesigninBannerUrl;
	
	@FindBy (name = "showUserEmail")
	private WebElement showUserEmail;
	
	@FindBy (name = "defaultBackgroundColor")
	private WebElement defaultBackgroundColor;
	
	@FindBy (name = "defaultBgColorHeaderFooter")
	private WebElement defaultBgColorHeaderFooter;
	
	@FindBy (name = "defaultFontColor")
	private WebElement defaultFontColor;
	
	@FindBy (name = "buttonFontColor")
	private WebElement buttonFontColor;
	
	@FindBy (name = "buttonBackgroundColor")
	private WebElement buttonBackgroundColor;
	
	@FindBy (name = "defaultBorderColor")
	private WebElement defaultBorderColor;
	
	@FindBy (name = "iconsColor")
	private WebElement iconsColor;
	
	@FindBy (name = "defaultLanguage")
	private WebElement defaultLanguage;
	
	@FindBy (name = "benefitHeaderTitle")
	private WebElement benefitHeaderTitle;
	
	/**
	 * Mensajes de error
	 */
	
	@FindBy (xpath = "//div[contains(@class,'field-logoUrl')]/div/div")
	protected WebElement errorlogoUrl;
	
	@FindBy (xpath = "//div[contains(@class,'field-logoUrlFooter')]/div/div")
	protected WebElement errorUrlFooter;
	
	@FindBy (xpath = "//div[contains(@class,'field-signinBannerUrl')]/div/div")
	protected WebElement errorSigninBannerUrl;
	
	@FindBy (xpath = "//div[contains(@class,'field-defaultBackgroundColor')]/div/div")
	protected WebElement errordefaultBackgroundColor;
	
	@FindBy (xpath = "//div[contains(@class,'field-defaultBgColorHeaderFooter')]/div/div")
	protected WebElement errordefaultBgColorHeaderFooter;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PersonalizationConfig(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar el campo unico
	 * 
	 * @param unique
	 */
	private void selectUniqueField(String unique) {
		Select select = new Select(uniqueField);
		select.selectByVisibleText(unique);
	}
	
	/**
	 * Completar el Logo principal
	 * 
	 * @param logo
	 */
	private void setLogoUrl(String logo) {
		filelogoUrl.sendKeys(logo);
	}
	
	/**
	 * Completar el logo del footer
	 * 
	 * @param footer
	 */
	private void setLogoFooter(String footer) {
		filelogoUrlFooter.sendKeys(footer);
	}
	
	/**
	 * Completar el signin banner
	 * 
	 * @param banner
	 */
	private void setSignInBanner(String banner) {
		filesigninBannerUrl.sendKeys(banner);
	}
	
	/**
	 * Completar el mostrar email
	 * 
	 * @param showmail
	 */
	private void setShowMail(boolean showmail) {
		if (showmail && showUserEmail.getAttribute("checked") == null)
			showUserEmail.click();
		else if (!showmail && showUserEmail.getAttribute("checked") != null)
			showUserEmail.click();
	}
	
	/**
	 * Completar el fondo plataforma
	 * 
	 * @param backgroundcolor
	 */
	private void setDefaulBackgroundColor(String backgroundcolor) {
		defaultBackgroundColor.clear();
		defaultBackgroundColor.sendKeys(backgroundcolor);
	}
	
	/**
	 * Completar el fondo header y footer
	 * 
	 * @param backgroundheader
	 */
	private void setDefaultBgColorHeaderFooter(String backgroundheader) {
		defaultBgColorHeaderFooter.clear();
		defaultBgColorHeaderFooter.sendKeys(backgroundheader);
	}
	
	/**
	 * Completar el texto header y footer
	 * 
	 * @param fontcolor
	 */
	private void setDefaultFontColor(String fontcolor) {
		defaultFontColor.clear();
		defaultFontColor.sendKeys(fontcolor);
	}
	
	/**
	 * Completar el Texto botones
	 * 
	 * @param buttontextcolor
	 */
	private void setButtonFontColor(String buttontextcolor) {
		buttonFontColor.clear();
		buttonFontColor.sendKeys(buttontextcolor);
	}
	
	/**
	 * Completar el fondo de los botones
	 * 
	 * @param btnbackground
	 */
	private void setButtonBackgroundColor(String btnbackground) {
		buttonBackgroundColor.clear();
		buttonBackgroundColor.sendKeys(btnbackground);
	}
	
	/**
	 * Completar border header y footer
	 * 
	 * @param border
	 */
	private void setDefaultBorderColor(String border) {
		defaultBorderColor.clear();
		defaultBorderColor.sendKeys(border);
	}
	
	private void setIconsColor(String iconcolor) {
		Select select = new Select(iconsColor);
		select.selectByVisibleText(iconcolor);
	}
	
	/**
	 * Completar la Configuración de Personalizaciones
	 * 
	 * @param unique
	 * @param logo
	 * @param footer
	 * @param banner
	 * @param showmail
	 * @param backgroundcolor
	 * @param backgroundheader
	 * @param fontcolor
	 * @param buttontextcolor
	 * @param btnbackground
	 * @param border
	 * @param iconcolor
	 */
	public void completePersonalization(String unique, String logo, String footer, String banner, 
			boolean showmail, String backgroundcolor, String backgroundheader, String fontcolor, 
			String buttontextcolor, String btnbackground, String border, String iconcolor) {
		selectUniqueField(unique);
		setLogoUrl(logo);
		setLogoFooter(footer);
		setSignInBanner(banner);
		setShowMail(showmail);
		setDefaulBackgroundColor(backgroundcolor);
		setDefaultBgColorHeaderFooter(backgroundheader);
		setDefaultFontColor(fontcolor);
		setButtonFontColor(buttontextcolor);
		setButtonBackgroundColor(btnbackground);
		setDefaultBorderColor(border);
		setIconsColor(iconcolor);
	}
	
	/**
	 * Obtener el campo unico de la plataforma
	 *  
	 * @return String
	 */
	public String getUniqueField() {
		 JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 String todisable = "document.getElementsByName('uniqueField')[0].removeAttribute('disabled');";
		 javascript.executeScript(todisable);
		 
		 Select select = new Select(uniqueField);
		 return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Obtener el status del uniquefield, tiene que venir false ya que tiene un .isEnabled()
	 * 
	 * @return boolean
	 */
	public boolean getUniqueFieldStatus() {
		return uniqueField.isEnabled();
	}
	
	/**
	 * Obtener el estado del Mostrar mail del usuario
	 * 
	 * @return boolean
	 */
	public boolean getUserMail() {
		return showUserEmail.isSelected();
	}
	
	/**
	 * Seleccionar el idioma predeterminado
	 * 
	 * @param language
	 */
	public void setDefaultLanguage(String language) {
		Select select = new Select(defaultLanguage);
		select.selectByVisibleText(language);
	}
	
	/**
	 * Obtener el idioma defecto de la plataforma
	 * 
	 * @return String
	 */
	public String getDefaultLanguage() {
		Select select = new Select(defaultLanguage);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el color fondo de la plataforma
	 * 
	 * @return String
	 */
	public String getDefaulBackgroundColor() {
		return defaultBackgroundColor.getAttribute("value");
	}
	
	/**
	 * Obtener el color de header y footer
	 * 
	 * @return String
	 */
	public String getDefaultBgColorHeaderFooter() {
		return defaultBgColorHeaderFooter.getAttribute("value");
	}
	
	/**
	 * Obtener el Texto header y footer
	 * 
	 * @return String
	 */
	public String getDefaultFontColor() {
		return defaultFontColor.getAttribute("value");
	}
	
	/**
	 * Obtener el color Texto botones
	 * 
	 * @return String
	 */
	public String getButtonFontColor() {
		return buttonFontColor.getAttribute("value");
	}
	
	/**
	 * Obtener el Fondo botones
	 * 
	 * @return String
	 */
	public String getButtonBackgroundColor() {
		return buttonBackgroundColor.getAttribute("value");
	}
	
	/**
	 * Obtener el Borde header y footer
	 * 
	 * @return String
	 */
	public String getDefaultBorderColor() {
		return defaultBorderColor.getAttribute("value");
	}
	
	/**
	 * Obtener el color de iconos
	 * 
	 * @return String
	 */
	public String getIconsColor() {
		Select select = new Select(iconsColor);
		WebElement option = select.getFirstSelectedOption();
		
		return option.getText();
	}
	
	/**
	 * Obtener el mensaje de error en el campo logo principal
	 * 
	 * @return String
	 */
	public String getErrorLogoUrl() {
		return errorlogoUrl.getText();
	}
	
	/**
	 * Obtener el mensaje de error en el campo logo secundario
	 * 
	 * @return String
	 */
	public String getErrorLogoUrlFooter() {
		return errorUrlFooter.getText();
	}
	
	/**
	 * Obtener el mensaje de error en el campo banner login
	 *  
	 * @return String
	 */
	public String getErrorSignInBanner() {
		return errorSigninBannerUrl.getText();
	}
	
	/**
	 * Obtener el mensaje de error en el campo fondo plataforma
	 * 
	 * @return String
	 */
	public String getErrorDefaultBackgroundColor() {
		return errordefaultBackgroundColor.getText();
	}
	
	/**
	 * Obtener el mensaje de error del campo fondo header y footer
	 * 
	 * @return Sring
	 */
	public String getErrorDefaultBgColorHeaderFooter() {
		return errordefaultBgColorHeaderFooter.getText();
	}

}
