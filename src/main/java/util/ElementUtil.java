package util;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Random;


import static java.time.Duration.ofSeconds;

public class ElementUtil {

    WebDriver driver;
    WebDriverWait wait ;
    WebDriverWait wait2 ;
    Actions action;
    TouchAction touchAction;
    public static String randomElementText;
    public static String randomElementIndex;

    public ElementUtil() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, ofSeconds(12));
        this.wait2 = new WebDriverWait(driver, ofSeconds(5));
        this.action = new Actions(driver);
        this.touchAction = new TouchAction((PerformsTouchActions) driver);
    }


    public WebElement presenceElement(By key) {return wait.until(ExpectedConditions.presenceOfElementLocated(key));}


    public WebElement visibilityElement(By key) {return wait.until(ExpectedConditions.visibilityOfElementLocated(key));}

    public WebElement clickableElement(By key) {return wait.until(ExpectedConditions.elementToBeClickable(key));}


    public WebElement findElementClickableShort(By key) {
        try {
            return wait2.until(ExpectedConditions.elementToBeClickable(key));
        }catch (Exception ignored) {
            return null;
        }
    }
    public WebElement findElementClickableShort(WebElement element) {
        try {
            return wait2.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception ignored) {
            return null;
        }
    }

    public void click(By key) {
        try {
            findElementClickableShort(key).click();
        }catch (Exception e){
            scrollToElement(presenceElement(key));
            clickableElement(key).click();
        }
    }


    public void click(WebElement element) {
        try {
            findElementClickableShort(element).click();
        }catch (Exception e){
            scrollToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'})", element);
        }catch (Exception ignored){
            Assert.fail("Scroll couldn't be performed");
        }
    }

    public void checkElementVisible(By key) {
        presenceElement(key);
        try {
            visibilityElement(key);
        }catch (Exception ignored){
            scrollToElement(presenceElement(key));
            visibilityElement(key);
        }
    }

    public void sendKey(By key, String text) {
        try {
            WebElement element = visibilityElement(key);
            element.clear();
            element.sendKeys(text);
        } catch (Exception ignored) {
            Assert.fail("Element not writing");
        }
    }

    public String elementGetText(By by) {
        String text = null;
        try {
            presenceElement(by);
            text = driver.findElement(by).getText();
            return text;
        } catch (Exception ignored) {
            Assert.fail();
            return null;
        }
    }

    public void checkElementText(By key,String text) {
        presenceElement(key);
        Assert.assertEquals(elementGetText(key),text);
    }

    public String randomDigitRandom(int i) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        for (int j = 0; j < i; j++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }

}
