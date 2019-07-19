package framework.impl;

import framework.AvailableLocatorModes;
import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;

public class Button extends General {

    RemoteWebDriver driver;
    Presence presence = new Presence();

    /**
     * Fetches Driver from ThreadLocal
     */
    public Button() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Clicks a button
     * @param buttonName Name of the button, refers to a field in the PageObjects Class
     * @param page PageObjects Class
     * @throws NoSuchFieldException
     */
    public void click(String buttonName, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement link = getWebElementFieldFromClass(pageClass, buttonName);

        presence.waitForElementPresence(buttonName, page);
        link.click();
    }
}
