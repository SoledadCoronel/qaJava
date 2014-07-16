package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

/**
 * Class with only de div post-form
 * 
 * @author gustavomoreira
 *
 */

public class PostForm extends PageBase{

	@FindBy (name = "text")
	private WebElement textpost;
	
	@FindBy (name = "post-text")
	private WebElement posttext;
	
	@FindBy (linkText = "Vínculo")
	private WebElement linkvinculo;
	
	@FindBy (name = "link")
	private WebElement link;
	
	@FindBy (id = "post-link-input")
	private WebElement postlink;
	
	@FindBy (name = "post-link")
	private WebElement postlinksubmit;
	
	@FindBy (xpath = "//table[@class='post-link']/tbody/tr[2]/td/a")
	private WebElement urlTest;
	
	@FindBy (linkText = "Archivo")
	private WebElement linkFile;
	
	@FindBy (id = "attachmentUpload")
	private WebElement attachment;
	
	@FindBy (id = "post-file-input")
	private WebElement postfileinput;
	
	@FindBy (name = "post-file")
	private WebElement postfile;
	
	@FindBy (name = "file-title")
	private WebElement postfiletitle;
	
	@FindBy (xpath = "//td[@class='url']/a")
	private WebElement feedurl;
	
	@FindBy (xpath = "//div[@class='img-like']/*[last()]")
	private WebElement feedimagen;
	
	@FindBy (css = "div.mentions-autocomplete-list > ul > li.active")
	private WebElement mentionlist;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PostForm(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Completa el texto de un post con el parametro que se le paso
	 * 
	 * @param post
	 */
	private void setText (String post) {
		textpost.clear();
		textpost.sendKeys(post);
	}
	
	/**
	 * Confirma el envio del post
	 */
	private void enterPost () {
		posttext.click();
	}
	
	/**
	 * Selecciona el tab Post-Link
	 */
	private void selectPostLink() {
		linkvinculo.click();
	}
	
	/**
	 * Completa el link de un post de link con el parametro enviado
	 * 
	 * @param link2
	 */
	private void completeLink (String link2) {
		link.clear();
		link.sendKeys(link2);
	}
	
	/**
	 * Completa el texto de un post de link con el parametro enviado
	 * 
	 * @param post
	 */
	private void completePostLinkInput (String post) {
		postlink.clear();
		postlink.sendKeys(post);
	}
	
	/**
	 * Selecciona el tab Post-File
	 */
	private void selectPostFile() {
		linkFile.click();
	}
	
	/**
	 * Completa el attachment de un Post-File
	 * 
	 * @param file
	 */
	private void completeAttachment(String file) {
		attachment.sendKeys(file);
	}
	
	/**
	 * Completa el texto de un post de file con el parametro enviado
	 * 
	 * @param post
	 */
	private void completePostFileInput(String post) {
		postfileinput.clear();
		postfileinput.sendKeys(post);
	}
	
	/**
	 * Envia el post
	 */
	private void submitPostFile() {
		postfile.click();
	}
	
	/**
	 * Completa el titulo de un archivo no imagen
	 * 
	 * @param title
	 */
	private void completeFileTitle (String title) {
		postfiletitle.clear();
		postfiletitle.sendKeys(title);
	}
	
	/**
	 * Selecciona un usuario para mencionar y le agrega un texto de post
	 * 
	 * @param post
	 * @param mention
	 */
	private void selectMention(String post, String mention) {
		String posteo = "@"+ mention;
		setText(posteo);
		WaitTool.waitForJQueryProcessing(driver, 5);
		mentionlist.click();
		textpost.sendKeys(" "+post);
	}
	
	/**
	 * Selecciona un usuario para mencionar y le agrega un texto de post
	 * 
	 * @param post
	 * @param mention
	 */
	private void selectMentionImg(String post, String mention) {
		String posteo = "@"+ mention;
		completePostFileInput(posteo);
		WaitTool.waitForJQueryProcessing(driver, 5);
		mentionlist.click();
		postfileinput.sendKeys(" "+post);
	}
	
	
	/**
	 * Envia un post de link
	 */
	public void submitPostLink () {
		postlinksubmit.click();
	}
	
	/**
	 * Aguarda a que se cargue el preview del post link
	 */
	public void waitForLinkLoad () {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		//TODO 
		//Estar hardcodeado el tiempo, habria que hacer un wait mas copado, pero no hay tiempo.
	}
	
	/**
	 * Obtiene la preview mostrada en el form de post
	 * 
	 * @return
	 */
	public String getURLPreview () {
		return urlTest.getText();
	}
	
	/**
	 * Obtiene el estado del boton publicar
	 * 
	 * @return
	 */
	public String getDisableButton() {
		return posttext.getAttribute("disable");
	}
	
	/**
	 * Obtiene el placeholder del textpost
	 * 
	 * @return
	 */
	public String getPlaceholder() {
		return textpost.getAttribute("placeholder");
	}
	
	/**
	 * Obtiene el nobmre de la imagen preview
	 * 
	 * @return
	 */
	public String getImageFeed() {
		return feedimagen.getAttribute("alt");
	}

	/**
	 * Completa un post de texto
	 * 
	 * @param post
	 */
	public void completePost (String post){
		setText(post);
		enterPost();
	}
	
	/**
	 * Completa un post de link con el link y el texto
	 * 
	 * @param link
	 * @param post
	 */
	public void completePostLink (String link, String post) {
		selectPostLink();
		WaitTool.waitForElement(driver, By.id("post-link-input"), 3);
		completeLink(link);
		completePostLinkInput(post);
	}
	
	/**
	 * Completa un post de imagen
	 * 
	 * @param post
	 * @param file
	 */
	public void completePostFileImagen (String post, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmentUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmentUploads.waitBar(driver);
		completePostFileInput(post);
		submitPostFile();
	}
	
	/**
	 * Completa un post de archivo
	 * 
	 * @param post
	 * @param title
	 * @param file
	 */
	public void completePostFile(String post, String title, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmentUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmentUploads.waitBar(driver);
		completeFileTitle(title);
		completePostFileInput(post);
		submitPostFile();
	}
	
	/**
	 * Completa un post simple con una mencion
	 * 
	 * @param post
	 * @param mention
	 */
	public void completePostMention(String post, String mention) {
		selectMention(post, mention);
		enterPost();
	}
	
	/**
	 * Completa un post de img con una mencion
	 * 
	 * @param post
	 * @param mention
	 * @param file
	 */
	public void completePostImageMention(String post, String mention, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmentUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmentUploads.waitBar(driver);
		selectMentionImg(post, mention);
		submitPostFile();
	}
	
	/**
	 * Completa un post de file con una mencion
	 * 
	 * @param post
	 * @param mention
	 * @param file
	 */
	public void completePostFileMention(String post, String mention, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmentUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmentUploads.waitBar(driver);
		selectMentionImg(post, mention);
		submitPostFile();
	}

}
