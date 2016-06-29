package go5.automation.espacios;


import org.testng.annotations.BeforeClass;




public class BuscarEspaciosTest extends BuscarEspaciosAC {
	

	
	
	
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
}
	

