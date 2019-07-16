package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import pages.General;
import setup.drivers.SharedDriver;

public class GeneralSteps {

    General general;

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        general = new General();
    }

    @Given("I navigate to url {string}")
    public void navigateToUrl(String url) {
        general.navigateToUrl(url);
    }

    @Given("I reopen browser")
    public void reopenBrowser() {
        general.reopenBrowser();
    }
}