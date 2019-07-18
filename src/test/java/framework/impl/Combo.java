package framework.impl;

import framework.AvailableLocatorModes;
import framework.General;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import setup.drivers.DriverFactory;

public class Combo extends General {

    RemoteWebDriver driver;
    Presence presence = new Presence();

    public Combo() {
        driver = DriverFactory.getDriver();
    }

    public void select(String field, String value, String page) {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement comboElement = getWebElementFieldFromClass(pageClass, field);

        final Select selectBox = new Select(comboElement);
        selectBox.selectByValue(value);
    }
}
