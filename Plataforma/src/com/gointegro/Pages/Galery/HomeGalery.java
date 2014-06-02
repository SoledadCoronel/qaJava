package com.gointegro.Pages.Galery;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsGalery;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class HomeGalery extends PageBase{
	
	@FindBy (id = "content-upload")
	private WebElement contentupload;
	
	@FindBy (id = "albumes")
	private WebElement albumdropdown;
	
	@FindBy (name = "nuevo")
	private WebElement newalbum;
	
	@FindBy (className = "admin-album")
	private WebElement adminalbum;
	
	@FindBy (xpath = "//div[@id='album-sidebar']/ul/li")
	private List<WebElement> albumsidebarlist;
	
	@FindBy (xpath = "//div[@class='main-container']/ul/li")
	private List<WebElement> maincontainerlist;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public HomeGalery(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL() + "/app/galleries/" + ConfigElementsGalery.getAppIdGalery();
	}
	
	/**
	 * Seleccionar el dropdown Albumes
	 */
	private void selectAlbumDropdown() {
		albumdropdown.click();
	}
	
	/**
	 * Hacer visible el boton browse para subir una imagen
	 */
	private void makeBrowseVisible() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('content-upload').setAttribute('style','visible: visible; opacity: 1; position: static; transform: none;');");
	}
	
	/**
	 * Seleccionar Nuevo Album del dropdown de Albumes
	 * 
	 * @return {@link NewAlbumOverlay}
	 */
	public NewAlbumOverlay selectNewAlbum() {
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.elementToBeClickable(albumdropdown));
		selectAlbumDropdown();
		WaitTool.waitForJQueryProcessing(driver, 5);
		newalbum.click();
		
		return PageFactory.initElements(driver, NewAlbumOverlay.class);
	}
	
	/**
	 * Seleccionar Administrador de Album del dropdown de Albumes
	 * 
	 * @return {@link AdminAlbum}
	 */
	public AdminAlbum selectAdminAlbum() {
		selectAlbumDropdown();
		adminalbum.click();
		
		return PageFactory.initElements(driver, AdminAlbum.class);
	}
	
	/**
	 * Verifica que exista el nombre del album en el contendor central
	 * 
	 * @param albumname
	 * @return boolean
	 */
	public boolean getAlbumNameMainContainer(String albumname) {
		boolean status = false;
		for (WebElement element : maincontainerlist) {
			if (element.getText().contains(albumname.substring(0, 15).toUpperCase())) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	/**
	 * Verifica que exista el nombre del album en el sidebar
	 * 
	 * @param albumname
	 * @return boolean
	 */
	public boolean getAlbumNameSideBar(String albumname) {

		boolean status = false;
		for (WebElement element : albumsidebarlist) {
			if (element.getText().contains(albumname.substring(0, 15))) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	/**
	 * Seleccionar un album del sidebar
	 * 
	 * @param albumname
	 * @return {@link AlbumDetail}
	 */
	public AlbumDetail selectAlbumSideBar(String albumname) {
		for (WebElement element : albumsidebarlist) {
			if (element.getText().contains(albumname.substring(0, 15))) {
				element.findElement(By.xpath("//header/a")).click();
				break;
			}
		}
		
		return PageFactory.initElements(driver, AlbumDetail.class);
	}
	
	/**
	 * Upload file
	 * 
	 * @param testfile
	 * @return {@link UploadContent}
	 */
	public UploadContent uploadFile(String testfile) {
		WaitTool.waitForJQueryProcessing(driver, 5);
		makeBrowseVisible();
		WaitTool.waitForJQueryProcessing(driver, 5);
		contentupload.sendKeys(testfile);
		return PageFactory.initElements(driver, UploadContent.class);
	}

}
