package searchItems;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import search.SearchPage;
import utility.ExtentReport.ApplicationLog;

import java.io.IOException;

import static base.CommonAPI.driver;

/**
 * Created by salah on 5/19/17.
 */
public class SearchItems extends CommonAPI {

    @Test
    public void search() throws IOException, InterruptedException {
        ApplicationLog.epicLogger("Epic: Search EC:1,2 <a https://peoplentch.atlassian.net/browse/GREEN-7> GREEN-7 </a>");
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.getDataFromExcelFileAndSearch();
    }
}
