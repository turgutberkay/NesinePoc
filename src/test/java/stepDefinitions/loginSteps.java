package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.ElementUtil;

public class loginSteps {

    LoginPage loginPage = new LoginPage();
    ElementUtil elementUtil = new ElementUtil();

    String userName = System.getProperty("userName");
    String password = System.getProperty("password");

    @When("enter User Name into the Username field on the Login Page")
    public void enterIntoTheUsernameFieldOnTheLoginPage() {
        loginPage.sendkeyUsernameTextbox(userName);
    }

    @When("enter Password into the Password field on the Login Page")
    public void enterIntoThePasswordFieldOnTheLoginPage() {
        loginPage.sendkeyPasswordTextbox(password);
    }

    @When("enter random Password into the Password field on the Login Page")
    public void enterRandomPasswordIntoThePasswordFieldOnTheLoginPage() {
        loginPage.sendkeyPasswordTextbox(elementUtil.randomDigitRandom(2));
    }

    @When("taps the Login button on the Login Page")
    public void tapsTheLoginButtonOnTheLoginPage() {
        loginPage.clickLoginButton();
    }

    @Then("should see the error message {string} on the Login Page")
    public void shouldSeeErrorMessageOnTheLoginPage(String errorMessage) {
        loginPage.checkErrorMessage(errorMessage);
    }

}
