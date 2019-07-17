package framework.impl;

import framework.General;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;
import setup.drivers.SharedDriver;


public class Navigation extends General {

    RemoteWebDriver driver;

    public Navigation() {
        driver = DriverFactory.getDriver();
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
