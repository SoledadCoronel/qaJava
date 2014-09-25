package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;


/**
 * Page object que controla todos los feeds
 * 
 * @author gustavomoreira
 *
 */

public class WallFeeds extends PageBase {
	
	@FindBy (css = "span.social-feed-content")
	private WebElement feedcontent;
	
	String firstPost = "//span[@class='social-feed-content']";
	
	@FindBy (css = "p.feed-content > span")
	private WebElement publicoen;
	
	@FindBy (xpath = "//td[@class='url']/a")
	private WebElement feedurl;
	
	@FindBy (xpath = "//div[@class='img-like']/*[last()]")
	private WebElement feedimagen;
	
	@FindBy (css = "span.file-title")
	private WebElement feedfiletitle;
	
	@FindBy (xpath = "//table[@class='post-file']/tbody/tr[3]/td/a")
	private WebElement feeddescargarfile;
	
	@FindBy (className = "view-more")
	private WebElement viewmore;
	
	@FindBy (className = "view-less")
	private WebElement viewless;
	
	@FindBy (className = "social-action-delete")
	private WebElement deletepost;
	
	@FindBy (xpath = "/html/body/div[5]/div[3]/button")
	private WebElement confirmdelete;
	
	@FindBy (xpath = "/html/body/div[5]/div[3]/button[2]")
	private WebElement canceldelete;
	
	@FindBy (css = "a.like-post")
	private WebElement likepost;
	
	@FindBy (xpath = "//div[@class='like-stuff']/div[2]/section")
	private WebElement likes;
	
	@FindBy (xpath = "//div[@class='like-stuff']/div[2]/section/a")
	private WebElement profilelikes;
	
	@FindBy (className = "excess-likers")
	private WebElement excesslikers;
	
	@FindBy (xpath = "//div[@class='post-text-content']/p/span/span/a")
	private WebElement feedmention;
	
	@FindBy(xpath = "//div[@class='media']/div/p/a")
	private WebElement commentmention;
	
	@FindBy(className = "share-content")
	private WebElement sharecontent;
	
	@FindBy(xpath = "//div[@class='well-quote']/p")
	private WebElement contentpreview;
	
	@FindBy(xpath = "//p[@class='feed-content']/span/a[2]")
	private WebElement supublicacion;
	
	@FindBy(className = "original-text")
	private WebElement originaltext;
	
	@FindBy(xpath = "//div[@class='p']/div[2]/div/img")
	private WebElement originalimg;
	
	@FindBy(xpath = "//table[@class='post-file']/tbody/tr[3]/td/a")
	private WebElement originalfile;
	
	@FindBy(xpath = "//table[@class='post-link']/tbody/tr[2]/td/a")
	private WebElement originalurl;
	
	@FindBy(className = "media")
	private WebElement media;
	
	/**
	 * Constructor 
	 * 
	 * @param driver
	 */
	public WallFeeds(WebDriver driver) {
		super(driver);
		
	}
	
	
	/**
	 * Confirmar eliminar un post
	 */
	private void selectConfirmDeletePost() {
		WaitTool.waitForJQueryProcessing(driver, 5);
		confirmdelete.click();
	}
	
