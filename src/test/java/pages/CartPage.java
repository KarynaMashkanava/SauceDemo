package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By itemNameInCart = By.xpath("//div[@class='inventory_item_name']");
    private By itemPriceInCart = By.xpath("//div[@class = 'inventory_item_price']");
    private By checkoutButton = By.id("checkout");

    @Override
    public BasePage isPageLoaded() {
        try {
            driver.findElement(checkoutButton);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("cart page not opened");
        }
        return this;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemNameInCart() {
        return driver.findElement(itemNameInCart).getText();
    }

    public String getItemPriceInCart() {
        return driver.findElement(itemPriceInCart).getText();
    }
}
