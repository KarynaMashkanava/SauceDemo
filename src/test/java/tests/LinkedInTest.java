package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInPage;
import pages.LoginPage;
import pages.ProductListPage;
import utils.Retry;

import java.util.concurrent.TimeUnit;

public class LinkedInTest extends BaseTest{

    private final String logoText = "LinkedIn";

    @Test(retryAnalyzer = Retry.class)
    public void linkedInTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUserName(Constants.STANDARD_USER);
        loginPage.typePassword(Constants.PASSWORD);
        loginPage.clickSubmitButton();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        ProductListPage productListPage = new ProductListPage(driver);
        LinkedInPage linkedInPage = productListPage.openLinkedIn();
        linkedInPage.waitForVisibilityOfElement(linkedInPage.getLinkedInLogo());

        Assert.assertEquals(linkedInPage.getTitleText(), logoText);
    }
}
