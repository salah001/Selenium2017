package home;

import base.CommonAPI;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class TestAmazonHome extends CommonAPI {
    @Test
    public void amazonTitle() {
        System.out.println(driver.getTitle());
    }
}
