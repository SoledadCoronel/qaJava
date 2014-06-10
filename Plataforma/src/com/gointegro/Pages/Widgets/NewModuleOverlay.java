package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gointegro.Helpers.ConfigElementsWidgets;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

public class NewModuleOverlay extends PageBase {
	
	@FindBy(className = "standard-app-radio")
	WebElement standardRadioBtn;
	
	@FindBy(className = "installed-app-radio")
	WebElement installedRadioBtn;
	
	@FindBy(className = "benefits-app-radio")
	WebElement benefitsRadioBtn;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[2]")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[3]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[4]")
	WebElement finishBtn;
	
	// Widget Texto / HTML
	@FindBy(xpath = "//*[@id='new-module-standard-img']/div[2]/nav/p[2]/label/input")
	WebElement textHtmlRadioBtn;
	
	@FindBy(className = "showTitle")
	WebElement titleVisibleCheckBox;
	
	@FindBy(className = "showBorder")
	WebElement borderCheckBox;
	
	@FindBy(xpath = "//form[@class='widget-form']/article/div/div/span/input")
	WebElement title;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[2]/form/article/div/div/span/input")
	WebElement celebrationTitle;
	
	@FindBy(xpath = "//div/div/iframe")
	WebElement description;
	
	@FindBy(xpath = "//form/article/div[2]/div/span[2]")
	WebElement titleErrorMsg;
	
	@FindBy(xpath = "//form/article/div[3]/div/div/span[2]")
	WebElement descriptionErrorMsg;
	
	@FindBy(xpath = "//*[@id='new-module-standard-img']/div[2]/nav/p[3]/label/input")
	WebElement imageRadioBtn;
	
	@FindBy (id = "banner-image-upload")
	WebElement attachmentUpload;
	
	@FindBy(className = "delete")
	WebElement deleteFileBtn;
	
	@FindBy(className = "hasLink")
	WebElement imageLinkCheckBox;
	
	@FindBy(name = "externalUrl")
	WebElement imageLink;
	
	@FindBy(xpath = "//div[@data-fields='externalUrl']/div/span[2]")
	WebElement linkErrorMsg;
	
	@FindBy(xpath = "//ul[@id='selection-tree']/li/ul/li")
	List<WebElement> selectionTree;
	
	@FindBy(xpath = "//div[@id='carousel-images-selector']/ul/li")
	List<WebElement> imagesSelector;
	
	String imageSelector = "//div[@id='carousel-images-selector']/ul/li";
	
	@FindBy(id = "album-selector")
	WebElement albumSelector;
	
	@FindBy(className = "all-categories")
	WebElement allCategoriesCheckBox;
	
	@FindBy(id = "empty-contents-error")
	WebElement categoryErrorMsg;
	
	@FindBy(xpath = "div[@class='widget-type-form']/div[5]")
	WebElement galleryNoImageErrorMsg;
	
	@FindBy(xpath = "//div[@class='widget-type-form']/div[4]/div/span[2]")
	WebElement bannerNoImageErrorMsg;
	
	/**
	 * Constructor
	 * 
	 * @param WebDriver
	 */
	public NewModuleOverlay(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Seleccionar la opción Estándar y Continuar
	 */
	public void selectStandard() {
		standardRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Aplicaciones instaladas y Continuar
	 */
	public void selectInstalledApps() {
		installedRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Beneficios y Continuar
	 */
	public void selectBenefits() {
		benefitsRadioBtn.click();
		selectContinue();
	}

	/**
	 * Seleccionar el botón Continuar
	 */
	private void selectContinue() {
		continueBtn.click();
	}
	
	/**
	 * Seleccionar el botón Finalizar
	 */
	public void selectFinishBtn() {
		finishBtn.click();
	}
	
	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancelBtn() {
		cancelBtn.click();
	}
	
	/**
	 * Seleccionar el botón Finalizar
	 */
	public void selectFinishBtnWithElement(WebElement element) {
		element.findElement(By.xpath("./div[3]/button[4]")).click();
	}
	
	
	/**
	 *  MÓDULO DE TEXTO
	 */
	
	
	/**
	 * Seleccionar la opción Texto / HTML y Continuar
	 */
	public void selectTextRadioBtn() {
		textHtmlRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Devuelve el mensaje de error del titulo
	 * 
	 * @return String
	 */
	public String getTitleErrorMsg() {
		return titleErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de la descripción
	 * 
	 * @return String
	 */
	public String getDescriptionErrorMsg() {
		return descriptionErrorMsg.getText();
	}
	
	/**
	 * Seleccionar la opción Imagen y Continuar
	 */
	public void selectImageBtn() {
		imageRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Titulo visible
	 */
	public void selectVisibleTitle() {
		titleVisibleCheckBox.click();
	}
	
	/**
	 * Devuelve si la opción Titulo visible esta habilitada
	 * 
	 * @return Boolean
	 */
	public Boolean isVisibleTitleEnabled() {
		return titleVisibleCheckBox.isEnabled();
	}
	
	/**
	 * Seleccionar la opción Borde
	 */
	public void selectBorder() {
		borderCheckBox.click();
	}
	
	/**
	 * Crear titulo para el widget
	 * 
	 * @param String
	 */
	public void createTitle(String name) {
		title.clear();
		title.sendKeys(name);
	}
	
	/**
	 * Crear titulo para el widget
	 * 
	 * @param String
	 */
	public void createCelebrationTitle(String name) {
		celebrationTitle.clear();
		celebrationTitle.sendKeys(name);
	}
	
	/**
	 * Crear descripcion para el widget
	 * 
	 * @param String
	 */
	public void createDescription(String descriptionText) {
		driver.switchTo().frame(description);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + descriptionText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Crea un widget Text/HTML con titulo y descripcion
	 * 
	 * @param String
	 * @param String
	 */
	public void createTextWidget(String title, String description) {
		selectStandard();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		selectTextRadioBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		selectVisibleTitle();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		selectBorder();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createTitle(title);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createDescription(description);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		selectFinishBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	/**
	 *  MÓDULO DE IMAGEN
	 */
	
	/**
	 * Ingresar una imagen miniatura
	 * 
	 * @param fileupload
	 */
	public void fileUpload(String fileupload) {
		AttachmentUploads.SocialWallAttachment(driver);
		attachmentUpload.sendKeys(fileupload);
		AttachmentUploads.waitBar(driver);
	}
	
	/**
	 * Selccionar el botón Eliminar
	 * 
	 * @param fileupload
	 */
	public void selectRemoveFile() {
		deleteFileBtn.click();
	}
	
	/**
	 * Selccionar el check box Aplicar link externo a la imagen
	 * 
	 */
	public void selectLinkCheckBox() {
		imageLinkCheckBox.click();
	}
	
	/**
	 * Crear link para la imagen
	 * 
	 * @param String
	 */
	public void createLink(String linkUrl) {
		imageLink.clear();
		imageLink.sendKeys(linkUrl);
	}
	
	/**
	 * Devuelve el mensaje de error del link
	 * 
	 * @return String
	 */
	public String getImageWidgetLinkErrorMsg() {
		return linkErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del link
	 * 
	 * @return String
	 */
	public String getImageWidgetNoImageErrorMsg() {
		return bannerNoImageErrorMsg.getText();
	}
	
	/**
	 *  MÓDULO DE APLICACIONES
	 */
	
	/**
	 * Seleccionar la aplicación Celebraciones
	 */
	public void selectApplicationCelebration() {
		selectApplication(ConfigElementsWidgets.getWidgetsCelebrationAppId());
	}
	
	/**
	 * Seleccionar la aplicación Galeria
	 */
	public void selectApplicationGallery() {
		selectApplication(ConfigElementsWidgets.getWidgetsGalleryAppId());
	}
	
	/**
	 * Seleccionar la aplicación por Id
	 */
	private void selectApplication(String appId) {
		WebElement subTree = null;
		
		for(WebElement element : selectionTree) {
			if(element.findElement(By.xpath("./label")).getText().contains(ConfigElementsWidgets.getNombreEspacio())) {
				subTree = element;
				element.findElement(By.xpath("./label")).click();
				break;
			}
		}
		
		if(subTree.findElement(By.xpath("./ul/li/a[@data-id='"+ appId +"']")).getAttribute("data-id").contains(appId)) {	
			subTree.findElement(By.xpath("./ul/li/a[@data-id='"+ appId +"']")).click(); 
		}
		
		selectContinue();
	}
	
	/**
	 * Seleccionar mitad de las imagenes en una galeria
	 */
	public void selectPicturesInGallery(int num) {
		int total = imagesSelector.size();
		int count = 1;
		if(num > total) { 
			num = total; 
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		List <WebElement> imagesSelector = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(imageSelector)));
		
		for(WebElement element : imagesSelector) {
			if(count <= num) {
				element.findElement(By.xpath("./img")).click();
				count += 1;
			} else {
				break;
			}
		}
	}
	
	/**
	 * Seleccionar un album
	 */
	public void selectAlbumByName(String name) {
		new Select(albumSelector).selectByVisibleText(name);
	}
	
	/**
	 * Seleccionar el check box Todas las Categorias
	 */
	public void selectCategories() {
		allCategoriesCheckBox.click();
	}
	
	/**
	 * Devuelve el mensaje de error de la categoria
	 * 
	 * @return String
	 */
	public String getCategoryErrorMsg() {
		return categoryErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de imagenes
	 * 
	 * @return String
	 */
	public String getNoImageErrorMsg() {
		return galleryNoImageErrorMsg.getText();
	}
	
}
