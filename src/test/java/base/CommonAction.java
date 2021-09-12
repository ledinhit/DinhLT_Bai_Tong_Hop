package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.ThreadLocalRandom;


public class CommonAction {
    private Actions action = null;
    public int randomNum = 0;

    public CommonAction(Actions action) {
        this.action = action;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void enterTextElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clickElementUseActionClass(WebElement element) {
        action.click(element).build().perform();
    }

    public void enterTextElementUseActionClass(WebElement element, String text) {
        action.sendKeys(element, text).build().perform();
    }

    public void actionSendKeys(Keys key) {
        action.sendKeys(key).build().perform();
    }

    public int randomNumber(int min, int max) {
        randomNum = ThreadLocalRandom.current().nextInt(min, max);
        return randomNum;

    }

//    public void uploadFile(String nameFile) {
//        StringSelection fileProduct = new StringSelection("src/test/resources/files" + nameFile);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileProduct, null);
//        robot.delay(250);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.delay(90);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }

//    public void clearText(WebElement element) {
//        element.click();
//    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }
}
