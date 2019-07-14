package setup.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class Driver {

    RemoteWebDriver driver;

    public RemoteWebDriver getDriver() {
        String seleniumDriver = System.getProperty("seleniumDriver");
        if (!isDriverAvailable(seleniumDriver)) {
            //logger
            seleniumDriver = AvailableDrivers.CHROME.driver();
        }
        String headlessOption = System.getProperty("headless");
        if (driver == null) {
            switch (seleniumDriver) {

                case "chrome":
                    driver = setupChromeDriver(headlessOption);
                    return driver;
                case "firefox":
                    driver = setupFirefoxDriver(headlessOption);
                    return driver;
                default:
                    driver = setupChromeDriver(headlessOption);
                    return driver;
            }
        } else {
            return driver;
        }
    }

    private boolean isDriverAvailable(String seleniumDriver) {
        for (AvailableDrivers availableDriver : AvailableDrivers.values()) {
            if (seleniumDriver == availableDriver.driver()) {
                return true;
            }
        }
        return false;
    }

    private ChromeDriver setupChromeDriver(String headlessOption) {
        final DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        final ChromeOptions chromeOptions = new ChromeOptions();
        if (headlessOption != null && headlessOption.equalsIgnoreCase("on")) {
            chromeOptions.setBinary("/usr/bin/chromium-browser");
            chromeOptions.addArguments("--headless");
        }
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        return (ChromeDriver) driver;
    }

    private FirefoxDriver setupFirefoxDriver(String headlessOption) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headlessOption != null && headlessOption.equalsIgnoreCase("on")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
//                    System.setProperty("webdriver.gecko.driver", "/home/ndipiazza/Desktop/geckodriver");
            firefoxOptions.setBinary(firefoxBinary);
        }
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        driver = new FirefoxDriver(firefoxOptions);
        return (FirefoxDriver) driver;
    }
}
