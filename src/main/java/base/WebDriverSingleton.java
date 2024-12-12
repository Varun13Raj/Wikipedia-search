package base;

import org.openqa.selenium.WebDriver;
import factiry.BrowserFactory;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = BrowserFactory.getDriver(browser);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
