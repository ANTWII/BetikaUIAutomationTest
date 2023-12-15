package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginTests extends BaseClass {

    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class,groups= {"Sanity","Master"})
    public void test_login(String phone, String password,String expected)
    {

        logger.info("*** Starting Login data driven tests******");
        try
        {
            HomePage homepage=new HomePage(driver);
            homepage.clickLogin();


            LoginPage loginpage=new LoginPage(driver);

            loginpage.setPhoneNumber(phone);
            loginpage.setPassword(password);
            loginpage.clickLogin();



        boolean targetbuttonlabel=homepage.isdepositExist();

        if(expected.equals("Valid"))
        {
            if(targetbuttonlabel==true)
            {
                homepage.clickhambager();
                homepage.clickLogout();
                Assert.assertTrue(true);
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
                loginpage.clearLogin();
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
