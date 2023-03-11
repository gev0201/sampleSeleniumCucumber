package sample.qa.pages;

import sample.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {

    @FindBy(css = "[alt = 'company-branding']")
    WebElement lable;

    @FindBy(name = "username")
    WebElement userNameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement loginButton;

    @FindBy(css = "[placeholder = 'Search']")
    WebElement searchInput;

    @FindBy(css = "[role='alert']")
    WebElement errorMessage;


    // Initializing the Page Objects:
    public LandingPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPageLable() {
        lable.isDisplayed();
    }

    public void inputCredentials(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public void isLoggedIn(){
        searchInput.isDisplayed();

    }

    public void verifyErrorMessage() {
        errorMessage.isDisplayed();
    }

    public void quitDriver(){
        driver.quit();
    }
}
