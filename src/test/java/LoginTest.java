import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class LoginTest extends BaseTest{

    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(Constants.USERNAME);
        loginPage.typePassword(Constants.PASSWORD);
        loginPage.clickSubmitButton();

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.clickAddToCartButton();
        productListPage.clickShoppingCartLink();

        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getItemNameInCart(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getItemPriceInCart(), "$29.99");
    }
}
