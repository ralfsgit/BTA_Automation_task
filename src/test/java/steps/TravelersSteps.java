package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PagesManager;

public class TravelersSteps {

    PagesManager pages = new PagesManager();

    @Then("I am in travelers page")
    public void iAmInTravelersPage() {
        pages.travelersPage.travelPageLoaded();
    }

    @And("I see empty and visible data fields")
    public void iSeeEmptyAndVisibleDataFields() {
        pages.travelersPage.verifyFieldsAreEmptyButVisible();
    }
}
