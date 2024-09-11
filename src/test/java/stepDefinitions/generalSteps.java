package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class generalSteps {

    HomePage homePage = new HomePage();
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();
    PromotionsPage promotionsPage = new PromotionsPage();
    PersonalInformationPage personalInformationPage = new PersonalInformationPage();

    String userName = System.getProperty("userName");
    String password = System.getProperty("password");

    @Given("go to Login Page")
    public void goToLoginPage() throws InterruptedException {
        generalPage.waitThreadSleep(10000); //Wait for application launch
        homePage.checkCookieBottomSheet();
        homePage.acceptCookieBottomSheet();
        homePage.checkHomePage();
        homePage.checkLoginButton();
        homePage.clickLoginButton();
    }
    @Given("go to Logged Home Page")
    public void goToLoggedHomePage() throws InterruptedException {
        goToLoginPage();
        loginPage.sendkeyUsernameTextbox(userName);
        loginPage.sendkeyPasswordTextbox(password);
        loginPage.clickLoginButton();
        homePage.checkCorrectLogged(userName);
    }

    @Then("should see {string} Page")
    public void shouldSeePage(String pageName) throws InterruptedException {
        switch (pageName) {
            case "Home":
                try {
                    homePage.checkHomePage();
                } catch (Exception e) {
                    System.err.println("Error on Home Page: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;
            case "Login":
                try {
                    loginPage.checkLoginPage();
                } catch (Exception e) {
                    System.err.println("Error on Login Page: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;
            case "Account":
                try {
                    accountPage.checkAccountPage();
                } catch (Exception e) {
                    System.err.println("Error on Account Page: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;
            case "Promotions":
                try {
                    generalPage.waitThreadSleep(5000);
                    promotionsPage.checkPromotionsPage();
                } catch (Exception e) {
                    System.err.println("Error on Promotions Page: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;
            case "Personal Information":
                try {
                    generalPage.waitThreadSleep(5000);
                    personalInformationPage.checkPersonalInformationPage();
                } catch (Exception e) {
                    System.err.println("Error on Personal Information Page: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }

}
