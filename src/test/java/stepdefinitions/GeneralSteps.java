package stepdefinitions;

import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import framework.impl.Button;
import framework.impl.TextField;
import framework.impl.Navigation;
import framework.impl.Presence;
import setup.drivers.SharedDriver;

public class GeneralSteps {

    Button button = new Button();
    TextField field = new TextField();
    Navigation navigation = new Navigation();
    Presence presence = new Presence();

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
    }

    @Given("I navigate to url {string}")
    public void navigateToUrl(String url) {
        navigation.navigateToUrl(url);
    }

    @Given("I click {string} button in {word} page")
    public void clickButton(String button, String page) {
//        navigation.clickButton(button, page);
    }
}