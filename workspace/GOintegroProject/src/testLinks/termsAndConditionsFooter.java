package testLinks;

//Se importan librer’as necesarias
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//Se declara la clase del test
public class termsAndConditionsFooter {
	// Se declaran las variables
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
  @Before
  public void setUp() throws Exception {
  // Se setean las variables
  driver = new FirefoxDriver();
  baseUrl = "https://goc.gointegro.com/";
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testLinkTyC() throws Exception {
	// Iniciando el test
    driver.get(baseUrl + "/auth/signin");
    driver.findElement(By.linkText("TŽrminos y Condiciones")).click();
    Thread.sleep(1000);
    String capturedText = new String(driver.findElement(By.xpath("//div[@id='termsAndConditionsModal']/div[2]")).getText());
    
    // Se setea el texto de validaci—n esperado
    String expectedText = "Ser empleado de GoIntegro";
    
    // Se valida que el texto es el esperado
    if(capturedText.equals(expectedText)) {
    	System.out.println("termsAndConditionsFooter  [OK]");
    }
    else {
    	System.out.println("termsAndConditionsFooter  [FAIL]");
    }
    // Se cierra la ventana modal
    driver.findElement(By.xpath("//div[@id='termsAndConditionsModal']/div[3]/button")).click();
  }   

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
   
}
