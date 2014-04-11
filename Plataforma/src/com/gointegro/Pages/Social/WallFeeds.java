package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;


/**
 * Clase para manejar todos los feeds creados
 * @author gustavomoreira
 *
 */

public class WallFeeds extends PageBase {
	
	@FindBy (css = "span.social-feed-content")
	private WebElement feedcontent;
	
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
	
	
	
	/** Constructor */
	public WallFeeds(WebDriver driver) {
		super(driver);
		
	}
	
	/** Get url feed content */
	public String getURLFeed () {
		return feedurl.getAttribute("text");
	}
	
	/** Get simple feed content */
	public String getFeedContent () {
		return feedcontent.getText();
	}
	
	/** Get complete simple feed content */
	public String getPublicoEn () {
		return publicoen.getText();
	}
	
	/** Get Image Feed */
	public String getFeedImage() {
		return feedimagen.getAttribute("alt");
	}
	
	/** Get File name */
	public String getFileName() {
		return feedfiletitle.getText();
	}
	
	/** Get Descargar */
	public String getDescargarFile() {
		return feeddescargarfile.getText();
	}
	
	public void waitDeleteAction() {
		WaitTool.waitForElement(driver, By.xpath("//*[contains(@id,'feed-item-post')]//a[contains(@class, 'social-action-delete')]"), 5);
	}
	
	/** Select "Ver Mas" */
	public void selectViewMore() {
		viewmore.click();
	}
	
	/** Select "Ver Menos" */
	public void selectViewLess() {
		viewless.click();
	}

	/** Get texto sin ver mas */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(feedcontent.getText());
	}
	
	/** Click "Eliminar" */
	private void selectDeletePost() {
		deletepost.click();
	}
	
	/** Confirmar popup eliminar post */
	private void selectConfirmDeletePost() {
		WaitTool.waitForJQueryProcessing(driver, 5);
		confirmdelete.click();
	}
	
	private void selectCancelDeletePost() {
		WaitTool.waitForJQueryProcessing(driver, 5);
		canceldelete.click();
	}
	
	/** eliminar un post */
	public void deletePost() {
		selectDeletePost();
		selectConfirmDeletePost();
	}
	
	/** cancelar eliminar un post */
	public void deleteCancelPost() {
		selectDeletePost();
		selectCancelDeletePost();
	}
	
	/** Like a post */
	public void selectLikePost() {
		likepost.click();
	}
	
	/** Get Like status */
	public String getLikes() {
		return likes.getText();
	}
	
	/** Select user name like */
	public void selectLikeUser() {
		profilelikes.click();
	}
	
	/** Select "1 persona mas" */
	public ExcessLikers selectExcessLikers() {
		excesslikers.click();
		return PageFactory.initElements(driver, ExcessLikers.class);
	}
	
	/** Get display status like */
	public String likeDisplayed() {
		return likes.getCssValue("display");
	}
	
	/** Select mention */
	public Profile selectMentionSocialFeed() {
		feedmention.click();
		return PageFactory.initElements(driver, Profile.class);
	}
	

}