	/**
	 * Cancelar eliminar un post
	 */
	private void selectCancelDeletePost() {
		WaitTool.waitForJQueryProcessing(driver, 5);
		canceldelete.click();
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
	 * Obtiene el feedcontent
	 * 
	 * @return
	 */
	public String getFeedContent () {
		return feedcontent.getText();
	}
	
	/**
	 * Obtiene el "publico en"
	 * 
	 * @return
	 */
	public String getPublicoEn () {
		return publicoen.getText();
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
	 * Obtiene el nombre del archivo
	 * 
	 * @return
	 */
	public String getFileName() {
		return feedfiletitle.getText();
	}
	
	/**
	 * Obtiene el "Descargar + nombre archivo"
	 * 
	 * @return
	 */
	public String getDescargarFile() {
		return feeddescargarfile.getText();
	}
	
	/**
	 * Espera por la accion de eliminar
	 */
	public void waitDeleteAction() {
		WaitTool.waitForElement(driver, By.xpath("//*[contains(@id,'feed-item-post')]//a[contains(@class, 'social-action-delete')]"), 5);
	}
	
	/**
	 * Seleccionar ver mas
	 */
	public void selectViewMore() {
		viewmore.click();
	}
	
	/**
	 * Seleccionar ver menos
	 */
	public void selectViewLess() {
		viewless.click();
	}

	/**
	 * Obtener el texto sin ver mas
	 *  
	 * @return
	 */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(feedcontent.getText());
	}
	
	/**
	 * Seleccionar eliminar
	 */
	private void selectDeletePost() {
		deletepost.click();
	}
	
	/**
	 * Eliminar un post
	 */
	public void deletePost() {
		selectDeletePost();
		selectConfirmDeletePost();
	}
	
	/**
	 * Esperar que el post se cargue
	 * @param content
	 */
	public void waitForPost(String content) {
		WaitTool.waitForTextPresent(driver, By.xpath(firstPost), content, 20);
	}
	
	/**
	 * Cancelar eliminar un post
	 */
	public void deleteCancelPost() {
		selectDeletePost();
		selectCancelDeletePost();
	}
	
	/**
	 * Likear un post
	 */
	public void selectLikePost() {
		likepost.click();
	}
	
	/**
	 * Obtener el status de mi like
	 * 
	 * @return
	 */
	public String getLikes() {
		return likes.getText();
	}
	
	/**
	 * Seleccionar el like de un usuario
	 */
	public void selectLikeUser() {
		profilelikes.click();
	}
	
	/**
	 * Seleccionar "a una persona mas le gusta"
	 *  
	 * @return
	 */
	public ExcessLikers selectExcessLikers() {
		excesslikers.click();
		return PageFactory.initElements(driver, ExcessLikers.class);
	}
	
	/**
	 * Ver si el like esta mostrado
	 * 
	 * @return
	 */
	public String likeDisplayed() {
		return likes.getCssValue("display");
	}
	
	/**
	 * Seleccionar a quien le gusta algo
	 * 
	 * @return Profile
	 */
	public Profile selectMentionSocialFeed() {
		feedmention.click();
		return PageFactory.initElements(driver, Profile.class);
	}
	
	/**
	 * Seleccionar una persona mencionada en un coment
	 * 
	 * @return Profile
	 */
	public Profile selectMentionInComment() {
		commentmention.click();
		return PageFactory.initElements(driver, Profile.class);
	}
	
	/** 
	 * Seleccionar un hashtag
	 * 
	 * @param hashtag
	 * @return TagFeed
	 */
	public TagFeed selectHashtag(String hashtag){
		driver.findElement(By.linkText(hashtag)).click();
		return PageFactory.initElements(driver, TagFeed.class);
	}
	
	/**
	 * Seleccionar SharePost
	 * 
	 * @return SharePost
	 */
	public SharePost selectShareContent() {
		sharecontent.click();
		return PageFactory.initElements(driver, SharePost.class);
	}
	
	/**
	 * Obtener la preview de un contenido
	 * 
	 * @return String
	 */
	public String getContentPreview() {
		return contentpreview.getText();
	}
	
	/**
	 * Seleccionar el texto "su publicacion"
	 * 
	 * @return DetailPost
	 */
	public DetailPost selectSuPublicacion() {
		supublicacion.click();
		return PageFactory.initElements(driver, DetailPost.class);
	}
	
	/** 
	 * Obtener el texto original de un feed de shareo
	 * 
	 * @return String
	 */
	public String getOriginalText() {
		return originaltext.getText();
	}
	
	/**
	 * Obtener el nombre de la imagen original de un feed de shareo
	 * 
	 * @return String
	 */
	public String getOriginalImg() {
		return originalimg.getAttribute("alt");
	}
	
	/**
	 * Obtener el nombre original de un archivo de un feed de shareo
	 * 
	 * @return String
	 */
	public String getOriginalFile() {
		return originalfile.getText();
	}
	
	/** 
	 * Obtener un la url original de un feed de shareo
	 * 
	 * @return String
	 */
	public String getOriginalUrl() {
		return originalurl.getText();
	}
	
	/**
	 * Obtener el texto recortado de un feed de shareo
	 * 
	 * @return String
	 */
	public String getTextVerMasContentPreview() {
		return StringUtils.RecortarTextoVerMas(contentpreview.getText());
	}
	
	/**
	 * Obtener el media content
	 * 
	 * @return String
	 */
	public String getMediaContent() {
		return media.getText();
	}

}
