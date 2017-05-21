package utility.ExtentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;

/**
 * Created by salah on 5/17/17.
 */
public class ExtentTestUpdate extends ExtentTest {

    private LogStatus runStatus;
    private Test test;

    public ExtentReports extentReports = new ExtentReports("");

    public ExtentTestUpdate (String testName, String description){super(testName,description);}

    public void starTest(String className, String testName, String description){extentReports.startTest(testName);}


}
