package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class homeSteps {

    HomePage homePage = new HomePage();

    String userName = System.getProperty("userName");

    @When("taps the Account on the Home Page")
    public void tapsTheAccountOnTheHomePage() {homePage.clickAccount();}

    @Then("should see the correct Logged-in User Name on the Home Page")
    public void shouldSeeCorrectLoggedOnTheHomePage() {homePage.checkCorrectLogged(userName);}

    @Then("should see Not Logged on the Home Page")
    public void shouldSeeNotLoggedOnTheHomePage() {homePage.checkRegisterButton();}

    @When("retrieves the Member Number on the Home Page")
    public void retrievesTheMemberNumberOnTheHomePage() {homePage.retrievesMemberNumber();}

}
