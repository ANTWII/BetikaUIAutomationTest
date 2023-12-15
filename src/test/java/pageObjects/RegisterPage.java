package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Enter your phone number')]/preceding::label/following::input[1]")
    WebElement txtPhoneNumber;

    @FindBy(xpath = "//span[contains(text(),'Enter your password')]/preceding::input[@type='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//span[contains(text(),'Confirm your password')]/preceding::input[@type='password'][1]")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//span[@class='checkmark']")
    WebElement btnCheckBox;

    @FindBy(xpath = "//span[contains(text(),'Already have a registration code')]/preceding::span[contains(text(),'Register')][1]")
    WebElement btnRegister;


    @FindBy(xpath = "//p[contains(text(),'Confirm your password and enter the verification code that was sent to you phone')]") // verification code message displays
    WebElement msgVerificationCode;

    public void setPhoneNumber(String PhoneNumber) {
        txtPhoneNumber.sendKeys(PhoneNumber);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);

    }

    public void clickCheckBox() {
        btnCheckBox.click();

    }

    public void clickRegister() {
        btnRegister.click();

    }
    public boolean isVerificationCodeSent()   // verification code message displays
    {
        try {
            return (msgVerificationCode.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }
}
