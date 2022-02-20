package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage extends BasePage{

    private By addToCartButton = By.cssSelector("[data-test$=backpack]");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
    }

}
