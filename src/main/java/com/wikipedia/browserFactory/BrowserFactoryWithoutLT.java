package com.wikipedia.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactoryWithoutLT {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;

        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser specified");
        }

        driver.manage().window().maximize();
        return driver;
    }
}
