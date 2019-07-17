package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.impl.*;
import setup.drivers.SharedDriver;

public class LoginSteps {

    public static final String LOGIN_PAGE = "Login";
    public static final String LOGIN_BUTTON = "loginButton";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String LOGIN_LINK = "loginLink";
    public static final String LOGOUT_LINK = "logoutLink";
    public static final String ASSIGNMENT_LINK = "assignmentLink";
    public static final String PROFILE_LINK = "profileLink";
    public static final String DETAILS_LINK = "detailsLink";
    private static final String SIGNUP_LINK = "signupLink";


    Button button = new Button();
    TextField field = new TextField();
    Navigation navigation = new Navigation();
    Presence presence = new Presence();
    Link link = new Link();
    TextField textField = new TextField();

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
    }

    @After("@login")
    public void afterReopenBrowser() {
        navigation.reopenBrowser();
    }

    @Given("I click Login link in Login page")
    public void clickLink() {
        link.click(LOGIN_LINK, LOGIN_PAGE);
        presence.waitForElementToDisappear(ASSIGNMENT_LINK, LOGIN_PAGE);
    }

    @Then("I am in Login screen")
    public void loginScreen() {
        presence.waitForElementPresence(USERNAME, LOGIN_PAGE);
    }

    @Given("User {string} logs in using password {string}")
    public void userLogsIn(String user, String password) {
        textField.fill(USERNAME, user, LOGIN_PAGE);
        textField.fill(PASSWORD, password, LOGIN_PAGE);
        button.click(LOGIN_BUTTON, LOGIN_PAGE);
    }

    @Given("message {string} is present on screen")
    public void messagePresent(String message) {
        presence.waitForElementPresence(message, LOGIN_PAGE);
    }

    @Then("Log out link is present on screen")
    public void logoutLinkPresent() {
        presence.waitForElementPresence(LOGOUT_LINK, LOGIN_PAGE);
    }

    @Then("Profile link is present on screen")
    public void profileLinkPresent() {
        presence.waitForElementPresence(PROFILE_LINK, LOGIN_PAGE);
    }

    @Then("Details link is present on screen")
    public void detailsLinkPresent() {
        presence.waitForElementPresence(DETAILS_LINK, LOGIN_PAGE);
    }

    @Then("the user has super power {string}")
    public void usersSuperPower(String superPower) {
        presence.waitForTextPresence(superPower);
    }

    @Then("Log in link is not present on screen")
    public void loginLinkNotPresent() {
        presence.waitForElementToDisappear(LOGIN_LINK, LOGIN_PAGE);
    }

    @Then("Sign up link is not present on screen")
    public void signupLinkNotPresent() {
        presence.waitForElementToDisappear(SIGNUP_LINK, LOGIN_PAGE);
    }
}