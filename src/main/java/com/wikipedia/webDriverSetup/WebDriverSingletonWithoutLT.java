package com.wikipedia.webDriverSetup;

import org.openqa.selenium.WebDriver;
import com.wikipedia.browserFactory.BrowserFactoryWithoutLT;

public class WebDriverSingletonWithoutLT {
    private static WebDriver driver;
    private WebDriverSingletonWithoutLT() {}
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = BrowserFactoryWithoutLT.getDriver(browser);
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
