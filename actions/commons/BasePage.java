package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class BasePage {
    public static BasePage getBasePageObject(){
        return new BasePage();


    }
    // common function
    // hàm window
    public void openPageURL(WebDriver driver, String pageURL)
    {
        driver.get(pageURL);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();

    }

    public String getPageURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }
    public void refreshToPage(WebDriver driver) {
        driver.navigate().refresh();
    }
    public Alert waitForAlertPresence(WebDriver driver){
       WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(30));
       return explicitwait.until(ExpectedConditions.alertIsPresent());

    }
    public void acceptAlert(WebDriver driver) {
      waitForAlertPresence(driver).accept();

    }
    public void cancelAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }
    public String getlAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();

    }
    public void senkeyToAlert(WebDriver driver, String textValue){
        waitForAlertPresence(driver).sendKeys(textValue);

    }
    public void switchToWindowByID(WebDriver driver, String windowID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }
    public void switchToWindowByTitle(WebDriver driver, String tabTitle){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(tabTitle)){
                break;
            }
        }
    }
    public void closeAllTabWithoutParent(WebDriver driver, String ParentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(ParentID)){
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(ParentID);
        }
    }
    // hàm tương tác với element
    private WebElement getElement(WebDriver driver, String xpathLocator){
       return driver.findElement(xpath(xpathLocator));

    }
    private List<WebElement> getListElement(WebDriver driver, String xpathLocator){
         return driver.findElements(xpath(xpathLocator));

    }
    public void clickToElement(WebDriver driver, String xpathLocator){
        getElement(driver, xpathLocator).click();
    }
    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue){
        WebElement element = getElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }
    public String getElementText(WebDriver driver, String xpathLocator){
        return getElement(driver, xpathLocator).getText();
    }
    public void selectItemDefaultDropdowm(WebDriver driver,String xpathLocator, String textItem ){
        Select select = new Select(getElement(driver, xpathLocator));
        select.deselectByValue(textItem);

    }
    public String getFirstSelectedItemDefaultDropdown(WebDriver driver,String xpathLocator, String textItem ) {
        Select select = new Select(getElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver,String xpathLocator){
        Select select = new Select(getElement(driver, xpathLocator));
        return select.isMultiple();
    }
    public String getElementAttribute(WebDriver driver,String xpathLocator, String attributeName ){
        return getElement(driver,xpathLocator ).getAttribute(attributeName);
    }
    public String getElementCssValue(WebDriver driver,String xpathLocator, String cssValue ){
        return getElement(driver,xpathLocator ).getCssValue(cssValue);
    }
    public int getElementSize(WebDriver driver,String xpathLocator){
        return getListElement(driver,xpathLocator).size();
    }
    public void checkToDefaultCheckboxOrRadio(WebDriver driver,String xpathLocator){
        WebElement element = getElement(driver,xpathLocator);
        if (!element.isSelected()){
            element.click();
        }
    }
    public void uncheckToDefaultCheckbox(WebDriver driver,String xpathLocator){
        WebElement element = getElement(driver,xpathLocator);
        if (element.isSelected()){
            element.click();
        }
    }
    public boolean isElementDisplay(WebDriver driver,String xpathLocator){
        return getElement(driver,xpathLocator).isDisplayed();
    }
    public boolean isElementEnable(WebDriver driver,String xpathLocator){
        return getElement(driver,xpathLocator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver,String xpathLocator){
        return getElement(driver,xpathLocator).isSelected();
    }
    public void switchToFrameIframe(WebDriver driver,String xpathLocator){
        driver.switchTo().frame(getElement(driver,xpathLocator));
    }
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver,String xpathLocator){
        Actions action = new Actions(driver);
        action.moveToElement(getElement(driver,xpathLocator)).perform();

    }
    // Javascript Executor

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }



    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    private void sleepInSeconds (long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitForElementVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(xpath(locator)));

    }
    public void waitForAllElementVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath(locator)));

    }
    public void waitForElementInVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(xpath(locator)));

    }
    public void waitForAllElementInVisible(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));

    }
    public void waitForElementClickable(WebDriver driver, String locator){
        WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(xpath(locator)));

    }

}
