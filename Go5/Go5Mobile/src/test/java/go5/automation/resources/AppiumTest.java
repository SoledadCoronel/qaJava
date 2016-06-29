package go5.automation.resources;

import go5.automation.mobile.pages.LandingPage;
import go5.automation.mobile.pages.LoginPageExample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumTest extends AndroidSetup {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void falseLoginTest() throws InterruptedException
    {
        new LoginPageExample(driver).invalidLogin();
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

    @Test
    public void testSwipeOnHomePage()  {
        new LandingPage(driver).swipeFromLeftToPullMenu();

    }

    @Test
    public  void testScrollUponHomePageAndTapAction(){
        new LandingPage(driver).scrollPageUpAndClickOnRefrigerator();

    }
}

