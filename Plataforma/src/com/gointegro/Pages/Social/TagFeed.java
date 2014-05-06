package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;

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
	
	public TagFeed(WebDriver driver) {
		super(driver);
		
	}
	
	public String getFeedContent() {
		return feedcontent.getText();
	}
	
	public void closeModal() {
		closemodal.click();
	}
	
	public String getModalTitle() {
		return titlemodal.getText();
	}
	
	public String getFeedFullContent() {
		return feedfullcontent.getText();
	}
	
	public String getFeedFileTitle() {
		return feeddescargarfile.getText();
	}
	
	public String getFileName() {
		return feedfiletitle.getText();
	}
	
	public String getFeedImage() {
		return feedimagen.getAttribute("alt");
	}
	
	public String getURLFeed () {
		return feedurl.getAttribute("text");
	}
	
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(feedcontent.getText());
	}
	
	public DetailPost selectFeed() {
		feedcontent.click();
		return PageFactory.initElements(driver, DetailPost.class);
	}

}
