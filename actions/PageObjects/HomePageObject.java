package PageObjects;

import PageUIs.HomePageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    // create constructor
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


        public void clickToRegisterLink (){
            waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
           clickToElement(driver, HomePageUI.REGISTER_LINK);
    }
}
