package home;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class TestLogin extends CommonAPI {

    @Test
    public void login() {
        driver.findElement(By.name("email")).sendKeys("rahmanww@gmail.com");
        driver.findElement(By.name("password")).sendKeys("abc123");
    }
}
