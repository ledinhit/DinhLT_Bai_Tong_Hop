package stepDefinitions;

import base.BaseSetup;
import base.CommonAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.OrderPage;

import java.awt.*;

public class OrderStepDefinition extends BaseSetup {
    private WebDriver driver;
    private LoginPage login;
    private CommonAction act;
    private OrderPage order = null;
    private WebDriverWait wait = null;

    @Given("The user open Web")
    public void theUserOpenWeb() throws AWTException, InterruptedException {
        beforeClass();
        openPage();
        driver = getDriver();
        act = getCommonAction();
        wait = getWait();
        login = new LoginPage(driver, act);
        order = new OrderPage(driver, act, wait);
        Thread.sleep(1000);
    }

    @When("The user login")
    public void theUserLogin() {
        login.clickTextAccountInHomePage();
        login.clickButtonSignIn();
        login.loginWithPhone("0376595922", "121212");
    }

    @When("The user select product")
    public void theUserSelectProduct() {
        order.searchProduct("Test update product #1 * 200ml");
        order.selectProduct();
    }

    @When("The user view cart")
    public void theUserViewCart() throws InterruptedException {
        Thread.sleep(1000);
        order.clickCart();
        order.clickBtnCreateOrderInCart();
    }

    @When("The user select address")
    public void theUserSelectAddress() {
        order.clickDropDownListAddress();
        order.selectAddress();
    }

    @When("The user enter note")
    public void theUserEnterNote() {
        order.enterNote("Đơn test");
    }

    @When("The user click create order")
    public void theUserClickCreateOrder() {
        order.clickBtnCreateOrderInOrder();
    }

    @Then("The user check message success")
    public void theUserCheckMessageSuccess() throws InterruptedException {
        order.checkNotify();
        afterClass();
    }

    @Given("The user open page")
    public void theUserOpenPage() throws AWTException, InterruptedException {
        beforeClass();
        openPage();
        driver = getDriver();
        act = getCommonAction();
        wait = getWait();
        login = new LoginPage(driver, act);
        order = new OrderPage(driver, act, wait);
        Thread.sleep(1000);
    }

    @When("The user login to page")
    public void theUserLoginToPage() {
        login.clickTextAccountInHomePage();
        login.clickButtonSignIn();
        login.loginWithPhone("0376595922", "121212");
    }


    @When("The user add product")
    public void theUserAddProduct() {
        order.searchProduct("Test update product #1 * 200ml");
        order.selectProduct();
    }

    @When("The user view cart after add product")
    public void theUserViewCartAfterAddProduct() throws InterruptedException {
        Thread.sleep(1000);
        order.clickCart();
        order.clickBtnCreateOrderInCart();
    }

    @When("The user enter note order")
    public void theUserEnterNoteOrder() {
        order.enterNote("Đơn test");
    }

    @When("The user click button create order")
    public void theUserClickButtonCreateOrder() {
        order.clickBtnCreateOrderInOrder();
    }

    @Then("The user check message error")
    public void theUserCheckMessageError() throws InterruptedException {
        order.checkNotifyErrorAddressEmpty();
        afterClass();
    }
}
