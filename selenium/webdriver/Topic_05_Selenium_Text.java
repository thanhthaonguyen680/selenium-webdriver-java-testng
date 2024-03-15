package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Selenium_Text {
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

    }
    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");
        // truyền text vào trong locator để check display

        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']"))
                .isDisplayed();
        // get text ra rồi verify sau
        String text = driver.findElement(By.xpath("//h5[@id = 'nine']/p[1]")).getText();
        // get : Mail Personal or Business Check, Cashier's Check or money order to:
        Assert.assertTrue(text.contains("Mail Personal or Business Check, " +
                "Cashier's Check or money order to:"));
        // case text chứa khoảng trắng nhiều đầu cuối nên dùng contains(text):
        // case text có nháy đôi và đơn dùng concat
        String concatText = driver.findElement(By.xpath("//span[@class='concat']")).getText();
        Assert.assertTrue(concatText.contains("Hello \"John\", What's happened?"));



    }
    @Test
    public void TC_02() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
