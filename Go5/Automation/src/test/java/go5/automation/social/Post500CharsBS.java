package go5.automation.social;




import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Post500CharsBS extends Post500CharsAC {
	
				

	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build,"Test de Postear mas de 500 Chars");
		
}
	
}	