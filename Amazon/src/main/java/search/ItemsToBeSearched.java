package search;

import base.CommonAPI;
import utility.ExtentReport.TestLogger;
import utility.ExtentReport.reader.DataReader;

import java.io.IOException;

/**
 * Created by salah on 5/19/17.
 */
public class ItemsToBeSearched extends CommonAPI {

    DataReader dr = new DataReader();
    public String [] getDataFromExcelFile()throws IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String path = System.getProperty("user.dir")+"/data/file1.xls";
        String [] st = dr.fileReader(path);
        return st;
    }
}
