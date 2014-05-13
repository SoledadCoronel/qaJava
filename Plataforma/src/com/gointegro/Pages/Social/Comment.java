package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

/**
 * Page que maneja todo el componente de comments
 * 
 * @author gustavomoreira
 *
 */

public class Comment extends PageBase{

	@FindBy (name = "comment-content")
	private WebElement commentcontent;
	
	@FindBy (css = "p.comment-content")
	private WebElement commentcreated;
	
	@FindBy (name = "comment-delete")
	private WebElement commentdelete;
	
	@FindBy (className = "view-more")
	private WebElement viewmore;
	
	@FindBy (className = "view-less")
	private WebElement viewless;
	
	@FindBy (xpath = "//div[@class='like-bar']/span[3]/a")
	private WebElement likecomment;
	
	@FindBy (className = "excess-likers")
	private WebElement excesslikers;
	
	@FindBy (className = "numeric-like-count")
	private WebElement likecount;
	
	@FindBy (css = "div.mentions-autocomplete-list > ul > li.active")
	private WebElement mentionlist;
	
	@FindBy (xpath = "//div[@class='feed-comments']/div/a")
	private WebElement excesscomments;
	
	@FindBy (className = "feed-comments")
	private WebElement feedcomments;
	
	/** 
	 * Constructor 
	 * 
	 * */
	public Comment(WebDriver driver) {
		super(driver);
	}
	
	
	
	/** 
	 * Complete comment box 
	 * 
	 * */
	private void setComment(String comment) {
		commentcontent.clear();
		commentcontent.sendKeys(comment+"\n");
	}
	
	/**
	 * Selection user in mention list
	 * 
	 * */
	private void selectMention(String post, String mention) {
		String posteo = "@"+ mention;
		commentcontent.clear();
		commentcontent.sendKeys(posteo);
		WaitTool.waitForJQueryProcessing(driver, 5);
		mentionlist.click();
		commentcontent.sendKeys(" "+post+"\n");
	}
	
	
	
	/** 
	 * Complete comment 
	 * 
	 * */
	public void completeComment (String comment) {
		setComment(comment);
		
	}
	
	/** 
	 * Get comment 
	 * */
	public String getTextComment () {
		return commentcreated.getText();
	}
	
	/** 
	 * Get placeholder 
	 * 
	 * */
	public String getPlaceholder() {
		return commentcontent.getAttribute("placeholder");
	}
	
	/** 
	 * Select delete comment 
	 * 
	 * */
	public void deleteCommment() {
		commentdelete.click();
	}
	
	/** 
	 * Get texto sin ver mas 
	 * 
	 * */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(commentcreated.getText());
	}
	
	/** 
	 * Select view more 
	 * 
	 * */
	public void selectViewMore() {
		viewmore.click();
	}
	
	/** 
	 * Select view less 
	 * 
	 * */
	public void selectViewLess() {
		viewless.click();
	}
	
	/** 
	 * Select like comment 
	 * 
	 * */
	public void selectLikeComment() {
		likecomment.click();
	}
	
	/** 
	 * View Ya no me gusta 
	 * 
	 * */
	public String getTextLikeComment() {
		return likecomment.getText();
	}
	
	/** 
	 * Get likers comment 
	 * 
	 * */
	public ExcessLikers selectExcessLikers() {
		excesslikers.click();
		return PageFactory.initElements(driver, ExcessLikers.class);
	}
	
	/**
	 * Ver si el like count esta display
	 * @return
	 */
	public String likecommentisDisplayed() {
		return likecount.getCssValue("display");
	}
	
	/**
	 * Completar una mencion en un comment
	 * 
	 * @param comment
	 * @param mention
	 */
	public void completCommentMention(String comment, String mention) {
		selectMention(comment, mention);
	}
	
	/**
	 * Acceder a un hashtag, esto debe mostrar el muro de hashtags
	 * 
	 * @param hashtag
	 * @return
	 */
	public TagFeed selectHashtag(String hashtag){
		driver.findElement(By.linkText(hashtag)).click();
		return PageFactory.initElements(driver, TagFeed.class);
	}
	
	/**
	 * Muestra si esta disponible el Excess Comments
	 * 
	 * @return
	 */
	public boolean isDisplayedExcessComments() {
		return excesscomments.isDisplayed();
	}
	
	/**
	 * Seleccionar el Excess Comments para ver todos
	 * 
	 */
	public void selectExcessComments() {
		excesscomments.click();
	}
	
	/**
	 * Obtener el comment 
	 * 
	 * @return
	 */
	public String getfeedComments() {
		return feedcomments.getText();
	}

}
