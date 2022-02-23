package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameInput = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("[placeholder^=Pass]");
    private By loginButton = By.cssSelector(".submit-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmitButton() {
        driver.findElement(loginButton).click();
    }
}
