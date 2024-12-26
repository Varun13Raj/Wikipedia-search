package com.wikipedia_search.pages;

import com.wikipedia_search.utilities.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    private final WebDriver driver;
    private final WaitUtils wait;
    private static final Logger logger = LogManager.getLogger(WikipediaSearchPage.class);

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
        logger.info("Starting search method for country on Wikipedia.");
        wait.waitForVisibility(searchInput).sendKeys(countryName);
        wait.waitForClickable(searchButton).click();
    }

    public String getCapitalOfCountry() {
        return wait.waitForVisibility(capitalLink).getText();
    }
}
