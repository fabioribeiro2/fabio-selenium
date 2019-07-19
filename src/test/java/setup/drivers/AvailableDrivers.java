package setup.drivers;

/**
 * Enum for keeping supported Selenium Drivers list
 */
public enum AvailableDrivers {

    CHROME("chrome"),
    FIREFOX("firefox");

    private String driver;

    AvailableDrivers(String driver) {
        this.driver = driver;
    }

    public String driver() {
        return driver;
    }
}
