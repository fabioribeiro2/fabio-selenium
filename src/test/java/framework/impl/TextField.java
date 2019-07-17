package framework.impl;

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
        Class pageClass = getInitializedClassFromName(page);
        WebElement textElement = getFieldFromClass(pageClass, field);

        presence.waitForElementPresence(textElement, page);
        textElement.sendKeys(text);
    }
}
