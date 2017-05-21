package news;

import base.CommonAPI;
import homePage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by salah on 5/16/17.
 */
public class NewsPage extends CommonAPI {

    @FindBy(how = How.CSS, using = ".postid-10958035")
    public static WebElement newsHeader;


    public static WebElement getNewsHeader() {
        return newsHeader;
    }

    public static void clickOnHeadLine(){

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnNewsItems();
        getNewsHeader().click();

    }
}
