package home;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by salah on 5/13/17.
 */
public class TestEbayHome extends CommonAPI {

    @Test
    public void ebayTitle() {
        String actualTitle = "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
        Assert.assertEquals(actualTitle, driver.getTitle());
        System.out.println(driver.getTitle());

    }

}
