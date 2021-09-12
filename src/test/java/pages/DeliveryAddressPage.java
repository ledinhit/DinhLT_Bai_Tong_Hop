package pages;

import base.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeliveryAddressPage {
    private WebDriver driver = null;
    private CommonAction act = null;
    private WebDriverWait wait = null;
    private int randomNumberDistrict = 0;
    private int randomNumberWard = 0;

    @FindBy(xpath = "//div[@class='action-bar']//div[@class='user-name']")
    private WebElement account;

    @FindBy(xpath = "//div[@class='action-bar']//ul[@class='my-account-submenu']/li/div[contains(text(),'Thông tin tài khoản')]")
    private WebElement accountInformation;

    @FindBy(xpath = "//span[contains(text(),'Quản lý địa chỉ')]")
    private WebElement listAddress;

    @FindBy(xpath = "//div[contains(text(),'Thêm địa chỉ mới')]")
    private WebElement btnCreateNewAddress;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement inputAddress;

    @FindBy(xpath = "//div[@class='showable']//div[contains(text(),'Chọn quận/huyện')]")
    private WebElement dropdownListDistrict;

    @FindBy(xpath = "//div[@class='showable']//div[contains(text(),'Chọn phường/xã')]")
    private WebElement dropdownListWard;

    @FindBy(xpath = "//div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']//div[contains(text(),'Thêm mới')]")
    private WebElement btnSaveAddress;

    @FindBy(xpath = "//div[@id='sm-toast-wrapper']//div[contains(text(),'Thêm địa chỉ thành công')]")
    private WebElement messSuccess;

    private By listDistrict = By.xpath("//div[@class='modal-body']/form[@class='address-modal-body']/div[4]/div[2]/div[1]/div[2]/div");
    private By listWard = By.xpath("//div[@class='modal-body']/form[@class='address-modal-body']/div[6]/div[2]/div[1]/div[2]/div");
    private By messError = By.xpath("//div[@class='content']/div[@class='validation-errors-wrapper']");

    public DeliveryAddressPage(WebDriver driver, CommonAction act, WebDriverWait wait) {
        this.driver = driver;
        this.act = act;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickUsernameInActionbar() throws InterruptedException {
        act.clickElementUseActionClass(account);
        Thread.sleep(1000);
    }

    public void selectAccountInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(accountInformation));
        act.clickElementUseActionClass(accountInformation);
    }

    public void selectListAddress() {
        act.clickElement(listAddress);
    }

    public void clickAddNewAddress() {
        act.clickElement(btnCreateNewAddress);
    }

    public void enterName(String name) {
        act.enterTextElement(inputName, name);
    }

    public void enterPhone(String phone) {
        act.enterTextElement(inputPhone, phone);
    }

    public void enterAddress(String address) {
        act.enterTextElement(inputAddress, address);
    }

    public String checkMessError(String expectError) {
        List<WebElement> listMessError = driver.findElements(messError);
        for (WebElement element : listMessError) {
            String actualError = act.getTextElement(element);
            if (actualError == expectError) {
                return actualError;
            } else {
                return null;
            }
        }
        return expectError;
    }

    public void clickDropdownListDistrict() throws InterruptedException {
        Thread.sleep(1000);
        act.clickElement(dropdownListDistrict);
    }

    public void selectDistrict() throws InterruptedException {
        List<WebElement> districts = driver.findElements(listDistrict);
        int max = districts.size();
        randomNumberDistrict = act.randomNumber(0, max);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", districts.get(randomNumberDistrict));
        Thread.sleep(1000);
    }

    public void clickDropdownListWard() throws InterruptedException {
        act.clickElement(dropdownListWard);
        Thread.sleep(1000);
    }

    public void selectWard() throws InterruptedException {
        List<WebElement> wards = driver.findElements(listWard);
        int max = wards.size();
        randomNumberWard = act.randomNumber(0, max);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", wards.get(randomNumberWard));
        Thread.sleep(2000);
    }

    public void clickButtonSaveAddress() {
        act.clickElement(btnSaveAddress);
    }

    public void checkMessSuccess() {
        wait.until(ExpectedConditions.visibilityOf(messSuccess));
    }
}
