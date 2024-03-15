package JavaTester.AccModSecond;

import JavaTester.AccModFirst.Annimal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dog {
    WebDriver driver;

    Annimal annimal = new Annimal();
    public void showProperty(){
        System.out.println(annimal.weight);
    }
}
