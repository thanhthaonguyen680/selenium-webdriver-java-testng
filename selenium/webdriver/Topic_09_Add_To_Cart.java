package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_Add_To_Cart {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Add_To_Cart(){
        driver.get("https://www.emma-sleep.com.sg/products/flip-topper");
        sleepInSeconds(3);
        WebElement dropdownList = driver.findElement(By.id("Option-template--22117378523454__main-product-0"));
        dropdownList.click();
    }
    @AfterClass

//    public void afterClass() {driver.quit();}
    public void sleepInSeconds (long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
