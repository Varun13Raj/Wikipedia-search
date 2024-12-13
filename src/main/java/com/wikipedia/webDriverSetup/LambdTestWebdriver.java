package com.wikipedia.webDriverSetup;

import com.wikipedia.browserFactory.BrowserFactoryLT;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

public class LambdTestWebdriver {
    private static WebDriver driver;

    private LambdTestWebdriver(){}

    public static WebDriver getDriver(String browserName , String browserVersion, String osVersion) throws MalformedURLException {
        driver = BrowserFactoryLT.getDriver(browserName, browserVersion, osVersion);
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
