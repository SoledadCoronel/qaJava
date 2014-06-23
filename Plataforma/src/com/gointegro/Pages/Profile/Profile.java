package com.gointegro.Pages.Profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

/**
 * PO. Profile
 * 
 * @author gustavomoreira
 *
 */
public class Profile extends PageBase{
	
	@FindBy (linkText = "Archivos")
	private WebElement linkArchivos;
	
	@FindBy (className = "table")
	private WebElement filetable;
	
	@FindBy (className = "followers-box")
	private WebElement followers;
	
	@FindBy (className = "following-box")
	private WebElement following;
	
	@FindBy (className = "wall")
	private WebElement linkWall;
	
	@FindBy (id = "head-updated_at")
	private WebElement orderDate;
	
	@FindBy (id = "user-name")
	private WebElement username;
	
	@FindBy (xpath = "//div[@class='profile-action']/div/button")
	private WebElement dataedit;
	
	@FindBy (xpath = "//div[@class='profile-action']/div/ul/li/a")
	private WebElement dataeditmodal;
	
	@FindBy (id = "notification-preference-modal-link")
	private WebElement notificationpreferencemodal;

	String profileURL = ConfigElements.getURL() + "/profile";
			
	/** 
	 * Constructor
	 * 
	 * @param driver
	 */
	public Profile(WebDriver driver) {
		super(driver);
		URL = profileURL;
	}
	
	/**
	 * Devuelve la URL del Perfil
	 */
	public String getProfileURL() {
		return profileURL;
	}
	
	/**
	 * Obtener el listado de followers
	 * 
	 * @return String
	 */
	private String getfollowers () {
		return followers.getAttribute("outerHTML");
	}
	
	/**
	 * Seleccionar el boton data-edit
	 */
	private void selectDataEdit() {
		dataedit.click();
	}
	
	/**
	 * Seleccionar Editar datos
	 */
	private void selectDataEditModalLink() {
		dataeditmodal.click();
	}
	
	
	/**
	 * Seleccionar la solapa archivos
	 */
	public void selectArchivos() {
		linkArchivos.click();
	}
	
	/**
	 * Seleccionar la solapa wall
	 */
	public void selectWall () {
		linkWall.click();
	}
	
	/**
	 * Ordenar los archivos de forma descendentes
	 */
	public void orderByDateFiles() {
		WaitTool.waitForJQueryProcessing(driver, 10);
		orderDate.click();
		WaitTool.waitForJQueryProcessing(driver, 10);
		orderDate.click();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/**
	 * Obtener el nombre del archivo posteado
	 * 
	 * @return String
	 */
	public String getFileNameList() {
		return driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[2]/a")).getAttribute("text");
	}
	
	/**
	 * Obtener la location donde se posteo un archivo
	 * 
	 * @return String
	 */
	public String getLocationNameList() {
		return driver.findElement(By.xpath("//table[@class='table']/tbody/tr/td[3]/a")).getAttribute("text");
	}
	
	
	/**
	 * Obtener el listado de following
	 * 
	 * @return String
	 */
	public String getfollowing () {
		return following.getAttribute("outerHTML");
	}
	
	/**
	 * Buscar un usuario en following
	 * 
	 * @param following
	 * @return boolean
	 */
	public boolean searchfollowing (String following) {
		if (getfollowing().contains(following))
			return true;
		else
			return false;
	}
	
	/**
	 * Buscar un usuario en followers
	 * 
	 * @param follower
	 * @return boolean
	 */
	public boolean searchfollowers (String follower) {
		if (getfollowers().contains(follower))
			return true;
		else
			return false;
	}
	
	/**
	 * Obtiene el nombre de perfil
	 * 
	 * @return String
	 */
	public String getUserName() {
		return username.getText();
	}
	
	/**
	 * Seleccionar Editar mis datos
	 * 
	 * @return {@link DataEditModal}
	 */
	public DataEditModal selectDataEditModal() {
		selectDataEdit();
		selectDataEditModalLink();
		
		return PageFactory.initElements(driver, DataEditModal.class);
	}

}
