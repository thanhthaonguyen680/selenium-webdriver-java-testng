package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

    }
    // TestNG order testcase theo alphabet
    @Test
    public void TC_01_ID() {
        // có 8 loại locators:
        // Selenium locator: HTML attribute
        // Id/Class/Name
        // Link text/ partial linktext ( thẻ a)
        // tag name: HTML tag name
        // Css/ Xpath
        // Riêng verion 4 sẽ có thêm:
        // Class - Relative  ( GUI testing)
        driver.findElement(By.id("FirstName")).sendKeys("Thao");




    }
    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));

    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }
    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_05_Linktext() {
        driver.findElement(By.linkText("Shipping & returns"));
    }
    // tuyệt đối
    @Test
    public void TC_06_Partial_Linktext() {
        driver.findElement(By.partialLinkText("vendor account"));
    }
    // tương đối
    @Test
    public void TC_07_CSS() {
        driver.findElement(By.cssSelector("input[id ='FirstName']"));
        driver.findElement(By.cssSelector("#FirstName"));
        // CSS với ID
        driver.findElement(By.cssSelector("div[class = 'page - title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
        // CSS với Name
        driver.findElement(By.cssSelector("div[name = 'FirstName']"));
        // CSS với Tagname
        driver.findElement(By.cssSelector("input"));
        // CSs với Link
        driver.findElement(By.cssSelector("a[href = '/customer/addresses']"));
    }
    @Test
    public void TC_08_Xpath() {
        driver.findElement(By.xpath("//input[@id ='FirstName']"));
        //  Xpath với ID
        driver.findElement(By.xpath("//div[@class = 'page - title']"));
        // Xpath với Name
        driver.findElement(By.xpath("//div[@name = 'FirstName']"));
        // Xpath với Tagname
        driver.findElement(By.xpath("//input"));
        // Xpath với Link
        driver.findElement(By.xpath("//a[@href = '/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));
        // Xpath vs partical link
        driver.findElement(By.xpath("//a[contain =(@href,'addresses')]"));

    }
     // text()=
    // contains(text())
    // contains(string())

        @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
