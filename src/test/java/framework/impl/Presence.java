package framework.impl;

import framework.AvailableLocatorModes;
import framework.General;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.drivers.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Presence extends General {

    RemoteWebDriver driver;

    /**
     * This wait can be later configured
     */
    int explicitWait = 15;

    /**
     * Fetches the driver from ThreadLocal
     */
    public Presence() {
        driver = DriverFactory.getDriver();
    }

    /**
     * Waits for an element to be present in the Dom
     * @param elementName Name of the element - refers to a field in the PageObjects class
     * @param page PageObjects class
     * @throws NoSuchFieldException
     */
    public void waitForElementPresence(String elementName, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement element = getWebElementFieldFromClass(pageClass, elementName);
        WebDriverWait wait = new WebDriverWait(driver, explicitWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be present in the Dom
     * Receives the web element object directly
     * @param element web element to be asserted on
     * @param page PageObjects class
     */
    public void waitForElementPresence(WebElement element, String page) {
        WebDriverWait wait = new WebDriverWait(driver, explicitWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to not be present in the Dom
     * Receives the element's name, which refers to a field in the Xpath class
     * @param elementName Name of the element
     * @param page Xpath Class
     * @throws NoSuchFieldException
     */
    public void waitForElementToDisappear(String elementName, String page) throws NoSuchFieldException {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.XPATH);
        String elementXpath = getStringFieldFromClass(pageClass, elementName);
        Duration duration = Duration.ofSeconds(6L);
        Duration duration2 = Duration.ofSeconds(2L);
        FluentWait wait = new FluentWait(driver).withTimeout(duration).pollingEvery(duration2).ignoring(NoSuchElementException.class);

        wait.until(new Function<RemoteWebDriver, Boolean>() {
            @Override
            public Boolean apply(RemoteWebDriver driver) {
                WebElement body = driver.findElement(By.tagName("body"));
                List<WebElement> el1 = body.findElements(By.xpath(elementXpath));
                return el1.size() == 0;
            }
        });
    }

    /**
     * Waits for presence of a string of text in the Dom
     * Uses dynamic function calling instead of ExpectedConditions
     * @param text Text to be searched for in the screen
     */
    public void waitForTextPresence(String text) {
        Duration duration = Duration.ofSeconds(6L);
        Duration duration2 = Duration.ofSeconds(2L);
        FluentWait wait = new FluentWait(driver).withTimeout(duration).pollingEvery(duration2).ignoring(NoSuchElementException.class);

        wait.until(new Function<RemoteWebDriver, Boolean>() {
            @Override
            public Boolean apply(RemoteWebDriver driver) {
                WebElement body = driver.findElement(By.tagName("body"));
                String bodyText = body.getText();
                return bodyText.contains(text);
            }
        });

    }

}
