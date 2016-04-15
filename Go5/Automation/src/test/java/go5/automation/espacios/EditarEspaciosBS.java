package go5.automation.espacios;



import go5.pageObjects.EspacioPage;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class EditarEspaciosBS extends EditarEspaciosAC {
	
	

	
	EspacioPage espacio=null;
	

	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url, build);
	   
	}	
	
}
