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

public class Topic_07_Webbrowser_Command02 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
    @Test
    public void TC_01_Page_Url() {
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        WebElement createAnAccountElement = driver.findElement((By.xpath("//a[@title='Create an Account']")));
        createAnAccountElement.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");


    }
    @Test
    public void TC_02_Page_Title() {
        driver.get("http://live.techpanda.org/");
        WebElement myAccountElement = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));
        myAccountElement.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getTitle(),"Customer Login");

        WebElement createAnAccountElement = driver.findElement((By.xpath("//a[@title='Create an Account']")));
        createAnAccountElement.click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");






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

}
