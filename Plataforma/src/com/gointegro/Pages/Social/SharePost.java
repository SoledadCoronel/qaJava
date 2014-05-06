package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;

public class SharePost extends PageBase{
	
	@FindBy(xpath = "//div[@id='sharepost']//div[@class='modal-header']/h3")
	private WebElement sharemodaltitle;
	
	@FindBy(xpath = "//div[@id='sharepost']//div[@class='mentions-input-box']/textarea")
	private WebElement inputShareComment;
	
	@FindBy(id = "share-btn")
	private WebElement sharebtn;
	
	@FindBy(xpath = "//div[@id='sharepost']//section[@class='shared-from']//div[@class='img-like']/img")
	private WebElement sharedimg;
	
	@FindBy(xpath = "//div[@id='sharepost']//table[@class='post-file']/tbody/tr[3]/td/a")
	private WebElement sharedfile;
	
	@FindBy(xpath = "//div[@id='sharepost']//div[@class='']/a[2]")
	private WebElement cancelsharebtn;
	
	@FindBy (xpath = "//div[@id='sharepost']//td[@class='url']/a")
	private WebElement shareurl;
	
	@FindBy(xpath = "//div[@id='sharepost']//div[@class='well-quote']/p")
	private WebElement sharedtext;

	public SharePost(WebDriver driver) {
		super(driver);
	}
	
	public String getShareModalTitle() {
		return sharemodaltitle.getText();
	}
	
	private void completeShareComment(String msj) {
		inputShareComment.clear();
		inputShareComment.sendKeys(msj);
	}
	
	private void selectShareBtn() {
		sharebtn.click();
	}
	
	public void completeShare (String msj) {
		completeShareComment(msj);
		selectShareBtn();
	}
	
	public String getSharedImg() {
		return sharedimg.getAttribute("alt");
	}
	
	public String getSharedFile() {
		return sharedfile.getText();
	}
	
	public String getShareUrl() {
		return shareurl.getAttribute("text");
	}
	
	public String getSharedText() {
		return sharedtext.getText();
	}
	
	public void waitForLinkLoad () {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		// Estar hardcodeado el tiempo, habria que hacer un wait mas copado, pero no hay tiempo.
	}
	
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(sharedtext.getText());
	}


}
