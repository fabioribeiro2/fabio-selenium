package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.impl.*;
import setup.drivers.SharedDriver;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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


    Navigation navigation;
    Presence presence;
    Link link;
    TextField textField;
    Combo combo;
    Button button;

    /**
     * This class runs before any scenario in the feature Signup runs
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
     * This class runs after each Scenario in Signup feature
     * It reopens the browser, to ensure fresh context in each scenario
     */
    @After("@signup")
    public void afterReopenBrowser() {
        navigation.reopenBrowser();
    }

    @Given("I click Sign up link")
    public void clickSignupLink() throws NoSuchFieldException {
        link.click(SIGNUP_LINK, SIGNUP_PAGE);
        presence.waitForElementToDisappear(LOGIN_BUTTON, LOGIN_PAGE);
        presence.waitForElementPresence(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @Given("I fill Username field with value {string}")
    public void fillUsername(String fieldValue) throws NoSuchFieldException {
        textField.fill(USERNAME, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Password field with value {string}")
    public void fillPassword(String fieldValue) throws NoSuchFieldException {
        textField.fill(PASSWORD, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Name field with value {string}")
    public void fillName(String fieldValue) throws NoSuchFieldException {
        textField.fill(NAME, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill E-mail field with value {string}")
    public void fillEmail(String fieldValue) throws NoSuchFieldException {
        textField.fill(EMAIL, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Day combo with value {string}")
    public void fillDobDay(String fieldValue) throws NoSuchFieldException {
        combo.select(DOB_DAY, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Month combo with value {string}")
    public void fillDobMonth(String fieldValue) throws NoSuchFieldException {
        combo.select(DOB_MONTH, fieldValue, SIGNUP_PAGE);
    }

    @Given("I fill Date of Birth Year combo with value {string}")
    public void fillDobYear(String fieldValue) throws NoSuchFieldException {
        combo.select(DOB_YEAR, fieldValue, SIGNUP_PAGE);
    }

    @Given("I click Submit button and wait for it to disappear")
    public void clickSubmitButtonWaitDisappear() throws NoSuchFieldException {
        link.click(SUBMIT_BUTTON, SIGNUP_PAGE);
        presence.waitForElementToDisappear(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @Given("I click Submit button")
    public void clickSubmitButton() throws NoSuchFieldException {
        link.click(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @When("I should be on the User Profile page")
    public void userProfileLanding() throws NoSuchFieldException {
        presence.waitForElementPresence(PROFILE_LINK, LOGIN_PAGE);
        presence.waitForElementPresence(DETAILS_LINK, LOGIN_PAGE);
    }

    @When("I should not be on the User Profile page")
    public void notInUserProfile() throws NoSuchFieldException {
        presence.waitForElementPresence(SUBMIT_BUTTON, SIGNUP_PAGE);
        presence.waitForElementPresence(USERNAME, SIGNUP_PAGE);
    }

    @When("I should be on the Sign up page")
    public void userSignupPage() throws NoSuchFieldException {
        presence.waitForElementPresence(USERNAME, SIGNUP_PAGE);
        presence.waitForElementPresence(SUBMIT_BUTTON, SIGNUP_PAGE);
    }

    @When("I should see text {string} on screen")
    public void messageOnScreen(String message) {
        presence.waitForTextPresence(message);
    }

    @When("I fill Birth Date with values that are in the future")
    public void birthDateInTheFuture() throws NoSuchFieldException {
        /**
         * The next block of code translates the Month from Integer
         * To the language that is set in the -locale- Object
         */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
        Month month = Month.of(calendar.get(Calendar.MONTH) + 1);
        Locale locale = new Locale("English");

        combo.select(DOB_DAY, String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), SIGNUP_PAGE);
        combo.select(DOB_MONTH, month.getDisplayName(TextStyle.FULL, locale), SIGNUP_PAGE);
        combo.select(DOB_YEAR, String.valueOf(calendar.get(Calendar.YEAR)), SIGNUP_PAGE);
    }

}