package com.wikipedia.webDriverSetup;

import com.wikipedia.browserFactory.BrowserFactoryLT;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.wikipedia.pages.WikipediaSearchPage;
import java.net.MalformedURLException;

public class LambdaTestSetup {
    public WikipediaSearchPage wikipediaSearchPage;
    private WebDriver driver;

    @Parameters({"browserName", "browserVersion", "osVersion"})
    @BeforeTest
    public void setUp(String browserName , String browserVersion, String osVersion) throws MalformedURLException {
        driver = BrowserFactoryLT.getDriver(browserName,browserVersion, osVersion);
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
        LambdTestWebdriver.quitDriver();
    }
}
