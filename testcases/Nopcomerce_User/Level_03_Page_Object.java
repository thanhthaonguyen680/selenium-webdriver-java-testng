package Nopcomerce_User;

import PageObjects.HomePageObject;
import PageObjects.RegisterPageObject;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object extends BasePage {
    //Declare
    HomePageObject homePage;
    WebDriver driver;
    RegisterPageObject registerPage;


    @BeforeClass
    public void beforeClass() {

        // Initial : khởi tạo
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);
        firstName = "Thao";
        lastName = "Nguyen";
        password = "123456";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtFirstName(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastName(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPassword(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(), "Password is required.");

    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        homePage.clickToRegisterLink();
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox("thao@123");
        registerPage.inputToPasswordTextBox(password);
        registerPage.inputToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorEmailTextBox(), "Wrong email");

    }

    @Test
    public void TC_03_Register_Success() {
        homePage.clickToRegisterLink();
        System.out.println("Step 02 Registerpage Input");
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox(emailAddress);
        registerPage.inputToPasswordTextBox(password);
        registerPage.inputToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getSuccessEmailMessage(), "Your registration completed");
        registerPage.clickToLogOutLink();

    }

    @Test
    public void TC_04_Register_Existing_Email() {

        homePage.clickToRegisterLink();
        System.out.println("Step 02 Registerpage Input");
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox("thanhthaonguyen680@gmail.com");
        registerPage.inputToPasswordTextBox(password);
        registerPage.inputToConfirmPasswordTextBox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorExistEmailMessage(), "The specified email already exists");
        registerPage.clickToLogOutLink();

    }


    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        homePage.clickToRegisterLink();
        System.out.println("Step 02 Registerpage Input");
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox(emailAddress);
        registerPage.inputToPasswordTextBox("134");
        registerPage.inputToConfirmPasswordTextBox("134");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorPassword(), "Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        homePage.clickToRegisterLink();
        registerPage.inputToFirstNameTextBox(firstName);
        registerPage.inputToLastNameTextBox(lastName);
        registerPage.inputToEmailTextBox(emailAddress);
        registerPage.inputToPasswordTextBox(password);
        registerPage.inputToConfirmPasswordTextBox("1345866785");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getErrorPasswordNotMatch(), "The password and confirmation password do not match.");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    private String firstName, lastName, emailAddress, password;

}