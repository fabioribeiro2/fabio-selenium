package xpath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.drivers.DriverFactory;

public class Login {

    public static String loginButton = "//input[@id='login_button']";

    public static String loginLink = "//a[@id='login_link']";

    public static String username;

    public static String password;

    public static String logoutLink;

    public static String assignmentLink = "//a[text()='here']";

    public static String profileLink;

    public static String detailsLink;

    public static String yourProfileText;

    public static String signupLink = "//a[@id='signup_link']";

}
