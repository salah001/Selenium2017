package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
//import sun.management.counter.Units;
import utility.ExtentReport.ExtentManager;
import utility.ExtentReport.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by PIIT_NYA on 5/6/2017.
 */
public class CommonAPI {

    /// this code is for the extent report (has to be set before launch of the tests

    public static ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();

        extent.flush();

        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    //////// end of extent report setting


    public static WebDriver driver = null;
    private String saucelabs_username = "salahoo1";
    private String browserstack_username = "eddine2";
    private String saucelabs_accesskey = "salah3awtanisl";
    private String browserstack_accesskey = "Exars3p4uYqxE4rxqvG3";

    @Parameters({"url","useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("http://www.ebay.com") String url, @Optional("false") boolean useCloudEnv, @Optional("browserstack")
                      String cloudEnvName, @Optional("Windows") String os, @Optional("10") String os_version,
                      @Optional("firefox") String browserName, @Optional("34") String browserVersion)throws IOException{
        if (useCloudEnv == true){
            if (cloudEnvName.equalsIgnoreCase("browserstack")){
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);

            } else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username,saucelabs_accesskey,os,os_version, browserName, browserVersion);
            }
        } else {
            //run local useCloudEnv is false
            getLocalDriver(os, browserName);
        }

        //System.setProperty("webdriver.gecko.driver","/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/geckodriver");
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);

        if(envName.equalsIgnoreCase("saucelabs")){

            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+"@ondemand.saucelabs.com:80/wd/hub"), cap);

        }else if(envName.equalsIgnoreCase("browserstack")) {

            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://"+ envUsername + ":" + envAccessKey +"@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    public WebDriver getLocalDriver(@Optional("Mac") String OS, String browserName){

        if(browserName.equalsIgnoreCase("chrome")){

            if(OS.equalsIgnoreCase("Mac")){
                System.setProperty("webdriver.chrome.driver", "/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/chromedriver");
            }else if(OS.equalsIgnoreCase("Win")){
                System.setProperty("webdriver.chrome.driver", "/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){

            if(OS.equalsIgnoreCase("Mac")){
                System.setProperty("webdriver.gecko.driver", "/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/geckodriver");
            }else if(OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/geckodriver");
            }
            driver = new FirefoxDriver();

        } else if(browserName.equalsIgnoreCase("ie")) {

            System.setProperty("webdriver.ie.driver", "/Users/salah/Desktop/automation-march2017-(original)/Generic/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;

    }

    @AfterMethod
    public void cleanUp(){
        System.out.println("It has been called");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }


    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    public void clickLinks(String locator) { driver.findElement(By.linkText(locator)).click();}




    public String converToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }

    }
    //Taking Screen shots
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }

    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec * 1000);
    }

    public List<String> getTextFromWebElements(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }

        return text;
    }

    public void clearInputField(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }



}
