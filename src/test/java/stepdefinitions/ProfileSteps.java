package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.impl.*;
import setup.drivers.SharedDriver;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProfileSteps {

    private static final String USER_LIST = "usersListTable";
    private static final String PROFILE_PAGE = "Profile";


    Button button;
    Navigation navigation;
    Presence presence;
    Link link;
    TextField textField;
    Combo combo;

    /**
     * This class runs before any scenario in the feature Profile runs
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

    /**
     * This class runs after each Scenario in Profile feature
     * It reopens the browser, to ensure fresh context in each scenario
     */
    @After("@profile")
    public void afterReopenBrowser() {
        navigation.reopenBrowser();
    }

    @Then("User Table List should be present")
    public void userListPresent() throws NoSuchFieldException {
        presence.waitForElementPresence(USER_LIST, PROFILE_PAGE);
    }

    @Then("User Table List should not be present")
    public void userListNotPresent() throws NoSuchFieldException {
        presence.waitForElementToDisappear(USER_LIST, PROFILE_PAGE);
    }

}