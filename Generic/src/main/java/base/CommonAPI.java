package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import sun.management.counter.Units;

import java.util.concurrent.TimeUnit;

/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class CommonAPI {

    public WebDriver driver = null;
    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\PIIT_NYA\\IdeaProjects\\PntAutomation\\Generic\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.quit();
    }
}
