package com.wikipedia.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wikipedia.utilities.WaitUtils;

public class WikipediaSearchPage {

    private WebDriver driver;
    private WaitUtils wait;

    private static Logger logger = LogManager.getLogger(WikipediaSearchPage.class);
    @FindBy(xpath = "//form[@id = 'searchform']/div//input")
    private WebElement searchInput;
    @FindBy(xpath = "//form[@id='searchform']//button")
    private WebElement searchButton;
    @FindBy(xpath = "//th[text() = 'Capital']/..//td/a")
    private WebElement capitalLink;
    public WikipediaSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    public void searchForCountry(String countryName) {
        logger.info("Starting search method for country on wikipedia :");
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
