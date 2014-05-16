package com.gointegro.Pages.Profile;

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

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public OtherProfile(WebDriver driver) {
		super(driver);
		URL = ConfigElements.getURL()+"/profile/"+ConfigElements.getProfileOtherUser();
	}
	
	
	/** 
	 * Search in filelist a string 
	 * 
	 * @return boolean
	 * */
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
	
	/**
	 * Obtiene el listado de followers
	 * 
	 * @return String
	 */
	private String getfollowers () {
		return followers.getAttribute("outerHTML");
	}
	
	/**
	 * Obtener el listado de following
	 * @return String
	 */
	private String getfollowing () {
		return following.getAttribute("outerHTML");
	}
	
	
	/**
	 * Seleccionar solapa archivos
	 */
	public void selectArchivos() {
		linkArchivos.click();
	}
	
	/**
	 * Seleccionar el wall
	 */
	public void selectWall () {
		linkWall.click();
	}
	
	/**
	 * Buscar un archivo en el listado de archivos
	 * 
	 * @param searched
	 * @return boolean
	 */
	public boolean searchinfilelist (String searched) {
		return listOfFiles(searched);
	}
	
	/**
	 * Buscar un follower
	 * 
	 * @param follower
	 * @return boolean
	 */
	public boolean searchfollowers (String follower) {
		if (getfollowers().contains(follower))
			return true;
		else
			return false;
	}
	
	/**
	 * Buscar un usuario en following
	 * 
	 * @param following
	 * @return boolean
	 */
	public boolean searchfollowing (String following) {
		if (getfollowing().contains(following))
			return true;
		else
			return false;
	}
	
	/**
	 * Verificar estado del btn Follow
	 * 
	 * @return boolean
	 */
	public boolean isFollowBtnPresent() {
		return followbutton.isEnabled();
	}
	
	

}
