package pages;

import pageobjects.LoginPage;
import support.Wait;

public class Login {

    private LoginPage loginPage = new LoginPage();
    Wait wait = new Wait();

    public Login() {
        loginPage = loginPage.initPage();
    }

    public void loginUser(String username, String password) {
        wait.forElementToBeVisible(loginPage.getUsername(), 20);
        loginPage.fillUsername(username);
        wait.forElementToBeVisible(loginPage.getPassword(), 20);
        loginPage.fillPassword(password);
        wait.forElementToBeClickable(loginPage.getLoginButton(), 20);
        loginPage.clickLoginButton();
    }

    public void logout() {
        wait.forElementToBeClickable(loginPage.getLogoutLink(), 20);
        loginPage.clickLogoutButton();
    }

}
