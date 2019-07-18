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

public class Presence extends General {

    RemoteWebDriver driver;

    public Presence() {
        driver = DriverFactory.getDriver();
    }

    public void waitForElementPresence(String elementName, String page) {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.PAGE_OBJECTS);
        WebElement element = getWebElementFieldFromClass(pageClass, elementName);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresence(WebElement element, String page) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(String elementName, String page) {
        Class pageClass = getInitializedClassFromName(page, AvailableLocatorModes.XPATH);
        String elementXpath = getStringFieldFromClass(pageClass, elementName);
        Duration duration = Duration.ofSeconds(6L);
        Duration duration2 = Duration.ofSeconds(2L);
        FluentWait wait = new FluentWait(driver).withTimeout(duration).pollingEvery(duration2).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
    }

    public void waitForTextPresence(String text) {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains(text));
    }

}
