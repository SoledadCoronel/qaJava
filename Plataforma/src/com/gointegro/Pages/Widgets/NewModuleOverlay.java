package com.gointegro.Pages.Widgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[2]")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[3]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id='new-module-standard-img']/div[3]/button[4]")
	WebElement finishBtn;
	
	// Widget Texto / HTML
	@FindBy(xpath = "//input[contains(@value, 'html-text')]")
	WebElement textHtmlRadioBtn;
	
	@FindBy(className = "showTitle")
	WebElement titleVisibleCheckBox;
	
	@FindBy(className = "showBorder")
	WebElement borderCheckBox;
	
	@FindBy(name = "name")
	WebElement title;
	
	@FindBy(xpath = "//div/div/iframe")
	WebElement description;
	
	@FindBy(xpath = "//form/article/div[2]/div/span[2]")
	WebElement titleErrorMsg;
	
	@FindBy(xpath = "//form/article/div[3]/div/div/span[2]")
	WebElement descriptionErrorMsg;
	
	@FindBy(xpath = "//input[contains(@value, 'banner')]")
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
	
	@FindBy(xpath = "//div[@class='widget-type-form']/div[contains(@class, 'data-error')]")
	WebElement galleryNoImageErrorMsg;
	
	@FindBy(xpath = "//div[@class='widget-type-form']/div[4]/div/span[2]")
	WebElement bannerNoImageErrorMsg;
	
	@FindBy(xpath = "//div[@id='mce_17']/button")
	WebElement tinyLink;
	
	//WIDGET BENEFITS
	@FindBy(className = "benefits-app-radio")
	WebElement benefitsRadioBtn;
	
	@FindBy(id = "radio-categories")
	WebElement benefitCategoryRadioBtn;
	
	@FindBy(id = "radio-collection")
	WebElement benefitSpecialRadioBtn;
	
	@FindBy(id = "radio-selected")
	WebElement benefitHighlightedRadioBtn;
	
	@FindBy(id = "radio-ranking")
	WebElement benefitRankingRadioBtn;
	
	@FindBy(className = "select-parent-tree")
	WebElement allCategory;
	
	@FindBy(xpath = "//div[@class='categories-tree']/div/ul[1]/li/label")
	WebElement firstCategory;
	
	@FindBy(xpath = "//div[@data-fields='categories']/div/div/div")
	WebElement benefitsCategoryError;
	
	@FindBy(className = "has-locations-checkbox")
	WebElement locations;
	
	@FindBy(className = "help-block")
	WebElement locationError;
	
	@FindBy (name = "txt-search")
	WebElement locationInput;
	
	@FindBy (xpath = "//button[contains(@class, 'search-btn')]")
	WebElement locationBtn;
	
	@FindBy(className = "checkbox-benefit")
	WebElement discount;
	
	@FindBy(name = "txt-search")
	WebElement searchInput;
	
	@FindBy (xpath = "//button[contains(@class, 'search-btn')]")
	WebElement searchBtn;
	
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
	 * Seleccionar el botón Continuar
	 */
	private void selectContinue() {
		continueBtn.click();
	}
	
	/**
	 * Seleccionar el botón Finalizar
	 * 
	 * @return HomeWidgets
	 */
	public HomeWidgets selectFinishBtn() {
		finishBtn.click();
		return PageFactory.initElements(driver, HomeWidgets.class);
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
	 * Crear descripción con link (TinyMce)
	 * 
	 * @param String
	 */
	public void createDescriptionWithURL(String url) {
		tinyLink.click();
		WaitTool.waitForJQueryProcessing(driver, 10);

		driver.findElement(By.xpath("//input[@class='mce-textbox mce-placeholder']")).sendKeys(url);
		WaitTool.waitForJQueryProcessing(driver, 5);
	
		driver.findElement(By.xpath("//div[@class='mce-container mce-panel mce-foot']/div/div[2]/button")).click();
	}
	
	/**
	 * Crear descripción para el contenido con imagen (TinyMce)
	 * 
	 * @param String
	 */
	public void createDescriptionWithPic(String imageFile) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(" document.getElementById('mce_26').style.visibility = 'visible'");
		
		driver.findElement(By.xpath("//div[@id='mce_19']/button")).click();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='mce-container-body mce-abs-layout']/iframe")));
		
		driver.findElement(By.xpath("//p[@id='upload_form_container']/input")).sendKeys(imageFile);
		
		Sleeper.sleepTightInSeconds(15);
		WaitTool.waitForJQueryProcessing(driver, 10);	
		
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
	
	
	/**
	 *  MÓDULO DE BENEFICIOS
	 *  
	 */
	
	/**
	 * Seleccionar la opción Beneficios y Continuar
	 */
	public void selectBenefits() {
		benefitsRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Categoria y Continuar
	 */
	public void selectBenefitCategory() {
		benefitCategoryRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Especiales y Continuar
	 */
	public void selectBenefitSpecial() {
		benefitSpecialRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Destacados y Continuar
	 */
	public void selectBenefitHighlighted() {
		benefitHighlightedRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la opción Rankings y Continuar
	 */
	public void selectBenefitRanking() {
		benefitRankingRadioBtn.click();
		selectContinue();
	}
	
	/**
	 * Seleccionar la primera categoria en Beneficios
	 */
	public void selectFirstCategory() {
		firstCategory.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		allCategory.click();
	}
	
	/**
	 * Devuelve el mensaje de error de la categoria en Beneficios
	 * 
	 * @return String
	 */
	public String getBenefitCategoryErrorMsg() {
		return benefitsCategoryError.getText();
	}
	
	/**
	 * Seleccionar Ubicaciones
	 */
	public void selectBenefitLocations() {
		locations.click();
	}
	
	/**
	 * Devuelve el mensaje de error de Ubicaciones en Beneficios
	 */
	public String getLocationError() {
		return locationError.getText();
	}
	
	/**
	 * Completar Ubicaciones
	 * 
	 * @param address
	 */
	public void addLocation(String address) {
		selectBenefitLocations();
		
		locationInput.clear();
		locationInput.sendKeys(address);
		
		locationBtn.click();
	}
	
	/**
	 * Seleccionar un beneficio en el widget Destacado
	 */
	public void selectDiscount() {
		discount.click();
	}
	
	/**
	 * Busca y selecciona un beneficio en el widget Destacado
	 */
	public void searchDiscount(String name) {
		searchInput.clear();
		searchInput.sendKeys(name);
		
		searchBtn.click();
		
		selectDiscount();
	}
}
