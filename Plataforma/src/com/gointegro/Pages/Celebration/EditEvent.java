package com.gointegro.Pages.Celebration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * PO. Editar evento, extiende de New Event ya que es el mismo form pero completo con datos.
 * 
 * @author gustavomoreira
 *
 */
public class EditEvent extends NewEvent{
	
	@FindBy (className = "text-wrap")
	private WebElement collaboratorscontainer;
	
	@FindBy (className = "file-name")
	private WebElement filename;
	
	@FindBy (className = "text-remove")
	private List<WebElement> removecollab;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public EditEvent(WebDriver driver) {
		super(driver);
	}
	
	
	@Override
	protected void selectCategory(String categoryname) {
		super.selectCategory(categoryname);
	}
	
	@Override
	protected void selectColaboratorList(String collaboratorname) {
		super.selectColaboratorList(collaboratorname);
	}
	
	@Override
	protected void selectDate(String date) {
		super.selectDate(date);
	}
	
	@Override
	public NewCategoryOverlay selectNewCategory() {
		return super.selectNewCategory();
	}
	
	
	/**
	 * Obtiene los collaboradores de un evento
	 * 
	 * @return String
	 */
	public String getCollaboratorsContainer() {
		return collaboratorscontainer.getText();
	}
	
	/**
	 * Obtiene el titulo de un evento
	 * 
	 * @return String
	 */
	public String getEventTitle() {
		return super.title.getAttribute("value");
	}
	
	/**
	 * Obtiene la descripcion de un evento
	 * 
	 * @return String
	 */
	public String getEventDescription() {
		return super.description.getAttribute("value");
	}
	
	/**
	 * Obtiene la fecha de un evento
	 * 
	 * @return String
	 */
	public String getEventeDate() {
		return super.date.getAttribute("value");
	}
	
	/**
	 * Obtiene la categoria a la que pertenece un evento
	 * 
	 * @return String
	 */
	public String getCategory() {
		Select select = new Select(super.categories);
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Obtiene el nombre de la imagen utilizada
	 * 
	 * @return String
	 */
	public String getFileName() {
		return filename.getText();
	}
	
	/**
	 * Limpiar el listado de colaboradores
	 */
	public void cleanCollaborators() {
		while (removecollab.size() > 0){
			for (WebElement element : removecollab) {
				element.click();
			}
		}
	}

}
