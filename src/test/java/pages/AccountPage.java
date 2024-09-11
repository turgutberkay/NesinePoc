package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import util.ElementUtil;

public class AccountPage {

    ElementUtil elementUtil = new ElementUtil();


    private final By closePopupButton = AppiumBy.id("com.pordiva.nesine.android:id/tvClose");
    private final By personalInfoButton = AppiumBy.id("com.pordiva.nesine.android:id/personal_info_btn");
    private final By logOutButton = AppiumBy.id("com.pordiva.nesine.android:id/logout_btn");
    private final By logOutPopup = AppiumBy.id("android:id/message");
    private final By continueButton = AppiumBy.id("android:id/button1");
    private final By promotionsButton = AppiumBy.id("com.pordiva.nesine.android:id/my_promotions_btn");
    private final By personalInformationButton = AppiumBy.id("com.pordiva.nesine.android:id/personal_info_btn");


    public void clickTvClose() {elementUtil.click(closePopupButton);}

    public void checkAccountPage() {elementUtil.checkElementVisible(personalInfoButton);}

    public void clickLogOutButton() {elementUtil.click(logOutButton);}

    public void checkLogOutPopup() {elementUtil.checkElementVisible(logOutPopup);}

    public void clickContinueButtonLogOutPopup() {elementUtil.click(continueButton);}

    public void clickPromotionsButton() {elementUtil.click(promotionsButton);}

    public void clickPersonalInformationButton() {elementUtil.click(personalInformationButton);}


}
