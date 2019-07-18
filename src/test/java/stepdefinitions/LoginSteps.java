package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.impl.*;
import setup.drivers.SharedDriver;

public class LoginSteps {

    private static final String LOGIN_PAGE = "Login";
    private static final String LOGIN_BUTTON = "loginButton";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String LOGIN_LINK = "loginLink";
    private static final String LOGOUT_LINK = "logoutLink";
    private static final String ASSIGNMENT_LINK = "assignmentLink";
    private static final String PROFILE_LINK = "profileLink";
    private static final String DETAILS_LINK = "detailsLink";
    private static final String SIGNUP_LINK = "signupLink";


    Button button;
    Navigation navigation;
    Presence presence;
    Link link;
    TextField textField;

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        navigation = new Navigation();
        presence = new Presence();
        link = new Link();
        textField = new TextField();
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

    @When("Log out link is present on screen")
    public void whenLogoutLinkPresent() {
        presence.waitForElementPresence(LOGOUT_LINK, LOGIN_PAGE);
    }

    @Then("Logout link is present on screen")
    public void thenLogoutLinkPresent() {
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

    @When("Sign up link is not present on screen")
    public void signupLinkNotPresent() {
        presence.waitForElementToDisappear(SIGNUP_LINK, LOGIN_PAGE);
    }

    @Then("Sign up link is present on screen")
    public void signupLinkPresent() {
        presence.waitForElementPresence(SIGNUP_LINK, LOGIN_PAGE);
    }

    @Then("Login link is present on screen")
    public void loginLinkPresent() {
        presence.waitForElementPresence(LOGIN_LINK, LOGIN_PAGE);
    }

    @Then("Login button is present on screen")
    public void loginButtonPresent() {
        presence.waitForElementPresence(LOGIN_BUTTON, LOGIN_PAGE);
    }

    @When("I log out")
    public void logout() {
        link.click(LOGOUT_LINK, LOGIN_PAGE);
        presence.waitForElementPresence(LOGIN_BUTTON, LOGIN_PAGE);
    }

    @When("Wrong credentials message is shown on screen")
    public void wrongCredentialsMessage() {
        presence.waitForTextPresence("Wrong credentials. You can do it, try again!");
    }

}