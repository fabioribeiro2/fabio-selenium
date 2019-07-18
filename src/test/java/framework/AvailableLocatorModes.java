package framework;

public enum AvailableLocatorModes {

    XPATH("xpath"),
    PAGE_OBJECTS("pageobjects");

    private String mode;

    AvailableLocatorModes(String mode) {
        this.mode = mode;
    }

    public String mode() {
        return mode;
    }
}
