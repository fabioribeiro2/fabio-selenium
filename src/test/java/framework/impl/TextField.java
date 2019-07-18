package framework.impl;

import framework.AvailableLocatorModes;
import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;

public class TextField extends General {

    RemoteWebDriver driver;
    Presence presence = new Presence();

    public TextField() {
        driver = DriverFactory.getDriver();
    }

    public void fill(String field, String text, String page) {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement textElement = getWebElementFieldFromClass(pageClass, field);

        presence.waitForElementPresence(textElement, page);
        textElement.sendKeys(text);
    }
}
