package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountRegional extends CreateAccountRegional {
	
	@FindBy(id = "c1_htmlLogin_ifr")
	private WebElement htmlLogin;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EditAccountRegional(WebDriver driver) {
		super(driver);
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
	 * Obtener el nombre de la cuenta
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getAttribute("value");
	}
	
	/**
	 * Obtener el nombre del sitio web
	 * 
	 * @return String
	 */
	public String getSitioWeb() {
		return website.getAttribute("value");
	}
	
	/**
	 * Obtener el HTML Login
	 * 
	 * @return String
	 */
	public String getHtmlLogin() {
		driver.switchTo().frame(htmlLogin);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return document.body.textContent");
		
		driver.switchTo().defaultContent();
		
		return text;
	}
	
	/**
	 * Editar la informacion basica
	 * 
	 * @param accountname
	 * @param web
	 * @param htmllog
	 */
	public void editBasicInfo(String accountname, String web, String htmllog) {
		//Quise extenderlo pero el htmllogin tiene otro id etcetc
		
		completeName(accountname);
		completeWebSite(web);
		setHtmlLogin(htmllog);
	}

}
