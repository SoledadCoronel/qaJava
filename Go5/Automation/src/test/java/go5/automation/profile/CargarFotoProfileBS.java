package go5.automation.profile;




import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class CargarFotoProfileBS extends CargarFotoProfile {
	
	
	
	 @BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build);
		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
	
 }
 
  
}