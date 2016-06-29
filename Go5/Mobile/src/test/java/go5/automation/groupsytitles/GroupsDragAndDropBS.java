package go5.automation.groupsytitles;


import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class GroupsDragAndDropBS extends GroupsDragAndDrop {

	


	
	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build,"Test de Drag and Drop Grupos");
		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		
				
	 }
}