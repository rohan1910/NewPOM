package WebTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class BaseTest extends Utils {
    BroswerSelector broswerSelector = new BroswerSelector();

    @BeforeMethod
    public void open_browser() {
        broswerSelector.browserselector();
    }

    @AfterMethod
    public void screenshot_of_browser(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("src\\test\\Screenshots\\" + result.getName() + ".png"));
                System.out.println("Screenshot taken");
            } catch (Exception e) {
                System.out.println("exception while taking Screenshot " + e.getMessage());

            }
            close_Browser();
        }
    }
}