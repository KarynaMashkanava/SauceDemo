import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriver.DriverFactory;
import webdriver.DriverType;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new DriverFactory().getDriverManager(DriverType.REMOTE_WEB_DRIVER).createWebDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
