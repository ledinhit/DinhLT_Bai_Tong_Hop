package pages;

import base.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPage {
    private WebDriver driver = null;
    private CommonAction act = null;
    private WebDriverWait wait = null;

    @FindBy(xpath = "//input[@placeholder='Tìm kiếm sản phẩm']")
    private WebElement inputSearchProduct;

    @FindBy(xpath = "//div[@class='content']/div/span[contains(text(),'Giỏ hàng')]")
    private WebElement cart;

    @FindBy(xpath = "//div[@class='cart-footer']/div/div[@class='content']")
    private WebElement btnCreateOrderInCart;

    @FindBy(xpath = "//div[contains(text(),'Chọn địa chỉ giao hàng')]")
    private WebElement dropDownListAddress;

    @FindBy(xpath = "//div[contains(text(),'Tìm kiếm nhanh...')]")
    private WebElement inputSearchAddress;

    @FindBy(xpath = "//textarea[@name='note']")
    private WebElement txtNote;

    @FindBy(xpath = "//div[@class='content' and contains(text(),'Đặt hàng')]")
    private WebElement btnCreateOrderInPageOrder;

    @FindBy(xpath = "//div[contains(text(),'Bạn đã đặt hàng thành công!')]")
    private WebElement notify;

    @FindBy(xpath = "//div[contains(text(),'Địa chỉ giao hàng không được để trống')]")
    private WebElement notifyErrorAddress;

    private By listAddress = By.xpath("//div[@class='option-wrapper']//div[@class='option-content']");

    private By listProducts = By.xpath("//div[@class='variant-card']/div[@class='variant-content']//div[@class='content']");

    public OrderPage(WebDriver driver, CommonAction act, WebDriverWait wait) {
        this.driver = driver;
        this.act = act;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String keyword) {
        act.enterTextElementUseActionClass(inputSearchProduct, keyword);
        act.actionSendKeys(Keys.ENTER);
    }

    public void selectProduct() {
        List<WebElement> products = driver.findElements(listProducts);
        act.clickElement(products.get(0));
    }

    public void clickBtnCreateOrderInCart() {
        act.clickElement(btnCreateOrderInCart);
    }

    public void clickCart() {
        act.clickElement(cart);
    }

    public void clickBtnCreateOrderInOrder() {
        act.clickElement(btnCreateOrderInPageOrder);
    }

    public void clickDropDownListAddress() {
        act.clickElement(dropDownListAddress);
    }

    public void searchAddress(String keyword) {
        act.enterTextElement(inputSearchAddress, keyword);
    }

    public void selectAddress() {
        List<WebElement> address = driver.findElements(listAddress);
        act.clickElement(address.get(0));
    }

    public void enterNote(String note) {
        act.enterTextElement(txtNote, note);
    }

    public void checkNotify() {
        wait.until(ExpectedConditions.visibilityOf(notify));
    }

    public void checkNotifyErrorAddressEmpty() {
        wait.until(ExpectedConditions.visibilityOf(notifyErrorAddress));
    }
}
