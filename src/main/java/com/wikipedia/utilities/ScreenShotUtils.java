package com.wikipedia.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {

private WebDriver driver;

public static void captureScreenshotOnTestFail(WebDriver driver, ITestResult result){
    if (result.getStatus() == ITestResult.FAILURE) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File("screenshots/" + result.getMethod().getMethodName() + ".png");
            FileUtils.copyFile(screenshot, destFile);
            System.out.println("Screenshot saved for failed test: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
}
