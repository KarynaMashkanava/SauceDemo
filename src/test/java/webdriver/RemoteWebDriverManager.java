package webdriver;

import lombok.SneakyThrows;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteWebDriverManager extends DriverManager{

    @SneakyThrows
    @Override
    public RemoteWebDriver createWebDriver() {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "99");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(new URL("https://karyna.mashkanava:c353d507-bea4-473b-b2da-4d5ce7637ab8@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
    }
}
