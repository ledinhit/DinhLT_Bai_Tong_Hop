package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private WebDriver driver = null;
    private Actions action = null;
    private WebDriverWait wait = null;
    private CommonAction act = null;
    static String appURL = "https://dev-web.sapomarket.com/";

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getAction() {
        return action;
    }

    public CommonAction getCommonAction() {
        return act;
    }


    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
        act = new CommonAction(action);
        driver.manage().window().maximize();
    }

    public void openPage(){
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}
