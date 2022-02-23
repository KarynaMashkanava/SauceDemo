package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By itemNameInCart = By.xpath("//div[@class='inventory_item_name']");
    private By itemPriceInCart = By.xpath("//div[@class = 'inventory_item_price']");

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
