package homePage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utility.ExtentReport.TestLogger;

/**
 * Created by salah on 5/16/17.
 */
public class HomePage extends CommonAPI {

    @FindBy(how = How.CSS, using = "#sections")//".nav-text")//
    public static WebElement sectionsMenu;

    @FindBy(how = How.CSS, using = "#menu-main-menu li:nth-child(1)")//
    public static WebElement sectionsMenuList;

    public  WebElement getSectionsMenuWebElement() {
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return sectionsMenu;
    }


    public static WebElement getSectionsMenuList() {
        return sectionsMenuList;
    }

    public void clickOnSectionsMenu() {
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getSectionsMenuWebElement().click();
    }

    public void clickOnNewsItems() {
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnSectionsMenu();
        getSectionsMenuList().click();
    }

}
