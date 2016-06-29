package go5.automation.mobile.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageExample extends BasePage {
    By userId = By.id(app_package_name + "user_id");
    By password = By.id(app_package_name + "user_password");
    By showPassword = By.id(app_package_name + "show_password");
    By login_Button = By.id(app_package_name + "btn_login");

    public LoginPageExample(WebDriver driver) {
        super(driver);
    }

    public LoginPageExample invalidLogin() {
        waitForVisibilityOf(userId);
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(showPassword).click();
        driver.findElement(login_Button).click();
        return new LoginPageExample(driver);
    }
}
