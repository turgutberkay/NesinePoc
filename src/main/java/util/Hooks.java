package util;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();
    public static String systemPort;
    public static String udid;


    @Before
    public void setUp() {
        systemPort = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("systemPort");
        udid = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("udid");
        driverFactory.setDriver(udid,systemPort);
    }

    @After
    public void after() {
        RemoteWebDriver driver = DriverFactory.getDriver();
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).terminateApp("com.pordiva.nesine.android");  // Uygulama kapatılır
            ((AndroidDriver) driver).activateApp("com.pordiva.nesine.android");   // Uygulama yeniden başlatılır
        }
        DriverFactory.getDriver().quit();  // Sürücü kapatılır
        DriverFactory.clearDriver();       // ThreadLocal temizlenir
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            RemoteWebDriver driver = DriverFactory.getDriver();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_login.png");
        }
    }
}
