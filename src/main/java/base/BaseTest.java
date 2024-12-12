package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.HomePage;


public class BaseTest {

    protected WebDriver driver;
    public HomePage homePage;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        driver = WebDriverSingleton.getDriver(browser);
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        homePage = new HomePage(driver);
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
        WebDriverSingleton.quitDriver();
    }
}
