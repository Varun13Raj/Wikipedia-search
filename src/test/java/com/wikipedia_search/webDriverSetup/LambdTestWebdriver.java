package com.wikipedia_search.webDriverSetup;

import com.wikipedia_search.remoteDriver.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LambdTestWebdriver {
    private static WebDriver driver;

    private LambdTestWebdriver(){}

    public static WebDriver getDriver(String browserName, String browserVersion, String osVersion) throws MalformedURLException {
        return BrowserFactory.getDriver(browserName, browserVersion, osVersion);
    }
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
