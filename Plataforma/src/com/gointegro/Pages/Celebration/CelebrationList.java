package com.gointegro.Pages.Celebration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy (className = "celeb-image")
	private WebElement celebimage;
	
	@FindBy (id = "event-options")
	private WebElement eventoptions;
	
	@FindBy (id = "edit-event")
	private WebElement eventedit;
	
	@FindBy (id = "delete-event")
	private WebElement eventdelete;
	
	@FindBy (className = "todayview-date")
	private WebElement todayviewdate;
	
	@FindBy (css = "a.celeb-image > img.media-object")
	private WebElement zoomimg;
	
	@FindBy (className = "lb-image")
	private WebElement lightbox;
	
	@FindBy (className = "collaborators-list")
	private WebElement collaboratorslist;
	
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
	private String getTodayViewDate() {
		return todayviewdate.getAttribute("datetime");
	}
	
	/**
	 * Seleccionar event option
	 */
	private void selectEventOption() {
		eventoptions.click();
	}
	
	/**
	 * Seleccionar Editar evento
	 */
	private void selectEventEdit() {
		eventedit.click();
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
	
	/**
	 * Obtener el src de la imagen
	 * 
	 * @return String
	 */
	public String srcCelebImg() {
		return media.getAttribute("src");
	}
	
	/**
	 * Seleccionar la imagen de la celebracion
	 */
	public void selectCelebImg() {
		zoomimg.click();
	}
	
	/**
	 * Obtener el src de la imagen en el lightbox
	 * 
	 * @return String
	 */
	public String srcLightBoxImg() {
		return lightbox.getAttribute("src");
	}
	
	/**
	 * Seleccionar editar un evento
	 * 
	 * @return {@link EditEvent}
	 */
	public EditEvent selectEditEvent() {
		selectEventOption();
		selectEventEdit();
		
		return PageFactory.initElements(driver, EditEvent.class);
	}
	
	/**
	 * Selecciona el texto "y otra persona mas" para desplegar el overlay de colaboradores
	 * 
	 * @return {@link EventCollaboratorOverlay}
	 */
	public EventCollaboratorOverlay selectCollaboratosList() {
		collaboratorslist.click();
		
		return PageFactory.initElements(driver, EventCollaboratorOverlay.class);
	}
	
	/**
	 * Verifica si la imagen es visible 
	 * 
	 * @return boolean
	 */
	public boolean isElementPresent() {
		if (driver.findElements(By.className("photo")).size() > 0)
			return true;
		else
			return false;
		
	}
	
}
