package framework.impl;

import framework.AvailableLocatorModes;
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

    public void click(String linkName, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement link = getWebElementFieldFromClass(pageClass, linkName);

        presence.waitForElementPresence(link, page);
        link.click();
    }
}
