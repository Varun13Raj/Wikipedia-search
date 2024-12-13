package com.wikipedia.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserFactoryLT {



    public static WebDriver getDriver(String browserName , String browserVersion, String osVersion) throws MalformedURLException {

        WebDriver driver = null;

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "varunsingh16067");
        ltOptions.put("accessKey", "WQd2hh2nhbtaDktrjv50KlLbW8Kg3ZlRCnbdUaD5kg9elZjoew");
        ltOptions.put("build", "WikipediaTestLambdaBuild");
        ltOptions.put("project", "WikipediaTestLambda");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");

        if (browserName.equalsIgnoreCase("Chrome")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(osVersion);
            browserOptions.setBrowserVersion(browserVersion);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName(osVersion);
            browserOptions.setBrowserVersion(browserVersion);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);

        }else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setPlatformName(osVersion);
            browserOptions.setBrowserVersion(browserVersion);
            browserOptions.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"),browserOptions);

        }
        return driver;
    }

}
