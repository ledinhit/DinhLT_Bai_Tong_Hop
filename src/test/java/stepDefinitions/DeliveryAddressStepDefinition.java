package stepDefinitions;

import base.BaseSetup;
import base.CommonAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DeliveryAddressPage;
import pages.LoginPage;

public class DeliveryAddressStepDefinition extends BaseSetup {
    private WebDriver driver = null;
    private LoginPage login = null;
    private CommonAction act = null;
    private WebDriverWait wait = null;
    private DeliveryAddressPage address = null;

    @Given("The user open page Market")
    public void theUserOpenPageMarket() throws InterruptedException {
        beforeClass();
        openPage();
        driver = getDriver();
        act = getCommonAction();
        wait = getWait();
        login = new LoginPage(driver, act);
        address = new DeliveryAddressPage(driver, act, wait);
        Thread.sleep(1000);
    }

    @When("The user login page")
    public void theUserLoginPage() {
        login.clickTextAccountInHomePage();
        login.clickButtonSignIn();
        login.loginWithPhone("0376595922", "121212");
    }

    @When("The user select account information")
    public void theUserSelectAccountInformation() throws InterruptedException {
        address.clickUsernameInActionbar();
        address.selectAccountInformation();
    }

    @And("The user select list address")
    public void theUserSelectListAddress() {
        address.selectListAddress();
    }

    @When("The user click button create address")
    public void theUserClickButtonCreateAddress() {
        address.clickAddNewAddress();
    }

    @When("The user enter name {string}")
    public void theUserEnterName(String name) {
        address.enterName(name);
    }

    @When("The user enter phone {string}")
    public void theUserEnterPhone(String phone) {
        address.enterPhone(phone);
    }

    @When("The user select district")
    public void theUserSelectDistrict() throws InterruptedException {
        address.clickDropdownListDistrict();
        address.selectDistrict();
    }

    @When("The user enter address {string}")
    public void theUserEnterAddress(String address1) {
        address.enterAddress(address1);
    }

    @When("The user select ward")
    public void theUserSelectWard() throws InterruptedException {
        address.clickDropdownListWard();
        address.selectWard();
    }

    @When("The user click button save")
    public void theUserClickButtonSave() {
        address.clickButtonSaveAddress();
    }

    @Then("The User checks the message of successful delivery address creation")
    public void theUserChecksTheMessageOfSuccessfulDeliveryAddressCreation() throws InterruptedException {
        address.checkMessSuccess();
        afterClass();
    }
}
