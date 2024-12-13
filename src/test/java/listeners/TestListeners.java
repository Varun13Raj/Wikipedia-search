package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.wikipedia.utilities.ScreenShotUtils;

public class TestListeners  implements ITestListener {

private WebDriver driver;

@Override
public void onTestFailure(ITestResult result){
    driver = (WebDriver) result.getTestContext().getAttribute("driver");
    ScreenShotUtils.captureScreenshotOnTestFail(driver , result);
}

@Override
public void onTestStart(ITestResult result) {}

}
