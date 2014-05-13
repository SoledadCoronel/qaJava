package com.gointegro.Pages.Social;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.StringUtils;


/**
 * Pageobject que maneja el overlay de share un post
 * 
 * @author gustavomoreira
 *
 */
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

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SharePost(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Completa el texto de share 
	 * 
	 * @param msj
	 */
	private void completeShareComment(String msj) {
		inputShareComment.clear();
		inputShareComment.sendKeys(msj);
	}
	
	/**
	 * Selecciona el boton de share
	 */
	private void selectShareBtn() {
		sharebtn.click();
	}
	
	
	/**
	 * Completa un share con el mensaje dado
	 * 
	 * @param msj
	 */
	public void completeShare (String msj) {
		completeShareComment(msj);
		selectShareBtn();
	}
	
	/**
	 * Obtiene el titulo del modal
	 * 
	 * @return
	 */
	public String getShareModalTitle() {
		return sharemodaltitle.getText();
	}
	
	/**
	 * Obtiene la imagen shareada
	 * 
	 * @return
	 */
	public String getSharedImg() {
		return sharedimg.getAttribute("alt");
	}
	
	/**
	 * Obtiene el file shareado
	 * 
	 * @return
	 */
	public String getSharedFile() {
		return sharedfile.getText();
	}
	
	/** 
	 * Obtiene la url shareada
	 * 
	 * @return
	 */
	public String getShareUrl() {
		return shareurl.getAttribute("text");
	}
	
	/**
	 * Obtiene el texto shareado
	 * 
	 * @return
	 */
	public String getSharedText() {
		return sharedtext.getText();
	}
	
	/** 
	 * Espera por la preview del link
	 */
	public void waitForLinkLoad () {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		// Estar hardcodeado el tiempo, habria que hacer un wait mas copado, pero no hay tiempo.
	}
	
	/**
	 * Recorta el texto ver mas para post extensos
	 * 
	 * @return
	 */
	public String getTextVerMas() {
		return StringUtils.RecortarTextoVerMas(sharedtext.getText());
	}
	
}
