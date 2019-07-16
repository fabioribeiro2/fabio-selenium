package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.drivers.DriverFactory;

public class LoginPage {

    RemoteWebDriver driver;

    @FindBy(how = How.ID, using = "login_button")
    @CacheLookup
    private static WebElement loginButton;

    @FindBy(how = How.ID, using = "username_input")
    @CacheLookup
    private static WebElement username;

    @FindBy(how = How.ID, using = "password_input")
    @CacheLookup
    private static WebElement password;

    @FindBy(how = How.LINK_TEXT, using = "log out")
    @CacheLookup
    private static WebElement logoutLink;

//    private WebElement jones;
//    private WebElement jones;
//    private WebElement jones;
//    private WebElement jones;
//    private WebElement jones;
//    private WebElement jones;
//    private WebElement jones;

    public LoginPage() {
        driver = DriverFactory.getDriver();
    }

    public LoginPage initPage() {
        return PageFactory.initElements(driver, LoginPage.class);
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

    public static void clickLogoutButton() {
        logoutLink.click();

    }

    public static WebElement getLoginButton() {
        return loginButton;
    }

    public static WebElement getUsername() {
        return username;
    }

    public static WebElement getPassword() {
        return password;
    }

    public static WebElement getLogoutLink() {
        return logoutLink;
    }
}
