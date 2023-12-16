package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;
import com.github.javafaker.Faker;


public class RegisterTests extends BaseClass {

    private final   Faker faker = new Faker();

    //Generate valid Kenya phone numbers
    public static String generatePhoneNumber(Faker faker) {
        // Generate a phone number where the second digit is 0, 4, 5, 6, or 7
        String firstDigit = faker.random().nextBoolean() ? "2" : "7"; // Start with 2 or 7
        String secondDigit = generateValidSecondDigit(faker);

        String restOfNumber = faker.numerify("#######"); // Generate 7 random digits
        String fixedExtension = "254";
        String number=firstDigit + secondDigit + restOfNumber;
        String phoneNumber = fixedExtension + " " + number;
        return phoneNumber;
    }
    private static String generateValidSecondDigit(Faker faker) {
        // Generate a valid second digit: 0, 4, 5, 6, or 7
        int[] validSecondDigits = {0, 4, 5, 6, 7};
        int randomIndex = faker.random().nextInt(validSecondDigits.length);
        return String.valueOf(validSecondDigits[randomIndex]);
    }
    @Test()
    public void test_register( )
    {
        String phone=generatePhoneNumber(faker);
        String password=""+faker.number().numberBetween(1000, 2000);

        logger.info("*** Starting register of new users******");
        try
        {
            HomePage homepage=new HomePage(driver);
            homepage.clickRegister();


            RegisterPage registerpage=new RegisterPage(driver);

            registerpage.setPhoneNumber(phone);
            registerpage.setPassword(password);
            registerpage.setConfirmPassword(password);
            registerpage.clickCheckBox();
            registerpage.clickRegister();




            boolean verificationcod=registerpage.isVerificationCodeSent();



                if(verificationcod==true)
                {

                    Assert.assertTrue(true);

                }

        }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info("***Registration completed******");

    }

}
