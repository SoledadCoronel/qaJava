package com.gointegro.Pages.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;

public class AplicationInstall extends PageBase{
	
	@FindBy (id = "app-name")
	protected WebElement appname;
	
	@FindBy (name = "description")
	protected WebElement description;
	
	@FindBy (id = "selected-icon")
	protected WebElement selectedicon;
	
	@FindBy (name = "disable")
	protected WebElement radioactive;
	
	@FindBy (xpath = "//input[@name='disable'][2]")
	protected WebElement radiodesactive;
	
	@FindBy (id = "socialEnabled")
	protected WebElement socialEnabled;
	
	@FindBy (name = "displayStrategy")
	protected WebElement radiodaysPast;
	
	@FindBy (xpath = "//input[@name='displayStrategy'][2]")
	protected WebElement radiomonthsPast;
	
	@FindBy (name = "daysPast")
	protected WebElement daysPast;
	
	@FindBy (name = "monthsPast")
	protected WebElement monthsPast;
	
	@FindBy (id = "accept")
	protected WebElement accept;
	
	@FindBy (id = "cancel")
	protected WebElement cancel;
	
	@FindBy (name = "tournamentList")
	protected WebElement tournamentlist;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AplicationInstall(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completar nombre
	 * 
	 * @param name
	 */
	protected void setAppName(String name) {
		appname.clear();
		appname.sendKeys(name);
	}
	
	/**
	 * Completar descripcion
	 * 
	 * @param descr
	 */
	protected void setDescription(String descr) {
		description.clear();
		description.sendKeys(descr);
	}
	
	/**
	 * Activa social o desactiva social
	 * 
	 * @param activeSocial activa = true, desactiva = false.
	 */
	protected void selectSocialEnabled(boolean activeSocial) {
		if (activeSocial) {
			if (!socialEnabled.isSelected())
				socialEnabled.click();
		}
		else {
			if (!socialEnabled.isSelected())
				socialEnabled.click();
		}
	}
	
	/**
	 * Seleccionar Estado Activa
	 */
	protected void selectActive() {
		radioactive.click();
	}
	
	/**
	 * Seleccionar Estado Desactivada
	 */
	protected void selectDesactive() {
		radiodesactive.click();
	}
	
	/**
	 * Seleccionar el status de la app
	 * 
	 * @param status
	 */
	protected void setStatus (boolean status) {
		if (status)
			selectActive();
		else
			selectDesactive();
	}
	
	/**
	 * Seleccionar Mostrar Celebraciones desde Una cantidad de dias atras
	 */
	protected void selectDaysPast() {
		radiodaysPast.click();
	}
	
	/**
	 * Seleccionar Mostrar celebracioens desde el primeo de un mes dado
	 */
	protected void selectMonthsPast() {
		radiomonthsPast.click();
	}
	
	/**
	 * Completar celebraciones desde una cantidad de dias atras
	 * 
	 * @param num
	 */
	protected void setDaysPast(String num) {
		daysPast.clear();
		daysPast.sendKeys(num);
	}
	
	/**
	 * Seleccionar un mes para mostrar
	 * 
	 * @param month false "Mes anterior" - true "Mes actual"
	 */
	protected void setMonthsPast(boolean month) {
		Select droplist = new Select(monthsPast);
		if (month)
			droplist.selectByVisibleText("Mes actual");
		else
			droplist.selectByVisibleText("Mes anterior");
	}
	
	/**
	 * Seleccionar Guardar
	 */
	protected void saveBtn() {
		accept.click();
	}
	
	/**
	 * Cancelar
	 */
	protected void cancelBtn() {
		cancel.click();
	}
	
	/**
	 * Completar dias atras
	 * 
	 * @param num
	 */
	protected void daysPastComplete(String num) {
		selectDaysPast();
		setDaysPast(num);
	}
	
	/**
	 * Completar meses atras
	 * 
	 * @param month
	 */
	protected void monthsPastComplete(boolean month) {
		selectMonthsPast();
		setMonthsPast(month);
	}
	
	
	/**
	 * Completa los campos especiales para el caso de una app de Celebraciones
	 * 
	 * @param num si esta vacio pasa directamente a tomar en cuenta el mes
	 * @param month
	 */
	public void celebrationComplete(String num, boolean month) {
		if (!num.isEmpty()) {
			daysPastComplete(num);
		}
		else
			monthsPastComplete(month);
	}
	
	/**
	 * Seleccionar un torneo por nombre
	 * 
	 * @param tournament
	 */
	public void selectTournament(String tournament) {
		Select droplist = new Select(tournamentlist);
		droplist.selectByVisibleText(tournament);
	}
	
	/**
	 * Completar los campos standard de todas las app
	 * 
	 * @param name
	 * @param descr
	 * @param status
	 * @param activeSocial
	 */
	public void completeInstallApp(String name, String descr, boolean status, boolean activeSocial, boolean isappsocial) {
		setAppName(name);
		setDescription(descr);
		setStatus(status);
		if (!isappsocial)
		selectSocialEnabled(activeSocial);
		saveBtn();
	}

}
