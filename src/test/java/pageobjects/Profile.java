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
public class Profile {

    RemoteWebDriver driver;

    @FindBy(how = How.ID, using = "users_list_table")
    @CacheLookup
    public static WebElement usersListTable;

    /**
     * Constructor that fetches the driver from ThreadLocal
     */
    public Profile() {
        driver = DriverFactory.getDriver();
    }

    /**
     * This class initializes the fields of this class on the Webdriver
     * @return an instance object of this class
     */
    public Profile initPage() {
        return PageFactory.initElements(driver, Profile.class);
    }

}
