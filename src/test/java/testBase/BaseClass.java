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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {

    public ResourceBundle rb;// to read config.properties

    public Logger logger;// for Logging

    public static WebDriver driver;  // make it static so that you can use same instance in Extent report manager


    @BeforeClass(groups = { "Master", "Sanity", "Regression" })
    @Parameters("browser")   // getting browser parameter from testng.xml
    public void setup(String br)
    {
        rb = ResourceBundle.getBundle("config");// Load config.properties

        logger = LogManager.getLogger(this.getClass());// for Logger

        //launch right browser based on parameter
        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
         //   options.addArguments("--headless"); // Add this line to run Chrome in headless mode
            driver = new ChromeDriver(options);
        } else if (br.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();


        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(rb.getString("appURL")); // get url from config.properties file
        driver.manage().window().maximize();
    }

    @AfterClass(groups = { "Master", "Sanity", "Regression" })
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

}
