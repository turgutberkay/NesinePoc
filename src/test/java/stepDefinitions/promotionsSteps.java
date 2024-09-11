package stepDefinitions;

import io.cucumber.java.en.When;
import pages.PromotionsPage;

import java.io.IOException;

public class promotionsSteps {

    PromotionsPage promotionsPage = new PromotionsPage();


    @When("enter a random value into the Promotion textbox on the Promotions Page")
    public void enterARandomValueIntoThePromotionTextboxOnThePromotionsPage() {promotionsPage.sendkeyRandomPromotionCode();
    }


    @When("taps the Close button on the Promotions Page")
    public void tapsToCloseOnThePromotionsPage() {promotionsPage.clickCloseButton();
    }

}
