package go5.automation.espacios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class CrearEspacioAdminEspaciosBS extends CrearEspacioAC {

	
	
	@BeforeClass
	@Parameters(value={"browser","version","platform","url","build"})
	  public void setup(String browser, String version, String platform,String url,String build) throws Exception {
	  		this.setUpBrowserStackAdminEspacio(browser, version, platform, url, build);
	 }
	      		
     }

