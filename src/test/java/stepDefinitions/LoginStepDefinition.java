package stepDefinitions;

import base.BaseSetup;
import base.CommonAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.OrderPage;

import java.awt.*;

public class LoginStepDefinition extends BaseSetup {
    private WebDriver driver = null;
    private LoginPage login = null;
    private CommonAction act = null;

    @Given("The user open Web Market")
    public void theUserOpenWebMarket() throws InterruptedException, AWTException {
        beforeClass();
        openPage();
        driver = getDriver();
        act = getCommonAction();
        login = new LoginPage(driver, act);
        Thread.sleep(1000);
    }

    @When("The user click account in action bar")
    public void theUserClickAccountInActionBar() {
        login.clickTextAccountInHomePage();
    }

    @When("The user select sign in")
    public void theUserSelectSignIn() {
        login.clickButtonSignIn();
    }

    @When("The user Login page")
    public void theUserLoginPage() {
        login.loginWithPhone("0376595922", "121212");
    }

    @Then("The user Check first name {string}")
    public void theUserCheckFirstName(String firstName) throws InterruptedException {
        Thread.sleep(1000);
        login.checkFirstName(firstName);
        afterClass();
    }


    @Given("The user Open Login page and set the variables")
    public void theUserOpenLoginPageAndSetTheVariables() throws InterruptedException, AWTException {
        beforeClass();
        openPage();
        driver = getDriver();
        act = getCommonAction();
        login = new LoginPage(driver, act);
        Thread.sleep(1000);
    }

    @When("The user click account in home")
    public void theUserClickAccountInHome() {
        login.clickTextAccountInHomePage();
    }

    @When("The user Click sign in with phone")
    public void theUserClickSignInWithPhone() {
        login.clickButtonSignIn();
    }

    @When("The user Enter the username and password {string} {string}")
    public void theUserEnterTheUsernameAndPassword(String username, String password) {
        login.loginWithPhone(username, password);
    }

    @Then("The user check message error {string} {string}")
    public void theUserCheckMessageError(String errorUsername, String errorPassword) throws InterruptedException {
        Thread.sleep(1000);
        login.checkErrorUsername(errorUsername);
        login.checkErrorPassword(errorPassword);
        afterClass();
    }


}
