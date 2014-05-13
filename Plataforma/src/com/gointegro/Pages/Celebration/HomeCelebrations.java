package com.gointegro.Pages.Celebration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsCelebration;
import com.gointegro.Pages.Base.PageBase;

/**
 * PO. Home de una app de celebraciones
 * 
 * @author gustavomoreira
 *
 */
public class HomeCelebrations extends PageBase{
	
	@FindBy(xpath = "//header[@class='app-name']/div/a")
	private WebElement neweventheader;
	
	@FindBy(id = "btn-admin-categories")
	private WebElement admincategbtn;
	
	@FindBy(id = "category-new")
	private WebElement newcategory;
	
	@FindBy(id = "admin-categories")
	private WebElement admincategories;
	
	@FindBy(id = "events-filter-today")
	private WebElement filtertoday;
	
	@FindBy(xpath = "//*[@id='category-list']/ul/li")
	private List<WebElement> categorylist;

	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HomeCelebrations(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/app/celebrations/"+ConfigElementsCelebration.getIdAppCelebraciones();
	}

	
	/**
	 * Selecionar Menu de categorias
	 */
	private void selectCategoryMenu() {
		admincategbtn.click();
	}
	
	
	/**
	 * Seleccionar nueva Categoria
	 * 
	 * @return NewCategoryOverlay
	 */
	public NewCategoryOverlay selectNewCategory() {
		selectCategoryMenu();
		newcategory.click();
		return PageFactory.initElements(driver, NewCategoryOverlay.class);
	}
	
	/**
	 * Seleccionar administrador de categorias
	 * 
	 * @return AdminCategory
	 */
	public AdminCategory selectAdminCategory() {
		selectCategoryMenu();
		admincategories.click();
		return PageFactory.initElements(driver, AdminCategory.class);
	}
	
	/**
	 * Seleccionar nueva celebracion
	 * 
	 * @return NewEvent
	 */
	public NewEvent selectNewCelebration() {
		neweventheader.click();
		return PageFactory.initElements(driver, NewEvent.class);
	}
	
	/**
	 * Buscar en el sidebar de categorias
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isCategoryInSideBar(String name) {
		boolean status = false;
		for (WebElement element : categorylist) {
			if (element.getText().contains(name)) {
				status = true;
				break;
			}
			else {
				status = false;
			}
		}
		return status;
	}
	
	/**
	 * Seleccionar una categoria en el arbol de celebraciones
	 * 
	 * @param categoryname
	 * @return CelebrationList
	 */
	public CelebrationList selectCategoryInSideBar(String categoryname) {
		for (WebElement element : categorylist) {
			if (element.getText().contains(categoryname)) {
				//Como la categoria por defecto queda seleccionada hay que hacer "doble click" para que funcione, 
				//queda asi total no afecta en nada
				element.click();
				element.click();
				break;
			}
			else {
				//
			}
		}
		return PageFactory.initElements(driver, CelebrationList.class);
	}
	
	/**
	 * Seleccionar nueva celebracion
	 * 
	 * @return NewEvent
	 */
	public NewEvent selectNewEvent() {
		neweventheader.click();
		return PageFactory.initElements(driver, NewEvent.class);
	}

}
