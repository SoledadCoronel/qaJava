package com.gointegro.Pages.Collaborators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Profile.Profile;

public class Home extends PageBase {
	
	@FindBy(name = "filters[fullname]")
	WebElement fullNameFilter;
	
	@FindBy(id = "fullname-filter-btn-submit")
	WebElement fullNameFilterBtn;
	
	@FindBy(name = "filters[email]")
	WebElement emailFilter;
	
	@FindBy(id = "email-filter-btn-submit")
	WebElement emailFilterBtn;
	
	@FindBy(xpath = "//table/tbody/tr")
	List<WebElement> collabList;

	String nameLink = "./td/a";
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Home(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/collaborators";
	}

	/**
	 * Completar el campo Buscar por nombre y apellido
	 * 
	 * @param name
	 */
	private void completeFullName(String name) {
		fullNameFilter.clear();
		fullNameFilter.sendKeys(name);
	}
	
	/**
	 * Seleccionar el botón Buscar por nombre y apellido
	 */
	private void selectFullNameBtn() {
		fullNameFilterBtn.click();
	}
	
	/**
	 * Buscar usuario por nombre
	 * 
	 * @param name
	 */
	public void searchFullName(String name) {
		completeFullName(name);
		selectFullNameBtn();
	}
	
	/**
	 * Completar el campo Buscar por email
	 * 
	 * @param name
	 */
	private void completeEmail(String name) {
		emailFilter.clear();
		emailFilter.sendKeys(name);
	}
	
	/**
	 * Seleccionar el botón Buscar por email
	 */
	private void selectEmailBtn() {
		emailFilterBtn.click();
	}
	
	/**
	 * Buscar usuario por email
	 * 
	 * @param email
	 */
	public void searchEmail(String email) {
		completeEmail(email);
		selectEmailBtn();
	}
	
	/**
	 * Devuelve si el colaborador se encuentra en la lista
	 * 
	 * @param name
	 * @return Boolean
	 */
	public Boolean isUserInList(String name) {
		Boolean isUserPresent = false;
		
		for(WebElement element : collabList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				isUserPresent = true;
			}
		}
		return isUserPresent;
	}
	
	/**
	 * Seleccionar el colaborador
	 * 
	 * @param name
	 * @return Profile
	 */
	public Profile selectCollaborator(String name) {
		for(WebElement element : collabList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath(nameLink)).click();
			}
		}
		return PageFactory.initElements(driver, Profile.class);
	}
	
	/**
	 * Seleccionar la sengunda pagina de archivos
	 */
	public void selectPaginate() {
		if(driver.findElements(By.id("page-2")).size() > 0) {
			driver.findElement(By.id("page-2")).click();
		}
	}

	/**
	 * Devuelve si la sengunda pagina de archivos esta activa
	 */
	public Boolean isSecondPageActive() {
		Boolean isPageActive = false;

		if(driver.findElements(By.xpath("//ul/li[@class='active']/a[@id='page-2']")).size() > 0) {
			isPageActive = true;
		}
		return isPageActive;
	}
}
