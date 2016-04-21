package go5.automation.espacios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class UnirseAEspacioUserBasic extends EspacioUserBasicAbstractClass{
	
	
	
	@BeforeClass
	@Parameters(value={"browser","version","platform","url","build"})
	  public void setup(String browser, String version, String platform,String url,String build) throws Exception {
		
			this.setUpBrowserStack(browser, version, platform, url,build);
	

	}
	
}	
	 
