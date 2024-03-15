package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01() {
        driver.get("");
        driver.quit();
        // Close broswer dont care have any tab
        driver.close();
        // close tab đang active nếu có nhiều tab
        // close broswer nếu có 1
        WebElement emailAddress = driver.findElement(By.id("email"));
        // WebElement cũng là một kiểu dữ
        // trả về 1 element nếu tìm thấy>1 cũng trả về 1 ( thao tác cái đầu tiên)
        //  nó sẽ đi tìm 1 loại by nào và trả về 1 danh sách element nếu được tìm thấy. ( list Element)
        driver.findElements(By.xpath("//input[@type='checkbox']"));
        // lấy ra src page HTML
        // verify một cach tương đối.
        driver.getPageSource();
        driver.getCurrentUrl().contains("");
        Assert.assertTrue(driver.getCurrentUrl().contains(""));
        driver.getTitle();
        // lấy title của page hiện
        driver.getWindowHandle();
        // lấy ra ID của cua sổ/ tab hiện/ ID/ handle window
        driver.getWindowHandles();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // chờ cho page dc load xong



    }
    @Test
    public void TC_02() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
