package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.PagesManager;


public class PersonalizedOfferSteps {

    PagesManager pages = new PagesManager();


    @When("I choose program \"(.*)\"$")
    public void iChooseProgram(String program) {
        pages.personalizedOfferPage.chooseProgram(program);
    }

    @Then("I can see form \"Add more protection\" and \"My Policy\" with data")
    public void iCanSeeFormAndWithData() {
        Assertions.assertEquals(pages.personalizedOfferPage.getHeaderAddMoreProtectionText(), "Vēlies pievienot papildu aizsardzību?");
        Assertions.assertEquals(pages.personalizedOfferPage.getPriceOfInsurance(), pages.personalizedOfferPage.getMyPolicySum());
    }

    @And("I click on \"Edit details\" button")
    public void iClickOnButton() {
        pages.personalizedOfferPage.clickEditDetailsButton();
    }

    @When("I and change Insurance sum to \"(.*)\"$")
    public void iChangeInsuranceSumTo(int insuranceSum) {
        pages.personalizedOfferPage.chooseInsuranceSum(insuranceSum);
    }

    @Then("Insurance sum has changed")
    public void insuranceSumHasChanged() {
        Assertions.assertEquals(pages.personalizedOfferPage.getPriceOfInsurance() +
                pages.personalizedOfferPage.carInsuranceAmount(),pages.personalizedOfferPage.getMyPolicySum(),
                "The calculated policy sum does not match the expected value.");
    }

    @And("I click on Continue Button")
    public void iClickOnContinueButton() {
        pages.personalizedOfferPage.clickContinueButton();
    }



}
