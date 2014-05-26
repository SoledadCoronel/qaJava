package com.gointegro.Pages.Content;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

/**
 * Menu lateral con el listado de contenidos
 * 
 * @author diogodarosa
 *
 */
public class ContentList extends PageBase {
	
	
	@FindBy(xpath = "//*[@id=\"middle-section\"]/aside/div/ul/li/a")
	WebElement title;
	
	@FindBy(xpath = "//ul[@class='nav nav-list']/li")
	List<WebElement> allContentList;
	
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public ContentList(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Obtiene el titulo del contenido en el menu lateral
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}

	
	/**
	 * Obtiene un listado con todos los contenidos del menu lateral
	 * 
	 * @return List
	 */
	public List<WebElement> getContentList() {
		return allContentList;
	}
	
	
	/**
	 * Obtiene el index del titulo en la lista de contenidos
	 * 
	 * @param allElements
	 * @param titulo
	 * @return int
	 */
	public int findInList(List<WebElement> allElements, String titulo) {
		int counter = 0;

		for (WebElement element: allElements) {
		      if (element.getText().contains(titulo)){
		    	  break;
		      }
		      else {
		    	  counter++;
		      }
		}
		return counter;
	}
}
