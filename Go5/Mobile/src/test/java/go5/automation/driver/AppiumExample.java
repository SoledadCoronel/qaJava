package go5.automation.driver;
import go5.pageObjects.*;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumExample extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

   
    @Test
    public void testProductSearch(){

   //     new LandingPage(driver).chooseToBrowseItems()
   //                             .searchFor("iphone");
    }


    @Test
    public void testAddToCart(){
     //   new LandingPage(driver).chooseToBrowseItems()
     //           .searchFor("iphone")
      //          .selectFirstResultFor("iphone")
      //          .addToCart("iphone")
      //          .verifyCartShowsTheCount();
    }

    

}

