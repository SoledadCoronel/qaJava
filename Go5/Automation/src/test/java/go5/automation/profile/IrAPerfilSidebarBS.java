package go5.automation.profile;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class IrAPerfilSidebarBS extends IrAPerfilSidebarAC {
	


	
 @BeforeClass
  @Parameters(value={"browser","version","platform","url","build"})
  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
	this.setUpBrowserStack(browser, version, platform, url,build);
	
 }
 }
   
