package framework.impl;

import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;

public class Link extends General {

    Presence presence = new Presence();

    RemoteWebDriver driver;

    public Link() {
        driver = DriverFactory.getDriver();
    }

    public void click(String linkName, String page) {
        Class pageClass = getInitializedClassFromName(page);
        WebElement link = getFieldFromClass(pageClass, linkName);

        presence.waitForElementPresence(linkName, page);
        link.click();
    }
}
