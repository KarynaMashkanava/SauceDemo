import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void setProp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/recources/chromedriver");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
