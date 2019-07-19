package setup.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that sets up and stores WebDriver objects in a ThreadLocal list
 * This ensures that for each framework thread (which is run per feature file), only one driver is initialized
 * This also ensures that drivers shut down at the end of the feature test
 */
public final class DriverFactory {
    private static ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    private static List<RemoteWebDriver> storedDrivers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                storedDrivers.stream().forEach(WebDriver::quit);
            }
        });
    }

    private DriverFactory() {

    }

    public static RemoteWebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(RemoteWebDriver driver) {
        storedDrivers.add(driver);
        drivers.set(driver);
    }

    public static void removeDriver(RemoteWebDriver driver) {
        storedDrivers.remove(drivers.get());
        drivers.remove();
    }
}
