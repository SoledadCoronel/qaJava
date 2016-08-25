package go5.automation.espacios;


import org.testng.annotations.BeforeClass;




public class BuscarEspaciosTest extends AgregarPersonasAEspacioAC {
	

	
	
	
	@BeforeClass // call function to open the browser and login 
	 public void setup () throws Exception{
		
		 this.setUpMaven();
	}
	
}
	

