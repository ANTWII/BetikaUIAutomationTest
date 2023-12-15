package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//a[contains(text(),'Login')]")
  public   WebElement btnLogin;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement btnRegister;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]") // deposit button boldly displayed after successful login
    WebElement btnDeposit;

    @FindBy(xpath = "//button[@class='topnav__menu']")
    WebElement btnhambager;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement btnLogout;
    // Action Methods
    public void clickLogin() {
        btnLogin.click();
    }

    public void clickRegister() {
        btnRegister.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }
    public void clickhambager() {
        btnhambager.click();
    }
    public boolean isdepositExist()   // deposit button boldly displayed
    {
        try {
            return (btnDeposit.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

}
