package framework.impl;

import framework.AvailableLocatorModes;
import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import setup.drivers.DriverFactory;

public class TextField extends General {

    RemoteWebDriver driver;
    Presence presence = new Presence();

    /**
     * Fetches Driver from ThreadLocal
     */
    public TextField() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Fills the field with text
     * @param field Field name, refers to a field in the PageObjects class
     * @param text Text to be typed into the element
     * @param page PageObjects class
     * @throws NoSuchFieldException
     */
    public void fill(String field, String text, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement textElement = getWebElementFieldFromClass(pageClass, field);

        presence.waitForElementPresence(textElement, page);
        textElement.sendKeys(text);
    }
}
