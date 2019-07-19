package stepdefinitions;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import framework.impl.*;
import setup.drivers.SharedDriver;

public class GeneralSteps {

    Navigation navigation;
    Presence presence;
    Link link;
    TextField textField;
    Combo combo;
    Button button;

    /**
     * This class runs before any scenario in the features that use its function
     * It initializes the webdriver and underlying framework classes
     */
    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        navigation = new Navigation();
        presence = new Presence();
        link = new Link();
        textField = new TextField();
        combo = new Combo();
        button = new Button();
    }

    @Given("I navigate to url {string}")
    public void navigateToUrl(String url) {
        navigation.navigateToUrl(url);
    }

}