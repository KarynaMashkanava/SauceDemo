package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ProductListPage extends BasePage{

    private By addToCartButton = By.cssSelector("[data-test$=backpack]");
    private By shoppingCartLink = By.className("shopping_cart_link");
    private By linkedInLink = By.xpath("//a[text()='LinkedIn']");

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
    }

    public LinkedInPage openLinkedIn() {
        driver.findElement(linkedInLink).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new LinkedInPage(driver);
    }


}
