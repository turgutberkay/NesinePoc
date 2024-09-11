package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import util.ElementUtil;

import java.io.IOException;


public class PromotionsPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By securityCodeTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Güvenlik Kodu\")");
    private final By promotionsCodeTextbox = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"code\")");
    private final By closeButton = AppiumBy.id("com.pordiva.nesine.android:id/back");



    public void checkPromotionsPage() {elementUtil.checkElementVisible(securityCodeTitle);}

    public void sendkeyRandomPromotionCode() {elementUtil.sendKey(promotionsCodeTextbox, elementUtil.randomDigitRandom(9));}

    public void clickCloseButton() {elementUtil.click(closeButton);}


}
