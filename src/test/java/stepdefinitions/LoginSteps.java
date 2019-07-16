package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import pages.General;
import pages.Login;
import setup.drivers.SharedDriver;

public class LoginSteps {

    Login login;
    General general;

    @BeforeStep
    public void beforeClass() {
        new SharedDriver();
        login = new Login();
        general = new General();
    }

    @After("@login")
    public void afterReopenBrowser() {
        general.reopenBrowser();
    }

    @Given("User {string} logs in using password {string}")
    public void secondStep(String user, String password) throws Throwable {
        login.loginUser(user, password);
    }

    @Given("I log out")
    public void logout() {
        login.logout();
    }

    @Given("I click {string} button on {string} page")
    public void clickButton(String button, String page) {
        general.clickButton(button, page);
    }

}