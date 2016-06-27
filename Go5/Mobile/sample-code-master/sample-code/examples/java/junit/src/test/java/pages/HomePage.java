package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

    By search_button_locator = By.id(app_package_name + "menu_search");
    By search_textbox_locator = By.id(app_package_name + "autoCompleteTextView");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clearText(WebElement elementToBeCleared) {
        elementToBeCleared.sendKeys("x");
        elementToBeCleared.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elementToBeCleared.sendKeys(Keys.chord(Keys.BACK_SPACE));
    }

}
