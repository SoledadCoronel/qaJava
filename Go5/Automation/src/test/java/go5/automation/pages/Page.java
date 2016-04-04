package go5.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

	
	protected String inputmailLogin = new String (".session label:nth-child(2) input");
	protected String inputPasswordLogin = new String (".session label:nth-child(3) input");
	protected String goButton = new String (".session .primary");
	
	protected String strCssConfiguration= new String(".applications .users .configuration");
	protected String irAMenu =new String (".menu");
	protected String irAPagina= new String("a[title='Ir a la página 4']");
	protected String irASpaces = new String ("a[title='Ir a listar espacios']");
	protected String searchButton = new String(".actions .search .btnsearch");
	protected String inputSearch = new String(".actions .search input");
	protected String orden =new String (".tables thead tr th:nth-child(2) a");
	protected String firstRow= new String(".tables tbody tr:nth-child(1) td:nth-child(2)");
	protected String secondRow= new String(".tables tbody tr:nth-child(2) td:nth-child(2)");  
	
    public void goElements(){
    	
    	//WebElement element = driver.findElement(By.id("userName"));
    
    
	  
}
	}
