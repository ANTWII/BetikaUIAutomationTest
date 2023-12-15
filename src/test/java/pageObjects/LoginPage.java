package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Enter your phone number')]/preceding::label/following::input[1]")
    WebElement txtPhoneNumber;

    @FindBy(xpath = "//span[contains(text(),'Enter your password')]/preceding::input[@type='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//span[contains(text(),'Enter your password')]/following::span[contains(text(),'Login')]")
    WebElement btnLogin;


    public void setPhoneNumber(String PhoneNumber) {
        txtPhoneNumber.sendKeys(PhoneNumber);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clearLogin() {
        txtPhoneNumber.clear();
        txtPassword.clear();
    }

}
