package com.wikipedia.webDriverSetup;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.wikipedia.pages.WikipediaSearchPage;


public class BaseTestWithoutLT {

    protected WebDriver driver;
    public WikipediaSearchPage wikipediaSearchPage;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        driver = WebDriverSingletonWithoutLT.getDriver(browser);
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        wikipediaSearchPage = new WikipediaSearchPage(driver);
    }

    @BeforeMethod
    public void getUrl(ITestContext context) {
        if (driver != null) {
            driver.get("https://en.wikipedia.org/wiki/Main_Page");
        } else {
            throw new NullPointerException("WebDriver is not initialized");
        }
    }

    @AfterSuite
    public void tearDown() {
        WebDriverSingletonWithoutLT.quitDriver();
    }
}
