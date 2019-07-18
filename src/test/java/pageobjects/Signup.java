package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.drivers.DriverFactory;

public class Signup {

    RemoteWebDriver driver;

    @FindBy(how = How.ID, using = "submit_button")
    @CacheLookup
    public static WebElement submitButton;

    @FindBy(how = How.ID, using = "signup_link")
    @CacheLookup
    public static WebElement signupLink;

    @FindBy(how = How.ID, using = "username_input")
    @CacheLookup
    public static WebElement username;

    @FindBy(how = How.ID, using = "password_input")
    @CacheLookup
    public static WebElement password;

    @FindBy(how = How.ID, using = "name_input")
    @CacheLookup
    public static WebElement name;

    @FindBy(how = How.ID, using = "email_input")
    @CacheLookup
    public static WebElement email;

    @FindBy(how = How.ID, using = "day_select")
    @CacheLookup
    public static WebElement dobDay;

    @FindBy(how = How.ID, using = "month_select")
    @CacheLookup
    public static WebElement dobMonth;

    @FindBy(how = How.ID, using = "year_select")
    @CacheLookup
    public static WebElement dobYear;

    public Signup() {
        driver = DriverFactory.getDriver();
    }

    public Signup initPage() {
        return PageFactory.initElements(driver, Signup.class);
    }

}
