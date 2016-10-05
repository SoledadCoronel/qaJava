package go5.automation.espacios;



import org.testng.annotations.BeforeClass;


public class EditarEspacioTest extends EditarEspacioAC {
	
		
	

	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
}
