package stepdefinitions;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import framework.impl.Button;
import framework.impl.TextField;
import framework.impl.Navigation;
import framework.impl.Presence;
import setup.drivers.SharedDriver;

public class GeneralSteps {

    Button button;
    TextField field;
    Navigation navigation;
    Presence presence;

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        button = new Button();
        field = new TextField();
        navigation = new Navigation();
        presence = new Presence();
    }

    @Given("I navigate to url {string}")
    public void navigateToUrl(String url) {
        navigation.navigateToUrl(url);
    }

}