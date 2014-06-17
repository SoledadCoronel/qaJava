package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

public class AplicationAdd extends PageBase{
	
	@FindBy (xpath = "//button[contains(@alt,'Instalar Contenidos')]")
	private WebElement installContent;
	
	@FindBy (xpath = "//button[contains(@alt,'Instalar Galerías')]")
	private WebElement installGalery;
	
	@FindBy (xpath = "//button[contains(@alt,'Instalar Celebraciones')]")
	private WebElement installCelebration;
	@FindBy (xpath = "//button[contains(@alt,'Instalar Novedades')]")
	private WebElement installNews;
	
	@FindBy (xpath = "//button[contains(@alt,'Instalar Torneos Pro')]")
	private WebElement installTournaments;
	
	@FindBy (xpath = "//button[contains(@alt,'Instalar Actividad social')]")
	private WebElement installAppSocial;


	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AplicationAdd(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/workspace/"+ConfigElements.getWorkspaceId()+"/app/list";
	}
	
	/**
	 * Seleccionar Instalar App de Contenidos
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallContent() {
		installContent.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Seleccionar Instalar App de Galerias
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallGalery() {
		installGalery.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Seleccionar Instalar App de Celebraciones
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallCelebration() {
		installCelebration.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Seleccionar Instalar App de Novedades
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallNews() {
		installNews.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Seleccionar Instalar App de Torneos
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallTournaments() {
		installTournaments.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}
	
	/**
	 * Seleccionar Instalar App Social
	 * 
	 * @return {@link AplicationInstall}
	 */
	public AplicationInstall selectInstallAppSocial() {
		installAppSocial.click();
		
		return PageFactory.initElements(driver, AplicationInstall.class);
	}


}
