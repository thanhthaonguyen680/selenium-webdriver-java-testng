package Nopcomerce_User;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_Apply_BasePage_2 {
    WebDriver driver;
    String emailAddress;
    // declare
    BasePage  basePage;

    @BeforeClass
    public void beforeClass() {
        // Initial : khởi tạo
        driver = new FirefoxDriver();
        basePage = BasePage.getBasePageObject();

        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver,"//button[@id='register-button']");



        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");

    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","Nguyen");
        basePage.sendkeyToElement(driver,"//div[@id='Email']","thao@1233");
        basePage.sendkeyToElement(driver,"//input[@id='Password']","@123456577");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","@123456577");
        basePage.clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Email is required.");

    }

    @Test
    public void TC_03_Register_Success() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","Nguyen");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Password']","@123456577");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","@123456577");
        basePage.clickToElement(driver,"//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"), "Your registration completed");

    }

    @Test
    public void TC_04_Register_Existing_Email() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","Nguyen");
        basePage.sendkeyToElement(driver,"//input[@id='Email']","thanhthaonguyen680@gmail.com");
        basePage.sendkeyToElement(driver,"//input[@id='Password']","@123456577");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","@123456577");
        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//div[contains(@class,'message-error')]//li"), "The specified email already exists");
    }


    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","Nguyen");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123");
        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","Nguyen");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","12356785");
        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateFakeNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }
}