package com.gointegro.Pages.Backoffice_User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class UserList extends PageBase{
	
	@FindBy (name = "filters[queryString]")
	private WebElement filter;
	
	@FindBy (className = "icon-plus")
	private WebElement newuserbtn;
	
	@FindBy (className = "icon-backward")
	private WebElement backbtn;
	
	@FindBy(xpath = "//div[@id='basic-grid']/table/tbody/tr")
	List <WebElement> basicgrid;
	
	@FindBy (xpath = "//tr[@class='empty']/td")
	private WebElement empty;
	
	@FindBy (id = "queryString-filter-btn-submit")
	private WebElement filtersubmit;
	
	String tablexpath = "./td";

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public UserList(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice() + "/platforms/" + ConfigElementsBO.getPlatformId() + "/user/list";
	}
	
	/**
	 * Obtener el elemento del listado
	 * 
	 * @param name
	 * 
	 * @return {@link WebElement}
	 */
	private WebElement getElementInList(String name) {
		WebElement e = null;
		
		for (WebElement element : basicgrid) {
			if (element.getAttribute("innerHTML").contains(name)) {
				e = element;
				break;
			}
		}
		
		if (e == null) {
			e = empty;
		}
		
		return e;
	}
	
	/**
	 * Completar la busqueda por nombre
	 * 
	 * @param name
	 */
	private void setFilter(String name) {
		filter.clear();
		filter.sendKeys(name);
		filtersubmit.click();
		
		WaitTool.waitForJQueryProcessing(driver, 15);
	}
	
	/**
	 * Buscar por nombre
	 * 
	 * @param name
	 * 
	 * @return boolean
	 */
	public boolean searchUser(String name) {
		if (!name.isEmpty())
			setFilter(name);
		
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement platformname = getElementInList(name);
		return platformname.getText().contains(name);
	}
	
	/**
	 * Seleccionar crear usuario
	 * 
	 * @return {@link CreateUser}
	 */
	public CreateUser selectNewUser() {
		newuserbtn.click();
		
		return PageFactory.initElements(driver, CreateUser.class);
	}

}
