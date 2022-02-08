
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void addProductToCartTest() {
        driver = new ChromeDriver();
        driver.get(Constants.URL);
        Page page = new Page();
        WebElement userNameInput = driver.findElement(page.userNameInput);
        userNameInput.sendKeys(Constants.USERNAME);

        WebElement passwordInput = driver.findElement(page.passwordInput);
        passwordInput.sendKeys(Constants.PASSWORD);

        WebElement loginButton = driver.findElement(page.loginButton);
        loginButton.click();

        WebElement addToCartButton = driver.findElement(page.addToCartButton);
        addToCartButton.click();

        WebElement shoppingCartLink = driver.findElement(page.shoppingCartLink);
        shoppingCartLink.click();

        String itemNameInCart = driver.findElement(page.itemNameInCart).getText();
        String itemPriceInCart = driver.findElement(page.itemPriceInCart).getText();
        Assert.assertEquals(itemNameInCart, "Sauce Labs Backpack");
        Assert.assertEquals(itemPriceInCart, "$29.99");
    }
}
