package go5.automation.espacios;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class UnirseAEspacioUserBasicNotDevelopYet extends EspacioUserBasicAbstractClass{
	
	
	
	@BeforeClass
	@Parameters(value={"browser","version","platform","url","build"})
	  public void setup(String browser, String version, String platform,String url,String build) throws Exception {
		
			this.setUpBrowserStack(browser, version, platform, url,build," Test Unirse a Espacio Basico");
	

	}
	
}	
	 
