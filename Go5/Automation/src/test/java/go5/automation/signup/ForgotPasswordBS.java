package go5.automation.signup;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class ForgotPasswordBS extends ForgotPasswordAC{
	
		

	@BeforeClass
	  @Parameters(value={"browser","version","platform","url","build"})
	  public void setUp(String browser, String version, String platform,String url,String build) throws Exception {
		this.setUpBrowserStack(browser, version, platform, url,build,"Test Forgot Password");
				 
}

}