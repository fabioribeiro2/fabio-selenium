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

    /**
     * Fetches Driver from ThreadLocal
     */
    public Combo() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Selects a value from a combo box
     * @param field combo name, refers to a field in the PageObjects class
     * @param value Value to be picked in the combobox
     * @param page PageObjects class
     * @throws NoSuchFieldException
     */
    public void select(String field, String value, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement comboElement = getWebElementFieldFromClass(pageClass, field);

        final Select selectBox = new Select(comboElement);
        selectBox.selectByValue(value);
    }
}
