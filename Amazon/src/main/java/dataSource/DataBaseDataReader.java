package dataSource;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import search.SearchPage;
import utility.ExtentReport.TestLogger;
import utility.ExtentReport.reader.ConnectDB;

import java.util.List;

/**
 * Created by salah on 5/19/17.
 */
public class DataBaseDataReader extends CommonAPI {

    public void dataFromDatabase()throws Exception,InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        SearchPage searchPage = PageFactory.initElements(driver,SearchPage.class);
        ConnectDB connectDB = new ConnectDB();
        List<String> list = connectDB.readDataBase();
        for(String data:list){
            searchPage.searchFor(data);
            sleepFor(2);
            searchPage.clearSearchInput();
        }
    }
}
