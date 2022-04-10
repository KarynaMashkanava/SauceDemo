package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utils.MyListener;
import webdriver.DriverFactory;
import webdriver.DriverType;

import java.util.concurrent.TimeUnit;


@Listeners(MyListener.class)
public class BaseTest {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(DriverType browser) {
        driver = new DriverFactory().getDriverManager(browser).createWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }
}
