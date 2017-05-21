package news;

import base.CommonAPI;
import log.NYPLog;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by salah on 5/16/17.
 */
public class News extends CommonAPI {

    @Test
    public void headLineNews(){

        NYPLog.epicLogger("Epic: News EC:1,2 <a https://peoplentch.atlassian.net/browse/GREEN-1> GREEN-1 </a>");
        NewsPage newsPage = PageFactory.initElements(driver, NewsPage.class);
        newsPage.clickOnHeadLine();

    }
}
