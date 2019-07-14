package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.Driver;

public class LoginSteps {

    Driver driver = new Driver();

    RemoteWebDriver getDriver() {
        return driver.getDriver();
    }

    @BeforeClass
    public void beforeAll() {
        System.out.println(System.getProperty("seleniumDriver"));
    }

    @Given("^Second step$")
    public void secondStep() throws Throwable {
        getDriver().get("https://waesworks.bitbucket.io/");
        Thread.sleep(20000);
    }

}