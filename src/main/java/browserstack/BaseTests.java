package browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BaseTests {
    private WebDriver driver;

    public WebDriver initializeDriver(DesiredCapabilities capabilities) throws Exception {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        URL url = new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
        driver = new RemoteWebDriver(url, capabilities);
        return driver;
    }
}
