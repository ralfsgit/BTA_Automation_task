package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.PagesManager;

public class TravelInsuranceSteps {

    PagesManager pages = new PagesManager();

    @Then("I am in Travel Insurance Page")
    public void iAmInTravelInsurancePage() {
        Assertions.assertEquals(pages.travelInsurancePage.getTravelInsuranceHeaderName(), "Ceļojumu apdrošināšana");
    }

    @And("I click on \"Change Destination\" Button")
    public void iClickOnChangeDestinationButton() {
        pages.travelInsurancePage.clickDestinationButton();
    }


    @And("I click \"Choose country\" button")
    public void iClickChooseCountryButton() {
        pages.travelInsurancePage.chooseCountry();

    }

    @And("I change destination to \"(.*)\"$")
    public void iChangeDestinationTo(String destination) {
        pages.travelInsurancePage.clickAddCountry();
        pages.travelInsurancePage.enterDestination(destination);
        pages.travelInsurancePage.selectFoundDestination(destination);
        pages.travelInsurancePage.clickApplyButton();
    }


    @Then("Travel Destination is changed to \"(.*)\"$")
    public void travelDestinationIsChangedTo(String changedDestination) {
        Assertions.assertEquals(pages.travelInsurancePage.getChangedTravelDestinationText(), changedDestination);
    }

    @And("I change activity to \"(.*)\"$")
    public void iChangeActivityTo(String activity) {
        pages.travelInsurancePage.clickActivityButton();
        pages.travelInsurancePage.changeActivity(activity);
        Assertions.assertEquals(pages.travelInsurancePage.getActivityText(), activity);

    }

    @And("I click \"Get Offer\" button")
    public void iClickGetOfferButton() {
        pages.travelInsurancePage.clickGetOfferButton();
    }

}
