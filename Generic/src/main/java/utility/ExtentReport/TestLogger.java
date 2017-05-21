package utility.ExtentReport;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.commons.lang.StringUtils;

/**
 * Created by salah on 5/17/17.
 */
public class TestLogger {

    public static void log(final String message) {
        Reporter.log(message, true);
        utility.ExtentReport.ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }

    public static void log(final StringUtils message) {
        Reporter.log(message + "<br>", true);
        utility.ExtentReport.ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }

    public static void log(final String message, WebDriver driver) {
        Reporter.log(message + "<br>", true);
        utility.ExtentReport.ExtentTestManager.getTest().log(LogStatus.INFO, message + "<br>");
    }

}
