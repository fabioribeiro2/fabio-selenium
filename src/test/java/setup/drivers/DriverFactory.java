package setup.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;

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
