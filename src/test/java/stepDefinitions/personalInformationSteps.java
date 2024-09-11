package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.PersonalInformationPage;

public class personalInformationSteps {

    PersonalInformationPage personalInformationPage = new PersonalInformationPage();


    @Then("displayed member number should match the retrieved member number on the Personal Information Page")
    public void displayedMemberNumberShouldMatchTheRetrievedMemberNumberOnThePersonalInformationPage() {
        personalInformationPage.checkMemberNumberMatch();
    }

}
