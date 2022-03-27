package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LinkedInPage extends BasePage{

    private By linkedInLogo = By.xpath("//a[@class = 'nav__logo-link']");

    @Override
    public BasePage isPageLoaded() {
        try {
            driver.findElement(linkedInLogo);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("linkedin page not opened");
        }
        return this;
    }

    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    public By getLinkedInLogo() {
        return linkedInLogo;
    }

    public String getTitleText() {
        return driver.findElement(linkedInLogo).getText();
    }
}
