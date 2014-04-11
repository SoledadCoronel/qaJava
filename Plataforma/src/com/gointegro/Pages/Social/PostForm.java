package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmenteUploads;
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
	
	/** Constructor */
	public PostForm(WebDriver driver) {
		super(driver);
	}
	
	/** Complete post text */
	private void setText (String post) {
		textpost.clear();
		textpost.sendKeys(post);
	}
	
	/** Submit post */
	private void enterPost () {
		posttext.click();
	}
	
	/** Select post link */
	private void selectPostLink() {
		linkvinculo.click();
	}
	
	/** Complete link */
	private void completeLink (String link2) {
		link.clear();
		link.sendKeys(link2);
	}
	
	/** Complete post link */
	private void completePostLinkInput (String post) {
		postlink.clear();
		postlink.sendKeys(post);
	}
	
	/** Select post File */
	private void selectPostFile() {
		linkFile.click();
	}
	
	/** Complete attachment */
	private void completeAttachment(String file) {
		attachment.sendKeys(file);
	}
	
	/** Complete postfileinput */
	private void completePostFileInput(String post) {
		postfileinput.clear();
		postfileinput.sendKeys(post);
	}
	
	/** Submit postfile */
	private void submitPostFile() {
		postfile.click();
	}
	
	/** Complete File Title */
	private void completeFileTitle (String title) {
		postfiletitle.clear();
		postfiletitle.sendKeys(title);
	}
	
	
	/** Submit post link */
	public void submitPostLink () {
		postlinksubmit.click();
	}
	
	/** Aguardo que se cargue el preview */
	public void waitForLinkLoad () {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		// Estar hardcodeado el tiempo, habria que hacer un wait mas copado, pero no hay tiempo.
	}
	
	/** Get url text of preview */
	public String getURLPreview () {
		return urlTest.getText();
	}
	
	/** Get Disable status button */
	public String getDisableButton() {
		return posttext.getAttribute("disable");
	}
	
	/** Get Placeholder */
	public String getPlaceholder() {
		return textpost.getAttribute("placeholder");
	}
	
	/** Get Alt from feed */
	public String getImageFeed() {
		return feedimagen.getAttribute("alt");
	}
	
	
	
	/** Complete post simple */
	public void completePost (String post){
		setText(post);
		enterPost();
	}
	
	/** Complete post Link */
	public void completePostLink (String link, String post) {
		selectPostLink();
		WaitTool.waitForElement(driver, By.id("post-link-input"), 3);
		completeLink(link);
		completePostLinkInput(post);
	}
	
	/** Complete post File Imagen */
	public void completePostFileImagen (String post, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmenteUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmenteUploads.waitBar(driver);
		completePostFileInput(post);
		submitPostFile();
	}
	
	/** Complete post File */
	public void completePostFile(String post, String title, String file) {
		selectPostFile();
		WaitTool.waitForElementPresent(driver, By.id("attachmentUpload"), 3);
		AttachmenteUploads.SocialWallAttachment(driver);
		completeAttachment(file);
		AttachmenteUploads.waitBar(driver);
		completeFileTitle(title);
		completePostFileInput(post);
		submitPostFile();
	}
	
	public void completePostMention(String post, String mention) {
		String posteo = "@"+ mention;
		setText(posteo);
		WaitTool.waitForJQueryProcessing(driver, 5);
		mentionlist.click();
		textpost.sendKeys(" "+post);
		enterPost();
	}
	

}
