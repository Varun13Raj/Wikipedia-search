package com.wikipedia_search.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.wikipedia_search.utilities.ScreenShotUtils;

public class TestListener implements ITestListener {

private WebDriver driver;

@Override
public void onTestFailure(ITestResult result){
    driver = (WebDriver) result.getTestContext().getAttribute("driver");
    ScreenShotUtils.captureScreenshotOnTestFail(driver , result);
}

@Override
public void onTestStart(ITestResult result) {}

}
