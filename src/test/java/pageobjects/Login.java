package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.drivers.DriverFactory;

/**
 * This is the PageObjects class for screen Signup
 */
public class Login {

    RemoteWebDriver driver;

    @FindBy(how = How.ID, using = "login_button")
    @CacheLookup
    public static WebElement loginButton;

    @FindBy(how = How.ID, using = "login_link")
    @CacheLookup
    public static WebElement loginLink;

    @FindBy(how = How.ID, using = "username_input")
    @CacheLookup
    public static WebElement username;

    @FindBy(how = How.ID, using = "password_input")
    @CacheLookup
    public static WebElement password;

    @FindBy(how = How.LINK_TEXT, using = "log out")
    @CacheLookup
    public static WebElement logoutLink;

    @FindBy(how = How.LINK_TEXT, using = "here")
    @CacheLookup
    public static WebElement assignmentLink;

    @FindBy(how = How.ID, using = "profile_link")
    @CacheLookup
    public static WebElement profileLink;

    @FindBy(how = How.ID, using = "details_link")
    @CacheLookup
    public static WebElement detailsLink;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your Profile')]")
    @CacheLookup
    public static WebElement yourProfileText;

    @FindBy(how = How.LINK_TEXT, using = "SignUp")
    @CacheLookup
    public static WebElement signupLink;

    /**
     * Constructor that fetches the driver from ThreadLocal
     */
    public Login() {
        driver = DriverFactory.getDriver();
    }

    /**
     * This class initializes the fields of this class on the Webdriver
     * @return an instance object of this class
     */
    public Login initPage() {
        return PageFactory.initElements(driver, Login.class);
    }

    public static void fillUsername(String text) {
        username.sendKeys(text);
    }

    public static void fillPassword(String text) {
        password.sendKeys(text);
    }

    public static void clickLoginButton() {
        loginButton.click();
    }

    public static void clickLoginLink() {
        loginLink.click();
    }

    public static void clickLogoutButton() {
        logoutLink.click();
    }
}
