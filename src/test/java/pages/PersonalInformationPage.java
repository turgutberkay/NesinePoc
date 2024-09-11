package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import util.ElementUtil;

public class PersonalInformationPage {

    ElementUtil elementUtil = new ElementUtil();

    public static String memberNumber = HomePage.memberNumber;

    private final By title = AppiumBy.androidUIAutomator("new UiSelector().text(\"Üye ve İletişim Bilgileri\")");
    private final By memberNo = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)");




    public void checkPersonalInformationPage() {elementUtil.checkElementVisible(title);}

    public void checkMemberNumberMatch() {
        //memberNo da text tanimlanmamis. Bu yuzden case in patlaması normaldir.
        System.out.println("memberNo da text tanimlanmamis. Bu yuzden case in patlaması normaldir.");
        elementUtil.checkElementText(memberNo, memberNumber);}

}
