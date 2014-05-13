package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.DateTool;

/**
 * PO. Listado de celebraciones
 * 
 * @author gustavomoreira
 *
 */

public class CelebrationList extends PageBase{
	
	@FindBy (className = "name")
	private WebElement name;
	
	@FindBy (className = "title")
	private WebElement title;
	
	@FindBy (xpath = "//div[@class='category-day']/a")
	private WebElement categoryname;
	
	@FindBy (className = "description")
	private WebElement description;
	
	@FindBy (className = "media-object")
	private WebElement media;
	
	@FindBy (id = "event-options")
	private WebElement eventoptions;
	
	@FindBy (id = "edit-event")
	private WebElement eventedit;
	
	@FindBy (id = "delete-event")
	private WebElement eventdelete;
	
	@FindBy (className = "todayview-date")
	private WebElement todayviewdate;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public CelebrationList(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el datetime de una celebracion
	 * 
	 * @return String
	 */
	private String getTodayViewDate () {
		return todayviewdate.getAttribute("datetime");
	}
	
	/**
	 * Obtener el datetime en formato español
	 * 
	 * @return String
	 */
	public String getTodayDate() {
		return DateTool.TimeFormatTodayViewDate(getTodayViewDate());
	}
	
	/**
	 * Obtener el nombre del colaborador
	 * 
	 * @return String
	 */
	public String getCollaboratonName() {
		return name.getText();
	}
	
	/**
	 * Obtener el nombre de la categoria
	 * 
	 * @return String
	 */
	public String getCategory() {
		return categoryname.getText();
	}
	
	/**
	 * Obtener el titulo de la celebracion
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}
	
	/**
	 * Obtener la descripcion de una celebracion
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Obtener el nombre de la miniatura de una imagen de perfil
	 * 
	 * @return String
	 */
	public String getImgAlt() {
		return media.getAttribute("alt");
	}
	
}
