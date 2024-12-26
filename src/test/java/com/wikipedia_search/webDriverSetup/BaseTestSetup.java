package com.wikipedia_search.webDriverSetup;

import com.wikipedia_search.pages.WikipediaSearchPage;
import com.wikipedia_search.remoteDriver.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTestSetup {
    public WikipediaSearchPage wikipediaSearchPage;
    protected WebDriver driver;

    @Parameters({"browserName", "browserVersion", "osVersion", "platformName"})
    @BeforeTest
    public void setUp(
            @Optional("Chrome") String browserName,
            @Optional("latest") String browserVersion,
            @Optional("Windows 10") String osVersion,
            @Optional("LambdaTest") String platformName
    ) throws MalformedURLException {

        browserName = System.getProperty("browserName", browserName);
        browserVersion = System.getProperty("browserVersion", browserVersion);
        osVersion = System.getProperty("osVersion", osVersion);
        platformName = System.getProperty("platformName", platformName);

        driver = BrowserFactory.getDriver(browserName, browserVersion, osVersion, platformName);
        driver.manage().window().maximize();
        wikipediaSearchPage = new WikipediaSearchPage(driver);
    }

    @BeforeMethod
    public void getUrl() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
