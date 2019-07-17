package framework.impl;

import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;

public class Button extends General {

    RemoteWebDriver driver;
    Presence presence = new Presence();

    public Button() {
        driver = DriverFactory.getDriver();
    }

    public void click(String buttonName, String page) {
        Class pageClass = getInitializedClassFromName(page);
        WebElement link = getFieldFromClass(pageClass, buttonName);

        presence.waitForElementPresence(buttonName, page);
        link.click();
    }
}
