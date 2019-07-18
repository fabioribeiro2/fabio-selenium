package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.impl.*;
import setup.drivers.SharedDriver;

public class SignupSteps {

    private static final String LOGIN_PAGE = "Login";
    private static final String SIGNUP_PAGE = "Signup";
    private static final String SUBMIT_BUTTON = "submitButton";
    private static final String LOGIN_BUTTON = "loginButton";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String LOGOUT_LINK = "logoutLink";
    private static final String PROFILE_LINK = "profileLink";
    private static final String DETAILS_LINK = "detailsLink";
    private static final String SIGNUP_LINK = "signupLink";
    private static final String LOGIN_LINK = "loginLink";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    public static final String DOB_DAY = "dobDay";
    public static final String DOB_MONTH = "dobMonth";
    public static final String DOB_YEAR = "dobYear";


    Button button;
    Navigation navigation;
    Presence presence;
    Link link;
    TextField textField;
    Combo combo;

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        navigation = new Navigation();
        presence = new Presence();
        link = new Link();
        textField = new TextField();
        combo = new Combo();
    }

    @After("@signup")
    public void afterReopenBrowser() {
        navigation.reopenBrowser();
    }

    @Given("I click Sign up link")
    public void clickSignupLink() {
        link.click(SIGNUP_LINK, SIGNUP_PAGE);
        presence.waitForElementToDisappear(LOGIN_BUTTON, LOGIN_PAGE);
        presence.waitForElementPresence(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @Given("I fill Username field with value {string}")
    public void fillUsername(String fieldValue) {
        textField.fill(USERNAME, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Password field with value {string}")
    public void fillPassword(String fieldValue) {
        textField.fill(PASSWORD, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Name field with value {string}")
    public void fillName(String fieldValue) {
        textField.fill(NAME, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill E-mail field with value {string}")
    public void fillEmail(String fieldValue) {
        textField.fill(EMAIL, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Day combo with value {string}")
    public void fillDobDay(String fieldValue) {
        combo.select(DOB_DAY, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Month combo with value {string}")
    public void fillDobMonth(String fieldValue) {
        combo.select(DOB_MONTH, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Year combo with value {string}")
    public void fillDobYear(String fieldValue) {
        combo.select(DOB_YEAR, fieldValue, SIGNUP_PAGE);
    }

    @Given("I click Submit button")
    public void clickSubmitButton() {
        link.click(SUBMIT_BUTTON, SIGNUP_PAGE);
        presence.waitForElementToDisappear(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @When("I should be on the User Profile page")
    public void userProfileLanding() {
        presence.waitForElementPresence(PROFILE_LINK, LOGIN_PAGE);
        presence.waitForElementPresence(DETAILS_LINK, LOGIN_PAGE);
    }

    @When("I should see text {string} on screen")
    public void messageOnScreen(String message) {
        presence.waitForTextPresence(message);
    }

}