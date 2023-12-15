package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;



public class HomeTests extends BaseClass {

@Test(description = "confirm title on home page")
    public void test_title() {
        Assert.assertTrue(driver.getTitle().contains("Betika | Best Online Sports Betting in Kenya"));

    }
}