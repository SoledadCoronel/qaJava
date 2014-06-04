package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	 * @return {@link DeleteAlbumOverlay}
	 */
	public DeleteAlbumOverlay deleteAlbum(String name) {
		selectAlbumDelete(name);
		
		return PageFactory.initElements(driver, DeleteAlbumOverlay.class);
	}
	
	/**
	 * Obtener el nombre del album
	 * 
	 * @return String
	 */
	public String getAlbumName(String name) {
		selectAlbumEdit(name);
		return albumname.getText();
	}

}
