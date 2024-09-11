package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import util.ElementUtil;

public class HomePage {

    ElementUtil elementUtil = new ElementUtil();

    public static String memberNumber ;

    private final By bottomSheet = AppiumBy.id("com.pordiva.nesine.android:id/design_bottom_sheet");
    private final By acceptBottomSheet = AppiumBy.id("com.pordiva.nesine.android:id/btnAccept");
    private final By loginButton = AppiumBy.id("com.pordiva.nesine.android:id/btnLogin");
    private final By homePageBar = AppiumBy.id("com.pordiva.nesine.android:id/top_home_page");
    private final By memberNo = AppiumBy.id("com.pordiva.nesine.android:id/tvMemberNoValue");
    private final By accountTab = AppiumBy.id("com.pordiva.nesine.android:id/rlMyAccountContainer");
    private final By registerButton = AppiumBy.id("com.pordiva.nesine.android:id/btnRegister");


    public void checkCookieBottomSheet(){elementUtil.checkElementVisible(bottomSheet);}

    public void acceptCookieBottomSheet(){elementUtil.click(acceptBottomSheet);}

    public void checkHomePage(){elementUtil.checkElementVisible(homePageBar);}

    public void checkRegisterButton(){elementUtil.checkElementVisible(registerButton);}

    public void checkLoginButton(){elementUtil.checkElementVisible(loginButton);}

    public void clickLoginButton(){elementUtil.click(loginButton);}

    public void checkCorrectLogged(String text){elementUtil.checkElementText(memberNo, text);}

    public void clickAccount(){elementUtil.click(accountTab);}

    public void retrievesMemberNumber(){memberNumber = elementUtil.elementGetText(memberNo);}

}
