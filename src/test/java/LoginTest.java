import models.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "getUsers")
    public void addProductToCartTest(User user) throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(user);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.clickAddToCartButton();
        productListPage.clickShoppingCartLink();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getItemNameInCart(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getItemPriceInCart(), "$29.99");
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot_" + new Random().nextInt() + ".png"), sourceFile);
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][] {
            {User.builder().username(Constants.STANDARD_USER).password(Constants.PASSWORD).build()},
            {User.builder().username(Constants.PROBLEM_USER).password(Constants.PASSWORD).build()},
            {User.builder().username(Constants.LOCKED_OUT_USER).password(Constants.PASSWORD).build()},
            {User.builder().username(Constants.PERFORMANCE_GLITCH_USER).password(Constants.PASSWORD).build()},
        };
    }
}
