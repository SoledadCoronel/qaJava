package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;

/**
 * Pageobject que maneja el overlay con feeds
 * 
 * @author gustavomoreira
 *
 */
public class TagFeed extends PageBase{
	
	@FindBy (xpath = "//div[@id='tag-feed']//*[@class='feed-content']/span/span")
	private WebElement feedcontent;
	
	@FindBy (xpath = "//div[@id='tag-feed']//div[@class='modal-footer']/a")
	private WebElement closemodal;
	
	@FindBy (xpath = "//div[@id='tag-feed']//div[@class='modal-header']/h3")
	private WebElement titlemodal;
	
	@FindBy (xpath = "//div[@id='tag-feed']//*[@class='feed-content']/span")
	private WebElement feedfullcontent;
	
	@FindBy (xpath = "//table[@class='post-file']/tbody/tr[3]/td/a")
	private WebElement feeddescargarfile;
	
	@FindBy (css = "span.file-title")
	private WebElement feedfiletitle;
	
	@FindBy (xpath = "//div[@class='img-like']/*[last()]")
	private WebElement feedimagen;
	
	@FindBy (xpath = "//td[@class='url']/a")
	private WebElement feedurl;
	
	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public TagFeed(WebDriver driver) {
		super(driver);
		
	}
	
	/**
	 * Obtiene el feed content
	 * 
	 * @return
	 */
	public String getFeedContent() {
		return feedcontent.getText();
	}
	
	/**
	 * Cierra el modal
	 */
	public void closeModal() {
		closemodal.click();
	}
	
	/**
	 * Obtiene el titulo del modal
	 * 
	 * @return
	 */
	public String getModalTitle() {
		return titlemodal.getText();
	}
	
	/**
	 * Obtiene todo el feed content
	 * 
	 * @return
	 */
	public String getFeedFullContent() {
		return feedfullcontent.getText();
	}
	
	/**
	 * Obtiene el Titulo del archivo con descargar
	 * 
	 * @return
	 */
	public String getFeedFileTitle() {
		return feeddescargarfile.getText();
	}
	
	/**
	 * Obtiene le nombre del archivo
	 * 
	 * @return
	 */
	public String getFileName() {
		return feedfiletitle.getText();
	}
	
	/**
	 * Obtiene el nombre de la imagen
	 * 
	 * @return
	 */
	public String getFeedImage() {
		return feedimagen.getAttribute("alt");
	}
	
	/**
	 * Obtiene la url del feed
	 * 
	 * @return
	 */
	public String getURLFeed () {
		return feedurl.getAttribute("text");
	}
	
	/**
	 * Obtiene el texto de ver mas
	 * 
	 * @return
	 */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(feedcontent.getText());
	}
	
	/**
	 * Selecciona un post del modal
	 * 
	 * @return
	 */
	public DetailPost selectFeed() {
		feedcontent.click();
		return PageFactory.initElements(driver, DetailPost.class);
	}

}
