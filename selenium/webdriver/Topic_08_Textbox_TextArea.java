package webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_Empty_Email_Pass() {
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

//        WebElement emailElement = driver.findElement(By.id("email"));
//        emailElement.sendKeys();
//        WebElement passwordElement = driver.findElement(By.id("pass"));
//        passwordElement.sendKeys();
        WebElement loginBtnElement = driver.findElement(By.id("send2"));
        loginBtnElement.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email"))
                .getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass"))
                .getText(),"This is a required field.");

    }
    @Test
    public void TC_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("123@34.567");
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys("123");

        WebElement loginBtnElement = driver.findElement(By.id("send2"));
        loginBtnElement.click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email"))
                .getText(), "Please enter a valid email address. For example johndoe@domain.com.");

    }
    @Test
    public void TC_03_Invalid_Password(){
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("123@gmail.com");
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys("123");

        WebElement loginBtnElement = driver.findElement(By.id("send2"));
        loginBtnElement.click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass"))
                .getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }
    @Test
    public void TC_04_Incorect_Email_Or_Password(){
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys("gihosah118@molyg.com");
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys("12345678");

        WebElement loginBtnElement = driver.findElement(By.id("send2"));
        loginBtnElement.click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span"))
                .getText(), "Invalid login or password.");

//        emailElement = driver.findElement(By.id("email"));
//        emailElement.clear();
//       passwordElement = driver.findElement(By.id("pass"));
//        passwordElement.clear();
//
//        driver.findElement(By.id("email")).sendKeys("automationfc@gmail.com");
//        driver.findElement(By.id("pass")).sendKeys("12345678");
//
//        loginBtnElement.click();
//        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span"))
//                .getText(), "Invalid login or password.");
    }
    @Test
    public void TC_05_Login_Successfully(){
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);
        // register
        WebElement createAnAccountElement = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnAccountElement.click();
        sleepInSeconds(3);
        String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(),password ="12345678";
        String fullName = firstName + " " + lastName;
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("input#is_subscribed")).isSelected();
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        // verify register success
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span"))
                .getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong"))
                .getText(),"Hello, "+ fullName + "!");
        String contactInfor = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p"))
                .getText();
        Assert.assertTrue(contactInfor.contains(fullName));
        Assert.assertTrue(contactInfor.contains(emailAddress));
        // log out
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSeconds(3);
        driver.findElement(By.xpath("//a[@title='Log Out']")).click();
        sleepInSeconds(5);
        //login
        myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(emailAddress);
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys(password);

        WebElement loginBtnElement = driver.findElement(By.id("send2"));
        loginBtnElement.click();
        //verify login
        contactInfor = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p"))
                .getText();
        Assert.assertTrue(contactInfor.contains(fullName));
        Assert.assertTrue(contactInfor.contains(emailAddress));
        // verify account
        driver.findElement(By.xpath("//a[text()='Account Information']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname"))
                .getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname"))
                .getAttribute("value"),lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email"))
                .getAttribute("value"),emailAddress);








    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public void sleepInSeconds (long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";

    }
}
