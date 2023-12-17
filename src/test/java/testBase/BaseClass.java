package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class BaseClass {

    public static ResourceBundle rb;// to read config.properties

    public Logger logger;// for Logging

    public static WebDriver driver;  // make it static so that you can use same instance in Extent report manager


    @BeforeClass
    @Parameters("browser")   // getting browser parameter from testng.xml
    public void setup(String br)
    {
        rb = ResourceBundle.getBundle("config");// Load config.properties

        logger = LogManager.getLogger(this.getClass());// for Logger

        //launch right browser based on parameter
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
         //options.addArguments("--headless"); // Add this line to run Chrome in headless mode
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);

        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options=new EdgeOptions();
           options.addArguments("--headless"); // Enable headless mode
            driver = new EdgeDriver(options);


        } else {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
          options.addArguments("--headless"); // Enable headless mode
            driver=new FirefoxDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().deleteAllCookies();
        driver.get(rb.getString("appURL")); // get url from config.properties file
        driver.manage().window().maximize();
    }


@AfterSuite
public void teadDown() {
    driver.quit();
}
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
//global login method for  all tests
    public static   void globalLogin()
    {
        //Fluent wait declaration

        FluentWait mywait=new FluentWait(driver);
        mywait.withTimeout(Duration.ofSeconds(30));
        mywait.pollingEvery(Duration.ofSeconds(2));
        mywait.ignoring(NoSuchElementException.class);


        HomePage homepage=new HomePage(driver);
        driver.navigate().refresh();
        mywait.until(ExpectedConditions.elementToBeClickable(homepage.btnLogin));
        homepage.clickLogin();


        LoginPage  loginpage=new LoginPage(driver);

        loginpage.setPhoneNumber(rb.getString("phone"));//loading credentials from the property file
        loginpage.setPassword(rb.getString("password"));

        loginpage.clickLogin();//login
    }

}
