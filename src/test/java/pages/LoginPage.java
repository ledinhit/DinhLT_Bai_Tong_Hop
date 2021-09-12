package pages;

import base.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver = null;
    private CommonAction act = null;

    @FindBy(xpath = "//div[@class='action-bar']//div[@class='user-name']")
    private WebElement account;

    @FindBy(xpath = "//span[contains(text(),'Đăng nhập')]")
    private WebElement btnSignIn;

    @FindBy(xpath = "//input[@placeholder='Nhập số điện thoại liên hệ']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder='Nhập mật khẩu']")
    private WebElement inputPassword;

    @FindBy(xpath = "//div[@class='wrapper-form']//div[@class='content']/span[contains(text(),'Đăng nhập')]")
    private WebElement btnSignInFrom;

    @FindBy(xpath = "//div[@class='wrapper-form']/div[1]/div[@class='validation-errors-wrapper']")
    private WebElement errorUsername;

    @FindBy(xpath = "//div[@class='wrapper-form']/div[@class='wrapper-password']/div[@class='validation-errors-wrapper']")
    private WebElement errorPassword;

    public LoginPage(WebDriver driver, CommonAction act) {
        this.driver = driver;
        this.act = act;
        PageFactory.initElements(driver, this);
    }

    public void clickTextAccountInHomePage() {
        act.clickElementUseActionClass(account);
    }

    public void clickButtonSignIn() {
        act.clickElementUseActionClass(btnSignIn);
    }

    public void enterUsername(String username) {
        act.enterTextElementUseActionClass(inputUsername, username);
    }

    public void enterPassword(String password) {
        act.enterTextElementUseActionClass(inputPassword, password);
    }

    public void clickButtonSignInFrom() {
        act.clickElementUseActionClass(btnSignInFrom);
    }

    public void checkFirstName(String expect) {
        Assert.assertEquals(act.getTextElement(account), expect);
    }

    public void checkErrorUsername(String expect) {
        Assert.assertEquals(act.getTextElement(errorUsername), expect);
    }

    public void checkErrorPassword(String expect) {
        Assert.assertEquals(act.getTextElement(errorPassword), expect);
    }

    public void loginWithPhone(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickButtonSignInFrom();
    }
}
