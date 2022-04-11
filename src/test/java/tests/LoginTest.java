package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.Retry;

public class LoginTest extends BaseTest{

    @Test(dataProvider = "getUsers", retryAnalyzer = Retry.class)
    public void addProductToCartTest(User user) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(user);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.clickAddToCartButton();
        productListPage.clickShoppingCartLink();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getItemNameInCart(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getItemPriceInCart(), "$29.99");
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
