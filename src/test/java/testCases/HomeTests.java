package testCases;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.time.Duration;
import java.util.Map;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;


public class HomeTests extends BaseClass {
    HomePage homepage;
    LoginPage loginpage;
@Test(priority=1,description = "confirm title on home page",groups = "regression")
    public void test_title() {
        Assert.assertTrue(driver.getTitle().contains("Betika | Best Online Sports Betting in Kenya"));

    }

    /***
     * the data driven tes will test odd sharing for:
     * Facebook
     * Twitter
     * Whatsapp
     */
    @DataProvider(name="TestData")
    public Object[][] TestData() {

        return new Object[][]{
                {Map.of("SocailMedialURL","https://www.facebook.com/login","PageTitle","Facebook")} ,

                {Map.of("SocailMedialURL","https://twitter.com/","PageTitle","X")} ,
                {Map.of("SocailMedialURL","https://api.whatsapp.com/","PageTitle","WhatsApp")} ,

        };

    }

    @Test(priority=2,description = "confirm odd sharing on social media",dataProvider="TestData",groups = "regression")
    public void test_OddShareOnSoccer(Map<String, String> _data) {

        String socailMedialURL=_data.get("SocailMedialURL");
        String pageTitle=_data.get("PageTitle");


        logger.info("*** starting to share odds on social media when soccer is selected******");
        try
        {


             homepage=new HomePage(driver);
             loginpage=new LoginPage(driver);

            BaseClass.globalLogin();
            homepage.clickSoccer();//select soccer game
            homepage.clickFirstOdd();
            homepage.clickSecondOdd();
            homepage.clickThirdOdd();
            homepage.clickShareButton();

            boolean verifySocialMediaSharing=homepage.isSocialSharePopupExist();
            if(verifySocialMediaSharing==true)
            {
                Assert.assertTrue(true);
            }


            if (pageTitle.equals("Facebook")) {
                homepage.shareonFacebook();
            }
            else if (pageTitle.equals("X")) {
                homepage.shareonTwitter();

            }
            else if (pageTitle.equals("WhatsApp")) {
                homepage.shareonWhatsapp();

            }
            // Store the handle of the currently active browser window
            String mainWindowHandle = driver.getWindowHandle();

            // Retrieve the handles of all currently open browser windows
            Set<String> windowHandles = driver.getWindowHandles();//store 2 window id's


            // Loop over each window handle
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    // Switch the WebDriver context to the new window
                    driver.switchTo().window(windowHandle);

                    // Wait until the new window's URL contains the desired value
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

                    wait.until(urlContains(socailMedialURL));
                    System.out.println(driver.getTitle());
                    // Validate that certain conditions on the page are met
                    Assert.assertTrue(driver.getTitle().contains(pageTitle));

                    // Close the new browser tab
                    driver.close();
                    break;

                }

            }
// Switch the WebDriver context back to the original browser window
           driver.switchTo().window(mainWindowHandle);
            homepage.cancelSocialshare();
            homepage.clickhambager();
            homepage.clickLogout();
        }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info("*** odds sucessfully shared on social media platformss******");

    }


    @Test(priority=3,description = "confirm odd sharing when Cricket is selected",dataProvider="TestData",groups = "regression")
    public void test_OddShareOnCricket(Map<String, String> _data) {

        String socailMedialURL=_data.get("SocailMedialURL");
        String pageTitle=_data.get("PageTitle");


        logger.info("*** starting to share odds on social media******");
        try
        {


            homepage=new HomePage(driver);
            loginpage=new LoginPage(driver);

            BaseClass.globalLogin();
            homepage.clickCricket();//select cricket game
            homepage.clickFirstOdd();
            homepage.clickSecondOdd();
            homepage.clickThirdOdd();
            homepage.clickShareButton();

            boolean verifySocialMediaSharing=homepage.isSocialSharePopupExist();
            if(verifySocialMediaSharing==true)
            {
                Assert.assertTrue(true);
            }


            if (pageTitle.equals("Facebook")) {
                homepage.shareonFacebook();
            }
            else if (pageTitle.equals("X")) {
                homepage.shareonTwitter();

            }
            else if (pageTitle.equals("WhatsApp")) {
                homepage.shareonWhatsapp();

            }
            // Store the handle of the currently active browser window
            String mainWindowHandle = driver.getWindowHandle();

            // Retrieve the handles of all currently open browser windows
            Set<String> windowHandles = driver.getWindowHandles();//store 2 window id's


            // Loop over each window handle
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    // Switch the WebDriver context to the new window
                    driver.switchTo().window(windowHandle);

                    // Wait until the new window's URL contains the desired value
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

                    wait.until(urlContains(socailMedialURL));
                    System.out.println(driver.getTitle());
                    // Validate that certain conditions on the page are met
                    Assert.assertTrue(driver.getTitle().contains(pageTitle));

                    // Close the new browser tab
                    driver.close();
                    break;

                }

            }
// Switch the WebDriver context back to the original browser window
            driver.switchTo().window(mainWindowHandle);
            homepage.cancelSocialshare();
            homepage.clickhambager();
            homepage.clickLogout();
        }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info("*** odds sucessfully shared on social media platformss******");

    }
    @Test(priority=3,description = "confirm odd sharing when VolleyBall is selected",dataProvider="TestData")
    public void test_OddShareOnVolleyBall(Map<String, String> _data) {

        String socailMedialURL=_data.get("SocailMedialURL");
        String pageTitle=_data.get("PageTitle");


        logger.info("*** starting to share odds on social media******");
        try
        {


            homepage=new HomePage(driver);
            loginpage=new LoginPage(driver);

            BaseClass.globalLogin();
            homepage.clickVolleyBall();//select Volley Ball game
            homepage.clickFirstOdd();
            homepage.clickSecondOdd();
            homepage.clickThirdOdd();
            homepage.clickShareButton();

            boolean verifySocialMediaSharing=homepage.isSocialSharePopupExist();
            if(verifySocialMediaSharing==true)
            {
                Assert.assertTrue(true);
            }


            if (pageTitle.equals("Facebook")) {
                homepage.shareonFacebook();
            }
            else if (pageTitle.equals("X")) {
                homepage.shareonTwitter();

            }
            else if (pageTitle.equals("WhatsApp")) {
                homepage.shareonWhatsapp();

            }
            // Store the handle of the currently active browser window
            String mainWindowHandle = driver.getWindowHandle();

            // Retrieve the handles of all currently open browser windows
            Set<String> windowHandles = driver.getWindowHandles();//store 2 window id's


            // Loop over each window handle
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    // Switch the WebDriver context to the new window
                    driver.switchTo().window(windowHandle);

                    // Wait until the new window's URL contains the desired value
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

                    wait.until(urlContains(socailMedialURL));
                    System.out.println(driver.getTitle());
                    // Validate that certain conditions on the page are met
                    Assert.assertTrue(driver.getTitle().contains(pageTitle));

                    // Close the new browser tab
                    driver.close();
                    break;

                }

            }
// Switch the WebDriver context back to the original browser window
            driver.switchTo().window(mainWindowHandle);
            homepage.cancelSocialshare();
            homepage.clickhambager();
            homepage.clickLogout();
        }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info("*** odds sucessfully shared on social media platformss******");

    }
}
