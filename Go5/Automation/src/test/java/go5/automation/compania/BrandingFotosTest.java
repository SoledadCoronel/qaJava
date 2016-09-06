package go5.automation.compania;




import org.testng.annotations.BeforeClass;




public class BrandingFotosTest extends BrandingFotosAC{

	
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		this.setUpMaven();
	 }	
		
	 
}