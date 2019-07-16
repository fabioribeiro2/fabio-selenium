package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import setup.drivers.DriverFactory;
import setup.drivers.SharedDriver;

public class GeneralPage {

    RemoteWebDriver driver;

    public GeneralPage() {
        driver = DriverFactory.getDriver();
    }

    public GeneralPage initPage() {
        return PageFactory.initElements(driver, GeneralPage.class);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void reopenBrowser() {
        driver.quit();
        DriverFactory.removeDriver(driver);
        new SharedDriver();
        driver = DriverFactory.getDriver();
    }
}
