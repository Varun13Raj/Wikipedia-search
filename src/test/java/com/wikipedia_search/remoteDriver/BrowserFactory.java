package com.wikipedia_search.remoteDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserFactory {

    private static WebDriver initializeBrowser(String browserName, String browserVersion, String osVersion, HashMap<String, Object> ltOptions) throws MalformedURLException {
        WebDriver driver;
        String url = "https://hub.lambdatest.com/wd/hub";

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPlatformName(osVersion);
                chromeOptions.setBrowserVersion(browserVersion);
                chromeOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL(url), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPlatformName(osVersion);
                firefoxOptions.setBrowserVersion(browserVersion);
                firefoxOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL(url), firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPlatformName(osVersion);
                edgeOptions.setBrowserVersion(browserVersion);
                edgeOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL(url), edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        return driver;
    }

    public static WebDriver getDriver(String browserName, String browserVersion, String osVersion) throws MalformedURLException {
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "varunsingh16067");
        ltOptions.put("accessKey", "WQd2hh2nhbtaDktrjv50KlLbW8Kg3ZlRCnbdUaD5kg9elZjoew");
        ltOptions.put("build", "WikipediaTestLambdaBuild");
        ltOptions.put("project", "WikipediaTestLambda");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");

        return initializeBrowser(browserName, browserVersion, osVersion, ltOptions);
    }
}
