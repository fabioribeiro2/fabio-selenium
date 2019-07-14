package setup.drivers;

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
