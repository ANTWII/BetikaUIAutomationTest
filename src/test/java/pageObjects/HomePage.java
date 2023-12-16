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

    @FindBy(xpath = "//div[@class='sports-list']/descendant::span[text()='Soccer']")
    WebElement btnSoccer;
    @FindBy(xpath = "//div[@class='sports-list']/descendant::span[contains(text(),'Boxing')]")
    WebElement btnBoxing;

    @FindBy(xpath = "//div[@class='sports-list']/descendant::span[contains(text(),'Cricket')]")
    WebElement btnCricket;

    @FindBy(xpath = "//div[@class='matches__title']/following::span[@class='prebet-match__odd__odd-value bold'][1]")
    WebElement btnOdd_first;

    @FindBy(xpath = "//div[@class='matches__title']/following::span[@class='prebet-match__odd__odd-value bold'][4]")
    WebElement btnOdd_Second;

    @FindBy(xpath = "//div[@class='matches__title']/following::span[@class='prebet-match__odd__odd-value bold'][7]")
    WebElement btnOdd_Third;


    @FindBy(xpath = "//span[text()='Share']")
    WebElement btnShare;

    @FindBy(xpath = "//div[contains(@class,'share-betslip__socials')]") //a popup containing the social media pages display
    WebElement popupShareSocial;

    @FindBy(xpath = "//a[contains(@title,'Facebook')]")
    WebElement shareFacebook;

    @FindBy(xpath = "//a[contains(@title,'Twitter')]")
    WebElement shareTwitter;

    @FindBy(xpath = "//a[contains(@title,'Whatsapp')]")
    WebElement shareWhatsapp;



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
    public void clickSoccer() {
        btnSoccer.click();
    }
    public void clickBoxing() {
        btnBoxing.click();
    }
    public void clickCricket() {
        btnCricket.click();
    }

    public void clickFirstOdd() {
        btnOdd_first.click();
    }
    public void clickSecondOdd() {
        btnOdd_Second.click();
    }
    public void clickThirdOdd() {
        btnOdd_Third.click();
    }
    public void clickShareButton() {
        btnShare.click();
    }
    public void ShareonFacebook() {
        shareFacebook.click();
    }
    public void shareonTwitter() {
        shareTwitter.click();
    }
    public void shareonWhatsapp() {
        shareWhatsapp.click();
    }
    public boolean isdepositExist()   // deposit button boldly displayed
    {
        try {
            return (btnDeposit.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public boolean isSocialSharePopupExist()   // Social medial share popup  displayed
    {
        try {
            return (popupShareSocial.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

}
