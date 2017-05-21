package home;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import utility.ExtentReport.TestLogger;

/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class TestAmazonHome extends CommonAPI {
    @Test
    public void amazonTitle() {

        String actualTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle, driver.getTitle());
        System.out.println(driver.getTitle());

    }
}
