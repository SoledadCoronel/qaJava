package go5.automation.social;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class MuroSocialProfileBS extends MuroSocialProfileAC {
	
	
		
	
	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build,"Test de Muro Social en perfil de usuario");
		
	}
}

