package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ProductListPage extends BasePage{

    private By addToCartButton = By.cssSelector("[data-test$=backpack]");
    private By shoppingCartLink = By.className("shopping_cart_link");
    private By linkedInLink = By.xpath("//a[text()='LinkedIn']");

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageLoaded() {
        try {
            driver.findElement(shoppingCartLink);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("product list page not opened");
        }
        return this;
    }

    public ProductListPage clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

    public LinkedInPage openLinkedIn() {
        driver.findElement(linkedInLink).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new LinkedInPage(driver);
    }


}
