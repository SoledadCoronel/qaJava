package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsGalery;
import com.gointegro.Pages.Base.PageBase;

public class AdminAlbum extends PageBase{
	
	@FindBy (id = "new-album-btn")
	private WebElement newalbumbtn;
	
	@FindBy (className = "btn-edit")
	private WebElement editbtn;
	
	@FindBy (className = "btn-delete")
	private WebElement deletebtn;
	
	@FindBy (xpath = "//*[@id='albums-list']/li")
	private List<WebElement> albumlist;
	
	@FindBy (name = "name")
	private WebElement albumname;
	
	@FindBy (id = "btn-album-save")
	private WebElement btnalbumsave;
	
	@FindBy (id = "btn-album-cancel")
	private WebElement btnalbumcancel;
	
	@FindBy (xpath = "//div[@id='alert']/div")
	private WebElement saveerror;
	
	@FindBy (className = "data-error")
	private WebElement albumnameerror;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AdminAlbum(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/app/galleries/" + ConfigElementsGalery.getAppIdGalery() + "/albums/admin";
	}
	
	/**
	 * Seleccionar el btn Nuevo Album
	 */
	private void selectNewAlbum() {
		newalbumbtn.click();
	}
	
	/**
	 * Completar el nombre del album
	 * 
	 * @param albumnam
	 */
	private void completeAlbumName(String albumnam) {
		albumname.clear();
		albumname.sendKeys(albumnam);
	}
	
	/**
	 * Seleccionar Guardar
	 */
	private void selectSave() {
		btnalbumsave.click();
	}
	
	/**
	 * Seleccionar Cancelar
	 */
	private void selectCancel() {
		btnalbumcancel.click();
	}
	
	/**
	 * Seleccionar el boton editar
	 * 
	 * @param name
	 */
	private void selectAlbumEdit(String name) {
		for (WebElement element : albumlist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				element.findElement(By.className("btn-edit")).click();
				break;
			}
		}
	}
	
	/**
	 * Seleccionar el boton eliminar
	 * 
	 * @param name
	 */
	private void selectAlbumDelete(String name) {
		for (WebElement element : albumlist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
				element.findElement(By.className("btn-delete")).click();
				break;
			}
		}
	}
	
	/**
	 * Completar el new album, si savecancel == true guarda, sino cancel
	 * 
	 * @param albumname
	 * @param savecancel
	 */
	public void newAlbum(String albumname, boolean savecancel) {
		selectNewAlbum();
		completeAlbumName(albumname);
		if (savecancel)
			selectSave();
		else
			selectCancel();
	}
	
	/**
	 * Obtener el mensaje de error debajo del campo
	 * 
	 * @return String
	 */
	public String getFieldErrorMsj() {
		return albumnameerror.getText();
	}
	
	/**
	 * Obtener el mensaje de error en la parte superior
	 * 
	 * @return String
	 */
	public String getErrorMsj() {
		return saveerror.getText();
	}
	
	/**
	 * Buscar un album en la lista
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean isAlbumInList(String name) {
		boolean status = false;
		for (WebElement element : albumlist) {
			if (element.findElement(By.className("span10")).getText().contains(name)) {
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
	 * Completar editar album
	 * 
	 * @param albumname
	 * @param savecancel
	 * @param newalbumname
	 */
	public void editAlbum(String albumname, boolean savecancel, String newalbumname) {
		selectAlbumEdit(albumname);
		completeAlbumName(newalbumname);
		if (savecancel)
			selectSave();
		else
			selectCancel();
	}
	
	/**
	 * Seleccionar eliminar album
	 * 
	 * @param name
	 * @return {@link DeleteOverlay}
	 */
	public DeleteOverlay deleteAlbum(String name) {
		selectAlbumDelete(name);
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Obtener el nombre del album
	 * 
	 * @return String
	 */
	public String getAlbumName(String name) {
		selectAlbumEdit(name);
		return albumname.getAttribute("value");
	}
	
	/**
	 * Cambiar el orden de los albums
	 * 
	 * @param album1name
	 * @param album2name
	 * @param album3name
	 */
	public void changeOrder(String album1name, String album2name, String album3name) {
		WebElement webElement1 = null;
		WebElement webElement3 = null;
		
		for (WebElement element : albumlist) {
			if (element.getText().contains(album1name)) {
				webElement1 = element;
			}
			else if (element.getText().contains(album3name)) {
				webElement3 = element;
			}
			else {
				// aca iria una excepcion ponele (?)
			}
		}
		
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(webElement3).moveToElement(webElement1).release(webElement1).build();

		dragAndDrop.perform();
	}
	
	/**
	 * OBtener el id del elemento en el listado
	 * 
	 * @param album
	 * @return int
	 */
	public int getElementIdInList(String album) {
		int i = 0;
		for (i=0; i < albumlist.size(); i++) {
			WebElement e = albumlist.get(i);
			if (e.getText().contains(album))
				break;
		}
		
		return i;
	}

}
