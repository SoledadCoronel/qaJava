package com.gointegro.Pages.Social;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

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
	
	/** Complete comment box */
	private void setComment(String comment) {
		commentcontent.clear();
		commentcontent.sendKeys(comment+"\n");
	}
	
	/** Constructor */
	public Comment(WebDriver driver) {
		super(driver);
	}
	
	/** Complete comment */
	public void completeComment (String comment) {
		setComment(comment);
		
	}
	
	/** Get comment */
	public String getTextComment () {
		return commentcreated.getText();
	}
	
	/** Get placeholder */
	public String getPlaceholder() {
		return commentcontent.getAttribute("placeholder");
	}
	
	/** Select delete comment */
	public void deleteCommment() {
		commentdelete.click();
	}
	
	/** Get texto sin ver mas */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(commentcreated.getText());
	}
	
	/** Select view more */
	public void selectViewMore() {
		viewmore.click();
	}
	
	/** Select view less */
	public void selectViewLess() {
		viewless.click();
	}
	
	/** Select like comment */
	public void selectLikeComment() {
		likecomment.click();
	}
	
	/** View Ya no me gusta */
	public String getTextLikeComment() {
		return likecomment.getText();
	}
	
	/** Get likers comment */
	public ExcessLikers selectExcessLikers() {
		excesslikers.click();
		return PageFactory.initElements(driver, ExcessLikers.class);
	}
	
	public String likecommentisDisplayed() {
		return likecount.getCssValue("display");
	}
	
	public void completCommentMention(String comment, String mention) {
		selectMention(comment, mention);
	}
	
	/** Selection user in mention list*/
	private void selectMention(String post, String mention) {
		String posteo = "@"+ mention;
		commentcontent.clear();
		commentcontent.sendKeys(posteo);
		WaitTool.waitForJQueryProcessing(driver, 5);
		mentionlist.click();
		commentcontent.sendKeys(" "+post+"\n");
	}
	
	public TagFeed selectHashtag(String hashtag){
		driver.findElement(By.linkText(hashtag)).click();
		return PageFactory.initElements(driver, TagFeed.class);
	}
	
	

}
