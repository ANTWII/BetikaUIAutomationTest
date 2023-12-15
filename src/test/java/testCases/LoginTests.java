package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginTests extends BaseClass {

    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)
    public void test_login(String phone, String password,String expected)
    {
        //Fluent wait declaration

        FluentWait mywait=new FluentWait(driver);
        mywait.withTimeout(Duration.ofSeconds(30));
        mywait.pollingEvery(Duration.ofSeconds(2));
        mywait.ignoring(NoSuchElementException.class);




        logger.info("*** Starting Login data driven tests******");
        try
        {
            HomePage homepage=new HomePage(driver);
            driver.navigate().refresh();
            mywait.until(ExpectedConditions.elementToBeClickable(homepage.btnLogin));
            homepage.clickLogin();


            LoginPage loginpage=new LoginPage(driver);

            loginpage.setPhoneNumber(phone);
            loginpage.setPassword(password);
            //usage
            loginpage.clickLogin();



        boolean targetbuttonlabel=homepage.isdepositExist();


        if(expected.equals("Valid"))
        {
            if(targetbuttonlabel==true)
            {
                homepage.clickhambager();
                homepage.clickLogout();
                Assert.assertTrue(true);
                driver.navigate().refresh();


            }
            else
            {
                Assert.assertTrue(false);
            }

        }

        if(expected.equals("Invalid"))
        {
            if(targetbuttonlabel==true)
            {

                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }

    }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info("*** Completed Login data driven tests******");

    }

}
