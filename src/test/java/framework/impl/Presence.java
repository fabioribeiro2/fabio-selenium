package framework.impl;

import framework.General;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.drivers.DriverFactory;
import support.Wait;

public class Presence extends General {

    RemoteWebDriver driver;

    public Presence() {
        driver = DriverFactory.getDriver();
    }

    public void waitForElementPresence(String elementName, String page) {
        Class pageClass = getInitializedClassFromName(page);
        WebElement element = getFieldFromClass(pageClass, elementName);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresence(WebElement element, String page) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToDisappear(String elementName, String page) {
        Class pageClass = getInitializedClassFromName(page);
        WebElement element = getFieldFromClass(pageClass, elementName);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextPresence(String text) {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains(text));
    }

}
