package utils;

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
    if (result.getStatus() == ITestResult.FAILURE) { // Take screenshot only for failed tests
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Use the test method name as part of the screenshot file name
            File destFile = new File("screenshots/" + result.getMethod().getMethodName() + ".png");
            FileUtils.copyFile(screenshot, destFile);
            System.out.println("Screenshot saved for failed test: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
}
