import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Page {

    public By shoppingCartLink = By.className("shopping_cart_link");
    public By linkTwitter = By.linkText("Twitter");
    public By linkLinkedIn = By.partialLinkText("Linked");
    public By bodyElement = By.tagName("body");
    public By itemNameInCart = By.xpath("//div[@class='inventory_item_name']");
    public By itemPriceInCartTestLocator = By.xpath("//div[text()='9.99']");
    public By itemPriceInCart = By.xpath("//div[@class = 'inventory_item_price']");
    public By removeButton = By.xpath("//button[contains(@class,'cart_button')]");
    public By inventoryContainer = By.xpath("//div[@id='inventory_container']/ancestor::div[@id='inventory_container']");
    public By cancelButton = By.xpath("//img/parent::button");
    public By userName = By.xpath("//input[@class='input_error form_input error' and @type='text']");
    public By userNameInput = By.cssSelector("#user-name");
    public By passwordInput = By.cssSelector("[placeholder^=Pass]");
    public By loginButton = By.cssSelector(".submit-button");
    public By addToCartButton = By.cssSelector("[data-test$=backpack]");
    public By productName = By.cssSelector("[class*=name]");
    public By firstProductOnPage = By.cssSelector(".inventory_item:first-child");
    public By thirdProductOnPage = By.cssSelector(".inventory_item:nth-child(3)");
    public By yourCart = By.cssSelector("span");


}
