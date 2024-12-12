package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(30));
    }

    public WebElement waitForVisisblity(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitforClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForStaleness( WebElement element){
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

}
