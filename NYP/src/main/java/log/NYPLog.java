package log;

import utility.ExtentReport.TestLogger;

/**
 * Created by salah on 5/17/17.
 */
public class NYPLog {

    public static void epicLogger(String epic) {

        TestLogger.log(epic);
        TestLogger.log("Launch local browser instance");

    }
}
