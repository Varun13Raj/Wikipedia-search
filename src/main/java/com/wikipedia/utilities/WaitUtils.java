package com.wikipedia.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    private static Logger logger = LogManager.getLogger(WaitUtils.class);

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement waitForVisisblity(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("error occured due to element invisibility: " + element + " " + e.getMessage());
            return element;
        }
    }

    public WebElement waitforClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("error occured due to element is not clickable: " + element + " " + e.getMessage());
            return  element;
        }
    }

    public Boolean waitForStaleness(WebElement element) {
        try {
            return wait.until(ExpectedConditions.stalenessOf(element));
        } catch (Exception e) {
            logger.error("error occured due to element became stale: " + element + " " + e.getMessage());
            return false;
        }
    }
}
