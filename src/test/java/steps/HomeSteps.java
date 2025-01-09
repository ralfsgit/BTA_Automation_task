package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.junit.jupiter.api.Assertions;
import pages.PagesManager;

import static com.codeborne.selenide.Selenide.open;

public class HomeSteps {

    PagesManager pages = new PagesManager();

    @Given("I open BTA home page")
    public void openLoginPage() {
        open("http://www.bta.lv");
        Assertions.assertEquals(pages.homePage.getLoginContainerName(), "Mans BTA");
    }

    @And("I click \"Accept Cookies\" Button")
    public void acceptCookies(){
        pages.homePage.clickAcceptCookiesButton();
    }

    @And("I click on \"Travel\" Button")
    public void iClickOnTravelButton() {
        pages.homePage.clickTravelButton();
    }

}

