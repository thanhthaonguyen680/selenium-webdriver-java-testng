package PageObjects;

import PageUIs.RegisterPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.CLICK_LOGIN_BUTTON);
        clickToElement(driver,RegisterPageUI.CLICK_LOGIN_BUTTON);
    }

    public String getErrorMessageAtFirstName() {
         waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
         return getElementText(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

    }

    public String getErrorMessageAtLastName() {
        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);

    }



    public String getErrorMessageAtEmail() {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);

    }

    public String getErrorMessageAtPassword() {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPassword() {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void inputToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.FIRSTNAME_TEXTBOX,firstName);
    }

    public void inputToLastNameTextBox(String lastName) {
        waitForElementVisible(driver,RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.LASTNAME_TEXTBOX,lastName);
    }


    public void inputToEmailTextBox(String email) {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);

    }

    public void inputToPasswordTextBox(String passWord) {
        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,passWord);
    }

    public void inputToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);

    }

    public String getErrorEmailTextBox() {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);

    }

    public String getSuccessEmailMessage() {
        waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE);
        return getElementText(driver,RegisterPageUI.REGISTER_SUCCESSFULLY_MESSAGE);

    }


    public void clickToLogOutLink() {
        waitForElementClickable(driver,RegisterPageUI.LOG_OUT_LINK);
        clickToElement(driver,RegisterPageUI.LOG_OUT_LINK);
    }

    public String getErrorExistEmailMessage() {
        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_EXIST_MESSAGE);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_EXIST_MESSAGE);
    }

    public String getErrorPassword() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_CHARACTER_MESSAGE);
        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_CHARACTER_MESSAGE);
    }

    public String getErrorPasswordNotMatch() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_NOT_MATCH_MESSAGE);
        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_NOT_MATCH_MESSAGE);

    }
}
