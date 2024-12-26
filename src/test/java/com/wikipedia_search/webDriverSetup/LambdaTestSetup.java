package com.wikipedia_search.webDriverSetup;

import com.wikipedia_search.pages.WikipediaSearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class LambdaTestSetup {
    public WikipediaSearchPage wikipediaSearchPage;
    private WebDriver driver;

    @Parameters({"browserName", "browserVersion", "osVersion"})
    @BeforeTest
    public void setUp(
            @Optional("Chrome") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("Windows 10") String osVersion
    ) throws MalformedURLException {

        browserName = System.getProperty("browserName", browserName);
        browserVersion = System.getProperty("browserVersion", browserVersion);
        osVersion = System.getProperty("osVersion", osVersion);

        driver = LambdTestWebdriver.getDriver(browserName, browserVersion, osVersion);
        driver.manage().window().maximize();
        wikipediaSearchPage = new WikipediaSearchPage(driver);
    }

    @BeforeMethod
    public void getUrl() {
        if (driver != null) {
            driver.get("https://en.wikipedia.org/wiki/Main_Page");
        } else {
            throw new NullPointerException("WebDriver is not initialized");
        }
    }

    @AfterSuite
    public void tearDown() {
        LambdTestWebdriver.quitDriver(driver);
    }
}
