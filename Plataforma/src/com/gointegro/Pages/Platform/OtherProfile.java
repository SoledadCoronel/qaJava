package com.gointegro.Pages.Platform;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Base.PageBase;

/**
 * Profile de otra persona, identico al propio salvo detalles como seguir.
 * 
 * @author gustavomoreira
 *
 */
public class OtherProfile extends PageBase{
	
	@FindBy (linkText = "Archivos")
	private WebElement linkArchivos;
	
	@FindBy (className = "table")
	private WebElement filetable;
	
	@FindBy (className = "followers-box")
	private WebElement followers;
	
	@FindBy (className = "following-box")
	private WebElement following;
	
	@FindBy (className = "wall")
	private WebElement linkWall;
	
	@FindBy (id = "follow-button")
	private WebElement followbutton;

	/** Constructor */
	public OtherProfile(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElements.getProfileOtherUser();
	}
	
	/** Select solapa Archivos */
	public void selectArchivos() {
		linkArchivos.click();
	}
	
	/** Select solapa Wall */
	public void selectWall () {
		linkWall.click();
	}
	
	/** Search a string in table files*/
	public boolean searchinfilelist (String searched) {
		return listOfFiles(searched);
	}
	
	/** Get list of followers */
	private String getfollowers () {
		return followers.getAttribute("outerHTML");
	}
	
	/** Search user in followers */
	public boolean searchfollowers (String follower) {
		if (getfollowers().contains(follower))
			return true;
		else
			return false;
	}
	
	
	/** Get list of followers */
	private String getfollowing () {
		return following.getAttribute("outerHTML");
	}
	
	/** Search user in followers */
	public boolean searchfollowing (String following) {
		if (getfollowing().contains(following))
			return true;
		else
			return false;
	}
	
	public boolean isFollowBtnPresent() {
		return followbutton.isEnabled();
	}
	
	/** Search in filelist a string */
	private boolean listOfFiles(String searched) {
		boolean status = false;
		
		List <WebElement> rowCollection = filetable.findElements(By.xpath("//*[@class='table']/tbody/tr"));
		
		for (WebElement rowElement : rowCollection) {
			List<WebElement> colCollection = rowElement.findElements(By.xpath("td"));
			
			for (WebElement colElement: colCollection){
				if (searched.contains(colElement.getAttribute("text"))){
					status = true;
					break;
				}
				
				else {
					status = false;
				}
			}
		}
		
		return status;
	}

}
