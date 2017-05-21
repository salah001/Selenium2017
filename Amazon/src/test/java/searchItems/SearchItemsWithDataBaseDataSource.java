package searchItems;

import base.CommonAPI;
import dataSource.DataBaseDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.ExtentReport.ApplicationLog;

/**
 * Created by salah on 5/19/17.
 */
public class SearchItemsWithDataBaseDataSource extends CommonAPI {

    @Test
    public void searchItemsWithDB()throws Exception, InterruptedException{
        ApplicationLog.epicLogger("Epic: Search EC:1,2 <a https://peoplentch.atlassian.net/browse/GREEN-7> GREEN-7 </a>");
        DataBaseDataReader databaseDataReader = PageFactory.initElements(driver, DataBaseDataReader.class);
        databaseDataReader.dataFromDatabase();
    }




}
