package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By userNameInput = By.cssSelector("#user-name");
    private By passwordInput = By.cssSelector("[placeholder^=Pass]");
    private By loginButton = By.cssSelector(".submit-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageLoaded() {
        try {
            driver.findElement(loginButton);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("login page not opened");
        }
        return this;
    }

    public LoginPage typeUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public ProductListPage clickSubmitButton() {
        driver.findElement(loginButton).click();
        return new ProductListPage(driver);
    }

    public ProductListPage logIn(User user) {
        typeUserName(user.getUsername());
        typePassword(user.getPassword());
        clickSubmitButton();
        return new ProductListPage(driver);
    }
}
