package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;

public class accountSteps {

    AccountPage accountPage = new AccountPage();


    @When("taps the Log Out button on the Account Page")
    public void tapsTheLogOutButtonOnTheAccountPage() {accountPage.clickLogOutButton();

    }

    @Then("should see the Log Out popup on the Account Page")
    public void shouldSeeLogOutPopupOnTheAccountPage() {accountPage.checkLogOutPopup();

    }

    @When("taps the Continue button on the Log Out popup on the Account Page")
    public void tapsTheContinueButtonLogOutPopupOnTheAccountPage() {accountPage.clickContinueButtonLogOutPopup();
    }

    @When("taps the Promotions button on the Account Page")
    public void tapsThePromotionsButtonOnTheAccountPage() {accountPage.clickPromotionsButton();
    }

    @When("taps the Personal Information button on the Account Page")
    public void tapsThePersonalInformationButtonOnTheAccountPage() {accountPage.clickPersonalInformationButton();
    }

    @When("taps the Tv Close on the Account Page")
    public void tapsTheTvCloseOnTheAccountPage() {accountPage.clickTvClose();
    }
}
