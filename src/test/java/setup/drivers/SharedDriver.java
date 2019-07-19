package setup.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.sql.Driver;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SharedDriver {

    RemoteWebDriver driver;
    public static final int IMPLICIT_WAIT_SECONDS = 3;

    /**
     * This is the constructor for this class
     * It initializes the drivers for each Thread and adds them to a ThreadLocal object
     * It also initializes useful options for the driver, such as:
     * - Implicit Wait period
     * - Which driver to use among available choices (Chrome, Firefox, etc) - Default: Chrome
     * - Headless option
     *
     */

    public SharedDriver() {
        if (DriverFactory.getDriver() != null) {
            return;
        } else {
            String seleniumDriver = System.getProperty("seleniumDriver");
            if (!isDriverAvailable(seleniumDriver)) {
                //logger
                seleniumDriver = AvailableDrivers.CHROME.driver();
            }
            String headlessOption = System.getProperty("headless");
            String implicitTimeoutString = System.getProperty("implicitTimeoutSeconds");
            int implicitWaitSeconds;
            if (implicitTimeoutString != null && implicitTimeoutString.length() > 0) {
                implicitWaitSeconds = Integer.parseInt(implicitTimeoutString);
            } else {
                implicitWaitSeconds = IMPLICIT_WAIT_SECONDS;
            }
            switch (seleniumDriver) {

                case "chrome":
                    driver = setupChromeDriver(headlessOption, implicitWaitSeconds);
                    break;
                case "firefox":
                    driver = setupFirefoxDriver(headlessOption, implicitWaitSeconds);
                    break;
                default:
                    driver = setupChromeDriver(headlessOption, implicitWaitSeconds);
                    break;
            }
            DriverFactory.addDriver(driver);
        }
    }

    /**
     * This method validates the choice of Selenium Driver
     * Against supported versions of drivers in this framework
     * @param seleniumDriver Selenium choice of user
     * @return if it is supported
     */
    private boolean isDriverAvailable(String seleniumDriver) {
        for (AvailableDrivers availableDriver : AvailableDrivers.values()) {
            if (seleniumDriver == availableDriver.driver()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets up the chrome driver
     * @param headlessOption On or Off
     * @param implicitWaitSeconds Implicit wait in seconds
     * @return the configured driver
     */
    private ChromeDriver setupChromeDriver(String headlessOption, int implicitWaitSeconds) {
        final DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        final ChromeOptions chromeOptions = new ChromeOptions();
        if (headlessOption != null && headlessOption.equalsIgnoreCase("on")) {
            chromeOptions.setBinary("/usr/bin/chromium-browser");
            chromeOptions.addArguments("--headless");
        }
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(implicitWaitSeconds, TimeUnit.SECONDS);
        return (ChromeDriver) driver;
    }

    /**
     * Sets up the firefox driver
     * @param headlessOption On or Off
     * @param implicitWaitSeconds Implicit wait in seconds
     * @return the configured driver
     */
    private FirefoxDriver setupFirefoxDriver(String headlessOption, int implicitWaitSeconds) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headlessOption != null && headlessOption.equalsIgnoreCase("on")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            firefoxOptions.setBinary(firefoxBinary);
        }
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(implicitWaitSeconds, TimeUnit.SECONDS);
        return (FirefoxDriver) driver;
    }
}
