package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import util.ElementUtil;

public class LoginPage {

    ElementUtil elementUtil = new ElementUtil();


    private final By usernameTextbox = AppiumBy.id("com.pordiva.nesine.android:id/username_edit");
    private final By passwordTextbox = AppiumBy.id("com.pordiva.nesine.android:id/password_edit");
    private final By loginButton = AppiumBy.id("com.pordiva.nesine.android:id/login_btn");
    private final By errorMessage = AppiumBy.id("android:id/message");


    public void checkLoginPage() {elementUtil.checkElementVisible(usernameTextbox);}

    public void sendkeyUsernameTextbox(String text) {elementUtil.sendKey(usernameTextbox, text);}

    public void sendkeyPasswordTextbox(String text) {elementUtil.sendKey(passwordTextbox, text);}

    public void clickLoginButton() {elementUtil.click(loginButton);}

    public void checkErrorMessage(String text) {elementUtil.checkElementText(errorMessage, text);}


}
