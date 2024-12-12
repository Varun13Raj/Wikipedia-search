package pages;

import base.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils wait;

    // Define WebElements using PageFactory
    @FindBy(xpath = "//form[@id = 'searchform']/div//input")
    private WebElement searchInput;

    @FindBy(xpath = "//form[@id='searchform']//button")
    private WebElement searchButton;

    @FindBy(xpath = "//th[text() = 'Capital']/..//td/a")
    private WebElement capitalLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForCountry(String countryName) {
      //  driver.navigate().refresh();
            wait.waitForVisisblity(searchInput);
            searchInput.sendKeys(countryName);
            wait.waitforClickable(searchButton);
            searchButton.click();
        }
    public String getCapitalOfCountry() {
        return capitalLink.getText();
    }
}
