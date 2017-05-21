package utility.ExtentReport;

import utility.ExtentReport.TestLogger;

/**
 * Created by salah on 5/19/17.
 */
public class ApplicationLog {
    public static void epicLogger(String epic) {

        TestLogger.log(epic);
        TestLogger.log("Launch local browser instance");

    }
}
